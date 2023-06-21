package com.example.monthly.service.board;

import com.example.monthly.dto.ProductFileDto;
import com.example.monthly.mapper.ProductFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductFileService {

    private final ProductFileMapper productFileMapper;

    public List<ProductFileDto> proFileList(Long productNumber){
        if (productNumber == null) {
            throw new IllegalArgumentException("제품 번호 누락");
        }

        return productFileMapper.proFileSelect(productNumber);
    }
}
