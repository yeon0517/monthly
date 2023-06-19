package com.example.monthly.service.board;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandService {
    private final BrandMapper brandMapper;

    public void register(BrandDto brandDto){
        if(brandDto == null){
            throw new IllegalArgumentException("brand 추가 내용이 없습니다.(null)");
        }
        brandMapper.brandInsert(brandDto);
    }
}
