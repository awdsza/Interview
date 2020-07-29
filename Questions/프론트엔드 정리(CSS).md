CSS
============

1.class와 id의 차이점에 관해서 설명해주세요.

  * class와 id는 고유한 선택자를 지정하기 위한 이름이고, class는 여러개의 태그를 묶어서 지정하기 위한 이름의 차이입니다.

2.“reset” CSS가 무엇인지, 어떻게 유용한지 설명해주세요.

  * reset의 뜻은 초기화하다라는 뜻인데, css reset은 단어의 뜻에 맞게 브라우저마다 css속성의 값이 다르기 때문에, 특정태그에 특정 CSS값을 지정해놓고 작업을 하는것을 의미합니다.
  
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
   
-----

문제 참고 : [프론트엔드 면접 문제 은행](https://h5bp.org/Front-end-Developer-Interview-Questions/translations/korean/)
