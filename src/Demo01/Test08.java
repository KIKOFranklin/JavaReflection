package Demo01;

/**
 * @author KIKOFranklin
 * @create 2021/3/30 0030 19:44
 */
public class Test08 {
    public static void main(String[] args) {
        Person8 person8 = new Person8();
        Class<? extends Person8> clazz = person8.getClass();
        //获取父类对象
        Class<?> parentClazz = clazz.getSuperclass();
        System.out.println(parentClazz);
    }
}
class Person8 extends Parent{
    private String name;
    private String pwd;
}
class Parent{

}
