
# Thymeleaf (SSR) + HTML 

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
 
 ➡ makeaplayground https://makeaplayground.tistory.com/187
  
 ➡ 인프런 김영한 강사님 스프링 MVC PDF
 
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

2) application.properties 여러 설정
   
```java
# Thymeleaf 사용
spring.thymeleaf.enabled=true
# cache 사용 /사용 시 컴파일한 파일만 사용 
spring.thymeleaf.cache=false
# 템플릿 위치 / View 파일 위치 
spring.thymeleaf.prefix=classpath:templates/
# View 파일 기본 확장자
spring.thymeleaf.suffix=.html
```   
3) 타임리프를 적용하는 HTML 문서에 네임스페이스 추가 

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
## basic expression

### 📌 간단한 표현

변수 표현식 ${…}

선택 변수 표현식 *{…}

메세지 표현식 #{…}

링크 URL 표현식 @{…}

조건 표현식 ~{…}

### 📌 리터럴

텍스트  ‘one text’,  ‘Another one!’, …

숫자  0, 34, 3.0, 12,3, …

불린  true, false

널 null

리터럴 토큰 one, sometext, main, …

### 📌 문자 연산 

문자 합치기 +

리터럴 대체 |The name is ${name}|

### 📌 산술 연산 

Binary operators +, -, *, /, %

Minus sign (unary operator) -

### 📌 불린 연산 

Binary operators and, or 

Boolean negation (unary operator) !, not 

### 📌 비교와 동등

비교 >, <, >=, <=, (gt, lt, get, le)

동등 연산 ==, != (eq, ne)

### 📌 조건 연산

If- then (if) ? (then)

If-then-else (if) ? (then) : (else)

Default: (value) ? : (defaultvalue)

### 📌 특별한 토큰

No-Operation: _

## HTML 태그 정리

### 📌 <html> 태그

```HTML
<!DOCTYPE html>
<html>
<head>
    <title>문서 제목</title>
</head>
<body>
    <!-- 내용 작성 -->
</body>
</html>
```

<html>: HTML 문서의 시작을 나타내는 태그입니다.


## Thymeleaf 문법 정리 


### 📌 주석


1 클라이언트에게 랜더링 되지 않는 주석 (타임리프 엔진이 템플릿을 처리할 때 무시)

1-1 단일 라인 주석 (Single-line Comment)
   ```html
   <!--/* Comment here */-->
   ```
1-2 다중 라인 주석 (Multi-line Comment)
  ```html
  <!--/* 
    여러 줄 주석 
  */-->
  ```

2 클라이언트에게 랜더링 되는 주석 (타임리프 프로토타입 주석)

```html
<!--/*/ <span>표준 HTML 주석</span> /*/-->
```
타임리프 프로토타입은 약간 특이한데, HTML 주석에 약간의 구문을 더했다. HTML 파일을 웹 브라우저에서 그대로 열어보면 <!-- -->을 포함하는 HTML 주석이기 때문에 이 부분이 웹 브라우저가 렌더링하지 않는다. 타임리프 렌더링을 거치면 이 부분이 정상 렌더링 된다. HTML 파일을 그대로 열어보면 주석처리가 되지만, 타임리프를 통해 렌더링 한 경우에만 출력된다.

### 📌 변수 표현식 - text 

💡 문법: th:text="${}"
```HTML
<div>
    <h1 th:text="${data}"></h1>
</div>
```
⭐️ 설명
- 일반 텍스트를 반환할 때 사용
```java
- [컨트롤러] model.addAttribute("data", "Hello <b>Spring</b>!");
```
- HTML 태그 또한 String 값으로 변환 => 출력: Hello Spring

```HTML
<td th:text="${item.price}">10000</td>
```
- 내용의 값을 th:text 의 값으로 변경한다.
- 여기서는 10000을 ${item.price} 의 값으로 변경한다.


💡 문법: th:utext="${}"

```HTML
<div>
    <h1 th:utext="${data}"></h1>
</div>
```
⭐️ 설명

- th:text와 동일하게 텍스트를 반환하지만, HTML 태그를 사용 가능하게 해준다
- 출력
- 
```HTML
Hello <b>Spring</b>! <b> 태그를 포함 그대로 출력 한다 
```

### 📌 이미지


💡 문법: th:src="${}"

```HTML
<img class="img" th:src="${dataList.IMG_URL}">
```
⭐️ 설명
- 이미지 src 사용시

### 📌 하이퍼 링크

💡 문법: URL 링크 표현식 

URL 링크 표현식을 사용하면 서블릿 컨텍스트를 자동으로 포함한다.

서블릿 컨텍스트?

웹 애플리케이션 환경을 나타내는 객체(서블릿 컨테이너:Apache, Tomcat) 에서 관리, 애플리케이션 전체에서 공유되는 정보 

@{...}

```html
<a th:href="@{/items/{id}(id=${item.id})}">View Detail</a>
```
⭐️ 설명

+ a 태그는 HTML 태그로 하이퍼링크를 생성하는데 사용 
+ th:href="@{....} : 타임리프 링크생성 표현식 

+ PathVariable 넣기 
+ {id}(id=${item.id}) 이런식으로 하면 item.id가 PathVariable로 넘어가진다.

+ QueryString, 쿼리 파라미터 넣기

```html
 th:href="@{/basic/items/{itemId}(itemId=${item.id}, query='test')}"
```

생성된 링크: http://localhost:8080/basic/items/1?query=test

### 📌 반복문 each

```html
<tr th:each="item : ${items}">
<!-- <td> 각 행의 열에 해당하는 데이터를 정의 -->
<td th:text="${item.id}"></td>
<td th:text="${item.itemName}"></td>
<td th:text="${item.price}"></td>
</tr>
```

### 📌 switch case

```html
<div th:switch="${userType}">
    <p th:case="'admin'">관리자 페이지에 오신 것을 환영합니다.</p>
    <p th:case="'user'">사용자 페이지에 오신 것을 환영합니다.</p>
    <p th:case="'guest'">게스트 페이지에 오신 것을 환영합니다.</p>
    <p th:case="*">알 수 없는 사용자입니다.</p>
</div>
```

### 📌 리터럴 

- 타임리프에서 문자와 표현식 등은 분리되어 있기 때문에 더해서 사용해야 된다.

```html
    <!-- 사용전 -->
        <span th:text="'Welcome to our application, ' + ${item.id} + '!'"> </span> <br>
    <!-- 사용후 -->
        <span th:text="|Welcome to our application, ${item.id}!|"> </span>
```
  
