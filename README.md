
# Thymeleaf

![Thymeleaf](https://img.shields.io/badge/-Thymeleaf-005F0F?style=flat-square&logo=Thymeleaf&logoColor=white)


## 뷰 템플릿 엔진 타임리프 공부용 레포지토리 

작성자 : 배제우 

Mail   : baejeu@naver.com

## ▶ Environment 

> Language : Java 17

> IDE : Intellij

> Framework : SpringBoot (3.2.5)

 
 ## ▶ Reference data
 
 ➡ 타임리프 공식 사이트 https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#what-is-thymeleaf
 
 ➡ 코딩하는 포로리 https://velog.io/@alicesykim95/Thymeleaf 
 
 ➡ README Simple Icons https://simpleicons.org/?q=Thy 

 
 ## Thymeleaf(타임리프)?

 타임리프는 View Templete Engine 으로 JSP, Freemarkerd, Velocity 와 같이 SSR(Server Side Rendering) 이다. 
 
 즉 서버에서 클라이언트에게 동적으로 응답할 브라우저 화면을 만들어주는 역할을 한다.


## Thymeleaf 장점 

1. 자연스러운 문법 : 타임리프는 자연스러운 문법을 제공하여 HTML 파일을 쉽게 통합할 수 있습니다. 이로 인해 개발자들은 빠르게 템플릿을 작성하고 유지보수할 수 있다.

2. 통합 용이성 : Spring 에서도 Spring Boot와 Thymeleaf를 함께 사용하는 것을 권장한다. JSP 사용 시 호환 및 환경설정에 어려움이 많다.
   반대로 타임리프는 간편하게 Depedency 추가 작업으로 사용할 수 있다.

3. View 집중 : JSP와 달리 Servlet Code로 변환되지 않기 때문에 비즈니스 로직과 분리되어 View에 집중할 수 있다.

4. 사용자 편의 : 서버상에서 동작하지 않아도 되기 때문에 서버 동작 없이 화면을 확인할 수 있다. 때문에 더미 데이터를 넣고 화면 디자인 밑 테스트에 용이하다.

5. 최종 사용자 친화적 : 타임리프는 최종 사용자가 이해하기 쉬운 템플릿을 생성할 수 있습니다. 템플릿에 태그를 추가하거나 속성을 변경하여 최종 출력물을 조작할 수 있으며, 이는 디자이너와 협업할 때 유용합니 
   다.

6. 템플릿 캐싱: 타임리프는 템플릿 캐싱을 지원하여 효율적인 성능을 제공합니다. 이를 통해 반복적으로 사용되는 템플릿을 미리 컴파일하고 캐시하여 속도를 향상시킵니다.
   그래서 초기 페이지 로딩 속도가 빠르다.

## Thymeleaf 설정 🛠️ 

1) 의존성 추가

Maven은 pom.xml에, Gradle은 build.gradle에 타임리프의 dependency를 추가해준다.

👉 Maven
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
👉 Gradle
```java
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
```

2) 타임리프를 적용하는 HTML 문서에 네임스페이스 추가 

```HTML
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1 th:text="${name}">Name</h1>
</body>
</html>
```
## 설명 

스프링 MVC 공부를 위해서가 아니라 순수하게 타임리프 공부를 위해서 최소한의 MVC 구성만 해두었다.

Controller -> Thymeleaf.study.MyController.java




## Thymeleaf 문법 정리 



  
 
