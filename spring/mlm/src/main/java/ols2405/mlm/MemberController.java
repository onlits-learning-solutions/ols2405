package ols2405.mlm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// @RequestMapping(path = "/mlm")
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping(path = "/members")
    public String getAllMembers(Map<String, Object> model) {
        model.put("members", memberRepository.findAll());
        return "member/member";
    }

    @GetMapping (path="/member/create")
    public String getMemberCreate() {
        return "member/create";
    }

    @PostMapping(path = "/member")
    public @ResponseBody String addNewMember(@RequestParam String name, @RequestParam String email) {
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        memberRepository.save(member);
        return "Saved";
    }
}
