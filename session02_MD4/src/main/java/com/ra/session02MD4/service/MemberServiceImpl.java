package com.ra.session02MD4.service;

import com.ra.session02MD4.model.dto.MemberDTO;
import com.ra.session02MD4.model.entity.Member;
import com.ra.session02MD4.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(int id) {
        return memberRepository.getReferenceById(id);
    }

    @Override
    public Member addMember(MemberDTO memberDTO) {
        Member member = new Member();
        member.setFullName(memberDTO.getFullName());
        member.setEmail(memberDTO.getEmail());
        member.setDateOfBirth(memberDTO.getDateOfBirth());
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(MemberDTO memberDTO, Integer id) {

        Member member = new Member();
        member.setFullName(memberDTO.getFullName());
        member.setEmail(memberDTO.getEmail());
        member.setDateOfBirth(memberDTO.getDateOfBirth());

        member.setId(id);
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Member member) {
        memberRepository.delete(member);
    }

    @Override
    public List<Member> findAllByFullNameOrDepartmentName(String search) {
        return memberRepository.findAllByFullNameOrDepartmentNameContains(search);
    }

}
