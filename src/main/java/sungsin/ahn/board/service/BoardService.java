package sungsin.ahn.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sungsin.ahn.board.db.BoardEntity;
import sungsin.ahn.board.db.BoardRepository;
import sungsin.ahn.board.model.BoardDto;
import sungsin.ahn.board.model.BoardRequest;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;


    public BoardDto create(
            BoardRequest boardRequest
    ){
        var entity = BoardEntity.builder()
            .boardName(boardRequest.getBoardName())
            .status("REGISTERED")
            .build()
            ;

        var saveEntity = boardRepository.save(entity);

        return boardConverter.toDto(saveEntity);
    }

    public BoardDto view(Long id) {
        var entity = boardRepository.findById(id).get();
        return boardConverter.toDto(entity);
    }
}
