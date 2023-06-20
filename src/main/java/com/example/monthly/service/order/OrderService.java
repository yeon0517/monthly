package com.example.monthly.service.order;

import com.example.monthly.dto.DeliveryDto;
import com.example.monthly.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderMapper orderMapper;

    public DeliveryDto findDelivery(Long userNumber){
        if (userNumber == null) {
            throw  new IllegalArgumentException("회원 번호 누락");
        }
        return orderMapper.select(userNumber);
    }

    public void registerDelivery(DeliveryDto deliveryDto){
        if (deliveryDto == null) {
            throw new IllegalArgumentException("배송지 정보 누락");
        }
        orderMapper.insert(deliveryDto);
    }

    public void changeDelivery(DeliveryDto deliveryDto){
        if (deliveryDto == null) {
            throw new IllegalArgumentException("배송지 정보 누락");
        }
        orderMapper.update(deliveryDto);
    }

}
