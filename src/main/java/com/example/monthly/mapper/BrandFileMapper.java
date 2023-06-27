package com.example.monthly.mapper;

import com.example.monthly.dto.BrandFileDto;
import com.example.monthly.vo.BrandFileVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandFileMapper {

    public int checkBrandFileExist(Long sellerNumber);
    public void insertBrandFile(BrandFileVo brandFileVo);
    public void updateBrandFile(BrandFileVo brandFileVo);
    public BrandFileDto selectBrandFileBySellerNumber(Long sellerNumber);
    public void deleteBrandFile(Long sellerNumber);

}
