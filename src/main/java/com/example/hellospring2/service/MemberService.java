package com.example.hellospring2.service;

import com.example.hellospring2.domain.Member;
import com.example.hellospring2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//test ctrl + shift + t
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //final이 무엇인가

    public Long join(Member member) { //이것이 바로 spring의 의존성 주입 ?

        vaildateDuplicateMember(member); //중복 회원 검사

        // result.orElse() <- 값이 있으면 꺼내고 null이면 꺼내지 않는다.

        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) // ctrl + alt + v
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 있는 회원입니다.");
                }); //null이 아니라 값이 있나 확인 Otional이기 가능하다.
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
