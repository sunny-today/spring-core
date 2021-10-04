package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContextBasicFindTest { // junit5 에서는 더이상 public이 없어도 동작 가능.
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService === " + memberService);   // hola.springbasic.member.MemberServiceImpl@4ce7fffa
        System.out.println("memberService === " + memberService.getClass());    // class hola.springbasic.member.MemberServiceImpl
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입만으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);  // 이름 없이, 타입으로만 조회
        System.out.println("memberService === " + memberService);
        System.out.println("memberService === " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("인터페이스가 아닌, 구체 타입으로 조회")
        // 구현에 의존하므로 유연성이 떨어짐.
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        System.out.println("memberService === " + memberService);
        System.out.println("memberService === " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("없는 빈 이름으로 조회")
    void findBeanByNameX() {
        // org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'xxxxx' available
//        MemberService xxxxx = ac.getBean("xxxxx", MemberService.class); //

        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));    // 무조건 예외가 발생해야 함.
    }
}
