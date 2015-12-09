package com.sg.members.service;

import java.util.List;

import com.sg.members.DTO.MemberDTO;

public interface MemberService {
     
	List<MemberDTO> getMembers(String query) ;
    List<MemberDTO> getAllMembers();
	
}
