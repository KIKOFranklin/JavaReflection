package Demo01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author KIKOFranklin
 * @create 2021/3/29 0029 23:19
 * @apiNote 获取类对象的构造器 并构造方法
 */
public class Test03 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Person3 person3 = new Person3();

        Class<? extends Person3> clazz = person3.getClass();
        //获取public无参构造器
        Constructor<? extends Person3> pubConstructor = clazz.getConstructor();
        Person3 testPerson1 = pubConstructor.newInstance();//通过public构造器实例化对象
        System.out.println(testPerson1);
        //获取public有参构造器
        Constructor<? extends Person3> pubConstructorWithParam = clazz.getConstructor(String.class);
        Person3 testPerson2 = pubConstructorWithParam.newInstance("王家豪");
        System.out.println(testPerson2);
        //获取private构造器
        Constructor<? extends Person3> priConstructor = clazz.getDeclaredConstructor(String.class, String.class);
        priConstructor.setAccessible(true);// 因为方法中带Declared字段的方法，就是可以获取private修饰的构造方法，如果通过该构造方法创建实例对象，就需要忽略构造方法访问修饰符的安全检查
        Person3 testPerson3 = priConstructor.newInstance("王家豪", "123");
        System.out.println(testPerson3);
        //获取所有构造器
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for(Constructor<?> constructor : constructors){
            System.out.println(constructor);
        }
    }
}

class Person3{
    private String name;
    private String pwd;

    public Person3() { }

    public Person3(String name) {
        this.name = name;
        this.pwd = pwd;
    }

    private Person3(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
