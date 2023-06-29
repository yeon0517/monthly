package com.example.monthly.service.user;

import com.example.monthly.dto.ExSubsDto;
import com.example.monthly.mapper.SubsMapper;
import com.example.monthly.vo.SubsVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MypageService {

    private final SubsMapper subsMapper;

//    내부 구독 정보 출력
    public List<SubsVo> subsFindAll(Long userNumber){
        if (userNumber == null) {
            throw new IllegalArgumentException("회원 번호 누락");
        }
        return subsMapper.subsSelect(userNumber);
    }

//    외부 구독 추가
    public void exSubsRegister(ExSubsDto exSubsDto){
        if (exSubsDto == null) {
            throw new IllegalArgumentException("외부 구독 정보 누락");
        }
        subsMapper.exSubsInsert(exSubsDto);
    }

    public ExSubsDto exSubsFindAll(Long userNumber){
        if (userNumber == null) {
            throw new IllegalArgumentException("회원 번호 누락");
        }
        return subsMapper.exSubsSelect(userNumber);
    }



}
