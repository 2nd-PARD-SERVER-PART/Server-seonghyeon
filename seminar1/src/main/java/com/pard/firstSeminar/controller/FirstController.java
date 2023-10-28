// alt + enter : 자동 수정
// ctrl + shift +enter : 자동 완성 (;)
package com.pard.firstSeminar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    // model 객체가 '윤성현'이라는 값을 username이라는 이름에 연결시켜서 보내주는것.
    // 컨트롤러를 만들고 페이지를 리턴하는데 템플릿 변수를 활용하기 위해서 모델을 파라미터로 넣고 보내준다.
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "박지성"); // username 이라는 키로 '서하민'이라는 값을 전달한다.
        return "greetings";
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "김현승");
        return "goodbye";
    }

}
