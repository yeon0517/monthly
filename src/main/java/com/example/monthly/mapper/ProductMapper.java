package com.example.monthly.mapper;

import com.example.monthly.dto.ProductDto;
import com.example.monthly.vo.Criteria;
import com.example.monthly.vo.ProductVo;
import com.example.monthly.vo.SearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductVo selectProduct(Long productNumber);
    public void insertProduct(ProductDto productDto);
    public void updateProduct(ProductDto productDto);
    public void deleteProduct(Long productNumber);

    public List<ProductVo> selectList(Long sellerNumber);
    public List<ProductVo> selectListPage(@Param("criteria") Criteria criteria, Long sellerNumber);
    public int selectTotal(Long sellerNumber);
    void amountChange(ProductVo productVo);
    public int selectSearchTotal(Long sellerNumber, SearchVo searchVo);
    public List<ProductVo> selectSearchProduct(Long sellerNumber, @Param("searchVo") SearchVo searchVo,@Param("criteria")Criteria criteria);
    public void updateStatus(ProductDto productDto);

}
