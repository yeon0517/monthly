package com.example.monthly.mapper;

import com.example.monthly.dto.SellerDto;
import com.example.monthly.vo.Criteria;
import com.example.monthly.vo.ParcelVo;
import com.example.monthly.vo.SearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ParcelMapper {
    public List<ParcelVo> selectParcelList(@Param("searchVo") SearchVo searchVo, @Param("criteria")Criteria criteria, Long brandNumber);
    public int selectParcelTotal(Long brandNumber, SearchVo searchVo);
}
