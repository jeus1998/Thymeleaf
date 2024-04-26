
# Thymeleaf (SSR) + HTML 

![Thymeleaf](https://img.shields.io/badge/-Thymeleaf-005F0F?style=flat-square&logo=Thymeleaf&logoColor=white)
![HTML5](https://img.shields.io/badge/-HTML5-E34F26?style=flat-square&logo=HTML5&logoColor=white)

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
  
 ➡ 인프런 김영한 강사님 스프링 MVC 강의 https://www.inflearn.com/roadmaps/373
 
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
## Thymeleaf basic expression (기본 표현식)

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

## HTML Entity & Escape vs Unescape 개념 

- 개념 : 웹 브라우저는 < 를 HTML 태그로 인식한다. 따라서 < 를 태그의 시작이 아니라 문자로 표현하는 방법이 필요한데 이것을 HTML 엔티티라 한다.
- escape : HTML에서 사용하는 특수 문자를 HTML Entity로 변경하는 것 
- unescape : escape 반대 (그대로 태그로 사용)

### 📌 주로 사용되는 이스케이프된 문자들 

- <를 \&lt;로 이스케이프
- \>를 \&gt;로 이스케이프
- &를 \&amp;로 이스케이프
- "를 \&quot;로 이스케이프
- '를 \&#39;로 이스케이프


## HTML 태그 정리

### 📌 html 태그

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
html : HTML 문서의 시작과 끝을 나타내는 태그입니다.

### 📌 head 태그

```html
<head>
    <title>문서 제목</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles.css">
</head>
```
head : 문서의 메타데이터를 포함하는 부분을 정의합니다.

### 📌 title 태그

```html
<title>나의 웹 페이지</title>
```
title : 문서의 제목을 정의합니다

### 📌 body 태그

body : 문서의 본문을 나타내는 부분을 정의합니다.

### 📌 h1 ~ h6 제목 태그

```html
<h1>첫 번째 제목</h1>
<h2>두 번째 제목</h2>
```
h? : 제목을 표시합니다 h1이 가장 크고 h6가 가장 작습니다.

### 📌 p 태그

```html
<p>이것은 문단입니다.</p>
```
p : 문단을 표시합니다 

### 📌 a 태그

```html
<a href="https://www.example.com">example 사이트</a>
```
a : 하이퍼링크를 정의 합니다.

### 📌 img 태그

```html
<img src="이미지주소.jpg" alt="example 이미지">
```
img : 이미지를 삽입합니다.

### 📌 div 태그

```html
<div id="content">
    <!-- 내용 -->
</div>
```
div : 구획을 정의하며 주로 CSS 스타일링이나 JavaScript를 적용하기 위해 사용됩니다.

### 📌 ul, ol, li 태그 

ul, ol, li : HTML에서 목록을 정의하는 데 사용되는 태그들입니다.

👉 ul Unordered List
- 순서가 없는 목록을 나타냅니다.
- 목록의 각 항목은 점, 별표, 혹은 다른 기호로 마크업됩니다.
- 주로 프로젝트 개요, 사이트의 메뉴 등에 사용됩니다.

```html
<ul>
    <li>항목 1</li>
    <li>항목 2</li>
    <li>항목 3</li>
</ul>
```
👉 ol Ordered List  
- 순서가 있는 목록을 나타냅니다.
- 각 항목은 번호(숫자)로 순서가 매겨집니다.
- 순서가 있는 항목을 나타낼때 사용됩니다.

```html
<ol>
    <li>첫 번째 항목</li>
    <li>두 번째 항목</li>
    <li>세 번째 항목</li>
</ol>
```

👉 li List Item
- 목록 내의 각 항목을 정의합니다.
- ul 또는 ol 안에서 사용되며, 각 항목을 나타냅니다.

정리 : 순서가 있는 목록 o1은 항목 간에 일정한 순서가 있어야 하고 순서가 없는 ul은 항목 간의 순서가 중요하지 않는다.


### 📌 span 태그

```html
<p>이 문장은 <span style="color: blue;">파란색</span>으로 표시됩니다.</p>
```

span : 텍스트의 일부를 그룹화하거나 스타일을 적용하기 위해 사용됩니다.

### 📌 b 태그

```html
<p>This is <b>bold</b> text.</p>
```
- b 태그는 텍스트를 굵게(bold)표시할 때 사용됩니다.
- 의미적인 중요성을 갖지 않고, 시각적으로 텍스트를 강조하고자 할 때 주로 사용됩니다.
- 위 예제에서는 "bold"라는 단어가 굵게 표시됩니다.

### 📌 br 태그

```html
<p>This is the first line.<br>This is the second line.</p>
```
- br 태그는 줄 바꿈(line break)을 나타냅니다.
- 새로운 줄로 텍스트를 이동시키기 위해 사용됩니다.
- 위 예제에서는 "This is the first line" 다음 새로운 줄에 "This is the second line"이 시작됩니다


## Thymeleaf 문법 정리 

### 📌 주석

1 클라이언트에게 랜더링 되지 않는 주석 (타임리프 엔진이 템플릿을 처리할 때 무시) 

- 자바 스크립트 표준 HTML 주석 타임리프가 렌더링 하지 않고, 그대로 남겨둔다. 

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

2 타임리프 파서 주석 

- 렌더링에서 주석 부분을 제거한다. 

```HTML
<!--/* [[${data}]] */-->
```

3 클라이언트에게 랜더링 되는 주석 (타임리프 프로토타입 주석)

```html
<!--/*/ <span>표준 HTML 주석</span> /*/-->
```
타임리프 프로토타입은 약간 특이한데, HTML 주석에 약간의 구문을 더했다. HTML 파일을 웹 브라우저에서 그대로 열어보면 <!-- -->을 포함하는 HTML 주석이기 때문에 이 부분이 웹 브라우저가 렌더링하지 않는다. 타임리프 렌더링을 거치면 이 부분이 정상 렌더링 된다. HTML 파일을 그대로 열어보면 주석처리가 되지만, 타임리프를 통해 렌더링 한 경우에만 출력된다.

### 📌 변수 표현식 - text, utext

💡 문법: th:text="${}" <b>escape</b>

```HTML
    <h1 th:text="${data}"></h1>
```
⭐️ 설명

- 일반 텍스트를 반환할 때 사용
  
```java
- [컨트롤러] model.addAttribute("data", "Hello <b>Spring</b>!");
```
- HTML 태그 또한 String 값으로 변환 => 출력: Hello &lt;b&gt;Spring&lt;/b&gt;

```HTML
<td th:text="${item.price}">10000</td>
```
- 내용의 값을 th:text 의 값으로 변경한다.
- 여기서는 10000을 ${item.price} 의 값으로 변경한다.

```html
 <li>컨텐츠 안에서 직접 출력하기 = [[${data}]] </li>
```
- HTML 태그의 속성이 아니라 HTML 콘텐츠 영역안에서 직접 데이터를 출력하고 싶다면 [[...]] 를 사용한다.
- [[...]]은 escape 기능을 가지고 있다. unescape로 사용하고 싶으면 [(...)]

💡 문법: th:utext="${}"  <b>unescape</b>

```HTML
    <h1 th:utext="${data}"></h1>
```
⭐️ 설명

```java
- [컨트롤러] model.addAttribute("data", "Hello <b>Spring</b>!");
```
- th:text와 동일하게 텍스트를 반환하지만, HTML 태그를 사용 가능하게 해준다
- 출력: Hello <b>Spring</b>!
- "Spring" 이 b 태그로 단어가 굵게 표시된다.

### 📌 SpringEL 표현식 

- Spring EL(Expression Language)은 스프링 프레임워크에서 사용되는 표현 언어, 주로 스프링의 설정 파일, JSP페이지, Thymeleaf 등에서 사용됩니다.
- 변수, 연산자, 메소드 호출, 속성 접근 등을 지원하며 다양한 유형의 데이터를 다루는데 유용합니다.

⭐️ 예시 설명 

- 시나리오 : 컨트롤러에서 model에 3개의 데이터(Book, List<Book>, Map<String, Book>)를 넣는다.

```java
@Controller
@RequestMapping("/books")
public class BookController {
    @Data
    static class Book{
        private String name;
        public Book(String name) {
            this.name = name;
        }
    }

    @GetMapping("/book-data")
    public String getBook(Model model){
          Book book1 = new Book("comic");
          Book book2 = new Book("novel");

          List<Book> list = new ArrayList<>();
          list.add(book1);
          list.add(book2);

          Map<String, Book> map = new HashMap<>();
          map.put("book1", book1);
          map.put("book2", book2);

          model.addAttribute("book", book1);
          model.addAttribute("books", list);
          model.addAttribute("map", map);

          return "books";
    }
}
```

- HTML + Thymeleaf로 브라우저에게 보여주기

```html
<h2>SpringEL 표현식 연습</h2>
<ul> <!-- Object (Book) -->
    <li><span th:text="${book.name}"></span></li>
    <li><span th:text="${book['name']}"></span></li>
    <li><span th:text="${book.getName()}"></span></li>
</ul>

<ul> <!-- List<Book> -->
    <li><span th:text="${books[0].name}"></span></li>
    <li><span th:text="${books[0]['name']}"></span></li>
    <li><span th:text="${books[0].getName()}"></span></li>
</ul>

<ul> <!-- Map<String, Book> -->
    <li><span th:text="${map['book1'].name}"></span> </li>
    <li><span th:text="${map['book1']['name']}"></span> </li>
    <li><span th:text="${map['book2'].getName()}"></span> </li>
</ul>
```

- 모두 자바 프로퍼티 getXxx를 사용하고 ['변수이름'], getXxx, .변수이름 다양한 메서드를 지원한다.
  
### 📌 Safe Navigation Operator

```HTML
 <div th:if="${errors.containsKey('globalError')}">
```

여기서 errors는 서버에서 Model에 넘겨준 Map 데이터이다. 만약 errors가 null 이라면 어떻게 될까?
호출하는 순간 NullPointerException이 발생한다.
그럼 어떻게 해야할까? 

```html
<div th:if="${errors?.containsKey('globalError')}">
```

errors?.은 errors가 null 일때 NullPointerException이 발생하는 대신, null을 반환하는 문법이다.
th:if에서 null은 실패로 처리되므로 오류 메세지가 출력되지 않는다.
이것은 스프링의 SpringEL이 제공하는 문법이다. 

참고 : https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#expressionsoperator-safe-navigation


### 📌 지역 변수 

💡 문법: th:with

```html
<h2>지역변수 th:with</h2>   <!-- scope는 <div> scope </div> -->
<div th:with="first=${books[0]}">
    <p>첫 번째 책 이름은? <span th:text="${first.name}"></span></p>
</div>
```

⭐️ 설명

- 이 지역 변수의 scope는 지역 변수를 정의한 태그 시작 ~ 끝


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


- 👉 모델에서 넘어온 데이터를 바탕으로 url 경로 만드는 예시

```java
  model.addAttribute("param1", "data1");
  model.addAttribute("param2", "data2");
```

```html
<ul>
  <!-- /hello -->
  <li><a th:href="@{/hello}">basic url</a></li>
  <!-- /hello?param1=data1&param2=data2 -->
  <li><a th:href="@{/hello(param1=${param1}, param2=${param2})}">hello query param</a></li>
  <!-- /hello/data1/dat2 -->
  <li><a th:href="@{/hello/{param1}/{param2}(param1=${param1}, param2=${param2})}">path variable</a></li>
  <!-- /hello/data1?param2=data2 -->
  <li><a th:href="@{/hello/{param1}(param1=${param1}, param2=${param2})}">path variable + query parameter</a></li>
</ul>
```

### 📌 연산 

⭐️ 타임리프 연산은 자바와 크게 다르지 않다. HTML 안에서 사용하기 때문에 HTML 엔티티를 사용하는 부분을 주의!

- 👉 산술 연산
   -  ```  <li>10 + 2 = <span th:text="10 + 2"></span></li> ```               결과 : 10 + 2 = 12
   -  ```  <li>10 % 2 == 0 = <span th:text="10 % 2 == 0"></span></li> ```     결과 : true
- 👉 비교 연산
   -  ```  <li>1 > 10 = <span th:text="1 > 10"></span></li> ``` 결과 : 1 > 10 = false
   -  ```  <li>1 > 10 = <span th:text="1 &gt; 10"></span></li> ``` 결과 : 1 > 10 = false
   -  ```  <li>1 > 10 = <span th:text="1 gt 10"></span></li> ``` 결과 : 1 > 10 = false
   -  ```  <li>1 < 10 = <span th:text="1 < 10"></span></li> ``` 결과 : 1 < 10 = true
   -  ```  <li>1 > 10 = <span th:text="1 &lt; 10"></span></li> ```  결과 : 1 < 10 = true
   -  ```  <li>1 > 10 = <span th:text="1 lt 10"></span></li> ```  결과 : 1 < 10 = true
   -  ```  <li>1 >= 10 = <span th:text="1 >= 10"></span></li> ``` 결과 : 1 >= 10 = false
   -  ```  <li>1 >= 10 = <span th:text="1 ge 10"></span></li> ``` 결과 : 1 >= 10 = false
   -  ```  <li>1 <= 10 = <span th:text="1 <= 10"></span></li> ``` 결과 : 1 <= 10 = true
   -  ```  <li>1 <= 10 = <span th:text="1 le 10"></span></li> ``` 결과 : 1 <= 10 = true
   -  ```  <li>1 == 10 = <span th:text="1 == 10"></span></li> ``` 결과 : 1 == 10 = false
   -  ```  <li>1 != 10 = <span th:text="1 != 10"></span></li> ``` 결과 : 1 != 10 = true
- 👉 조건식
   -  ```  <li> (10 % 2 == 0)? '짝수':'홀수' = <span th:text="(10 % 2 == 0)? '짝수':'홀수'"></span></li> ``` 결과 : (10 % 2 == 0)? '짝수':'홀수' = 짝수
- 👉 Elvis 연산자
   ```java
     model.addAttribute("nullData", null);
     model.addAttribute("data", "Spring!");
   ```
   -  null check를 간단하게 수행하는데 사용  ?:
   -  ```<li><span th:text="${data}?: '데이터가 없습니다.'"></span></li>``` 결과 : Spring!
   -  ```<li><span th:text="${nullData}?: '데이터가 없습니다.'"></span></li>``` 결과 : 데이터가 없습니다.
- 👉 No-Operation 
  -  _ 인 경우 마치 타임리프가 실행되지 않는 것 처럼 동작한다.
  -  ```<li><span th:text="${data}?: _ "></span></li>``` 결과 : Spring!
  -  ```<li><span th:text="${nullData}?: _ "></span></li>``` 결과 : 

### 📌 속성 

⭐️ 타임리프는 주로 HTML 태그에 th:* 속성을 지정하는 방식으로 동작한다. th:*로 속성을 적용하면 기존 속성을 대체한다. 기존 속성이 없으면 새로 만든다.

- 👉 속성 설정
  - 파일   : ``` <input type="text" name="mock" th:name="userA" /> ``` 
  - 렌더링 : ``` <input type="text" name="userA" /> ``` 
- 👉 속성 추가
  - 파일   : ``` <input type="text" class="text" th:attrappend="class=' large'" /> ```   
  - 렌더링 : ``` <input type="text" class="text large" /> ```
  - 설명   : th:attrappend 속성 값의 뒤에 값을 추가 
  - 파일   : ``` <input type="text" class="text" th:attrprepend="class='large '" /> ```   
  - 렌더링 : ``` <input type="text" class="large text" /> ```
  - 설명   : th:attrprepend 속성 값의 앞에 값을 추가 
  - 파일   : ``` <input type="text" class="text" th:classappend="large" /> ```     
  - 렌더링 : ``` <input type="text" class="text large" /> ```
  - 설명   : th:classappend class 속성에 자연스럽게 값 추가 
- 👉 checked 처리
    - ``` <input type="checkbox" name="active" checked="false" /> ``` HTML에서는  boolean 값과 상관없이 checked 처리
    - 파일   : ``` <input type="checkbox" name="active" th:checked="false" /> ```
    - 렌더링 : ```<input type="checkbox" name="active" /> ```
    - 설명   : th:checked=false면 checked 속성 자체를 제거한다. true면 유지 

### 📌 반복문 each

👉 반복 기능 

```html
<tr th:each="item : ${items}">
<td th:text="${item.id}"></td>
<td th:text="${item.itemName}"></td>
<td th:text="${item.price}"></td>
</tr>
```

👉 반복 상태 유지 

![Thymeleaf each Table](https://github.com/jeus1998/Thymeleaf/assets/161576167/6e230378-ce05-46cb-bb96-57fda31023c5)

```html
<table border="1">
    <tr>
        <th>count</th>
        <th>index</th>
        <th>username</th>
        <th>age</th>
        <th>size</th>
        <th>even</th>
        <th>odd</th>
        <th>first</th>
        <th>last</th>
        <th>current</th>
    </tr>
    <tr th:each="user, userStat : ${users}">
        <td th:text="${userStat.count}">username</td>
        <td th:text="${userStat.index}">index</td>
        <td th:text="${user.username}">username</td>
        <td th:text="${user.age}">0</td>
        <td th:text="${userStat.size}">0</td>
        <td th:text="${userStat.even}">true</td>
        <td th:text="${userStat.odd}">true</td>
        <td th:text="${userStat.first}">true</td>
        <td th:text="${userStat.last}">true</td>
        <td th:text="${userStat.current}">true</td>
    </tr>
</table>
```

- 반복의 두번째 파라미터를 설정해서 반복의 상태를 확인 할 수 있습니다.
- 두번째 파라미터는 생략이 가능한데, 생략하면 지정한 변수명 + Stat가 됩니다.
- 반복 상태 유지 기능
   - index : 0부터 시작하는 값
   - count : 1부터 시작하는 값
   - size : 전체 사이즈
   - even , odd : 짝수 홀수 여부 (boolean) count를 기준으로 한다. 
   - first, last : 처음, 마지막 여부 (boolean) count를 기준으로 한다. 
   - current : 현재 객체 

### 📌 switch case

```html
<div th:switch="${userType}">
    <p th:case="'admin'">관리자 페이지에 오신 것을 환영합니다.</p>
    <p th:case="'user'">사용자 페이지에 오신 것을 환영합니다.</p>
    <p th:case="'guest'">게스트 페이지에 오신 것을 환영합니다.</p>
    <p th:case="*">알 수 없는 사용자입니다.</p>
</div>
```
- th:case="*" 만족하는 조건이 없을 때 사용하는 default 값 

### 📌 조건식 if, unless(if의 반대)

```html
 <span th:text="'미성년자'" th:if="${user.age lt 20}"></span>
 <span th:text="'미성년자'" th:unless="${user.age ge 20}"></span>
```

- 만약 user age <  20 '미성년자'가 출력
- 만약 user age >= 20  렌더링 x 


### 📌 리터럴, 리터럴 대체 

- 타임리프에서 문자 리터럴은 항상 작은 따옴표로 감싸야 한다.
   - ``` <span th:text="'hello'"> ```
- 만약 공백 없이 쭉 이어진다면 다음과 같이 작은 따음표를 생략할 수 있다.
   - ``` <span th:text="hello"> ```
- 예시
   - 오류 ``` <span th:text="hello world!"> ```  중간에 공백이 있어서 오류 
   - 수정 ``` <span th:text="'hello world!'"> ```
- 리터럴 대체 |...|
- 👉 정리

```html
  <li>'hello' + ' world!' = <span th:text="'hello' + ' world!'"></span></li>
  <li>'hello world!' = <span th:text="'hello world!'"></span></li>
  <li>'hello ' + ${data} = <span th:text="'hello ' + ${data}"></span></li>
  <li>리터럴 대체 |hello ${data}| = <span th:text="|hello ${data}|"></span></li>
```

### 📌 블록 

- 타임리프 특성상 HTML 태그안에 속성으로 기능을 정의해서 사용하는데, 사용하기 애매한 경우에 사용하면된다.
- 렌더링시 제거된다.
- ``` <th:block> </th:block> ```


### 📌 th:classappend

```html
          <input type="text" id="itemName" th:field="*{itemName}"
                   th:class="${errors?.containsKey('itemName')} ? 'form-control field-error' : 'form-control'"
                   class="form-control" placeholder="이름을 입력하세요">
```

지금 이 코드를 보면 th:class가 if - else 문으로 복잡하게 사용되고 있다. 이걸 th:classappend를 활용해서 간단하게 변경이 가능하다.

```html
          <input type="text" id="itemName" th:field="*{itemName}"
                   th:classappend="${errors?.containsKey('itemName')} ? 'field-error' : _"
                   class="form-control" placeholder="이름을 입력하세요">
```

이렇게 하면 errros(Map)에 itemName key가 있으면 class에 field-error를 추가해서 class = "form-control field-error"와 같이 동일하게 동작한다. 


### 📌 자바스크립트 인라인 

- 타임리프는 자바스크립트에서 타임리프를 편리하게 사용할 수 있는 자바스크립트 인라인 기능을 제공한다.
- 사용법 : ``` <script th:inline="javascript"> </script> ```


 👉 사용 전 

```html
<script>

  var username = "[[${user.username}]]";
  var age = [[${user.age}]];

  //자바스크립트 내추럴 템플릿
  var username2 = /*[[${user.username}]]*/ "test username";

  //객체
  var user = [[${user}]];

</script>
```
 👉 사용 후

 ```html
 <script th:inline="javascript">

  var username = [[${user.username}]];
  var age = [[${user.age}]];

  //자바스크립트 내추럴 템플릿
  var username2 = /*[[${user.username}]]*/ "test username";

  //객체

  var user = [[${user}]];
</script>
 ```

- 텍스트 렌더링 
   - 인라인 사용 전  var username = userA  개발자가 기대하는 것은 "userA" 자바스크립트 오류 발생 
   - 인라인 사용 후  var username = "userA"
   - 인라인 사용 후 렌더링 결과를 보면 문자 타입인 경우 "를 포함해 준다. 추가로 자바스크립트에서 문제가 될 수 있는 문자가 포함되어 있으면 이스케이프 처리도 해준다.
 
- 자바스크립트 내추럴 템플릿
   -  타임리프는 HTML 파일을 직접 열어도 동작하는 내추럴 템플릿 기능을 제공한다. 자바스크립트 인라인 기능을 사용하면 주석을 활용해서 이 기능을 사용할 수 있다.
   -  인라인 사용 전 var username2 = /*userA*/ "test username";
   -  인라인 사용 후 var username2 = "userA";
 
 - 객체
    - 타임리프의 자바스크립트 인라인 기능을 사용하면 객체를 JSON으로 자동으로 변환해준다.
    - var user = [[${user}]];
    - 인라인 사용 전 var user = BasicController.User(username=userA, age=10);
    - 인라인 사용 후 var user = {"username":"userA","age":10};
    - 인라인 사용 전은 객체의 toString()이 호출된 값이다.
    - 인라인 사용 후는 객체를 JSON으로 변환해준다.

 👉 인라인 반복문 

 ```HTML
<script th:inline="javascript">

  [# th:each="user, stat : ${users}"]
  var user[[${stat.count}]] = [[${user}]];
  [/]

</script>
 ```

### 📌 템플릿 조각 

웹 페이지를 개발할 때는 공통 영역이 많다. 상단 영역, 하단 영역, 좌측 카테고리 등등 여러 페이지에서 함께 사용하는 영역들이 있다. 
이런 부분을 코드를 복사해서 사용한다면 변경시 여러 페이지를 다 수정해야 하므로 상당히 비효율적이다. 
이런 문제를 해결하기 위해서 템플릿 조각과 레이아웃 기능을 지원한다. 

👉 footer.html

여러 페이지에서 다 똑같은 영역을 사용한다면 footer를 활용한다. 다른 타임리프 파일이 해당 파일(footer.html)을 불러서 사용하는 용도 
th:fragment 가 있는 태그는 다른곳에 포함되는 코드 조각으로 이해하면 된다.

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>

<footer th:fragment="copy">
  푸터 자리 입니다.
</footer>

<footer th:fragment="copyParam (param1, param2)">
  <p>파라미터 자리 입니다.</p>
  <p th:text="${param1}"></p>
  <p th:text="${param2}"></p>
</footer>

</body>
</html>
```

👉 fragmentMain.html

footer를 불러서 사용하는 html

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>부분 포함</h1>

<h2>부분 포함 insert</h2>
<div th:insert="~{template/fragment/footer :: copy}"></div>

<h2>부분 포함 replace</h2>
<div th:replace="~{template/fragment/footer :: copy}"></div>

<h2>부분 포함 단순 표현식</h2>
<div th:replace="template/fragment/footer :: copy"></div>

<h1>파라미터 사용</h1>
<div th:replace="~{template/fragment/footer :: copyParam ('데이터1', '데이터2')}"></div>

</body>
</html>
```

- ``` template/fragment/footer :: copy ``` : ```template/fragment/footer.html``` 템플릿에 있는 ```th:fragment="copy"``` 부분을 템플릿 조각으로 사용한다는 의미
- 부분포함 insert
   - ``` <div th:insert="~{template/fragment/footer :: copy}"></div> ``` : ```th:insert```를 사용하면 현재 태그 ```<div>``` 내부에 추가한다.
   - 웹 브라우저에 렌더링 된 소스
   ```html
   <div><footer>
      푸터 자리 입니다.
   </footer></div>
   ```
- 부분포함 replace
   - ``` <div th:replace="~{template/fragment/footer :: copy}"></div> ``` : ```th:replace```를 사용하면 현재 태그  ```<div>```를 대체한다.
   - 웹 브라우저에 렌더링 된 소스
   ```html
   <footer>
      푸터 자리 입니다.
   </footer>
   ```
- 부분 포함 단순 표현식
   - ``` <div th:replace="template/fragment/footer :: copy"></div> ``` : ``` ~{...} ``` 를 사용하는 것이 원칙이지만 템플릿 조각을 사용하는 코드가 단순하면 생략
- 파라미터 사용
   - ``` <div th:replace="~{template/fragment/footer :: copyParam ('데이터1', '데이터2')}"></div> ``` : 파라미터를 전달해서 동적으로 조각을 렌더링
   - 웹 브라우저에 렌더링 된 소스
   ```html
    <footer>
       <p>파라미터 자리 입니다.</p>
       <p>데이터1</p>
       <p>데이터2</p>
    </footer>
   ```

## Thymeleaf 객체 정리 

### 📌 스프링 부트 v 3.0 미만 (기본 객체)

- 기본 제공 객체 : request, response, session, servletContext, locale
- 사용법 : ${#request}, ${#response}, ${#session}, ${#servletContext}, ${#locale}

### 📌 스프링 부트 v 3.0 이상  (기본 객체)

- 기본 제공 객체 : locale
- 사용법 : ${#locale}
- 스프링 부트 3.0 이상은 locale 객체 말고는 지원을 안한다. 만약 사용하면 아래와 같은 에러가 발생한다.
```java
Caused by: java.lang.IllegalArgumentException: The 
'request','session','servletContext' and 'response' expression utility objects 
are no longer available by default for template expressions and their use is not 
recommended. In cases where they are really needed, they should be manually 
added as context variables.
```
- 나머지 객체들은 모델(Model)에 직접 넣어서 사용한다. 

### 📌 Thymeleaf 편의 객체 

- HTTP 요청 파라미터 접근 : param
   - 예) ${param.paramData}
- HTTP 세션 접근 : session
   - 예) ${session.sessionData}
   - sessionData는 서버에서 넣어준 데이터(session.setAttribute) key 
- 스프링 빈 접근: @
   - 예) ${@helloBean.hello('Spring!')}
   - 빈 이름(helloBean) 으로 접근 hello는 해당 빈의 메서드  

### 📌 Thymeleaf 유틸리티 객체  

- 타임리프는 문자, 숫자, 날짜, URI등을 편리하게 다루는 다양한 유틸리티 객체들을 제공한다.
- 타임리프 공식 홈페이지에서 필요할 때 찾아서 사용한다.

➡ 타임리프 유틸리티 객체 https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#expression-utility-objects

➡ 타임리프 유틸리티 객체 예시 https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#appendix-b-expressionutility-objects

## Thymeleaf Practice1

- project를 다운받고 localhost:8181로 접속을 하면 테슬라 차 판매라는 링크가 있습니다. 
- 들어가서 보면 타임리프를 활용한 상품 등록, 상품 수정, 상품 리스트 볼 수 있습니다. 
- README에 설명 안된 문법들 th:object, th:field, select, checkbox, radio, ${#ids.prev('...')}

Back-End Package ➡ Thymleaf/study/pratice1/*

SSR      Package ➡ resources/templates/practice1/* 

    


