package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();
        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();
        
        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        /**
         * [출력]
         * memberService1 = hello.core.member.MemberServiceImpl@11111111
         * memberService2 = hello.core.member.MemberServiceImpl@22222222
         * => 다른 객체가 생성이 된다.
         */

        // memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }
    
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {

        /* private으로 선언했기 때문에 직접 선언을 방지할 수 있다. */
        // new SingletonService();

        // 1. 조회: 호출할 때 마다 같은 객체를 반환
        SingletonService singletonService1 = SingletonService.getInstance();
        // 2. 조회: 호출할 때 마다 같은 객체를 반환
        SingletonService singletonService2 = SingletonService.getInstance();
        /**
         * [출력]
         * memberService1 = hello.core.member.MemberServiceImpl@11111111
         * memberService2 = hello.core.member.MemberServiceImpl@11111111
         * => 동일한 인스턴스를 참조하여 사용한다.
         */

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }


    /**
     * 요청이 올 때마다 객체를 생성하지 않는다.
     * 이미 만들어진 객체를 공유하여 효율적으로 재사용할 수 있다.
     */
    @Test
    @DisplayName("Spring Container와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 1. 조회: 호출할 때 마다 같은 객체를 반환
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        // 2. 조회: 호출할 때 마다 같은 객체를 반환
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        /**
         * [출력]
         * memberService1 = hello.core.member.MemberServiceImpl@11111111
         * memberService2 = hello.core.member.MemberServiceImpl@11111111
         * => 동일한 인스턴스를 참조하여 사용한다.
         */

        // memberService1 == memberService2
        assertThat(memberService1).isSameAs(memberService2);
    }

}
