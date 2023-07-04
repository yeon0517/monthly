package com.example.monthly.controller.board;

import com.example.monthly.dto.ProductFileDto;
import com.example.monthly.service.board.ProductFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController //화면 전환 이뤄지지 않음
@RequiredArgsConstructor
@RequestMapping("/profiles/*")
public class ProductFileController {
    private final ProductFileService productFileService;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/imgList")
    public List<ProductFileDto> imgList(Long productNumber){
        return productFileService.proFileList(productNumber);
    }

    //    서버 컴퓨터에 저장된 파일을 복사하여 넘겨주는 핸들러
    @GetMapping("/display")
    public byte[] display(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileDir,fileName));
    }
}
///upload/display?filename=${filename}