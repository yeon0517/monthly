package com.example.monthly.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor //임의로 데이터를 받을수도 있어서 추가 했다.
public class Criteria {
    private int page; //현재 페이지
    private int amount; //한 페이지 당 게시물 수

//    컨트롤러의 매개변수는 자동으로 기본 생성자가 실행된다.
//    그러므로 page,amount에 대한 데이터가 전달되지 않으면 자동으로 1페이지의 내용이 리스트에 나타나게 된다.
//    만약 page,amount에 대한 데이터가 URL을 통해서 들어온다면 criteria객체의 setter가 실행된다.
//    page만 들어와도 amount는 기본 생성자에 의해 12로 초기화가 된다.
    public Criteria(){
//        위와 아래는 같다.
//        this.page =1;
//        this.amount =12;
        this(1,5);
    }

}
