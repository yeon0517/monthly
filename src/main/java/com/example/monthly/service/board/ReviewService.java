package com.example.monthly.service.board;

import com.example.monthly.dto.ReviewDto;
import com.example.monthly.mapper.ReviewMapper;
import com.example.monthly.vo.Criteria;
import com.example.monthly.vo.ReviewVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewMapper reviewMapper;

//    댓글 추가
    public void reviewRegister (ReviewDto reviewDto){
        if (reviewDto == null) {
            throw new IllegalArgumentException("댓글 정보 누락");
        }
        reviewMapper.insert(reviewDto);
    }

//    댓글 수정
    public void reviewModify(ReviewDto reviewDto){
        if (reviewDto == null) {
            throw new IllegalArgumentException("댓글 정보 누락");
        }
        reviewMapper.update(reviewDto);
    }

//    댓글 삭제
    public void reviewRemove(Long userNumber){
        if (userNumber == null) {
            throw new IllegalArgumentException("회원 번호 누락");
        }
       reviewMapper.delete(userNumber);
    }

//    댓글 번호로 검색
    public ReviewVo reviewSelect(Long reviewNumber){
        if (reviewNumber == null) {
            throw new IllegalArgumentException("댓글 번호 누락");
        }

        return Optional.ofNullable(reviewMapper.select(reviewNumber)).orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 회원 번호");});
    }

//    제품번호로 댓글 전체 리스트 조회
    public List<ReviewVo> reviewFindList(Long productNumber){
        if (productNumber == null) {
            throw new IllegalArgumentException("제품 번호 누락");
        }

        return Optional.ofNullable(reviewMapper.selectList(productNumber)).orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 회원 번호");});
    }

    public List<ReviewVo> findListPage(Criteria criteria, Long productNumber){
        if(criteria == null || productNumber == null){
            throw new IllegalArgumentException("댓글 페이징 정보 누락");
        }
        return reviewMapper.selectListPage(criteria,productNumber);
    }

    public int findTotal(Long productNumber){
        if (productNumber == null) {
            throw new IllegalArgumentException("게시글 번호 누락");
        }
        return reviewMapper.selectTotal(productNumber);
    }

}
