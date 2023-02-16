package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.reository.JdbcTemplateMemberRepository;
import hello.hellospring.reository.JpaMemberRepository;
import hello.hellospring.reository.MemberRepository;
import hello.hellospring.reository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MemberService {


//    private JdbcTemplateMemberRepository  memberRepository;
//
//    @Autowired
//    public  MemberService (JdbcTemplateMemberRepository memberRepository) {
//        this.memberRepository=memberRepository;
//    }

    private JpaMemberRepository memberRepository;

    @Autowired
    public  MemberService (JpaMemberRepository memberRepository) {
        this.memberRepository=memberRepository;
    }

    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원 x
        extracted(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void extracted(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }


    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers(){
       return memberRepository.findAll();

    }


    public Optional<Member> findOne(Long memberId){
        return  memberRepository.findById(memberId);
    }




}







