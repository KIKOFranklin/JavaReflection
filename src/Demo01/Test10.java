package Demo01;

/**
 * @author KIKOFranklin
 * @create 2021/3/30 0030 19:47
 */
public class Test10 {
    public static void main(String[] args) {
        Person9 person9 = new Person9();
        Class<? extends Person9> clazz = person9.getClass();
        //判断注解是否存在
        Boolean result = clazz.isAnnotationPresent(Deprecated.class);
        System.out.println(result);
    }
}

@Deprecated
class Person9{

}
