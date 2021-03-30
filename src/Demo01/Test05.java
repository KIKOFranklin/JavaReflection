package Demo01;

/**
 * @author KIKOFranklin
 * @create 2021/3/30 0030 19:32
 * @apiNote 获取全类名
 */
public class Test05 {
    public static void main(String[] args) {
        Person5 person5 = new Person5();
        Class<? extends Person5> clazz = person5.getClass();
        //获取全类名
        String className = clazz.getName();
        System.out.println(className);
    }


}
class Person5{
    private String name;
    private String pwd;

}
