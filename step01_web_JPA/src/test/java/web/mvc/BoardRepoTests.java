package web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import web.mvc.entity.Board;
import web.mvc.repository.BoardRepository;

/**
 * @DataJpaTest는
 */

@SpringBootTest // 통합 테스트
@Slf4j
public class BoardRepoTests {

    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void test() {
        log.info("board test 입니다.");
        log.info("boardRepo = " + boardRepo);
    }

    /**
     * 등록
     */
    @DisplayName("게시물 등록")
    @Test
    public void test2() {
        boardRepo.save(Board.builder()
                .title("제목2")
                .writer("어아유")
                .content("아이아이")
                .build());

        boardRepo.save(Board.builder()
                .title("쉬고싶다")
                .writer("노홍철")
                .content("곧 쉬어요")
                .build());
    }

    @DisplayName("게시물 검색")
    @Test
    public void test3() {

    }

    @DisplayName("게시물 삭제")
    @Test
    public void test4() {

    }

}
