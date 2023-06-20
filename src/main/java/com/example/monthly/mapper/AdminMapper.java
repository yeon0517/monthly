package com.example.monthly.mapper;

import com.example.monthly.dto.SellerDto;
import com.example.monthly.vo.SearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    public List<SellerDto> selectAll(SearchVo searchVo);
}
