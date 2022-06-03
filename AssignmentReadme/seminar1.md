# Hot-yoon
Sopt에 모인 Hot한 개발자들

# Seminar1


# 기억해야되는 부분!
 1. mathchparent는 0dp로 설정해놓고 부모한테 제약을 걸어놓은거
 2. edt에 아무것도 입력이 안되어 있을 경우를 아는 방법
    - 방법 1 : isNullOrBlank 메서드사용
    - 방법 2 : isEmpty 메서드
 3. ScrollView에는 View가 한개밖에 안들어감
 4. constraintDimensinRatio를 사용하려면 비율에 맞게 가로세로를 설정가능

## 함수함수!
- put("전달할 값의 name", 전달할 값)

## 코드분석

```kotlin
SignInActivity.kt임
val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data: Intent? = result.data
                    val userId = data?.getStringExtra("id")
                    val userPw = data?.getStringExtra("pw")
                    binding.edtId.setText(userId)
                    binding.edtPassword.setText(userPw)
                }
            }
```
1. registerForActivityResult : Activity에 대한 콜백 등록 후 launcher생성 ->  ~~launcher는 무엇인가..?~~
2. ActivityResultContracts : activityresult에 대해서 contrats(계약)이 포함된 클래스
3. startActivityForResult(): 새로운 activity를 열어줌
4. resultCode: 위의 새로운 activity가 작업을 수행하고 나서 결과값을 판단하여 RESULT_OK 혹은 RESULT_CANCLED를 알려줌 이걸 받은 activity가 result.resultCode == Activity.RESULT_OK 이면 if문 실행

### 이걸 resultLauncher에 저장했으니 사용을 해야겠죵?!

```kotlin
    binding.btnSign.setOnClickListener {
                val intent = Intent(this, SignUpActivity::class.java)
                resultLauncher.launch(intent)
            }
```
회원가입 버튼을 누르면 signupActivity로 이동할 수 있는 intent를 생성한다. 이 intent를 resultlauncher의 launch에 넣어서 실행하면 <p>
SignUp이 실행이 된다. 이제 여기서
```kotlin
SignUpActiviy.kt임
else{
                val intent = Intent(this ,SignInActivity::class.java)
                //signin(도착하는 activity)에 입력한걸 이동
                intent.putExtra("id", binding.edtId.text.toString())
                intent.putExtra("pw",binding.edtPassword.text.toString())
                setResult(Activity.RESULT_OK, intent)
                //이 activity가 잘 실행 되었는지 아닌쥐~!
                finish()
```
 <img src="/gif/seminar1.gif" width="200" height="400"/>
