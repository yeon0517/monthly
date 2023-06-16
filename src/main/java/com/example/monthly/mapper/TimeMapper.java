package com.example.monthly.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//  이 인터페이스를 (이용하여 만든 구현체를)빈으로 등록하고
//  매퍼를 사용하기 위한 인터페이스인 것을 알려주기 위해 @Mapper 어노테이션을 사용
@Mapper
public interface TimeMapper {
//    Mapper.xml의 쿼리 id와 일치하는 메소드 이름을 사용하면 알아서 매핑된다.
    String getTime();

//    매우 간단한 쿼리는 mapper.xml에 등록하지 않고 어노테이션안에 쿼리 가능하지만 잘 안씀!
    @Select("SELECT SYSDATE FROM DUAL")
    String getTime2();
}

