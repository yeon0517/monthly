package com.example.monthly.service.admin;

import com.example.monthly.dto.SellerDto;
import com.example.monthly.mapper.AdminMapper;
import com.example.monthly.mapper.SellerMapper;
import com.example.monthly.vo.SearchVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {
    private final AdminMapper adminMapper;
    //전체조회
    @Transactional(readOnly = true)
    public List<SellerDto> findAll(SearchVo searchVo) {
        return adminMapper.selectAll(searchVo);

    }

    }

