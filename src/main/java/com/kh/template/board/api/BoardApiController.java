package com.kh.template.board.api;

import com.kh.template.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;
    @PostMapping
    public int register(@RequestBody String json){
        return boardService.register(json);
    }

    @GetMapping("{no}")
    public String getBoard(@PathVariable String no) {
        return boardService.getBoard(no);
    }

    @DeleteMapping("{no}")
    public void removeBoard(@PathVariable String no) {
        boardService.removeBoard(no);
    }
}
