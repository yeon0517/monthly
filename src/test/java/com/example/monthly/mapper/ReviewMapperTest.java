package com.example.monthly.mapper;

import com.example.monthly.dto.ReviewDto;
import com.example.monthly.vo.ReviewVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class ReviewMapperTest {

    @Autowired
    private ReviewMapper reviewMapper;

    private ReviewVo reviewVo;
    private ReviewDto reviewDto;

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
        reviewDto.setUserNumber(1L);

    }

    @Test
    @DisplayName("댓글 삽입")
    void insert() {
        reviewMapper.insert(reviewDto);

        assertThat(reviewMapper.selectList(reviewDto.getProductNumber()).get(0).getUserNumber()).isEqualTo(reviewDto.getUserNumber());
    }

    @Test
    @DisplayName("댓글 수정")
    void update() {
        reviewMapper.insert(reviewDto);

        reviewDto.setUserNumber(1L);
        reviewDto.setReviewContents("수정테스트");

        reviewMapper.update(reviewDto);

        assertThat(reviewMapper.selectList(reviewDto.getProductNumber()).get(0).getReviewContents()).isEqualTo("수정테스트");
    }

    @Test
    @DisplayName("댓글 삭제")
    void delete() {
        reviewMapper.insert(reviewDto);

        List<ReviewVo> review = reviewMapper.selectList(reviewDto.getProductNumber());
        reviewMapper.delete(review.get(0).getReviewNumber());
        assertThat(reviewMapper.selectList(reviewDto.getProductNumber()).size()).isEqualTo(0);

    }

    @Test
    void select() {
        reviewMapper.insert(reviewDto);
        ReviewVo review = reviewMapper.select(reviewDto.getReviewNumber());
        log.info(review.toString());

    }

    @Test
    void selectList() {
    }
}