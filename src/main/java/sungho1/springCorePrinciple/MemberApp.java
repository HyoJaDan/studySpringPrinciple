package sungho1.springCorePrinciple;

import sungho1.springCorePrinciple.member.Grade;
import sungho1.springCorePrinciple.member.Member;
import sungho1.springCorePrinciple.member.MemberService;
import sungho1.springCorePrinciple.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig=new AppConfig();
        MemberService memberService= appConfig.memberService();

        Member memberA = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(memberA);

        Member findedMember=memberService.findMember(1L);

        System.out.println("newMember = " + memberA.getName());
        System.out.println("Finded_member = " + findedMember.getName());
    }
}
