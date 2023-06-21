package com.example.monthly.mapper;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BrandDto> brandSelect();
//    이것의 이름은  Service에서 만든 이름으로.. 괄호 안에는 매개변수가 들어가야하는데 지금 현재 안받아서 비워둠

    List<ProductDto> productSelect();



}
