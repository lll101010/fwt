package free.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import free.dao.CommentDao;
import free.domain.Member;
import free.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("join.do")
	public String memberJoin(Member member, HttpServletRequest req) {
		
		if(service.registerMember(member)) {
			return "home";
		}
		return "home";
	}
}
