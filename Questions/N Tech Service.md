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

- Statement

  ```
    String sqlstr = "SELECT name, memo FROM TABLE WHERE num = " + num 
    Statement stmt = conn.credateStatement(); 
    ResultSet rst = stmt.executeQuerey(sqlstr); 
  ```
 
 Dynamic SQL을 사용하면 매번 조건절이 달라진다. 캐싱의 장점을 잃어버리기 때문에 Statement가 적절하다.
 
- PreparedStatement

  ```
    String sqlstr = "SELECT name, memo FROM TABLE WHERE num = ? " 
    PreparedStatement stmt = conn.prepareStatement(sqlstr); 
    pstmt.setInt(1, num);
    ResultSet rst = pstmt.executeQuerey();
  ```
  사용자 입력값으로 쿼리를 생성하거나, 반복적인 쿼리를 수행할때 좋다.
  
  ```
    pstmt = conn.preapreStatement("INSERT INTO TEST_TABLE VALUES(?)");
    for (int i = 0; i < 10000; i++) {
    	pstmt.setString(1, content+i);
   	pstmt.executeUpdate();
    }

  ```
### 4) innerJoin 과 OuterJoin 설명
## 5.Web
### 1) Javascript의 특징과 장점 설명
### 2) jQuery 비동기 특징
### 3) jQuery에서 #과 . 구분자의 특징
### 4) javaScript에서 getElementById에 준하는 jQuery 문법은?
### 5) Ajax get 방식으로 url을 조회하여 DB를 Update를했는데, DB는 변경되었지만 화면은 안바꼈다면 어떻게 해야 할 것인가
## 6.서버
### 1) 아파치 Keep-alive의 설정 설명
### 2) Tomcat, Apache, Nginx를 설명
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
