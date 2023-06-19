package com.example.monthly.mapper;

import com.example.monthly.dto.BrandDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandMapper {
    public void brandInsert(BrandDto brandDto);
}
