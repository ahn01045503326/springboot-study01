package sungsin.ahn.board.service;

import org.springframework.stereotype.Service;
import sungsin.ahn.board.db.PostEntity;
import sungsin.ahn.board.model.PostDto;

@Service
public class PostConverter {

    public PostDto toDto(PostEntity postEntity){
        return PostDto.builder()
            .id(postEntity.getId())
            .userName(postEntity.getUserName())
            .status(postEntity.getStatus())
            .email(postEntity.getEmail())
            .password(postEntity.getPassword())
            .title(postEntity.getTitle())
            .content(postEntity.getContent())
            .postedAt(postEntity.getPostedAt())
            .boardId(postEntity.getBoardEntity().getId())
            .build()
            ;
    }
}
