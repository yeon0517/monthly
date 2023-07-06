package com.example.monthly.service.board;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.mapper.BrandMapper;
import com.example.monthly.mapper.ParcelMapper;
import com.example.monthly.vo.Criteria;
import com.example.monthly.vo.ParcelVo;
import com.example.monthly.vo.ProductVo;
import com.example.monthly.vo.SearchVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ParcelService {
    private final ParcelMapper parcelMapper;

    //  sellerNumber로 브랜드 정보 조회
    @Transactional(readOnly = true)
    public List<ParcelVo> findParcelList(SearchVo searchVo, Criteria criteria){
        System.out.println("===============검색 productService진입==================");
        if(criteria==null || searchVo==null){throw new IllegalArgumentException("주문-검색정보누락");}
        return parcelMapper.selectParcelList(searchVo, criteria);
    }
}
