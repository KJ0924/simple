package com.kh.template.board.service;

import com.kh.template.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardMapper boardMapper;
    public int register(@RequestBody String json){
        boardMapper.insertBoard(json);
        return boardMapper.lastInsertNo();
    }

    public String getBoard(String no) {
        return boardMapper.selectBoard(no);
    }

    public void removeBoard(String no) {
        boardMapper.deleteBoard(no);
    }
}
