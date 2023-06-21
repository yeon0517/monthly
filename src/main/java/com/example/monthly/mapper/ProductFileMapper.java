package com.example.monthly.mapper;

import com.example.monthly.dto.ProductFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductFileMapper {

    // 제품 이미지 파일 조회
    List<ProductFileDto> proFileSelect(Long productNumber);
}
