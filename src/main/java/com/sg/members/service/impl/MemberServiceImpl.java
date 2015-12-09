package com.sg.members.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.members.DTO.MemberDTO;
import com.sg.members.entity.Member;
import com.sg.members.repository.MemberDAO;
import com.sg.members.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	@Transactional
	public List<MemberDTO> getMembers(String query) {

		List<Member> members = new ArrayList<>();
		List<MemberDTO> memberDTOs = new ArrayList<>();

		try {

			members = memberDAO.getMembers(query);

			for (Member member : members)
				memberDTOs.add(Member.toMemberDTO(member));

		} catch (Exception e) {

			e.printStackTrace();

		}

		return memberDTOs;
	}

	@Override
	@Transactional
	public List<MemberDTO> getAllMembers() {

		List<Member> members = new ArrayList<>();
		List<MemberDTO> memberDTOs = new ArrayList<>();

		try {

			members = memberDAO.getAllMembers();

			for (Member member : members)
				memberDTOs.add(Member.toMemberDTO(member));

		} catch (Exception e) {

			e.printStackTrace();

		}

		return memberDTOs;
	}
}
