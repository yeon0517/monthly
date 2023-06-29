package com.example.monthly.mapper;

import com.example.monthly.dto.ExSubsDto;
import com.example.monthly.dto.SubsDto;
import com.example.monthly.vo.SubsVo;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.creation.SuspendMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class SubsMapperTest {

    private SubsMapper subsMapper;
    private SubsDto subsDto;
    private ExSubsDto exSubsDto;

    @Autowired
    void setUp(){
        subsDto = new SubsDto();
        subsDto.setUserNumber(1L);

        exSubsDto= new ExSubsDto();
        exSubsDto.setExSubsDate("2023-06-29");
        exSubsDto.setUserNumber(1L);
        exSubsDto.setExSubsPrice("13000");
        exSubsDto.setExSubsName("넷플릭스");
    }

    @Test
    void subsSelect() {
        List<SubsVo> subsVoList = subsMapper.subsSelect(1L);

        Assertions.assertThat(subsVoList.contains(subsDto.getUserNumber())).isTrue();
    }

    @Test
    void exSubsInsert(){
        subsMapper.exSubsInsert(exSubsDto);

        Assertions.assertThat(subsMapper.exSubsSelect(subsDto.getUserNumber()).getExSubsDate()).isEqualTo(exSubsDto.getExSubsDate());
    }
}