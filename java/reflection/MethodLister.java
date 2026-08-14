import java.lang.reflect.Method;

public class MethodLister extends Object {
    public static void main(String[] args) {
        Class<?> cls = Volunteer1.class;

        Method[] methods = cls.getMethods();

        System.out.println("Methods in " + cls.getName() + " are:");

        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
