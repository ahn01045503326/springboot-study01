package sungsin.ahn.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sungsin.ahn.board.db.BoardEntity;
import sungsin.ahn.board.model.BoardDto;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardConverter {

    private final PostConverter postConverter;

    public BoardDto toDto(BoardEntity boardEntity){

        var postList = boardEntity.getPostList()
            .stream()
            .map(postConverter::toDto)
            .collect(Collectors.toList());

        return BoardDto.builder()
            .id(boardEntity.getId())
            .boardName(boardEntity.getBoardName())
            .status(boardEntity.getStatus())
            .postList(postList)
            .build()
            ;
    }
}
