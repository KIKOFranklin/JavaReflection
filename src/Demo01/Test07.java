package Demo01;

/**
 * @author KIKOFranklin
 * @create 2021/3/30 0030 19:42
 */
public class Test07 {
    public static void main(String[] args) {
        Person7 person7 = new Person7();
        Class<? extends Person7> clazz = person7.getClass();
        //获取类所在的包名
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }
}
class Person7{
    private String name;
    private String pwd;
}
