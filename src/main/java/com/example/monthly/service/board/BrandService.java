package com.example.monthly.service.board;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandService {

    private final BrandMapper brandMapper;


    //  sellerNumber로 브랜드 정보 조회
    @Transactional(readOnly = true)
    public BrandDto findBrandInfo(Long sellerNumber) {
        if (sellerNumber == null) {
            throw new IllegalArgumentException("판매자 번호 누락");
        }
        return Optional.ofNullable(brandMapper.selectBrandBySellerNumber(sellerNumber))
                .orElse(new BrandDto()); // 조회했는데 brand가 없어서 null일경우 그냥 새 BrandDto객체를찍어서 넘겨준다
    }

    //    sellerNumber로 브랜드 정보조회
    @Transactional(readOnly = true)
    public Long checkBrandNumber(Long sellerNumber) {
        if (sellerNumber == null) {
            throw new IllegalArgumentException("판매자 정보 누락");
        }
            int isExist = brandMapper.checkBrandExist(sellerNumber);
            return isExist == 0 ? null : brandMapper.selectBrandNumberBySellerNumber(sellerNumber);
    }

//  브랜드 정보 저장 (brand가 없으면 insert, 있으면 update)
        public void saveBrandInfo (BrandDto brandDto){
            if (brandDto == null) {
                throw new IllegalArgumentException("brand 추가 내용이 없습니다.(null)");
            }
            int isExist = brandMapper.checkBrandExist(brandDto.getSellerNumber()); //0아니면 1이 온다
            System.out.println("****************" + isExist);
//        0 이면 insert, 1 이면 update
            if (isExist == 1) {
                brandMapper.updateBrand(brandDto);
            } else {
                brandMapper.insertBrand(brandDto);
            }
        }

    }
