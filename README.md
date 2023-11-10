# WatchaPedia_Project
> SpringBoot 와 SpringSecurity, SQL 등 백엔드 웹 개발 기술을 배운 것들로 
> 왓챠피디아 클론코딩 Team Project를 진행했습니다.
<br>

<img alt="watchaPedia" src="https://github.com/mollani0704/WatchaPedia_Project_Backup/assets/72548305/8c42a872-27ba-4c0e-bfe1-ef31ba42cf09" width="550">

## 사용 기술스택
<p>
  <img alt="html5" src="https://img.shields.io/badge/-html5-F44336?style=flat-square&logo=html5&logoColor=white" />
  <img alt="css" src="https://img.shields.io/badge/-css-03A9F4?style=flat-square&logo=css3&logoColor=white" />
  <img alt="javascript" src="https://img.shields.io/badge/-javascript-FFEB3B?style=flat-square&logo=javascript&logoColor=white" />
  <img alt="springboot" src="https://img.shields.io/badge/-springboot-13aa52?style=flat-square&logo=springboot&logoColor=white" />
  <img alt="thymeleaf" src="https://img.shields.io/badge/-thymeleaf-13aa52?style=flat-square&logo=thymeleaf&logoColor=white" />
  <img alt="Java" src="https://img.shields.io/badge/-java-007396?style=flat-square&logo=java&logoColor=white" />
  <img alt="MariaDB" src="https://img.shields.io/badge/-mariadb-42A5F5?style=flat-square&logo=mariadb&logoColor=white" />
</p>

## 구현기능
### Oauth2를 이용해 구글 로그인 구현
> 카카오, 네이버, 구글, 페이스북 Oauth2 로그인을 구현했습니다.
<img alt="Login" src="https://github.com/mollani0704/WatchaPedia_Project_Backup/assets/72548305/46087768-cd4d-411f-976e-8be90209249b" width="550">

### 보고싶어요 기능 구현
> 보고싶어요 버튼을 누르면 버튼의 스타일이 바뀜. 이후 개인 보고싶어요 리스트에 추가됨.
<img alt="wish" src="https://github.com/mollani0704/WatchaPedia_Project_Backup/assets/72548305/be89c04e-3354-43b1-ad26-41654b2292a5" width="550">
<img alt="wish_like" src="https://github.com/mollani0704/WatchaPedia_Project_Backup/assets/72548305/8edac920-0119-468b-b6fe-e828f89a45a8" width="550">
<img alt="wish_list" src="https://github.com/mollani0704/WatchaPedia_Project_Backup/assets/72548305/77b87191-7211-4031-bbe3-d16e624c500e" width="550">

### 코멘트 기능 구현
> 코멘트를 적으면 해당 작품에 코멘트를 남길 수 있다.
<img alt="comment" src="https://github.com/mollani0704/WatchaPedia_Project_Backup/assets/72548305/726d9e54-4357-4acb-bc0d-786cc8c57817" width="550">
<img alt="comment_list" src="https://github.com/mollani0704/WatchaPedia_Project_Backup/assets/72548305/87305134-4417-434e-a098-07c78057b800" width="550">

## 프로젝트의 진행과정 및 느낀점.
### 진행과정
- 팀원이 4명이서 구성되었고 프로젝트는 왓챠피디아 영화 평점 사이트를 선택했다.
- 왓챠피디아를 선택한 이유는 각자 영화를 좋아하기도 했고 프론트부분이 리액트로 짜여져 있다는 것을 알고 리액트와 Spring을 연동해 프로젝트를 진행해보고 싶었기 때문이다.
- 개발환경은 SpringBoot, React, DB는 MariaDB를 사용하면서 AWS Database를 연동해서 구성했다.
- 프로젝트를 시작하고 회의를 거치면서 먼저 DB 테이블부터 설계하고 포론트 부분을 다 같이 React로 빠르게 끝낸 뒤에 남은 기간을 백엔드 부분을 완성시키는 것으로 계획을 했다.
- 프로젝트가 시작 된지 1주를 조금 넘은 상황에서 팀장과 팀원 1명이 개인사정으로 팀을 나가게 되면서 프로젝트 진행에 큰 차질이 생겼고 위기가 닥쳤다. 리액트로 프론트만 하다가 프로젝트가 끝날 거 같아서 내가 팀장을 다시 맡고 남은 팀원과 회의를 계속 한 결과 React를 포기하고 Thymeleaf로 프론트 단을 교체하고 팀원 한명이 프론트를 내가 백엔드를 맡는 걸로 해서 빠르게 진행하는 것으로 결정했다.
- 위기인 부분을 서로 의사소통을 계속 하면서 보완하는데 일단 DB 부분부터 손을 좀 봐야했다. Movie, Drama, Book 세 카테고리를 하나의 테이블에 넣어서 카테고리로 구분을 줘서 데이터를 가져오자고 처음에 설계를 했고 그렇게 하는게 쉬울 줄 알았는데 나중에 다른 기능들을 넣을 때 너무 복작하게 될 거 같고 또 한 테이블에 너무 많은 데이터가 합쳐질 거 같아서 세 개로 분리해 진행했다.
- 프로젝트의 핵심적인 기능은 좋아요, 코멘트, 보고싶은 영화, 평점 이렇게 4가지 이다. 기능을 만들면서 DB 부분에서 계속 어려움이 있었다. Movie테이블에 4가지 기능에 대한 컬럼을 함께 넣어서 진행했다. 하지만 진행하다 보니 코멘트를 삭제를 하거나 좋아요나 평점에 대한 수정이 이루어졌을 때 값이 중복되서 생성되는 문제도 생기고 값이 다 같이 없어지는 현상도 종종 생겨서 4가지 기능에 대한 테이블을 다 따로 만든 후에 movie_id를 외래키로 가져와서 movie 테이블과 연결해서 진행하는 방식으로 바꿔 해결했다.
- 시간이 있을 때 프론트 부분도 좀 맡아서 진행했는데 평점을 매기는 데 벌표 모양의 아이콘으로 표시해 만들고 싶었다. hover를 이용해서 아이콘에 색칠하는 것은 어느정도 만들었는데 클릭시 평점의 값을 전달하는 게 조금 어려웠다. 이 부분을 input에 value 값을 미리 지정한 후에 javascript로 값을 받아와서 서버에 넘기는 방식으로 해결했다.
- Git을 통해 서로의 부분을 commit하고 1주일에 한 번씩 각자 한 것을 git merge를 통해 합쳐서 진행했고 이를 Github에 올리면서 프로젝트를 진행했다.

### 느낀 점
- Spring에 대한 이해와 CURD 흐름에 대해 크게 배울 수 있는 계기가 되었다. 
- 팀 프로젝트를 하면서 팀원들과 의사소통 하는 방법을 기를 수 있는 아주 좋은 경험이었다.
- 팀원 2명이 빠지면서 위기가 있었고 포기하고 싶은 마음도 들었지만 부족할 지라도 이 위기를 극복해보는 경험을 가져보자라고 팀원과 이야기 했고 결국엔 프로젝트를 잘 마무리 할 수 있었다.
- '이 기능이 어떻게 동작할까' 하는 고민을 통해 기능을 구현해 봄으로써 서비스에 대한 이해가 생겼고 사용자에게 좀 더 나은 서비스를 고민하고 구현하는 것이 개발자로 성장하기 위해 필수적이라는 걸 느꼈다.
- 혼자 고민하는 것보다 팀원과 함께 고민하면서 기능을 코드로 구현하는 문제, 프로젝트에 대한 문제들을 해결 할 수 있었다.
- 더 큰 웹 애플리케이션의 복잡성과 규모에 대한 체감을 할 수 있었고 협동력이 그만큼 개발자에게 매우 중요한 요소라는 걸 알게 됐다.
- Backend와 Frontend의 실력을 함께 향상시킬 수 있는 좋은 발판이 되었고 위기를 극복했다는 성취감도 얻을 수 있었다.
