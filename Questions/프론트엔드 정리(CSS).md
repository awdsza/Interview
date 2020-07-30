CSS
============

1.class와 id의 차이점에 관해서 설명해주세요.

  * class와 id는 고유한 선택자를 지정하기 위한 이름이고, class는 여러개의 태그를 묶어서 지정하기 위한 이름의 차이입니다.

2.“reset” CSS가 무엇인지, 어떻게 유용한지 설명해주세요.

  * reset의 뜻은 초기화하다라는 뜻인데, css reset은 단어의 뜻에 맞게 브라우저마다 css속성의 값이 다르기 때문에, 특정태그에 특정 CSS값을 지정해놓고 작업을 하는것을 의미합니다. 주로 padding, margin,border등의 속성이 브라우져마다 미세하게 차이가 있으므로, 속성들을 초기화 시킨 후 css를 작업하는것이 대표적입니다.
  
  참고 링크1 : [everdevel](https://www.everdevel.com/CSS/css-reset/)

3.Floats가 어떻게 동작하는지 설명해주세요.

  * float는 요소의 모서리가 왼쪽(left),오른쪽(right)으로 이동 시키는 것을 말합니다.
  
  
  참고 링크1: [Web Club](https://webclub.tistory.com/606)

 4.z-index에 관해 설명해주세요.

   * z-index는 간단한게 말해서 요소의 수직 위치를 정해주는 속성입니다.  position 속성을 이용해서, 요소를 한곳에 겹치게 놓을수 있는데, z-index를 사용하지 않으면, 입력한 순서대로 요소가 쌓입니다. 요소에 z-index를 지정하면 z-index의 내림차순으로 요소가 쌓이게 됩니다.
   
   * z-index형제끼리 순위를 결정하고 자식 요소는 부모요소와 같이 움직입니다.
   ```
   /*css*/
    div{
            width:200px;
            height: 200px;
            border : 2px solid #050505;
        }
        div.x{
            position: absolute;
            top:20px;
            left:200px;
            z-index:-1;
            background-color:tomato;
            font-size:16px;
        }
        div.y{
            position: absolute;
            top:10px;
            left:100px;
            z-index:-0;
            background-color:blanchedalmond;
            font-size:16px;
        }
        div.z{
            position: absolute;
            top:30px;
            left:150px;
            z-index:1;
            background-color:goldenrod;
            font-size:16px;
        }
    
    <!-- HTML -->
    <div class="x">1번!!</div>
    <div class="y">2번!!</div>
    <div class="z">3번!!</div>
    
    <!-- z-index속성에 따라 3번,2번,1번 순서대로 수직위치가 나옵니다.-->
   
   ```
   참고 링크1 : [CODING FACTORY](https://www.codingfactory.net/10878)
   
   5.BFC(Block Formatting Context)에 관해 설명해주세요
 
   6.클리어링(Clearing) 기술에는 어떤 것들이 있으며, 어떨 때 어떻게 사용하는 것이 적절한지 설명하세요.

   7.CSS 스프라이트(CSS Sprites)를 설명하고, 페이지나 사이트를 어떻게 향상하는지 설명하세요.
   
   8.Image Replacement를 사용해야 할 때, 선호하는 기술과 언제 사용하는지를 설명해주세요.
   
   9.브라우저 스펙 차이에 따른 스타일링 이슈를 수정하기 위해서 어떻게 접근하나요?
   
   10.기능이 제약된 브라우저를 위해서 어떤 방식으로 페이지를 만드나요?
   
   11.어떠한 기술과 절차를 거치는지 설명하세요.
   
   12.시각적으로 보이지 않고 스크린 리더에서만 가능하게 하는 방법에 관해 설명해주세요.
   
   13.그리드 시스템(Grid system)을 사용한 적이 있나요? 있다면 어떠한 것을 선호하나요?
   
   14.미디어 쿼리(media queries)를 사용한 적이 있나요? 혹은 모바일에 맞는 layout과 CSS를 사용한 적이 있나요?
   
   15.SVG를 스타일링하는데 익숙하신가요?
   
   16.인쇄하기 위해 웹페이지를 어떻게 최적화 하나요?
   
   17.효율적인 CSS를 작성하기 위한 "비법(gotchas)"은 어떤 게 있나요?
   
   18.CSS 전처리(CSS preprocessors)를 사용해보셨나요?
   
   19.그렇다면, 사용 경험에 기반을 둬 좋았던 점과 나빴던 점을 설명해주세요.
   
   20.페이지에서 표준 폰트가 아닌 폰트 디자인을 사용할 때 어떤 방식으로 처리하시나요? (웹폰트를 제외하고)
   
   21.CSS Selector가 어떠한 원리로 동작하는지 설명해주세요.
   
   22.pseudo-elements에 관해서 설명하고 어디에서 사용되는지 이야기해보세요.
   
   23.box model에 관해 설명하고 브라우저에서 어떻게 동작하는지 설명해주세요.
   
   24.* { box-sizing: border-box; }은 무엇이고 사용했을때 이점은 무엇인가요?
   
   25.기억나는 display 속성에 대한 값들을 나열해보세요.
   
   26.inline과 inline-block의 차이점은 무엇인가요?
   
   27.요소를 배치하는 방법(relative, fixed, absolute, static) 간의 차이는 무엇인가요?
   
   28.CSS에서 'C’는 Cascading을 의미합니다. Cascading에 관해서 설명해주세요. 또 cascading system의 장점은 무엇인가요?
   
   29.CSS framework를 사용해본 적이 있으신가요? 실무에서 사용해보았다면 어떤 이점이 있었나요?
   
   30.새로운 CSS Flexbox 혹은 Grid 스펙을 사용해 보신 적 있나요?
   
   31.반응형(Responsive) 디자인은 적응형(Adaptive) 디자인과 어떤 차이점이 있나요?
   
   32.레티나 그래픽 환경에서 작업해 보신 적이 있나요? 하셨다면 어떤 기술을 사용하셨나요?
   
   33.절대 좌표대신 translate() 혹은 반대로 사용하는 이유가 있나요? 있다면 이유에 관해서 설명해주세요.

-----

문제 참고 : [프론트엔드 면접 문제 은행](https://h5bp.org/Front-end-Developer-Interview-Questions/translations/korean/)
