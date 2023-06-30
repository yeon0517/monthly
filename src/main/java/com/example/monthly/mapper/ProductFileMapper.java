package com.example.monthly.mapper;

import com.example.monthly.dto.ProductFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductFileMapper {

    // 제품 이미지 파일 조회
    List<ProductFileDto> proFileSelect(Long productNumber);

//    제품이미지파일등록
    public void insertProductFile(ProductFileDto productFileDto);
//    1개 파일 조회 필요할까?
    public ProductFileDto selectProductFile(Long productFileNumber);
//    업데이트필요할까?
    public void updateProductFile(Long productFileNumber);
    public void deleteProductFile(Long productNumber);
}
