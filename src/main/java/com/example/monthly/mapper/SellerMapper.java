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

}
