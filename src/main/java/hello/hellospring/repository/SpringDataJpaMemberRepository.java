package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL select m from Member m where m.name = ? 라는 쿼리를 자동으로 생성함
    // JPA와 스프링 데이터 JPA는 동적 쿼리에 적합하지 않아 대신 Querydsl이라는 라이브러리를 사용하게 된다.
    @Override
    Optional<Member> findByName(String name);
}
