package com.test.test.service;

import com.test.test.entity.Board;
import com.test.test.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public void write(Board board){
        boardRepository.save(board);
    }

    //게시글 모두 불러오기
    public List<Board> boardList() {

        return boardRepository.findAll();
    }

    // 게시글 내용 불러오기
    public Board BoardView(Integer id) {

        return boardRepository.findById(id).get();
    }


}
