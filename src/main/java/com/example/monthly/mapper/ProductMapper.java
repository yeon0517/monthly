package com.example.monthly.mapper;

import com.example.monthly.dto.ProductDto;
import com.example.monthly.vo.Criteria;
import com.example.monthly.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductVo selectProduct(Long productNumber);
    public void insertProduct(ProductDto productDto);
    public void updateProduct(ProductDto productDto);
    public void deleteProduct(Long productNumber);
    public List<ProductVo> selectAll(Criteria criteria, Long sellerNumber);
    public int selectTotal(Long sellerNumber);
}
