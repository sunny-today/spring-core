package hello.core.member;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface MemberService {

    void join(Member member);
    Optional<Member> findMember(Long id);

    // 입문 강의에서 class 사용하던 것 주석 처리, 핵심 원리 강의에서는 MemberService Interface 생성하여 사용함.
//    // 회원 서비스가 메모리 회원 리포지토리를 직접 생성하게 함.
//    // private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final MemberRepository memberRepository;
//
//    // Constructor 생성 - 직접 new 로 생성하는 것이 아니라, 외부에서 넣어주도록 함.
//    // Dependency Injection (DI)
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    /**
//     * 회원 가입
//     */
//    public long join(Member member) {
//        //중복 회원 검증, Optional 이기에 가능함.
//        /*Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });*/
//
//        /*memberRepository.findByName(member.getName())   // 위에 코드 정리
//                .ifPresent(m ->{
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });*/
//
//        validateDuplicateMember(member);    // 위에 코드 → option + command + T → extract Methods
//        memberRepository.save(member);
//        return member.getId();
//    }
//
//    private void validateDuplicateMember(Member member) {
//        memberRepository.findByName(member.getName())
//                .ifPresent(m ->{
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
//    }
//
//    /**
//     * 전체 회원 조회
//     */
//    public List<Member> findMembers(){
//        return memberRepository.findAll();
//    }
//
//    public Optional<Member> findOne(Long memberId) {
//        return memberRepository.findById(memberId);
//    }

}
