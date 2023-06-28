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
    void insert(SellerDto sellerDto);

    Long findAdminNumber(@Param("adminId")String adminId, @Param("adminPassword")String adminPassword);

//    public List<SellerDto> selectAll(SearchVo searchVo);


    List<AdminChartVo> sellerApplication();

    List<AdminChartVo> paymentCount();

}
