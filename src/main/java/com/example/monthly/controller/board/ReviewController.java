package com.example.monthly.controller.board;

import com.example.monthly.dto.ReviewDto;
import com.example.monthly.service.board.ReviewService;
import com.example.monthly.vo.Criteria;
import com.example.monthly.vo.PageVo;
import com.example.monthly.vo.ReviewVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews/*")
public class ReviewController {

    private final ReviewService reviewService;


//    댓글 추가
    @PostMapping("/review")
    public String reviewRegister(@RequestBody ReviewDto reviewDto, HttpServletRequest req){
       Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        reviewDto.setUserNumber(userNumber);
        reviewService.reviewRegister(reviewDto);
        return "추가 성공";
    }

//    댓글 조회
    @GetMapping("/list/{productNumber}")
    public List<ReviewVo> getReviewList(@PathVariable("productNumber") Long productNumber){
//        return reviewService.reviewFindList(productNumber);
        List<ReviewVo> review = reviewService.reviewFindList(1L);
        System.out.println(review);
        return reviewService.reviewFindList(1L);
    }

//   댓글 수정
    @PatchMapping("/{reviewNumber}")
    public void replyModify(@PathVariable("reviewNumber") Long reviewNumber,
                            @RequestBody ReviewDto reviewDto){
        reviewDto.setReviewNumber(reviewNumber);
        reviewService.reviewModify(reviewDto);

    }

    @DeleteMapping("/{reviewNumber}")
    public void replyDelete(@PathVariable("reviewNumber") Long reviewNumber){
        reviewService.reviewRemove(reviewNumber);
    }

//    댓글 페이징
    @GetMapping("/list/{productNumber}/{page}")
    public Map<String, Object> replyListPage(@PathVariable("productNumber") Long productNumber,
                                             @PathVariable("page") int page){
        Criteria criteria = new Criteria(page,5);
        PageVo pageVo = new PageVo(criteria,reviewService.findTotal(1L));

        List<ReviewVo> reviewList = reviewService.findListPage(criteria,1L);
        Map<String,Object> replyMap = new HashMap<>();

        replyMap.put("pageInfo",pageVo);
        replyMap.put("reviewList",reviewList);
        return replyMap;

    }


}
