package com.ra.session02MD4.controller;

import com.ra.session02MD4.model.dto.MemberDTO;
import com.ra.session02MD4.model.entity.Member;
import com.ra.session02MD4.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    private MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public String member(Model model) {
        List<Member> memberList= memberService.findAll();
        model.addAttribute("memberList", memberList);
        return "member/index";
    }

    @GetMapping("/add")
    public String addMember(Model model) {
        MemberDTO memberDTO = new MemberDTO();
        model.addAttribute("memberDTO", memberDTO);
        return "member/add";
    }

    @PostMapping("/add")
    public String addMember(@Valid @ModelAttribute("memberDTO") MemberDTO memberDTO, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "member/add";
        }
        memberService.addMember(memberDTO);
        return "redirect:/member";
    }

    @GetMapping("/edit/{id}")
    public String editMember( @PathVariable int id, Model model) {
        MemberDTO memberDTO =new MemberDTO();
        model.addAttribute("memberDTO", memberDTO);
        return "redirect:/member/edit/" + id;
    }

    @PostMapping("edit/{id}")
    public String update(@Valid @ModelAttribute("memberDTO")MemberDTO memberDTO, Model model, @PathVariable int id,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "redirect:/member/edit/" + id;
        }
        model.addAttribute("memberDTO", memberDTO);
        return "redirect:/member";
    }


}
