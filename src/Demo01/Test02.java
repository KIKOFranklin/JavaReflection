package Demo01;

import java.lang.reflect.Field;

/**
 * @author KIKOFranklin
 * @create 2021/3/29 0029 22:55
 * @apiNote 通过类对象的操作方法操作对象中的元素
 */
public class Test02 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person2 person2 = new Person2();
        //获取类对象
        Class<? extends Person2> clazz = person2.getClass();
        //获取类中的所有public元素
        Field[] publicFields = clazz.getFields();
        printFields(publicFields);
        //获取类中所有元素
        Field[] allFields = clazz.getDeclaredFields();
        printFields(allFields);
        //获取类中单个public元素
        Field singlePublicField = clazz.getField("name");
        printField(singlePublicField);
        //获取类中单个任意权限元素
        Field randomField = clazz.getDeclaredField("pwd");
        printField(randomField);
        //获取变量name的值
        singlePublicField.get(person2);
        randomField.setAccessible(true);//private属性要设置
        randomField.get(person2);
        //设置变量name的值
        singlePublicField.set(person2, "franklin");
        randomField.set(person2,"123");
        //打印结果
        printFieldValue(singlePublicField, person2);
        printFieldValue(randomField, person2);
    }

    private static void printFields(Field[] fields){
        System.out.println("----result----");
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("\n");
    }
    private static void printField(Field field){
        System.out.println("----result----");
        System.out.println(field);
        System.out.println("\n");
    }
    private static void printFieldValue(Field field, Object object) throws IllegalAccessException {
        System.out.println("----result----");
        System.out.println(field.get(object));
        System.out.println("\n");
    }
}
class Person2 {
    public String name;
    private String pwd;
}

