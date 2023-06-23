package com.example.monthly.mapper;

import com.example.monthly.dto.ReviewDto;
import com.example.monthly.vo.Criteria;
import com.example.monthly.vo.ReviewVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {

    void insert(ReviewDto reviewDto);

    void update(ReviewDto reviewDto);

    void delete(Long userNumber);

    ReviewVo select(Long reviewNumber);

    List<ReviewVo> selectList(Long productNumber);

    List<ReviewVo> selectListPage(@Param("criteria") Criteria criteria, @Param("productNumber") Long productNumber);

    int selectTotal(Long productNumber);

}
