package com.example.monthly.mapper;

import com.example.monthly.dto.ExSubsDto;
import com.example.monthly.vo.SubsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubsMapper {

    //내부 구독 정보 출력
    public List<SubsVo> subsSelect(Long userNumber);

//    외부 구독 추가
    void exSubsInsert(ExSubsDto exSubsDto);
//    외부 구독 조회
    ExSubsDto exSubsSelect(Long userNumber);
}
