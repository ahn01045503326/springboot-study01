package sungsin.ahn.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sungsin.ahn.board.db.PostRepository;
import sungsin.ahn.board.db.ReplyEntity;
import sungsin.ahn.board.db.ReplyRepository;
import sungsin.ahn.board.model.ReplyRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;


    public ReplyEntity create(
        ReplyRequest replyRequest
    ){
        var optionalPostEntity = postRepository.findById(replyRequest.getPostId());

        if(optionalPostEntity.isEmpty()){
            throw new RuntimeException("게시물이 존재 하지 않습니다 : "+replyRequest.getPostId());
        }

        var entity = ReplyEntity.builder()
            .post(optionalPostEntity.get())
            .userName(replyRequest.getUserName())
            .password(replyRequest.getPassword())
            .status("REGISTERED")
            .title(replyRequest.getTitle())
            .content(replyRequest.getContent())
            .repliedAt(LocalDateTime.now())
            .build()
            ;

        return replyRepository.save(entity);
    }

    public List<ReplyEntity> findAllByPostId(Long postId){
        return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId, "REGISTERED");
    }
}
