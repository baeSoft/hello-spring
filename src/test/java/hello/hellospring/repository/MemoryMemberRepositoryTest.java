package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
         repository.clearStore();
    }

    @Test
    public void Save(){
        Member member = new Member();
        member.setName("spring");

        repository.Save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member01 = new Member();
        member01.setName("spring-01");

        repository.Save(member01);

        Member member02= new Member();
        member02.setName("spring-02");

        repository.Save(member02);


        Member result = repository.findByName("spring-02").get();
        assertThat(member02).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Member member01 = new Member();
        member01.setName("spring-01");

        repository.Save(member01);

        Member member02 = new Member();
        member02.setName("spring-02");

        repository.Save(member02);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
