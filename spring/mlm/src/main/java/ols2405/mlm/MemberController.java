package ols2405.mlm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    private MemberRepository memberRepository;

    @PostMapping(path="/member")
    public @ResponseBody String addNewMember(@RequestParam String name, @RequestParam String email) {
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        memberRepository.save(member);
        return "Saved";
    }

    @GetMapping(path="/members")
    public @ResponseBody Iterable<Member> getAllUsers() {
        return memberRepository.findAll();
    }
}
