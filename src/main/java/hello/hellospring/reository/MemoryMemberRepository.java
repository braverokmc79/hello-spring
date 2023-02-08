package hello.hellospring.reository;

import hello.hellospring.domain.Member;
import lombok.val;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store =new HashMap<>();
    private static long sequence =0L;

    @Override
    public Member save(Member member) {
         member.setId(++sequence);
         store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //ofNullable  : store.get(id) 값이 null 이어도 상관없다.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }


}
