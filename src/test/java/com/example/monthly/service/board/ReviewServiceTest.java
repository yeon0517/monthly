package com.example.monthly.service.board;

import com.example.monthly.dto.ReviewDto;
import com.example.monthly.mapper.ReviewMapper;
import com.example.monthly.vo.ReviewVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ReviewServiceTest {

    @Mock
    private ReviewMapper reviewMapper;

    @InjectMocks
    private ReviewService reviewService;

    private ReviewDto reviewDto;
    private ReviewVo reviewVo;


    @BeforeEach
    void setUp(){
        reviewVo = new ReviewVo();
        reviewVo.setReviewContents("안녕하세여");
        reviewVo.setUserId("aaa");
        reviewVo.setProductNumber(1L);
        reviewVo.setUserNumber(1L);

        reviewDto = new ReviewDto();
        reviewDto.setReviewContents("안녕하세여");
        reviewDto.setProductNumber(1L);
        reviewDto.setUserNumber(1L);reviewDto = new ReviewDto();

    }

    @Test
    @DisplayName("댓글 추가")
    void reviewRegister() {
        doNothing().when(reviewMapper).insert(any(ReviewDto.class));

        reviewService.reviewRegister(reviewDto);

        verify(reviewMapper,times(1)).insert(reviewDto);
    }

    @Test
    @DisplayName("댓글 수정")
    void reviewModify() {
        doNothing().when(reviewMapper).update(any(ReviewDto.class));

        reviewService.reviewModify(reviewDto);

        verify(reviewMapper,times(1)).update(reviewDto);

    }

    @Test
    @DisplayName("댓글 삭제")
    void reviewRemove() {
        doNothing().when(reviewMapper).delete(any(Long.class));

        reviewService.reviewRemove(1L);

        verify(reviewMapper,times(1)).delete(1L);
    }

    @Test
    @DisplayName("댓글 번호로 댓글 검색")
    void reviewSelect() {
        doReturn(reviewVo).when(reviewMapper).select(any(Long.class));

        ReviewVo review = reviewService.reviewSelect(1L);

        assertThat(review).isEqualTo(reviewVo);
    }

    @Test
    void reviewSelectNull(){
//        doReturn(null).when(reviewMapper).select(any(Long.class));
//
//        assertThatThrownBy(() -> reviewService.reviewSelect(reviewDto.getReviewNumber())).isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("댓글");


    }

    @Test
    @DisplayName("제품 번호로 전체 조회")
    void reviewFindList() {
        doReturn(List.of(reviewVo)).when(reviewMapper).selectList(any(Long.class));

       List<ReviewVo> review =  reviewService.reviewFindList(1L);

       assertThat(review).contains(reviewVo);

    }


}