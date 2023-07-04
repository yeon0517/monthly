package com.example.monthly.vo;

import com.example.monthly.dto.ProductFileDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@NoArgsConstructor
public class ProductFileListVo {
    private ProductFileDto mainFile;
    private List<ProductFileDto> files;
}
