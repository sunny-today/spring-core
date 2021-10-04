//package hola.springbasic.repository;
//
//import hola.springbasic.member.Member;
//import hola.springbasic.member.MemoryMemberRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class MemoryMemberRepositoryTest {
//
//    MemoryMemberRepository repository = new MemoryMemberRepository();
//
//    /**
//     * 테스트 끝나고 store data 비우기.
//     */
//    @AfterEach  // 각 테스트 끝난 후 실행
//    public void afterEach() {
//        repository.clearStore();
//    }
//
//    @Test
//    public void save(){
//        //given
//        Member member = new Member();
//        member.setName("spring");
//
//        //when
//        repository.save(member);
//
//        //then
//        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member, result); // import static method
//        assertThat(result).isEqualTo(null);
//    }
//
//    @Test
//    public void findName() {
//        //given
//        Member member1 = new Member();
//        member1.setName("spring1");
//        repository.save(member1);
//
//        Member member2 = new Member();  // shift + F6: Rename
//        member2.setName("spring2");
//        repository.save(member2);
//
//        //when
//        Member result = repository.findByName("spring1").get();
//
//        //then
//        assertThat(result).isEqualTo(member2);
//    }
//
//    @Test
//    public void findAll() {
//        //given
//        Member member1 = new Member();
//        member1.setName("spring1");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setName("spring2");
//        repository.save(member2);
//
//        //when
//        List<Member> result = repository.findAll();
//
//        //then
//        assertThat(result.size()).isEqualTo(2);
//    }
//}
