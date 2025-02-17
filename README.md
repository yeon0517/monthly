# 팀명 : monthly
SpringProject

# 프로젝트 이름 : 구독과 좋아요
## 팀 구성

|팀장|정우정|           
|:--:|:--:|
|부팀장|김준혁|
|팀원|강승연|
|팀원|박은서|
|팀원|김덕수|


## 프로젝트 주제 

1. ###  구매자 :
    개별 서비스들에 대해 각각의 사업체에 대한 가입절차를 거치지 않고도 바로 서비스를 이용가능. <br/>
개인의 구독서비스 파악, 관리, 이용성 증가

2. ###  판매자 :
 구독서비스 판매를 시작할 때 사업체의 개별적 홍보 어려움 극복<br/>
정기결제를 통한 매출 안정화, 향후 매출을 예측<br/>
일관된 경험과 혜택을 제공하여 고객 충성도를 향상

3. ### 관리자 :
  구독데이터를 수집하고 분석하여 선호도와 구매 패턴 등을 파악 <br/>
마케팅 전략을 개선하고 개인화된 서비스를 제공 가능<br/>
구독서비스를 기반으로 추후 플랫폼의 사업 확장 가능성

## ERD구성
![monthly ERD 구성](https://github.com/yeon0517/monthly/assets/112221690/729c11d3-08b9-4ecd-be1b-ae06f1b25c47)


### 😉 나의 역할 <br/>
프론트, 백엔드 : 메인페이지, 브랜드페이지, 브랜드 상세페이지,제품 All페이지, 관리자 모든 차트, 사이드바


⚙️ 개발 환경

java 11  <br/>
IDE : Eclipse <br/>
Framework : Springboot(2.x) <br/>
Database : Oracle DB(11xe) <br/>
ORM : Mybatis


📌 주요 기능 <br/>

로그인 <br/> 
● DB값 검증 <br/>
● ID찾기, PW찾기 <br/>
● 로그인 시 쿠키(Cookie) 및 세션(Session) 생성 <br/>

회원가입 <br/>
● ID 중복 체크 <br/>
● 비밀번호 유효성 검사 <br/>
● DB에 값 저장 <br/>

장바구니 및 결제페이지 <br/>
● 장바구니 재료 선택 <br/>
● 선택한 재료 총 결제 금액 알려주기 <br/>

### 메인페이지 [main WIKI 이동](https://github.com/yeon0517/monthly/wiki/%EB%A9%94%EC%9D%B8-%ED%8E%98%EC%9D%B4%EC%A7%80)  <br/>
● 브랜드 및 브랜드의 제품리스트 <br/>
● 사이드바<br/>
● 제품 검색 기능 <br/>

### 브랜드 ALL, LIST 페이지 [브랜드 ALL, LIST 페이지](https://github.com/yeon0517/monthly/wiki/%EB%B8%8C%EB%9E%9C%EB%93%9C-All,-List%ED%8E%98%EC%9D%B4%EC%A7%80)<br/> 
● 모든 브랜드 
● 대표 브랜드 이미지 및 제품 리스트

### 제품 ALL 페이지 [제품All WIKI 이동](https://github.com/yeon0517/monthly/wiki/%EC%A0%9C%ED%92%88%ED%8E%98%EC%9D%B4%EC%A7%80) <br/>
● 검색 시 제품ALL 페이지로 이동 <br/>
● 모든 제품 게시물 <br/> 

마이페이지 <br/>
● 찜한 게시물, 장바구니 게시물 <br/>
● 구독 캘린더 <br/>
● 프로필,기본정보 편집 <br/>
● 구매내역 조회 <br/>

판매자 페이지<br/>
● 판매자 로그인 <br/>
● 브랜드 등록 <br/>
● 제품 등록 <br/> 

관리자 페이지<br/>
● 관리자 로그인 <br/>
● 회원관리, 게시글 관리, 결제 관리<br/>
● 구독 문자 알림 서비스
##### ● 판매 매출, 판매자등록, 회원 증가 차트 [관리자 WIKI 이동](https://github.com/yeon0517/monthly/wiki/%EA%B4%80%EB%A6%AC%EC%9E%90-%EC%B0%A8%ED%8A%B8-%ED%8E%98%EC%9D%B4%EC%A7%80)



