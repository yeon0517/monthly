package com.example.monthly.service.admin;

import com.example.monthly.dto.ReviewDto;
import com.example.monthly.dto.SellerDto;
import com.example.monthly.mapper.AdminMapper;
import com.example.monthly.mapper.SellerMapper;
import com.example.monthly.vo.AdminChartVo;
import com.example.monthly.vo.ProductVo;
import com.example.monthly.vo.SearchVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {
    private final AdminMapper adminMapper;


//    관리자 로그인
    /**
     * 판매자 로그인
     * @param adminId
     * @param adminPassword
     * @return
     * @throws IllegalArgumentException 존재하지 않는 회원 id, pw로 조회하는 경우
     */
@Transactional(readOnly = true)
public Long findAdminNumber(String adminId, String adminPassword){
    if(adminId==null||adminPassword==null){throw new IllegalArgumentException("아이디,패스워드 누락!");}
    return Optional.ofNullable(adminMapper.findAdminNumber(adminId,adminPassword))
            .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 판매자 회원");});
}



// 차트 판매자 조회
    /**
     * 차트 판매자 조회
     * @return 판매자 정보 리스트
     */
    @Transactional(readOnly = true)
    public List<AdminChartVo> getSellerApplication() {
        return adminMapper.sellerApplication();
    }


// 월간 전체 매출액
    /**
     * 차트 판매자 조회
     * @return 판매자 정보 리스트
     */
    @Transactional(readOnly = true)
    public List<AdminChartVo> getPaymentCount() {
        return adminMapper.paymentCount();
    }



    //판매자 검색결과 조회 띄우기
    public List<SellerDto> selectSeller(SearchVo searchVo) {
        return adminMapper.selectSeller(searchVo);


    }

    //상태 변경
    public void statusModify(SellerDto sellerDto){
        if (sellerDto == null) {
            throw new IllegalArgumentException("수정 정보 누락");
        }
        adminMapper.update(sellerDto);
    }

    //상품 검색결과 조회 띄우기
    public List<ProductVo> searchProduct(SearchVo searchVo) {
        return adminMapper.searchProduct(searchVo);
    }
}

