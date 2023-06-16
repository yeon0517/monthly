package com.example.monthly.service.seller;

import com.example.monthly.mapper.SellerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SellerService {
    private final SellerMapper sellerMapper;
}
