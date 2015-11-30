package com.sg.members.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sg.members.DTO.MemberDTO;
import com.sg.members.service.MemberService;

@RestController
public class SearchController {
	
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/search")
	public ResponseEntity<List<MemberDTO>>  getMatchedMembers(@RequestParam(value="query", required=false) String query){
		
		List<MemberDTO> members = memberService.getMembers(query);
		return new ResponseEntity<List<MemberDTO>>(members, HttpStatus.OK);
		
		
	}
	
}
