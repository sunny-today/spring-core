//package hola.springbasic.service;
//
//import hola.springbasic.member.Member;
//import hola.springbasic.member.MemberRepository;
//import hola.springbasic.member.MemberService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행
//@Transactional  // 테스트 완료 후에 항상 롤백
//class MemberServiceIntegrationTest {
//
//    @Autowired
//    MemberService memberService;
//    @Autowired
//    MemberRepository memberRepository;
//
//    @Test
//    void 회원가입() { // 빌드될 때, 테스트 코드는 실제 코드에 포함되지 않음.
//        // given
//        Member member = new Member();
//        member.setName("hello");
//
//        // when
//        Long savedId = memberService.join(member);
//
//        // then
//        Member findMember = memberService.findOne(savedId).get();
//        assertEquals(member.getName(), findMember.getName());
//    }
//
//    @Test
//    public void 중복_회원_예외() throws Exception {
//        // given
//        Member member1 = new Member();
//        member1.setName("spring");
//
//        Member member2 = new Member();
//        member2.setName("spring");
//
//        // when & then
///*
//        // try~catch문 / 자동 완성 단축키 또한 Command + option + v
//        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (Exception e) { // 오류 나야함.
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
//*/
//
//        // assertThrows 문법 사용
//        // 람다 표현식으로, member2 join 하였을 때 Exception 발생한다는 것을 넘김.
//        memberService.join(member1);
//        // assertThrows(Exception.class, () -> memberService.join(member2));   // 예외가 발생해야 함.
//        Exception e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    }
//}