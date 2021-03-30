package Demo01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author KIKOFranklin
 * @create 2021/3/30 0030 19:58
 * @apiNote 利用反射执行对象的方法
 */
public class Test12 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object object = objectFactory("Demo01.Person13");
        invokeFunction(object, "method", null, null);
        invokeFunction(object, "method1", new Class[]{String.class}, "method1 is being executing");
        invokeFunction(object, "method2", new Class[]{String.class}, "method2 is being executing");
    }


    private static void invokeFunction(Object object, String methodName, Class[] types, Object...args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        Method method = clazz.getDeclaredMethod(methodName,  types);
        method.setAccessible(true);
        method.invoke(object, args);
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

class Person13{
    private String name;
    private String pwd;

    public void method(){
        System.out.println("No params function");
    }

    public void method1(final String content){
        System.out.println(content);
    }

    private void method2(final String content){
        System.out.println(content);
    }
}
