package web.mvc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import web.mvc.entity.Board;
import web.mvc.repository.BoardRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class BoardQueryMethodJPQLTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("1. 전달된 글번호보다 큰 레코드 검색")
    public void test() {
        boardRepository.findByBnoGreaterThan(150L).forEach(System.out::println);
    }

    @Test
    @DisplayName("2. 전달된 글번호, 작성자 기준")
    public void test2() {
        boardRepository.findByBnoLessThanOrTitle(150L, "제목150").forEach(System.out::println);
    }

    @Test
    @DisplayName("JPQL문법 1 - delete")
    public void test3() {
        boardRepository.delGratebybno(600L);
    }

    @Test
    @DisplayName("JPQL문법 2 - select")
    public void test4() {
        boardRepository.findBnoTitle(4L, "%제목7%").forEach(System.out::println);
    }

    @Test
    @DisplayName("JPQL문법 3 - 여러조건")
    public void test5() {
        boardRepository.findByWhere(Board.builder()
                        .bno(100L)
                        .title("제목5")
                        .writer("작성자9")
                        .build())
                .forEach(System.out::println);
    }
}
