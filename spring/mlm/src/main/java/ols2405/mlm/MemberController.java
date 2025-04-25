package ols2405.mlm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String addNewMember(@RequestParam String name, @RequestParam String email) {
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        memberRepository.save(member);
        return "redirect:/member";
    }

    @GetMapping(path = "/edit/{id}")
    public String getMemberEdit(@PathVariable("id") int id, Model model) {
        Member member = memberRepository.findById(id).orElseThrow();
        model.addAttribute("member", member);
        return "member/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String updateMember(@PathVariable("id") int id, @RequestParam String name, @RequestParam String email) {
        Member member = memberRepository.findById(id).orElseThrow();
        member.setName(name);
        member.setEmail(email);
        memberRepository.save(member);
        return "redirect:/member";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteMember(@PathVariable("id") int id) {
        Member member = memberRepository.findById(id).orElseThrow();
        memberRepository.delete(member);
        return "redirect:/member";
    }
}
