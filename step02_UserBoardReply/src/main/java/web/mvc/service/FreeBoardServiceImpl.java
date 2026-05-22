package web.mvc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import web.mvc.domain.FreeBoard;

import java.util.List;

@Service
@Slf4j
public class FreeBoardServiceImpl implements FreeBoardService {
    @Override
    public List<FreeBoard> selectAll() {
        return List.of();
    }

    @Override
    public Page<FreeBoard> selectAll(Pageable pageable) {
        return null;
    }

    @Override
    public void insert(FreeBoard board) {

    }

    @Override
    public FreeBoard selectBy(Long bno, boolean state) {
        return null;
    }

    @Override
    public FreeBoard update(FreeBoard board) {
        return null;
    }

    @Override
    public void delete(Long bno, String password) {

    }
}
