package com.example.monthly.mapper;

import com.example.monthly.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    ProductVo selectProduct(Long productNumber);
}
