package com.example.monthly.mapper;

import com.example.monthly.dto.BrandDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandMapper {
//    판매자가 등록한 브랜드 존재 여부 검사
    public int checkBrandExist(Long sellerNumber);
    // sellerNumber로 브랜드조회
    public BrandDto selectBrandBySellerNumber(Long sellerNumber);
//    sellerNumber로 brandNumber만 조회
    public Long selectBrandNumberBySellerNumber(Long sellerNumber);

    // 브랜드 등록
    public void insertBrand(BrandDto brandDto);

    // 브랜드 수정
    public void updateBrand(BrandDto brandDto);

    // 브랜드 삭제
    public void deleteBrand(Long brandNumber);
}
