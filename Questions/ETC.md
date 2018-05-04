
면접 질문 정리(기술 위주)
======================
# 경력 개발자 면접(중소기업면접)
## 1.Spring
### 1) Spring에서 중요하게 생각하는것?

### 2) DI의 개념
의존 관계 주입. 오브젝트 사이의 의존 관계를 만드는 것. 클래스에서 new 연산자가 사라진다. 펙토리 메소드 같은 디자인 패턴을 구사하지 않아도, DI 컨테이너가 건내주는 인스턴스를 인터페이스로 받아서 인터페이스 기반의 컴포넌트화를 구현할 수 있게 되는것이다.
 - 장점
   (1) 불필요한 의존 관계를 없애거나 줄일수 있음.<br/>
 - Autowired<br/>
 - Component<br/>
### 3) AOP의 개념

## 2.Java
### 1) Collection종류와 설명
  - List<br/>
    (1) Array List : 저장순서가 유지되고 중복허용.<br/>
    (2) 크기를 변경하는데 많은 비용이 든다.(배열을 새로 생성하고, 데이터를 복사해야한다.)<br/>
    (3) 비순차적인 데이터의 추가, 삭제에 시간이 많이 걸린다.(순차적인 추가 및 삭제는 빠르다.)<br/>
    (4) 3번의 약점을 보완하기 나온 것이 LinkedList이다. 불연속적으로 존재하는 데이터를 연결하며, 비 순차적인 데이터 추가/삭제가 빠르다.<br/>
  - Set<br/>
    (1) Hash Set : 중복을 허용하지않고, 순서가 따로 없다.<br/>
    (2) Tree Set : Hash Set과 같은 특징을 가지지만, 정렬저장을 한다는 특징이 있다. 이진 검색 트리 구조로 되어있다.<br/>
  - Map<br/>
    (1) Hash Map : (Key : Value) 쌍으로 저장되어있다. 이때 Key는 중복을 허용하지않는다. 빠른 검색이 장점이다.<br/>
    (2) Tree Map : HashMap과 같은 구성이며, 빠른 검색과 Tree의 장점인 정렬과 범위검색의 장점을 모두 가지고 있다 .<br/>
### 2) 추상클래스와 interface의 차이점

  - 공통점<br/>
    (1) 선언만 있고 구현 내용은 없다.<br/>
    (2) new 객체를 생성할 수 없다.<br/>
  - 추상클래스<br/>
    (1) 클래스 내 '추상 메소드'가 하나이상 포함되거나 abstract로 정의된 경우를 말한다.<br/>
    (2) 단일 상속<br/>
    (3) 메소드를 가져다 쓰거나 Override하거나 abstract가 붙은 메소드는 반드시 구현한다.<br/>
  - 인터페이스<br/>
    (1) 메소드에 대한 명시만 있다.<br/>
    (2) 다중 상속<br/>
    (3) 상속받은 메소드는 전부 구현해야한다.<br/>

### 3) Thread Pool에 대한 설명

  스레드를 제한된 개수만큼 할당해 놓고 작업 큐에 들어오는 작업들을 하나씩 맡아서 처리하는 기법.병렬 작업 처리가 많아지면 스레드 개수가 증가하며, 그로인한 스레드 생성과 스케줄링으로 인해 메모리 사용량이 늘어나는것을 해결할수있음.<br/>
   
### 4) batch Module작성법

## 3.DB
### 1) db 페이징 방법
### 2) index는 어디에 하는게 좋은가?
Index는 검색속도를 높이기 위해 사용되는 하나의 기술이며 색인이라고 생각하면 된다. 해당 Table의 칼럼을 색인화 하여 검색시 해당 Table의 레코드를 색인화 되어 있는 Index 파일을 검색하여 검색속도를 빠르게 한다.</br>
  주로 where 절에 사용되는 컬럼, 외래키가 사용되는 열, join에 사용되는 열에 사용한다. 데이터의 중복도가 높은 열은 효율이 나지 않는다.(성별, 타입이 별로 없는 경우)</br>
  
### 3) trigger 써본적 있는가?

## 4.javascript
### 1)jquery에서 element를 제일 빨리 가져오는 것은?
### 2)clone 함수용도

# 출처
## 1.Spring
 * Spring 3입문(하세가와 유이치 오오노 와타루 토키 코헤이 지음, 김성재 옮김)
 * [갱짱.study(스프링(Spring) DI(Dependency Injection) - #1](http://gangzzang.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81Spring-IoCDIInversion-of-ControlDependency-Injection)
 ## 2.Java
 * Java의 정석(남궁 성지음)
 * [Take Action 신매력(추상화클래스와 인터페이스의 용도, 차이점, 공통)](http://marobiana.tistory.com/58)
 * [Joinc(Thread Pooling)](https://www.joinc.co.kr/w/Site/Thread/Advanced/ThreadPool)
 * [palpit's log-b([Java] 멀티 스레드 - 스레드풀(ThreadPool))](http://palpit.tistory.com/732)
 ## 3. DB
  * [후회하기 싫으면 그렇게 살지 말고, 그렇게 살거면 후회하지 마라 ( LIVE A LIFE WITHOUT REGRETS J. )(DB Index 란?)](https://lalwr.blogspot.kr/2016/02/db-index.html)
