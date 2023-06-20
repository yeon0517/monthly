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

    //brand 조회
    public Long brandSelectAll(Long brandNumber);

}
