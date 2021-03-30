package Demo01;

/**
 * @author KIKOFranklin
 * @create 2021/3/29 0029 22:48
 * @apiNote 检测类对象三种获取方式获取的类对象是否一致
 *
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person1 person = new Person1();
        //获取类对象的第一种方式
        Class<? extends Person1> clazz1 = person.getClass();
        //获取类对象的第二种方式
        Class<Person1> clazz2 = Person1.class;
        //获取类对象的第三种方式
        Class<?> clazz3 = Class.forName("Demo01.Person");

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz2 == clazz3);

    }
}


class Person1{
    private String name;
    private String age;
}
