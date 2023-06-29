package com.example.monthly.service.board;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.dto.ProductDto;
import com.example.monthly.mapper.BoardMapper;
import com.example.monthly.mapper.BrandMapper;
import com.example.monthly.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardMapper boardMapper;

    public List<BrandDto> brandSelect(){
       return boardMapper.brandSelect();
    };

    public List<ProductDto> productSelect(){return boardMapper.productSelect(); };

    public List<ProductVo> searchProductList(String searchSelect, String searchInput){
        return boardMapper.searchProductList(searchSelect, searchInput);
    }

}
