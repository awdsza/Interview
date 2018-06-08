
# EcmaScript6(Ecma2015)

## 소개</br>
대부분의 자바스크립트는 2009년에 제정되어 2011년에 개정된 EcmaScript5.1을 표준으로 사용했다.
지금은 ECMA라는 단체에서 매년 결점을 보완하여 표준 자바스크립트 버전을 발표하였으며, 2015년 6월에 대대적인 업데이트를 통해 EcmaScript6가 발표되었다.
## 사용하고 싶다면?
가능하지만 Babel,TypeScript같은 ES6 컴파일러를 사용하여야 한다.
## 새로운 기능들</br>
### 1.Const,Let</br>
- 기존의 함수 스코프를 따르지않고 블록 스코프를 따르는점이다. 
- 블록 스코프는 해당 블록에서만 접근할수 있는것을 말한다. 
- window나 global에 등록되지 않는다.
#### Let
기존의 var를 대체함.
```
let x = "X";
x = "Y"; // 'Y'
```
#### Const
Const는 변수를 선언한 시점에서만 값을 할당 할 수 있고, 그 이후로는 할 수 없다. 값을 할당하지 않으면 에러를 발생시킨다. 할당한 객체나 배열의 요소를 바꾸는것은 가능하다.
```
const A = 3000;
A = 5000;
VM226:1 Uncaught SyntaxError: Identifier 'A' has already been declared
```
```
const A;
Uncaught SyntaxError: Missing initializer in const declaration
```
### 2.Function</br>
- Arrow Function</br>
기존에 function(friend){}을 사용했다면, ES6에서는 (매개변수) =>{}로 사용할 수 있다>
```
const object2 = {
  name: 'Zero',
  friends: ['One', 'Two', 'Three'],
  alertFriends() {     
    this.friends.forEach((friend) => {
      console.log(this.name);
      console.log(friend);
    });
  }
};
object2.alertFriends();
```
## 출처
- [ZeroCho Blog](https://www.zerocho.com/category/EcmaScript/post/5756d488e9c105aaeb550ea5)</br>
- [좋은 JavaScript 코드 작성을 위한 블로그](https://cimfalab.github.io/deepscan/2016/07/ecmascript-6)
- [ES6 In Depth](http://hacks.mozilla.or.kr/category/es6-in-depth/)
- [머루의개발블로그](http://wonwoo.ml/)
