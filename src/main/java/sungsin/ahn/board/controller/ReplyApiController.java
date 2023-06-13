package sungsin.ahn.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sungsin.ahn.board.db.ReplyEntity;
import sungsin.ahn.board.model.ReplyRequest;
import sungsin.ahn.board.service.ReplyService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyApiController {

    private final ReplyService replyService;

    @PostMapping("")
    public ReplyEntity create(
        @Valid
        @RequestBody ReplyRequest replyRequest
    ){
        return replyService.create(replyRequest);
    }

}
