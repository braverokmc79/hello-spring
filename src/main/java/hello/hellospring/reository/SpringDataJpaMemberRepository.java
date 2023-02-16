package hello.hellospring.reository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface SpringDataJpaMemberRepository  extends JpaRepository<Member, Long>{

    Optional<Member> findByName(String name);

    Optional<Member> findById(Long name);
}
