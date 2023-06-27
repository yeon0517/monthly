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
//    브랜드 파일 정보 DB저장
    public void register(BrandFileVo brandFileVo) throws IllegalArgumentException{
        if(brandFileVo==null){
            throw new IllegalArgumentException("브랜드 파일 정보 누락");
        }
        if(brandFileVo.getBrandNumber()==null){
            throw new IllegalArgumentException("브랜드 번호 없음 / 브랜드 등록필요"); }

        int isExist = brandFileMapper.checkBrandFileExist(brandFileVo.getSellerNumber());
        if(isExist == 0){
            brandFileMapper.insertBrandFile(brandFileVo);
        }else{
            removeImg(brandFileVo.getSellerNumber());
            brandFileMapper.updateBrandFile(brandFileVo);
        }
    }

//    브랜드파일 정보 삭제
    public void remove(Long sellerNumber, String brandFileSize) {
        if (sellerNumber == null) {
            throw new IllegalArgumentException("판매자번호 누락");}
        removeImg(sellerNumber);
        brandFileMapper.deleteBrandFile(sellerNumber);
    }
//    브랜드이미지 실제파일 삭제
    public void removeImg(Long sellerNumber){
        if(sellerNumber==null){throw new IllegalArgumentException("판매자 번호누락");}
        BrandFileDto file = findBrandFile(sellerNumber);
        File target = new File(brandFileDir, file.getBrandFileUploadPath() + "/" + file.getBrandFileUuid() + "_" + file.getBrandFileName());
        File thumbnail = new File(brandFileDir, file.getBrandFileUploadPath() + "/th_" + file.getBrandFileUuid() + "_" + file.getBrandFileName());
        if (target.exists()) {
            target.delete();
        }
        if (thumbnail.exists()) {
            thumbnail.delete();
        }
    }

//    브랜드 파일조회

    public BrandFileDto findBrandFile(Long sellerNumber){
        if(sellerNumber==null){throw new IllegalArgumentException("판매자번호누락");}
        return brandFileMapper.selectBrandFileBySellerNumber(sellerNumber);
    }

//    실제 파일 저장처리
    public BrandFileVo saveBrandFile(MultipartFile file) throws IOException{

        String originName = file.getOriginalFilename();
        originName = originName.replaceAll("\\s+", "");//공백처리
        UUID uuid = UUID.randomUUID();
        String sysName = uuid.toString()+"_"+originName;
        File uploadPath = new File(brandFileDir, getUploadPath());

//        경로에 필요한 폴더 생성
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

//        brandNumber 제외한 모든 정보를 가진 brandFileVo 반환
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
    public void registerAndSaveBrandFile(MultipartFile file, Long sellerNumber, Long brandNumber)throws IOException, IllegalArgumentException{
        BrandFileVo brandFileVo = saveBrandFile(file);
        brandFileVo.setSellerNumber(sellerNumber);
        brandFileVo.setBrandNumber(brandNumber);
        register(brandFileVo);
    }

    //    파일이 저장되는 하위 경로를 현재 날짜로 설정할 것이기 때문에 현재 날짜를 구한다.
    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
}
