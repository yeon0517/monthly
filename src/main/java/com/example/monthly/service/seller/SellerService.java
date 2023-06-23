package com.example.monthly.service.seller;

import com.example.monthly.dto.SellerDto;
import com.example.monthly.mapper.SellerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SellerService {
    private final SellerMapper sellerMapper;
//    판매자신청
    public void sellerApply(SellerDto sellerDto){
        if(sellerDto == null){throw new IllegalArgumentException("판매자 정보 누락!");}
        sellerMapper.insert(sellerDto);
    }

//    판매자 아이디 중복확인
    @Transactional(readOnly = true)
    public int sellerIdCheck(String sellerId){
        if(sellerId==null){throw new IllegalArgumentException("아이디 정보 누락!");}
        return sellerMapper.selectId(sellerId);
    }
    
//    판매자 로그인
    /**
     * 판매자 로그인
     * @param sellerId
     * @param sellerPassword
     * @return
     * @throws IllegalArgumentException 존재하지 않는 회원 id, pw로 조회하는 경우
     */
    @Transactional(readOnly = true)
    public Long findSellerNumber(String sellerId, String sellerPassword){
        if(sellerId==null||sellerPassword==null){throw new IllegalArgumentException("아이디,패스워드 누락!");}
        return Optional.ofNullable(sellerMapper.selectSellerNumber(sellerId,sellerPassword))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 판매자 회원");});
    }
//    판매자 회원 정보 조회
    @Transactional(readOnly = true)
    public SellerDto findSellerInfo(Long sellerNumber){
        if(sellerNumber==null){
            throw new IllegalArgumentException("판매자 번호 누락!");
        }
        return Optional.ofNullable(sellerMapper.selectSellerInfo(sellerNumber))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 판매자 회원 정보");});
    }

//  판매자 현재 비밀번호 확인
    @Transactional(readOnly = true)
    public int checkCurrentPw(Long sellerNumber, String sellerPassword){
        if(sellerNumber==null||sellerPassword==null){throw new IllegalArgumentException("판매자번호, 패스워드누락!");}
        return Optional.ofNullable(sellerMapper.selectCurrentPw(sellerNumber, sellerPassword))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 판매자 비밀번호");});
    }
//    판매자 회원정보 수정
    public void modifySellerInfo(SellerDto sellerDto){
        if(sellerDto == null){throw new IllegalArgumentException("판매자 정보 누락!");}
        sellerMapper.updateSellerInfo(sellerDto);
    }
}
