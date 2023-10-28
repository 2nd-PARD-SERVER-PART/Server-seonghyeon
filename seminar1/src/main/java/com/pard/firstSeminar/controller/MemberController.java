package com.pard.firstSeminar.controller;

import com.pard.firstSeminar.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //로그를 위한 annotataion
public class MemberController {

    @GetMapping("/members/new")
    public String newMemberForm(){
        return "members/new";
    }

    @PostMapping("/members/create")
    public String createMember(Model model, MemberDto dto){
        log.info(dto.toString());
        model.addAttribute("myName", dto.getMyName());
        model.addAttribute("teamName", dto.getTeamName());
        return "members/create";
    }
}
