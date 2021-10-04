//package hola.springbasic;
//
//import hola.springbasic.member.MemberRepository;
//import hola.springbasic.member.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringConfig {
//
////    private DataSource dataSource;  // 스프링이 자체적으로 DataSource를 만들어 줌.
////    private final EntityManager em;   //JPA
//    private final MemberRepository memberRepository;
//
//    @Autowired  // 주입
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Bean   // 스프링 빈으로 등록할거야!
//    public MemberService memberService() {
//        return new MemberService(memberRepository);
//    }
//
//    /**
//     * 오직 구현체만 바꿈으로써(=애플리케이션을 조립하는 코드만 바꿈으로써) 설정을 바꿔주면
//     * 나머지 실제 서비스 코드는 손대지 않아도 됨.
//     * @return
//     */
////    @Bean
////    public MemberRepository memberRepository() {    // Interface (New 불가)
//////        return new MemoryMemberRepository();    // 구현체
//////        return new JdbcMemberRepository(dataSource);
//////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
////    }
//}
