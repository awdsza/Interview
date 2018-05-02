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
### 2) JVM에는 어떤메모리가 들어가있으며, 어떠한 정보가 있는지?
## 3.Spring
### 1) Spring에서 예외처리방법
### 2) Spring MVC 처리 과정
### 3) Spring에서 Bean은 Singleton패턴이 맞는가? 그리고 Bean Scope의 종류는?
## 4.DB
### 1) MyBatis의 defaultexecutortype에 대해 설명
### 2) index스캔과 full scan을 설명. 옵티마이저된 인덱스가 풀스캔을 하는 경우는?
### 3) PreparedStatement 와 Statement의 차이점
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
* http://www.nextree.co.kr/p6960/
* https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/Development_common_sense
* https://namu.wiki/w/%EA%B0%9D%EC%B2%B4%20%EC%A7%80%ED%96%A5%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/%EC%9B%90%EC%B9%99
* https://wkdtjsgur100.github.io/solid-principle/
## 2.JAVA
### 1) Java7과 8의 차이점은?
* http://jdm.kr/blog/181
* https://johanneslee.github.io/articles/page7/
