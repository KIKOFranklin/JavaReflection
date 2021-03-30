package Demo01;

/**
 * @author KIKOFranklin
 * @create 2021/3/30 0030 19:34
 * @apiNote 获取当前类实现的接口
 */
public class Test06 {
    public static void main(String[] args) {
        Person6 person6 = new Person6();
        Class<? extends Person6> clazz = person6.getClass();
        //获取对象实现的接口
        Class<?>[] interfaces = clazz.getInterfaces();
        for(Class<?> element : interfaces){
            System.out.println(element);
            //判断是否为接口
            System.out.println(element.isInterface());
        }
    }
}
class Person6 implements Demo{
    private String name;
    private String pwd;

    @Override
    public void getResult() {
        System.out.println("Done!");
    }
}

interface Demo{
    void getResult();
}