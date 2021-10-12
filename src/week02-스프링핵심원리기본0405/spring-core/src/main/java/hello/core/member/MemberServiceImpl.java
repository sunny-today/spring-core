package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 추상화에만 의존을 한다. // MemberServiceImpl은 모른다.
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Configuration의 싱글톤 유지 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
