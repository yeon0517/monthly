package com.example.monthly.mapper;

import com.example.monthly.dto.AdminDto;
import com.example.monthly.dto.SellerDto;
import com.example.monthly.vo.AdminChartVo;
import com.example.monthly.vo.SearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface AdminMapper {
    public void insert(SellerDto sellerDto);

    public void update(SellerDto sellerDto);
    Long findAdminNumber(@Param("adminId")String adminId, @Param("adminPassword")String adminPassword);

    //카테고리별 조회 검색
    List<SellerDto> selectSeller(SearchVo searchVo);

    List<AdminChartVo> sellerApplication(@Param("sellerRegisterDate") Date sellerRegisterDate);

}
