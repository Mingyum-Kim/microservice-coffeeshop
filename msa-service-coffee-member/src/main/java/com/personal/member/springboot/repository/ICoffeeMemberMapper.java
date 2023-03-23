package com.personal.member.springboot.repository;

import com.personal.member.springboot.repository.dvo.MemberDVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICoffeeMemberMapper {
    MemberDVO existsByMemberName(MemberDVO memberDVO);
    int createMemberTable();
    int insertMemberData();
}
