package com.example.monthly.mapper;

import com.example.monthly.dto.BrandFileDto;
import com.example.monthly.vo.BrandFileVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandFileMapper {

    public int checkBrandFileExist(Long sellerNumber, String brandFileSize);
    public void insertBrandFile(BrandFileVo brandFileVo);
    public List<BrandFileDto> selectBrandFileList(Long sellerNumber);
    public BrandFileDto selectBrandFile(Long brandFileNumber);
    public Long selectBrandFileBySize(Long sellerNumber, String brandFileSize);
    public void updateBrandFile(BrandFileVo brandFileVo);
    public void deleteBrandFile(Long sellerNumber);

}
