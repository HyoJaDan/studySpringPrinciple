package sungho1.springCorePrinciple;

import sungho1.springCorePrinciple.discount.DiscountPolicy;
import sungho1.springCorePrinciple.discount.FixDiscountPolicy;
import sungho1.springCorePrinciple.discount.RateDiscountPolicy;
import sungho1.springCorePrinciple.member.MemberRepository;
import sungho1.springCorePrinciple.member.MemberService;
import sungho1.springCorePrinciple.member.MemberServiceImpl;
import sungho1.springCorePrinciple.member.MemoryMemberRepository;
import sungho1.springCorePrinciple.order.OrderService;
import sungho1.springCorePrinciple.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
