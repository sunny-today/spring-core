package hello.core.member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // Optional  - NULL 처리를 위함.
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
