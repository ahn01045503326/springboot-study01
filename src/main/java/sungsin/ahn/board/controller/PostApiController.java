package sungsin.ahn.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import sungsin.ahn.board.common.Api;
import sungsin.ahn.board.db.PostEntity;
import sungsin.ahn.board.model.PostRequest;
import sungsin.ahn.board.model.PostViewRequest;
import sungsin.ahn.board.service.PostService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("")
    public PostEntity create(
        @Valid
        @RequestBody PostRequest postRequest
    ){
        return postService.create(postRequest);
    }

    @PostMapping("/view")
    public PostEntity view(
        @Valid
        @RequestBody PostViewRequest postViewRequest
    ){
        var entity = postService.view(postViewRequest);
        return entity;
    }


    @GetMapping("/all")
    public Api<List<PostEntity>> list(
        @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC)
        Pageable pageable
    ){
        return postService.all(pageable);
    }

    @PostMapping("/delete")
    public void delete(
        @Valid
        @RequestBody PostViewRequest postViewRequest
    ){
        postService.delete(postViewRequest);
    }

}
