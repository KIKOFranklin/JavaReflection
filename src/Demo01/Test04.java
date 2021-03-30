package Demo01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author KIKOFranklin
 * @create 2021/3/29 0029 23:37
 * @apiNote 获取类对象的方法 并执行调用
 */
public class Test04 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person4 person4 = new Person4();
        //获取类对象
        Class<? extends Person4> clazz = person4.getClass();
        //获取public无参方法
        Method method1 = clazz.getMethod("method1");
        method1.invoke(person4);//执行方法
        //获取public有参方法
        Method method2 = clazz.getMethod("method3", String.class);
        method2.invoke(person4, "Hello,");
        //获取private无参方法
        Method method3 = clazz.getDeclaredMethod("method2");
        method3.setAccessible(true);//原理同field、constructor一致
        method3.invoke(person4);
        //获取 public 修饰的所有方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            //获取方法名
            System.out.println(method.getName());
        }
        //获取所有方法
        Method[] allMethods = clazz.getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println(method);
            //获取方法名
            System.out.println(method.getName());
        }
    }
}
class Person4{
    private String name;
    private String pwd;

    public void method1(){
        System.out.println("方法1执行了");
    }
    public void method3(String name){
        System.out.println(name + "方法3执行了");
    }
    private void method2(){
        System.out.println("方法2执行了");
    }

}
