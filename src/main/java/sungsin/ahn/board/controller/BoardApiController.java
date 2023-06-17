package sungsin.ahn.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sungsin.ahn.board.db.BoardEntity;
import sungsin.ahn.board.db.BoardRepository;
import sungsin.ahn.board.model.BoardDto;
import sungsin.ahn.board.model.BoardRequest;
import sungsin.ahn.board.service.BoardService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("")
    public BoardDto create(
        @Valid
        @RequestBody BoardRequest boardRequest
    ){
        return boardService.create(boardRequest);
    }


    @GetMapping("/id/{id}")
    public BoardDto view(
        @PathVariable Long id
    ){
        var entity = boardService.view(id);
        log.info("result : {}",entity);
        return entity;
    }

    @GetMapping("/ids")
    public List<BoardEntity> all(
    ){
        return boardRepository.findAll();
    }
}
