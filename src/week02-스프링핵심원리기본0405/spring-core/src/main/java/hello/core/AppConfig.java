package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 실제 동작에 필요한 구현 객체를 생성한다.
 */
@Configuration  // @Configuration: 바이트코드를 조작하는 CGLIB 기술을 사용해서 싱글톤을 보장
public class AppConfig {

    /**
     *  @Configuration과 싱글톤
     *  스프링은 싱글톤을 반드시 보장해준다
     */
    // call memberService
    // call AppConfig.memberRepository  // 3회가 아닌, 예상과 다르게 1회 호출
    // call AppConfig.orderService

    @Bean   // @Bean: 스프링 컨테이너에 스프링 빈으로 등록한다.
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

//    @Bean
//    public OrderService orderService() {
//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
//    }


    /* [@Configuration과 싱글톤] */
    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()
    // 싱글톤이 깨질까?
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
