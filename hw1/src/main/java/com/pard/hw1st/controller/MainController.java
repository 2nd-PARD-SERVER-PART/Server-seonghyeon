package com.pard.hw1st.controller;


import com.pard.hw1st.dto.MyInfoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String startPage() {
        return "start";
    }

    @GetMapping("/submitInfo")
    public String showForm() {

        return "submitInfo";
    }

    @PostMapping("/showInfo")
    public String newInfoForm(Model model, MyInfoDto myInfoDto) {
        model.addAttribute("major", myInfoDto.getMajor());
        model.addAttribute("grade", myInfoDto.getGrade());
        model.addAttribute("age", myInfoDto.getAge());
        model.addAttribute("hobby", myInfoDto.getHobby());
        model.addAttribute("name", myInfoDto.getName());
        model.addAttribute("hometown", myInfoDto.getHometown());
        model.addAttribute("introduction", myInfoDto.getIntroduction());
        return "showInfo";
    }
}
