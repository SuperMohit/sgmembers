package com.sg.members.repository;

import java.util.List;

import com.sg.members.entity.Member;

public interface MemberDAO {

	List<Member> getMembers(String query);

	List<Member> getAllMembers();

}
