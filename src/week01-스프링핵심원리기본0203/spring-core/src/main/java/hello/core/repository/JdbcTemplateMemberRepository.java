//package hola.springbasic.repository;
//
//import hola.springbasic.member.Member;
//import hola.springbasic.member.MemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//public class JdbcTemplateMemberRepository implements MemberRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired  // 생성자가 1개만 있으면 autowired 생략 가능.
//    public JdbcTemplateMemberRepository(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @Override
//    public Member save(Member member) {
//        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");  // 쿼리 작성할 필요가 없음.
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("name", member.getName());
//
//        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters)); // key 받아옴.
//        member.setId(key.longValue());
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        List<Member> result = jdbcTemplate.query("select * from member where id = ? ", memberRowMapper(), id);
//        return result.stream().findAny();
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return jdbcTemplate.query("select * from member", memberRowMapper());
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        List<Member> result = jdbcTemplate.query("select * from member where name = ? ", memberRowMapper(), name);
//        return result.stream().findAny();
//    }
//
//    private RowMapper<Member> memberRowMapper() {
////        return new RowMapper<Member>() { // option + Enter → lamda 전환
////            @Override
////            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
////                Member member = new Member();
////                member.setId(rs.getLong("id"));
////                member.setName(rs.getString("name"));
////                return member;
////            }
////        };
//        return (rs, rowNum) -> {
//            Member member = new Member();
//            member.setId(rs.getLong("id"));
//            member.setName(rs.getString("name"));
//            return member;
//        };
//    }
//}
