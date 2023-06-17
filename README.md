## 게시판 기능 구현 (API with JPA)
- API CRUD
- JPA
- pagination

---
### 1. 환경구축
- Language : Java 11
- Framework : Spring Boot 2.7.X
- DBMS : MySQL 8
- DB Library : JPA

### 2. 요구사항
- 목록 (글제목, 작성일, 작성자)
![img_1.png](img_1.png)
- 작성 ( 작성자, 비밀번호, 이메일, 핸드폰번호, 제목, 내용)
![img_3.png](img_3.png)
- 답변 (작성자, 비밀번호, 제목, 내용)
![img_7.png](img_7.png)

### 3. DB 설계
![img.png](img.png)

### 4. API
- 게시판 생성
![img_9.png](img_9.png)
- 게시판 조회
![img_10.png](img_10.png)
- 게시글 생성
![img_5.png](img_5.png)
- 게시글 열람
![img_6.png](img_6.png)
- 전체 게시글
![img_2.png](img_2.png)
- 답변 작성
![img_8.png](img_8.png)
