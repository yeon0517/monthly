package com.example.monthly.controller.board;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.service.board.BoardService;
import com.example.monthly.service.board.BrandFileService;
import com.example.monthly.service.board.BrandService;
import com.example.monthly.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards/*")
public class BoardRestController {
    private final BoardService boardService;


 @GetMapping("/search")
    public List<ProductVo> boardSearch(@RequestParam("searchSelect") String searchSelect, @RequestParam("searchInput") String searchInput){
     return boardService.searchProductList(searchSelect, searchInput);
 }

}
