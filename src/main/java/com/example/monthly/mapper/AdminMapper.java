package com.example.monthly.mapper;

import com.example.monthly.dto.SellerDto;
import com.example.monthly.vo.SearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
    void insert(SellerDto sellerDto);

    Long selectSellerNumber(@Param("sellerId")String sellerId, @Param("sellerName")String sellerName);

    public List<SellerDto> selectAll(SearchVo searchVo);
}
