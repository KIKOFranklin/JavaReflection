package Demo01;

/**
 * @author KIKOFranklin
 * @create 2021/3/30 0030 19:49
 */
public class Test11 {
    public static void main(String[] args) {
        Object object = objectFactory("Demo01.Person10");
        System.out.println(object);
    }
    private static Object objectFactory(String className){
        try {
            Class<?> clazz = Class.forName(className);
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Person10{

}

