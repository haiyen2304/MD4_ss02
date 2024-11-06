package com.ra.session02MD4.service;

import com.ra.session02MD4.model.dto.MemberDTO;
import com.ra.session02MD4.model.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> findAll();
    Member getMemberById(int id);
    Member addMember(MemberDTO memberDTO);
    Member updateMember(MemberDTO memberDTO,Integer id);
    void deleteMember(Member member);
    List<Member> findAllByFullNameOrDepartmentName(String search);
}
