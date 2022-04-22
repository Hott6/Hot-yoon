# seminar2

stroke는 테두리의 두꼐와 색상을 지정함

## 필수과제
### RecyclerView에 대해서 알아봅시다.

### Fragment는 
1. 액티비티 내에서 화면 UI일부를 나타내준다.
2. 여러 개의 프래그먼트를 조합하여 액티비티가 출력하는 한 화면의 UI표현을 가능하게 한다.
3. 액티비티 실행 중에도 화면에 동적으로 추가되거나 다른 프래그먼트로 교체가 가능하다.

이 프래그먼트를 사용하기 위해서 프래그먼트랑 액티비티를 연결해줄 무언가가 필요한데 그것이 Adapter이다.

Viewholder는 동일한 형태의 뷰 하나에 대한 데이터 넣을 위치 정보를 알고있는 녀석을 말하는 것이다.

## 성장과제
### 2-1 DetailActivity
    처음에 생각했던 것은 ViewHolder에는 view가 있으니까 거기서  setOnclickListner를 달아주고 이거를
    ViewFollowerAdapter에서 startActivity()를 호출해서 intent를 사용해가지고..! 하면 되겠다 라고 생각을
    했었는데 this가 사용이 안 되는 것임.. 이유는.. 아직도 잘 모르겠쥐만.. 그래서
```kotlin
     //클릭 인터페이스 정의
    interface ItemClickListener{
        fun onClick(view: View, position: Int)
    }
    //클릭 리스너 선언
    private lateinit var itemClickListener: ItemClickListener

    //클릭리스너 등록 메소드
    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener = itemClickListener
    }
```
이렇게 아예 클릭리스너를 만들어줘서 onVindViewHolder에 선언해줬다. \
참고 : https://sunpil.tistory.com/181

그 다음 DetailActivity에서 intent를 사용하여 불러왔다!
### 2-2 ItemDecoration
 MyDecoration.kt을 만들어 주었다.

```kotlin
class MyDecoration(private val divHeight : Int, private val rowcount : Int) : RecyclerView.ItemDecoration()
```
나는 MyDecoration의 변수로 마진값을 주고싶은 크기(?)를 받아왔고 행을 사용해서 행이 2개 이상일때는 Grid를 사용했다고 생각하고 그거에 맞게끔 조건을 짜주었다.
저기 RecyclerView.ItemDecoraion을 쓰니까 getItemOffset과 OnDraw가 생겻다. 두둥
저 함수 두개를 이용해서 여백을 만들어 주는 것이다.

![ezgif com-gif-maker](https://user-images.githubusercontent.com/66460447/164726226-01f92fce-940c-4652-92b9-c451f4aed2a6.gif)
