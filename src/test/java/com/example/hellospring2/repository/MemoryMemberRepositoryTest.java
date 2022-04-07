package com.example.hellospring2.repository;

import com.example.hellospring2.domain.Member;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    //TTD : 테스트 주도 개발, 테스트를 먼저 만들고, 개발을 하는것

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //메서드가 끝날때 마다 실행
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //optional이기 때문에 get을 쓴다
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByname(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); //shift + f6으로 바로 이름 변경
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get( );

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
