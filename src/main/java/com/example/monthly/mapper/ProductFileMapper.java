package com.example.monthly.mapper;

import com.example.monthly.dto.ProductFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductFileMapper {

    // 제품 이미지 파일 조회
    List<ProductFileDto> proFileSelect(Long productNumber);

//    대표이미지파일조회
    public ProductFileDto selectMainProductFile(Long productNumber);

//    상세이미지리스트 조회
    public List<ProductFileDto> selectDetailProductFile(Long productNumber);

//    제품이미지파일등록
    public void insertProductFile(ProductFileDto productFileDto);

    public void deleteProductFile(Long productNumber);
}
