package ols2405.mlm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping()
    public String getAllMembers(Map<String, Object> model) {
        model.put("members", memberRepository.findAll());
        return "member/members";
    }

    @GetMapping(path = "/create")
    public String getMemberCreate() {
        return "member/create";
    }

    @PostMapping()
    public @ResponseBody
    String addNewMember(@RequestParam String name, @RequestParam String email) {
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        memberRepository.save(member);
        return "Saved";
    }

    @GetMapping(path = "/edit")
    public String getMemberEdit() {
        return "member/edit";
    }
}
