package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        /* State를 유지 */
//        // ThreadA: A사용자가 10000원을 주문함
//        statefulService1.order("userA", 10000);
//        // ThreadB: B사용자가 20000원을 주문함
//        statefulService2.order("userB", 20000);
//
//        //ThreadA: A사용자의 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
//        // 10000원을 예상헀으나 20000원 출력
//        assertThat(statefulService1.getPrice()).isEqualTo(20000);


        /* State를 유지하지 않음 */
        // ThreadA: A사용자가 10000원을 주문함
        int userAPrice = statefulService1.order("userA", 10000);
        // ThreadB: B사용자가 20000원을 주문함
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA: A사용자의 주문 금액 조회
        System.out.println("price = " + userAPrice);
        // 10000원을 예상헀으나 20000원 출력
        assertThat(userAPrice).isEqualTo(10000);
    }

    static class TestConfig  {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}