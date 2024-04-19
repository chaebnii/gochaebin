package com.test.test.controller;

import com.test.test.entity.Board;
import com.test.test.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class testController {

    @Autowired
    private  final BoardService boardService;

    public testController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/test/write") //글쓰기 창 클라이언트
    public String boardWriteForm(){
        return "boardWrite";
    }

    @PostMapping("/test/write1") //글쓰기 클릭 서버 부분
   public String boardWrite1(Board board ,Model model){

        boardService.write(board);
        model.addAttribute("board",boardService.boardList());

        System.out.println("제목:"+board.getTitle());
        System.out.println("내용은:"+board.getContent());
        return "BoardList";
    }

    @GetMapping("/test/view")
    public String boardView(@RequestParam(name="id") Integer id, Model model){
        System.out.println("aha");
        model.addAttribute("board",boardService.BoardView(id));
        return "BoardView";
    }


}
