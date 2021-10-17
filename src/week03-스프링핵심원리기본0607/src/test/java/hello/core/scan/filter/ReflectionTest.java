package hello.core.scan.filter;

import hello.core.reflection.Person;
import hello.core.reflection.PersonParent;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

public class ReflectionTest {

    @Test
    void findComponentAnnotated() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Reflections reflector = new Reflections("");

        Set<Class<?>> listConfiguration = reflector.getTypesAnnotatedWith(Configuration.class);
        Set<Class<?>> listComponent = reflector.getTypesAnnotatedWith(Component.class);

        String classNameAnnotatedAsComponent = null;
        //classNameAnnotatedAsComponent = clazz.getAnnotation(Configuration.class).value();

        for(Class<?> clazz: listConfiguration) {
            // getAnnotation(): 클래스로부터 어노테이션 추출
            System.out.println("Configuration");
            System.out.println(clazz.getName() + "() -> 객체 준비 완료");
        }

        for(Class<?> clazz: listComponent) {
            // getAnnotation(): 클래스로부터 어노테이션 추출
            System.out.println("Component");
            System.out.println(clazz.getName() + "() -> 객체 준비 완료");
        }
    }

    @Test
    void findField() throws IllegalAccessException {
        Person person = new Person("Yeop",20);
        Field[] fields = person.getClass().getDeclaredFields();

        for (Field field : fields) {
            System.out.println("field = " + field);
            field.setAccessible(true);

            System.out.println("field.getType() => " + field.getType());
            System.out.println("field.getName() => " + field.getName());

            Person ps = new Person();
            Object value = field.get(person);
            //field.set(person, value);

            System.out.println("value = " + value);
        }
    }

    @Test
    void findMethod() throws InvocationTargetException, IllegalAccessException {
        Person person = new Person("Yeop", 20);

        Class clazz = person.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for(Method method : methods) {
            if(method.getName().equals("process")) {
                System.out.println("method.invoke(person) => " + method.invoke(person));
            }

            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            for(Annotation annotation : declaredAnnotations) {
                System.out.println(method.getName());
                System.out.println(annotation.toString());
            }
        }
    }

    @Test
    void findConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person person = new Person("Yeop",20);

        Class<?> clazz = person.getClass();
        Constructor<?> constructor = clazz.getConstructor();

        Person newPerson = (Person) constructor.newInstance();
        System.out.println("newPerson = " + newPerson);

    }

    @Test
    void findAnnotation() {
        // getAnnotations() : 상위 클래스의 상속가능한 애노테이션정보까지 가져온다.
        // getDeclaredAnnotations() : 현재 클래스의 애노테이션 정보만 가져온다.

        System.out.println("Person");
        Arrays.stream(Person.class.getAnnotations()).forEach(System.out::println);
        Arrays.stream(Person.class.getDeclaredAnnotations()).forEach(System.out::println);

        System.out.println("PersonParent");
        Arrays.stream(PersonParent.class.getAnnotations()).forEach(System.out::println);
        Arrays.stream(PersonParent.class.getDeclaredAnnotations()).forEach(System.out::println);

    }
}
