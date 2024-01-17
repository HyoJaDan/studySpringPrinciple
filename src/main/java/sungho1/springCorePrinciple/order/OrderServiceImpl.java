package sungho1.springCorePrinciple.order;

import sungho1.springCorePrinciple.discount.DiscountPolicy;
import sungho1.springCorePrinciple.discount.FixDiscountPolicy;
import sungho1.springCorePrinciple.member.Member;
import sungho1.springCorePrinciple.member.MemberRepository;
import sungho1.springCorePrinciple.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy=new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId,String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice=discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
