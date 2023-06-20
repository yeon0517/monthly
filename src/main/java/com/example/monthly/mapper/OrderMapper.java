package com.example.monthly.mapper;

import com.example.monthly.dto.DeliveryDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    void insert(DeliveryDto deliveryDto);

    DeliveryDto select(Long userNumber);

    void update(DeliveryDto deliveryDto);

}
