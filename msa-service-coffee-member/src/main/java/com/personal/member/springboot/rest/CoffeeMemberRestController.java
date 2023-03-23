package com.personal.member.springboot.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.personal.member.springboot.repository.ICoffeeMemberMapper;
import com.personal.member.springboot.repository.dvo.MemberDVO;
import com.personal.member.springboot.rest.rvo.MemberRVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CoffeeMemberRestController {
    private final ICoffeeMemberMapper iCoffeeMemberMapper;

    @HystrixCommand
    @RequestMapping(value = "/coffeeMember/v1.0/{memberName}", method = RequestMethod.GET)
    public boolean isMember(@PathVariable("memberName") String memberName) {
        MemberDVO memberDVO = new MemberDVO();
        memberDVO.setMemberName(memberName);

        if (iCoffeeMemberMapper.existsByMemberName(memberDVO)
                .getMemberName().isEmpty()) return false;
        else return true;
    }

    @HystrixCommand
    @RequestMapping(value = "/coffeeMember/v1.0", method = RequestMethod.POST)
    public boolean isMember(@RequestBody MemberRVO memberRVO) {
        MemberDVO memberDVO = new MemberDVO();
        memberDVO.setMemberName(memberRVO.getMemberName());

        if (iCoffeeMemberMapper.existsByMemberName(memberDVO)
                .getMemberName().isEmpty()) return false;
        else return true;
    }

    // 서킷 브레이커 테스트
    @HystrixCommand(fallbackMethod = "fallbackFunction")
    @RequestMapping(value = "/fallbackTest", method = RequestMethod.GET)
    public String fallbackTest() throws Throwable{
        throw new Throwable("fallbackTest");
    }
    public String fallbackFunction(){
        return "fallbackFunction()";
    }

    // 테스트 테이블 & 데이터 생성
    @RequestMapping(value = "/createMemberTable", method=RequestMethod.PUT)
    public void createMemberTable(){
        iCoffeeMemberMapper.createMemberTable();
    }
    @RequestMapping(value = "/insertMemberData", method=RequestMethod.PUT)
    public void insertMemberData(){
        iCoffeeMemberMapper.insertMemberData();
    }
}
