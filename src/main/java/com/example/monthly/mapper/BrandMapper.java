package com.example.monthly.mapper;

import com.example.monthly.dto.BrandDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandMapper {
    // 추가
    public void brandInsert(BrandDto brandDto);

    // 삭제
    public void brandDelete(Long brandNumber);

    // 수정
    public void brandUpdate(BrandDto brandDto);

//    판매자가 등록한 브랜드 존재 여부 검사
    public int checkBrandExist(Long sellerNumber);

    // 개인브랜드조회
    public BrandDto brandSelectBySellerNumber(Long sellerNumber);

    //brand 조회
    public Long brandSelectAll(Long brandNumber);

}
