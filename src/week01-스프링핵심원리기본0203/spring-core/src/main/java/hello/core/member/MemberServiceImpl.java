package hello.core.member;

import java.util.Optional;

public class MemberServiceImpl implements MemberService {

    // interface만... 즉, 추상화에만 의존함.
    private final MemoryMemberRepository memberRepository; // = new MemoryMemberRepository();

    // 구현 객체 생성 - 생성자를 통해서 MemberServiceImpl 구현체에 어떤 Repository를 사용할지 지정해줌.
    public MemberServiceImpl(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        // 다형성에 의해, MemberRepository의 save 메서드가 호출됨.
        memberRepository.save(member);
    }

    @Override
    public Optional<Member> findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
