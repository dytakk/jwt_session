package com.spring.session.member;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface MemberRepository extends JpaRepository<Member,Long> {
	Optional<Member> findByAccount(String account);

}
