package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class MemberServiceTest {

    /**
     * AppConfig 를 사용하도록 변경.
     * -> AppConfig 스프링 기반으로 변경하면 아래 설정 부분 지워주어도 됨!
     */
//    MemberService memberService; // = new MemberServiceImpl();
//
//    @BeforeEach
//    public void beforeEach() {
//        AppConfig appConfig = new AppConfig();
//        memberService = appConfig.memberService();
//    }

    // 스프링 컨테이너 생성!
    // annotation 기반으로 하여, AppConfig 클래스의 환경 설정 정보를 가지고 스프링 빈에 등록하겠다는 의미.
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

    @Test
    void join(){
        // given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        // when
        memberService.join(member);
        Optional<Member> findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember.get());  // optional class에서 내부적으로 갖고있는 값 꺼내기
    }
}
