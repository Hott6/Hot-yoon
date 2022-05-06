### 1.필수과제
#### Font적용하기
fontfamily라는 속성을 이용해서 res에 font파일을 만들어 주고 거기서 적용을 해서 사용을 한다.

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<font-family xmlns:android="http://schemas.android.com/apk/res/android">
    <font
        android:font="@font/noto_sanskr_regular"
        android:fontStyle="normal"
        android:fontWeight="400"/>

    <font
        android:font="@font/noto_sanskr_bold"
        android:fontStyle="normal"
        android:fontWeight="700"/>

</font-family>
```
* fontfamily를 만들어서 layout 파일에서 font를 설정할 때 편리하게 해줌
* fontWeight 같은 폰트여도 weight 값으로 다르게 사용할 수 있음

font family 파일을 적용하고 Weight를 넣어주면 Weight 값에 해당하는 폰트가 적용된다
#### profileFragmnet
BottomNavigation을 만들어주고 Fragment를 와따리 가따리 할 수 있게 만들어 보겠다

1. drawble에서 menu.xml을 만들어주고 메뉴에 들어갔으면 하는것을 <item 을 이용해서 만들어준다.
##### menu를 눌렀을때 selector를 이용해서 메뉴아이콘이 체크가 되었을 때 컬러를 바뀌게끔 줄것이다
2. select 되었을 경우의 xml, select되지 않았을 경우의 xml을 만들어서 두개를 [StateListDrawable(selector)](https://ju-hy.tistory.com/26)를 활용하여 만들었다.

### 2.성장과제
#### 중첩 스크롤 문제 해결하기 
> 스크롤 뷰와 이 스크롤 뷰를 포함하는 ViewPager2 객체의 방향이 같은 경우 ViewPager2는 기본적으로 중첩된 스크롤 뷰를 지원하지 않습니다.

TabLayout에서 화면이 넘어가도록 ViewPager2를 연동했는데 BottomNavigation만 스와이프 되고 Tab은 스와이프가 되지 않는다.
따라서 
[NestedScrollableHost.kt](https://github.com/android/views-widgets-samples/blob/master/ViewPager2/app/src/main/java/androidx/viewpager2/integration/testapp/NestedScrollableHost.kt)를 만들어주고 제공해주는 코드를 넣어준 뒤에 원하는 자식 ViewPager2에 
```kotlin
<org.techtown.soptseminar.NestedScrollableHost
        android:id="@+id/nst_home"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toBottomOf="@id/tab_home">

        <androidx.viewpager2.widget.ViewPager2
            android:id="@+id/vp_homefragment"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

    </org.techtown.soptseminar.NestedScrollableHost>
</androidx.constraintlayout.widget.ConstraintLayout>
```
이런식으로 넣어주면 된다.
