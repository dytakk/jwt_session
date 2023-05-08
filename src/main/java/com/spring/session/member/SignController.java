package com.spring.session.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.session.dto.SignRequest;
import com.spring.session.dto.SignResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SignController {
	
	// private final MemberRepository memberRepository;
	private final SignService memberService;
	
	
	@PostMapping(value = "/login")
	public ResponseEntity<SignResponse> signin(@RequestBody SignRequest request) throws Exception{
		return new ResponseEntity<>(memberService.login(request),HttpStatus.OK);
	}
	
	@PostMapping(value ="/register")
	public ResponseEntity<Boolean> signup(@RequestBody SignRequest request) throws Exception{
		return new ResponseEntity<>(memberService.register(request),HttpStatus.OK);
	}
	
	@GetMapping("/user/get")
	public ResponseEntity<SignResponse> getUser(@RequestParam String account) throws Exception{
		return new ResponseEntity<>(memberService.getMember(account),HttpStatus.OK);
	}
	
	@GetMapping("/admin/get")
	public ResponseEntity<SignResponse> getUserForAdmin(@RequestParam String account) throws Exception{
		return new ResponseEntity<>(memberService.getMember(account),HttpStatus.OK);
	}

}
