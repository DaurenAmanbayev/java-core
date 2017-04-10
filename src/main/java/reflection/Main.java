package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static final String PERSON = "reflection.Person";

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        Class<?> personClass = person.getClass();
        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        Method m = personClass.getMethod("setLname", String.class);
        m.invoke(person, "suryawanshi");
        System.out.println("Person last name is : " + person.getLname());
        System.out.println("This is for class " + personClass.getSimpleName());
    }
}
