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

    //추가
    public void register(BrandDto brandDto){
        if(brandDto == null){
            throw new IllegalArgumentException("brand 추가 내용이 없습니다.(null)");
        }
        brandMapper.brandInsert(brandDto);
    }

    // 삭제
    public void remove(Long brandNumber){
        if(brandNumber == null) {
            throw new IllegalArgumentException("존재하지 않는 브랜드입니다.");
        }
        // 브랜드 삭제라서 브랜드 이미지도 나중에 삭제 할 수도 있음 //

        brandMapper.brandDelete(brandNumber);
    }

    //수정
    public void modify(BrandDto brandDto){
        if(brandDto == null){
            throw new IllegalArgumentException("브랜드 수정할 정보가 없습니다.");
        }
        // 브랜드 이미지 사진 수정 할 수도 있음 //

        brandMapper.brandUpdate(brandDto);
    }

    // 전체 조회





}
