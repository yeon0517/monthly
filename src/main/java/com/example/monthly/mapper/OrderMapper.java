package com.example.monthly.mapper;

import com.example.monthly.dto.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

//    배송지 추가
    void insert(DeliveryDto deliveryDto);

//    배송지 조회
    DeliveryDto select(Long userNumber);

//    배송지 수정
    void update(DeliveryDto deliveryDto);

//    구독 추가
    void subsInsert(SubsDto  subsDto);

//    카카오 결제 정보 추가
    void kakaPay(KakaoDto kakaoDto);

//    카드 추가
    void cardInsert(CardDto cardDto);

//    결제 추가
    void paymentInsert(PaymentDto paymentDto);

//    배송주문 추가
    void parcelInsert(ParcelDto parcelDto);


}
