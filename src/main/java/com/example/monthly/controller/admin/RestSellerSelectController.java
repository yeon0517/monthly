package com.example.monthly.controller.admin;

import com.example.monthly.dto.ReviewDto;
import com.example.monthly.dto.SellerDto;
import com.example.monthly.service.admin.AdminService;
import com.example.monthly.vo.SearchVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //화면 전환 이뤄지지 않음
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/search/*")
public class RestSellerSelectController {

    private final AdminService adminService;

    @GetMapping("/sellers")
    public List<SellerDto> searchSelect(String period,String searchSelect, String searchInput){
        SearchVo searchVo = new SearchVo();
        searchVo.setSearchSelect(searchSelect);
        searchVo.setPeriod(period);
        searchVo.setSearchInput(searchInput);

        System.out.println("============================");
        System.out.println(searchVo);
        return adminService.selectSeller(searchVo);
    }
    //영업 상태 수정
    @PatchMapping("/{sellerStatus}")
    public void statusModify(@PathVariable("sellerStatus") int sellerStatus,
                            @RequestBody SellerDto sellerDto){
        sellerDto.setSellerStatus(sellerStatus);
        adminService.statusModify(sellerDto);

    }
}

