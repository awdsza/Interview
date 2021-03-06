면접 질문 정리(기술 위주)
======================
# N Tech Service 웹 개발자 경력(전화면접)
## 1.언어
### 1) 객체 지향의 Solid란?
* SRP(단일책임의 원칙 : Single Responsibility Principle)

클래스는 하나의 기능만 가지며 서비스는 하나의 책임을 수행하는데 집중되어야 한다.

* OCP (개방폐쇄의 원칙: Open Close Principle)

컴포넌트, 클래스, 모듈, 함수는 확장에는 열려있고, 변경에는 닫혀있어야 한다는 원리다.
즉, 변경에 필요한 비용은 최대한 줄이고, 확장에 대한 비용은 극대화 해야한다.

* LSP (리스코브 치환의 원칙: The Liskov Substitution Principle)

서브 타입은 언제나 기반 타입과 호환될 수 있어야 한다.
즉 부모 클래스가 들어갈 자리에 자식 클래스를 넣어도 계획대로 잘 작동해야 한다는 것.
클래스 업캐스팅을 해도 문제가 없다는 의미.(일반화를 해도 어색함이 없어야한다??)

* ISP (인터페이스 분리의 원칙: Interface Segregation Principle)

어떤 클래스가 다른 클래스에 종속될 때에는 가능한 최소한의 인터페이스만을 사용.
한 클래스는 자신이 사용하지 않는 인터페이스는 구현하지 말아야 한다.

* DIP (의존성역전의 원칙: Dependency Inversion Principle

상위클래스는 하위클래스에 의존해서는 안된다

### 2) 본인이 사용했던 디자인 패턴은?
## 2.Java
### 1) Java7과 8의 차이점은?

- 람다식

  식별자 없이 실행 가능한 함수 표현식
  ```
  ( parameters ) -> expression body
  ( parameters ) -> { expression body }
  () -> { expression body }
  () -> expression body
  ```
 
 - Stream API
  
 - Default Method for Interface

기존 자바 인터페이스는 상수와 추상화된 함수만 허용했다면, 8부터는 default 키워드를 통해 기능을 가진 method를 만들 수 있다.

### 2) JVM에는 어떤메모리가 들어가있으며, 어떠한 정보가 있는지?
## 3.Spring
### 1) Spring에서 예외처리방법

- ExceptionHandler 사용.
  
  스프링 컨트롤러에서 정의한 메소드에서 기술한 예외가 발생되면 자동으로 받아낼 수 있는데 이를 이용하여 컨트롤러에서 발생하는 예외를 View단 JSP등으로 보내서 처리할 수 있다.

  ```
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest req,	HttpServletResponse response, Exception ex) {
	}
  ```
  
- ControllerAdvice 사용
  
  
  스프링 3.2이상에서 처리 가능. Controller에서 발생하는 예외 등을 catch하는 기능을 가지고있다.

  ```
    @ControllerAdvice //모든 컨트롤러에 대응된다.
    public class ExceptionControllerAdvice { 
      @ExceptionHandler(Exception.class) //모든 예외를 받음 
      public ModelAndView exception(Exception e) { 
        ModelAndView mav = new ModelAndView("exception"); 
        mav.addObject("name", e.getClass().getSimpleName()); 
        mav.addObject("message", e.getMessage()); return mav; 
      } 
    }
  ```
  
- 에러페이지 처리
    
  web.xml 에 특정 코드의 에러상황에 따라 반환해주는 jsp 페이지를 설정해줄 수 있다.
  
  ```
    <error-page>
    <error-code>404</error-code>
    <location>/WEB-INF/views/error/404error.jsp</location>
    </error-page>
    
    <error-page>
    <exception-type>java.lang.Throwable</exception-type>
    <location>/WEB-INF/views/error/error.jsp</location>
    </error-page>
    ```
    
### 2) Spring MVC 처리 과정

[링크](http://asfirstalways.tistory.com/180)로 대체한다.

### 3) Spring에서 Bean은 Singleton패턴이 맞는가? 그리고 Bean Scope의 종류는?

- 빈을 가져올때마다 오브젝트를 새로 생성하지 않는다.
	
  ```
    ApplicationContext context =
	new GenericXmlApplicationContext("applicationContext.xml");
	CarDAO carDao1 = context.getBean("carDAO",CarDAO.class);
	CarDAO carDao2 = context.getBean("carDAO",CarDAO.class);

	System.out.println(carDao1);
	System.out.println(carDao2);
	System.out.println(carDao1==carDao2);
  ```

- Bean Scope 종류

기본적으로 SingleTon으로 관리를 하지만 요구사항이나 구현 기능에 따라, 비싱글턴일 때도 있다. 
  
  * singleton : 기본적인 스코프
  * prototype : 어플리케이션에서 요청시 (getBean()) 마다 스프링이 새 인스턴스를 생성
  * request : HTTP 요청별로 인스턴스화 되며 요청이 끝나면 소멸 (spring mvc webapplication 용도)
  * session : HTTP 세션별로 인스턴스화되며 세션이 끝나며 소멸 (spring mvc webapplication 용도)
  * global session : 포틀릿 기반의 웹 어플리케이션 용도. 전역 세션 스코프의 빈은 같은 스프링 MVC를 사용한 포탈 어플리케이션 내의 모든 포틀릿 사이에서 공유할 수 있다
  * thred : 새 스레드에서 요청하면 새로운 bean 인스턴스를 생성, 같은 스레드에 대해서는 항상 같은 bean 인스턴스가 반환
  * custom : org.pringframework.beans.factory.config.Scope를 구현하고 커스텀 스코프를 스프링의 설정에 등록하여 사용
  
## 4.DB
### 1) MyBatis의 defaultexecutortype에 대해 설명

디폴트 실행자를 설정.

  * SIMPLE : default 설정
  
  * REUSE : PreparedStatement를 재사용
  
  * BATCH : 구문을 재사용하고 수정을 배치처리
  
### 2) index스캔과 full scan을 설명. 옵티마이저된 인덱스가 풀스캔을 하는 경우는?
### 3) PreparedStatement 와 Statement의 차이점

가장 큰차이점은 캐시의 사용여부다</br>
Statement 순서</br>
  (1) 쿼리 문장분석</br>
  (2) 컴파일</br>
  (3) 실행</br>
Statement를 사용하면 매번 쿼리를 실행할떄마다 1~3단계를 거치지만, PreparedStatement는 처음 한번만 3단계를 거친후 캐시에 담아 재사용을 한다.
같은 DB를 수행시 PreparedStatement가 DB에 적은 부하를 주며 성능도 좋다.

- Statement</br>
  Dynamic SQL을 사용하면 매번 조건절이 달라진다. 캐싱의 장점을 잃어버리기 때문에 Statement가 적절하다.
  ```
    String sqlstr = "SELECT name, memo FROM TABLE WHERE num = " + num 
    Statement stmt = conn.credateStatement(); 
    ResultSet rst = stmt.executeQuerey(sqlstr); 
  ```
 
- PreparedStatement</br>
  사용자 입력값으로 쿼리를 생성하여 수행할때 좋다.
  대표적인 예로 아래와 같이 쿼리를 미리 정의해 놓고 실행때만 값을 바꾸면서 실행하는 방법이 있다.
 
 ```
    String sqlstr = "SELECT name, memo FROM TABLE WHERE num = ? " 
    PreparedStatement stmt = conn.prepareStatement(sqlstr); 
    pstmt.setInt(1, num);
    ResultSet rst = pstmt.executeQuerey();
 ```
 ```
    pstmt = conn.preapreStatement("INSERT INTO TEST_TABLE VALUES(?)");
    for (int i = 0; i < 10000; i++) {
    	pstmt.setString(1, content+i);
   	pstmt.executeUpdate();
    }

 ```
### 4) innerJoin 과 OuterJoin 설명

- InnerJoin
 ```
      CREATE TABLE BOARD 
     (	
   	 BOARD_ID VARCHAR2(8 BYTE) NOT NULL, 
	  BOARD_TITLE VARCHAR2(100 BYTE), 
	  BOARD_CONTENTS VARCHAR2(1000 BYTE)
      );
     CREATE TABLE REPLY
     (
       REPLY_ID VARCHAR2(8 BYTE) NOT NULL, 
       BOARD_ID VARCHAR2(8 BYTE) NOT NULL, 
       REPLY_CONTENTS  VARCHAR2(1000 BYTE)
     );
  ```
  
  위에 게시판 테이블과 댓글 테이블을 만들었다. BOARD테이블의 BOARD_ID는 PK이며,  REPLY테이블의 BOARD_ID는 BOARD테이블의 FK이다.
  여기서 선택한 게시판의 내용과 댓글들을 보고 싶다면 쿼리는 이렇게 나올 것이다.
  
  ```
       SELECT 
	  BOARD_ID,
	  BOARD_TITLE,
	  BOARD_CONTENTS,
	  REPLY_ID,
	  REPLY_CONTENTS
	  FROM BOARD A INNER JOIN REPLY B ON A.BOARD_ID = B.BOARD_ID
  ```
  INNER JOIN은 테이블 2개가 매칭되는 값을 보여줄때 쓴다.
  
- Outer Join

Outer Join은 Left/Right/Full Join이 있다. Left는 왼쪽의 테이블 모든 결과값을 가져오며, Right는 오른쪽의 테이블 모든 결과값을 가져온다. Full은 양쪽테이블 모든 결과를 가져온다. 매칭된 결과가 없다면 Null 값을 가져온다.
  
- 이해가 되지 않는다면 [집합 이미지](https://www.quora.com/What-is-the-difference-between-various-types-of-joins-For-instance-there%E2%80%99s-inner-join-left-join-right-join-full-join-cross-join-natural-join-equi-join-and-semi-join) 형태로 설명이 잘되어있는 링크를 보시면 될꺼 같습니다.
## 5.Web
### 1) Javascript의 특징과 장점 
- 특징 </br>
 (1) 웹페이지의 동작을 역동적으로 구현 할 수 있다.</br>
 (2) 객체(내장객체)를 이용하여 프로그래밍하는 객체지향 언어이다.</br>
 (3) 웹 브라우저에서 실행할 때 프로그램 코드가 해석된다.</br>
 (4) 표준이 있지만 브라우저마다 지원하는 범위가 다른 언어이다.</br>
- 장점</br>
 (1) html 파일내에서 작성이 가능해 개발 속도가 빠르다.</br>
 (2) 웹 브라우저에서 동작하는 언어라 운영체제의 제한을 받지 않는다.</br>
### 2) jQuery 비동기 특징
아래의 코드에서 async를 true라면 telNo변수 값은 빈값으로 된다. ajax와 아래 코드가 순차적으로 처리되지않는다. 즉, 비동기 방식으로 데이터를 처리한다. async를 false로 하면 ajax가 끝난 이후에  아래 코드가 순차적으로 실행되므로, telNo값이 변경이 된다.
```
  	// 전화번호를 검색하여 받아온다.
  	var telNo = '';
	$.ajax({
		url     : '',
		data    : {},
		type    : 'post',
		sendDataType : 'json',
		success : function(data) {
			telNo = data;
		}
	});

	// 전화번호를 넣어준다.
	$('#telNo').val(telNo);
```

### 3) jQuery에서 #과 . 구분자의 특징
- #은 Element ID를 의미.
- .은 Element의 Class를 의미.
### 4) javaScript에서 getElementById에 준하는 jQuery 문법은?
- $("#ID")
### 5) Ajax get 방식으로 url을 조회하여 DB를 Update를했는데, DB는 변경되었지만 화면은 안바꼈다면 어떻게 해야 할 것인가
## 6.서버
### 1) 아파치 Keep-alive의 설정 설명
특정 한 프로세스가 특정 사용자의 지속적인 요청 작업들을 계속해서 처리하도록 함.
즉, 첫 요청 시에 열어 놓은 Port를 끊지 않고, 지정된 KeepAliveTimeout동안 idle하면 끊는다. 
KeepAliveTimeout값이 채워지기 전에 다시 요청이 온다면 다시 KeepAliveTimeout은 다시 0부터 Count를 수행한다.
최종적으로, KeepAliveTimeout 지정한 시간만큼 idle하면 그때, 해당 Port연결을 끊는다.
### 2) Tomcat, Apache, Nginx 설명
- Tomcat
Java 기반의 웹 애플리케이션 서버(WAS)이다. 서블릿 / JSP 엔진이 들어가 있다. 주로 DB를 주고 받거나 프로그램으로 데이터 조작이 필요할 떄 많이 사용한다. 정적인 데이터 처리에 단점이 있기 때문에, Apache와 같이 사용한다.
- Apache
http요청을 처리하는 웹서버를 말한다. 클라이언트가 GET, POST, DELETE메소드를 이용해 요청을 하면 아파치가 결과를 돌려주는 기능을 한다. 주로 정적인 데이터를 처리한다.
- Nginx
트래픽이 많은 웹사이트 확장성을 위해 설계한 비동기 이벤트 기반구조의 웹서버 소프트웨어이다. 가벼움과 높음 성능을 목표로 만들어짐. 확장성이 장점이기 때문에, 다수의 연결을 효과적으로 처리 가능하며, 코어 모듈이 Apache보다 적은 리소스로 더 빠르게 동작가능하고, 더 작은 쓰레드로 클라이언트의 요청들을 처리가능
### 3) get방식에서 한글 값을 넘겼는데 한글이 깨져서 나오면 어떻게 조치해야하는가?
### 4) 한 서버에서 도베인을 여러개 서비스를 하고싶다면 어떻게 할 것인가?
## 7.개발론
### 1) 사용했던 형상관리 솔루션은?
### 2) Unit Test와 Integration Test 설명
### 3) Test에 Mokking은 무엇이며 왜 필요한가?
### 4) CS REF의 취약점과 대처법
### 5) 프로젝트를 진행하면서 코드 개선의 경험



# 출처
## 1.언어
### 1) 객체 지향의 Solid란?
* [Nextree(객체지향 개발 5대 원리: SOLID)](http://www.nextree.co.kr/p6960/)
* [JaeYeopHan님의 github(Object Oriented Programming)](https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/Development_common_sense#object-oriented-programming)
* [나무위키(객체 지향 프로그래밍/원칙)](https://namu.wiki/w/%EA%B0%9D%EC%B2%B4%20%EC%A7%80%ED%96%A5%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/%EC%9B%90%EC%B9%99)
* [Jang님의 github(객체지향 디자인의 5원칙(SOLID 원칙))](https://wkdtjsgur100.github.io/solid-principle/)
## 2.JAVA
### 1) Java7과 8의 차이점은?
* [PyunJY님 블로그(자바 8 튜토리얼)](https://medium.com/@pyeonjy97/%EC%9E%90%EB%B0%94-8-%ED%8A%9C%ED%86%A0%EB%A6%AC%EC%96%BC-5d05f0f55fe1)
* [Juno Lee님의 github(자바 7 와 자바 8 에 대하여)](https://johanneslee.github.io/articles/page7/)
* [JDM's Blog(자바 람다식(Lambda Expressions in Java))](http://jdm.kr/blog/181)
* [iloveulhj님의 github(스트림API)](http://iloveulhj.github.io/posts/java/java-stream-api.html)
## 3.Spring
### 1) Spring에서 예외처리방법
 * [신희준 블로그([Spring] 예외 처리)](https://shj7242.github.io/2017/12/27/Spring33/)
 * [탑크리에듀(스프링컨트롤러예외처리,@ExceptionHandler, @ControllerAdvice)](https://www.slideshare.net/topcredu/exceptionhandler-controlleradvice)
### 3) Spring에서 Bean은 Singleton패턴이 맞는가? 그리고 Bean Scope의 종류는?
 * [Toward the Developer(싱글톤과 스프링)](http://joont.tistory.com/144)
 * [전산쟁이 블로그(Spring Bean Scope 정리)](http://javaslave.tistory.com/45)
## 4.DB
### 1) MyBatis의 defaultexecutortype에 대해 설명
 * [MyBatis 홈페이지](http://www.mybatis.org/mybatis-3/ko/configuration.html)
### 2) index스캔과 full scan을 설명. 옵티마이저된 인덱스가 풀스캔을 하는 경우는?
### 3) PreparedStatement 와 Statement의 차이점
 * [장인개발자를 꿈꾸는 :: 기록하는 공간](http://devbox.tistory.com/entry/Comporison)
 * [Head First Thinking](https://inthej.com/2017/09/27/statement%EC%99%80-preparedstatement-%EC%9D%98-%EC%B0%A8%EC%9D%B4/)
 ## 5.Web
### 1) Javascript의 특징과 장점 설명
 * [DoDat 자바스크립트(Java Script)특징과 활용범위](http://jayzzz.tistory.com/54)
 * [JOY&YOUNG(자바스크립트의 기초 및 특징)](http://blog.jiyoung5.com/entry/%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8%EC%9D%98-%EA%B8%B0%EC%B4%88-%EB%B0%8F-%ED%8A%B9%EC%A7%95)
 * [Code Dragon(자바스크립트의 특징)](http://codedragon.tistory.com/3443)
### 2) jQuery 비동기 특징
 * [Why(JQuery Ajax 동기 비동기)](http://www.springcome.net/?p=55)
 ## 6.서버
### 1) 아파치 Keep-alive의 설정 설명
 * [MC뺴인트와 함께([Apache] KeepAlive 설정)](http://mcpaint.tistory.com/141)
### 2) Tomcat, Apache, Nginx 설명
 * [나무위키(톰켓)](https://namu.wiki/w/%ED%86%B0%EC%BA%A3)
 * [위키백과(아파치 톰켓)](https://ko.wikipedia.org/wiki/%EC%95%84%ED%8C%8C%EC%B9%98_%ED%86%B0%EC%BA%A3)
 * [BLOG FOR ME(WAS와 웹서버의 차이 – 톰캣과 아파치를 구별하지 못하는 사람을 위해)](http://sungbine.github.io/tech/post/2015/02/15/tomcat%EA%B3%BC%20apache%EC%9D%98%20%EC%97%B0%EB%8F%99.html)
 * [큰돌의 터전([개발자 면접준비]#2. nginx란](https://m.blog.naver.com/jhc9639/220967352282)
