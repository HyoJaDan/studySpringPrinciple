package sungho1.springCorePrinciple.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sungho1.springCorePrinciple.discount.DiscountPolicy;
import sungho1.springCorePrinciple.member.Member;
import sungho1.springCorePrinciple.member.MemberRepository;
@Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId,String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice=discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
