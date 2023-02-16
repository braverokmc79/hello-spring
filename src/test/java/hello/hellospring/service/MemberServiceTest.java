package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.reository.JdbcTemplateMemberRepository;
import hello.hellospring.reository.MemberRepository;
import hello.hellospring.reository.MemoryMemberRepository;
import hello.hellospring.reository.SpringDataJpaMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService ;
    //MemberRepository memberRepository;


    SpringDataJpaMemberRepository memberRepository;

//    @BeforeEach
//    public void beforeEach(){
//        memberRepository =new JdbcTemplateMemberRepository();
//        memberService =new MemberService(memberRepository);
//    }


//    @AfterEach
//    public void afterEach(){
//        memberRepository.clearStore();
//    }

    @Test
    void 회원가입() {
        //give
        Member member =new Member();
        member.setName("hello");

        //when
        Long saveId =memberService.join(member);

        //then
        Member findMember= memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }


  //  @Test
    public void 중복_회원_예외(){
        //given
        Member member1 =new Member();
        member1.setName("spring1");

        Member member2=new Member();
        member2.setName("spring2");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        //then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}