package com.example.monthly.mapper;

import com.example.monthly.dto.SellerDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerMapper {
//    판매자 신청
    public void insert(SellerDto sellerDto);
//    판매자 아이디 중복검사
    public int selectId(String sellerId);
//    판매자 로그인
    public Long selectSellerNumber(@Param("sellerId")String sellerId, @Param("sellerPassword")String sellerPassword);
//    판매자 정보 조회
    public SellerDto selectSellerInfo(Long sellerNumber);
//    판매자 현재 비밀번호 확인
    public int selectCurrentPw(@Param("sellerNumber")Long sellerNumber, @Param("sellerPassword")String sellerPassword);
//    판매자 회원 정보 수정처리
    public void updateSellerInfo(SellerDto sellerDto);
}
