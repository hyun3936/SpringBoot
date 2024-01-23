package edu.pnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping({"/", "/index"})
	public String index() {  // 리턴이 String이면 [return명.html]을 호출하라는 의미 ➔index.html
		System.out.println("index 요청입니다.");
		return "index";
	}
	
	@GetMapping("/member")
	public void member() { // 리턴이 void면 [url명.html]을 호출한다는 의미. ➔member.html
		System.out.println("Member 요청입니다.");
	}
	
	@GetMapping("/manager")
	public void manager() {
		System.out.println("Manager 요청입니다.");
	}
	
	@GetMapping("/admin")
	public void admin() {
		System.out.println("Admin 요청입니다.");
	}
	
}
