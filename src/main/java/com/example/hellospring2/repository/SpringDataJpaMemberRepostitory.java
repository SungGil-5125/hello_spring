package com.example.hellospring2.repository;

import com.example.hellospring2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepostitory extends JpaRepository<Member, Long>, MemberRepository { //인터페이스는 다중 상속 가능
    //스프링 데이터 jpa가 JpaRepository를 보고 자동으로 구현체를 만들어 준다 /memberRepository를 상속 한다고 해서 바로 쓸수 있나 ?

    @Override
    Optional<Member> findByName(String name);
}
