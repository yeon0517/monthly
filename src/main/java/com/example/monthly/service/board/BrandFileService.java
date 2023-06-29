package com.example.monthly.service.board;

import com.example.monthly.dto.BrandFileDto;
import com.example.monthly.mapper.BrandFileMapper;
import com.example.monthly.mapper.BrandMapper;
import com.example.monthly.vo.BrandFileVo;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandFileService {
    private final BrandFileMapper brandFileMapper;
    private final BrandMapper brandMapper;


    @Value("${brand.file.dir}")
    private String brandFileDir;

//    브랜드파일 정보 DB 저장
    public void register(BrandFileVo brandFileVo)throws IllegalArgumentException{
        if(brandFileVo == null){throw new IllegalArgumentException("브랜드파일정보누락");}
        if(brandFileVo.getBrandNumber()==null){throw new IllegalArgumentException("브랜드번호없음 브랜드등록필요");}
        int isExist = brandFileMapper.checkBrandFileExist(brandFileVo.getSellerNumber(),brandFileVo.getBrandFileSize());
        if(isExist==0){
            brandFileMapper.insertBrandFile(brandFileVo);
        }else{
            Long brandFileNumber = brandFileMapper.selectBrandFileBySize(brandFileVo.getSellerNumber(),brandFileVo.getBrandFileSize());
            brandFileVo.setBrandFileNumber(brandFileNumber);
//            실제 파일은 삭제하고 DB에 정보는 남겨둔다
            removeImg(brandFileNumber);
//            DB에 있는 파일정보는 업데이트한다.
            brandFileMapper.updateBrandFile(brandFileVo);

        }
    }
//    실제 브랜드파일삭제
    public void removeImg(Long brandFileNumber){
        if(brandFileNumber==null){throw new IllegalArgumentException("판매자번호누락");}
        BrandFileDto file = findBrandFile(brandFileNumber);
        File target = new File(brandFileDir,file.getBrandFileUploadPath()+"/"+file.getBrandFileUuid()+"_"+file.getBrandFileName());
        File thumbnail = new File(brandFileDir, file.getBrandFileUploadPath()+"/th_"+file.getBrandFileUuid()+"_"+file.getBrandFileName());
        if(target.exists()){target.delete();}
        if(thumbnail.exists()){thumbnail.delete();}
    }

//    브랜드파일정보 DB삭제
    public void remove(Long sellerNumber){
        if(sellerNumber == null){throw new IllegalArgumentException("판매자 번호 누락");}
        brandFileMapper.deleteBrandFile(sellerNumber);
    }

//    판매자 번호로 브랜드파일 리스트 조회
    @Transactional(readOnly = true)
    public List<BrandFileDto> findList(Long sellerNumber){return brandFileMapper.selectBrandFileList(sellerNumber);}

//   파일번호로 브랜드파일 1개 조회
    @Transactional(readOnly = true)
    public BrandFileDto findBrandFile(Long brandFileNumber){
        if(brandFileNumber==null){throw new IllegalArgumentException("브랜드 파일 번호 누락");}
        return Optional.ofNullable(brandFileMapper.selectBrandFile(brandFileNumber))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 브랜드파일");});
    }

//  파일번호 조회 : 긴거 짧은거 구분
    @Transactional(readOnly = true)
    public Long findBrandFileNumber(Long sellerNumber, String brandFileSize){
        if(sellerNumber == null){throw new IllegalArgumentException("판매자번호누락");}
        else if(brandFileSize == null){throw new IllegalArgumentException("파일사이즈 누락");}
        return Optional.ofNullable(brandFileMapper.selectBrandFileBySize(sellerNumber, brandFileSize))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 파일번호");} );
    }

//    실제 파일 저장
    public BrandFileVo saveBrandFile(MultipartFile file) throws IOException{

        String originName = file.getOriginalFilename();
        originName = originName.replaceAll("\\s+", "");//공백처리
        UUID uuid = UUID.randomUUID();
        String sysName = uuid.toString()+"_"+originName;
        File uploadPath = new File(brandFileDir, getUploadPath());

        // 경로에 필요한 폴더 생성
        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }
        File uploadFile = new File(uploadPath, sysName);
        file.transferTo(uploadFile);

        if(Files.probeContentType(uploadFile.toPath()).startsWith("image")){
            FileOutputStream out = new FileOutputStream(new File(uploadPath, "th_"+sysName));
            Thumbnailator.createThumbnail(file.getInputStream(),out, 300, 300);
            out.close();
        }

//        brandNumber,sellerNumber,brandFileSize 제외한 정보를 가진 brandFileVo 반환
        BrandFileVo brandFileVo = new BrandFileVo();
        brandFileVo.setBrandFileName(originName);
        brandFileVo.setBrandFileUuid(uuid.toString());
        brandFileVo.setBrandFileUploadPath(getUploadPath());
        return brandFileVo;
    }

    /**
     * 브랜드 대표 이미지파일을 DB 등록 및 실제파일 저장처리
     * @param file
     * @param sellerNumber
     * @throws IOException
     */
    public void registerAndSaveBrandFile(MultipartFile file, String brandFileSize, Long sellerNumber, Long brandNumber)throws IOException, IllegalArgumentException{
        BrandFileVo brandFileVo = saveBrandFile(file);
        brandFileVo.setSellerNumber(sellerNumber);
        brandFileVo.setBrandNumber(brandNumber);
        brandFileVo.setBrandFileSize(brandFileSize);
        register(brandFileVo);
    }

    //    파일이 저장되는 하위 경로를 현재 날짜로 설정할 것이기 때문에 현재 날짜를 구한다.
    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
}
