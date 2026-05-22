package web.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import web.mvc.domain.FreeBoard;
import web.mvc.domain.User;
import web.mvc.repository.FreeBoardRepository;
import web.mvc.repository.UserRepository;

@SpringBootTest
class Step03BoardApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FreeBoardRepository freeBoardRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @Rollback(value = false)
    public void userInsert() {
        userRepository.save(User.builder().userId("chan").pwd("1234").name("이찬범").build());
        userRepository.save(User.builder().userId("jang").pwd("1234").name("장희정").build());
        userRepository.save(User.builder().userId("lee").pwd("1234").name("이가현").build());
    }

    @Test
    @Rollback(value = false)
    public void boardInsert() {
        for (int i = 1; i < 45; i++) {
            freeBoardRepository.save(FreeBoard.builder()
                    .subject("제목"+i)
                    .writer("User"+i)
                    .readnum(0)
                    .content("내용"+i)
                    .password("1234")
                    .build());
        }
    }

}
