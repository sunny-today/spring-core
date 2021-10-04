//package hola.springbasic.repository;
//
//import hola.springbasic.member.Member;
//import hola.springbasic.member.MemberRepository;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//import java.util.Optional;
//
//public class JpaMemberRepository implements MemberRepository {
//
//    // JPA는 EntityManager 로 모든 것이 동작한다.
//    private final EntityManager em;
//
//    public JpaMemberRepository(EntityManager em) {
//        this.em = em;
//    }
//
//    @Override
//    public Member save(Member member) {
//        em.persist(member);
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        return Optional.ofNullable(em.find(Member.class, id));
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return em.createQuery("select m from Member as m", Member.class)    // Member Entity 자체를 select 함.
//                .getResultList();
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//       List<Member> result = em.createQuery("select m from Member as m where m.name = :name", Member.class)
//                .setParameter("name", name)
//                .getResultList();
//       return result.stream().findAny();
//    }
//}
