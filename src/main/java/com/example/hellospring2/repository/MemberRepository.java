package com.example.hellospring2.repository;

import com.example.hellospring2.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //null 처리를 쉽게 해줌
    Optional<Member> findByName(String name);
    List<Member> findAll();
}