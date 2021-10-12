package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

/**
 * 주문 생성 요청이 오면, 회원 정보를 조회하고, 할인 정책을 적용한 뒤 주문 객체를 생성해서 반환하다.
 * 메모리 회원 리포지토리와, 고정 금액 할인 정책을 구현체로 생성한다.
 */
public class OrderServiceImpl implements OrderService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    // Interface에만 의존한다. 어떤 구현체가 들어올지 모르고 있어도 된다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // Grade만 넘길 지, Member만 넘길 지는 고민..
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName,itemPrice, discountPrice);
    }

    // Configuration의 싱글톤 유지 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
