//package hola.springbasic.repository;
//
//import hola.springbasic.member.Member;
//import hola.springbasic.member.MemberRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//// interface 는 다중 상속 가능하다. (implements 말고 extends 사용)
//public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
//
//    @Override
//    Optional<Member> findById(Long aLong);
//}
