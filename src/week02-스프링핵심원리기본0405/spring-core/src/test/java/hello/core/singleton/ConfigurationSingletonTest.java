package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> orderRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);
        /**
         * 동일한 인스턴스를 참조한다.
         * [출력]
         * memberService -> memberRepository = hello.core.member.MemoryMemberRepository@11111111
         * orderService -> orderRepository = hello.core.member.MemoryMemberRepository@11111111
         * memberRepository = hello.core.member.MemoryMemberRepository@11111111
         */

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

    }

    /**
     * [@Configuration과 바이트코드 조작의 마법]
     *
     */
    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
        // [출력] bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$3bef51a5
        /**
         * [CGLIB 예상 코드]
         * memoryMemberRepository가
         *  스프링 컨테이너에 등록되어있지 않다면: 기존 로직을 호출하여 MemoryMemberRepository를 생성하고 스프링 컨테이너에 등록
         *  이미 스프링 컨테이너에 등록되어 있다면: 스프링 컨테이너에서 찾아서 반환
         */
    }
}
