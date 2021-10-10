package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 정액 할인 정책
 */
public class FixDiscountPolicy implements  DiscountPolicy {

    private int discountFixAmount = 1000;   // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        // enum은 == 쓰는게 맞다
        if (member.getGrade() == Grade.VIP) {   // VIP이면 할인
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
