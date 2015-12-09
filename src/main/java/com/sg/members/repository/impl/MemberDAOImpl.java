package com.sg.members.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sg.members.entity.Member;
import com.sg.members.repository.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getMembers(String queryString) {

		List<Member> members = new ArrayList<>();

		Session session = getSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);

		QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Member.class)
				.get();
		org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword()
				.onFields("status").matching(queryString).createQuery();

		org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, Member.class);

		members.addAll(fullTextQuery.list());

		return members;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getAllMembers() {

		List<Member> members = new ArrayList<>();
		Session session = getSession();

		members = session.createCriteria(Member.class).setMaxResults(20).list();

		return members;
	}

}
