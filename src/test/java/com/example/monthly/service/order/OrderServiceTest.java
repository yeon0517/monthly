package com.example.monthly.service.order;

import com.example.monthly.dto.DeliveryDto;
import com.example.monthly.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
@Slf4j
class OrderServiceTest {

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderService orderService;

    private DeliveryDto deliveryDto;

    @Autowired
    void setUp(){
        deliveryDto = new DeliveryDto();
        deliveryDto.setDeliveryPostcode("강남");
        deliveryDto.setDeliveryAddress1("평택시");
        deliveryDto.setDeliveryAddress2("서정동");
        deliveryDto.setUserNumber(1L);
    }

    @Test
    void findDelivery() {
        doReturn(deliveryDto).when(orderMapper).select(any(Long.class));

        DeliveryDto board = orderService.findDelivery(1L);

        assertThat(board.getDeliveryPostcode()).isEqualTo(deliveryDto.getDeliveryPostcode());
    }

    @Test
    void registerDelivery() {
    }

    @Test
    void changeDelivery() {
    }
}