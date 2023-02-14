package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(){
        return  "members/createForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member =new Member();
        member.setName(form.getName());

        System.out.println("member =  " +member.getName());;
        memberService.join(member);
        return  "redirect:/";
    }
}
