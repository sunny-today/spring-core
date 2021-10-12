package week03.hola;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DiscountTest {

    /**
     * 1. Reflection을 이용해 Constructor를 이용해 객체 생성 만들기
     */
    @Test
    @DisplayName("Constructor를 이용한 객체 생성")
    void Solution01() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class discountClass = Discount.class;
        Constructor constructor = discountClass.getConstructor(new Class[]{String.class, String.class});
        System.out.println("Constructor's name === " + constructor.getName());

        Constructor constructors[] = discountClass.getDeclaredConstructors();
        for (Constructor cons : constructors) {
            System.out.println("Get Cconstructors in Discount : " + cons);
        }

        Discount discount = (Discount) constructor.newInstance("RatePolicy", "10"); // newInstance의 반환형이 Object라 캐스팅이 필요함.
        System.out.println("Discount === " + discount.toString());
    }

    /**
     * 2. Reflection을 이용해 Method를 실행하는 예제코드 만들기
     */
    @Test
    @DisplayName("Method 실행")
    void Solution02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class classes = Class.forName("week03.hola.Discount");
        Method method = classes.getDeclaredMethod("method1");
        method.setAccessible(true); // private
        method.invoke(new Discount());
    }

    /**
     * Reflection을 이용해 Field를 변경하는 예제코드 만들기
     */
    @Test
    @DisplayName("Field 변경")
    void Solution03() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class classes = Class.forName("week03.hola.Discount");
        Field field = classes.getDeclaredField("policy");
        System.out.println("field's name == " + field);

        Discount discount = new Discount();
        System.out.println("field before change === " + discount);
        field.setAccessible(true);
        field.set(discount, "FixFixPolicy");
        System.out.println("field after change === " + discount);
    }
}
