package com.example.monthly.service.board;

import com.example.monthly.mapper.ProductMapper;
import com.example.monthly.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductMapper productMapper;

    //조회
    public ProductVo productView(Long productNumber){
        if (productNumber == null) {
            throw new IllegalArgumentException("상품번호 누락");
        }
        return productMapper.selectProduct(productNumber);
    }

}
