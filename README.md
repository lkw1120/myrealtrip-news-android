# 마이리얼트립 Android 앱 과제
RSS 뉴스 리더 어플리케이션

### 스크린샷

<img src="https://github.com/lkw1120/myrealtrip-news-android/blob/master/assets/images/Screenshot_2020-04-03-02-17-54.png" width="35%"><img src="https://github.com/lkw1120/myrealtrip-news-android/blob/master/assets/images/Screenshot_2020-04-03-02-18-05.png" width="35%">
<img src="https://github.com/lkw1120/myrealtrip-news-android/blob/master/assets/images/Screenshot_2020-04-03-02-18-44.png" width="35%"><img src="https://github.com/lkw1120/myrealtrip-news-android/blob/master/assets/images/Screenshot_2020-04-03-02-18-57.png" width="35%">

### 요구사항

- 스플래시 화면
  + 앱 실행 시 스플래시 화면이 보여집니다.
  + 1.3초 후에 뉴스 리스트 화면으로 이동합니다.
  + 화면은 아래와 같이 구성되어야 합니다.
    * 로고 이미지(원형): 가운데 정렬. 1:1 비율 사이즈. 원형 마스킹
    * 좌우 작은 이미지: 로고 이미지 대비 ⅓ 사이즈. 1:1 비율 사이즈. 로고이미지와 하단 정렬, 화면 좌우 동일 마진
    * 앱 설명 텍스트: 라벨 3개, 왼쪽 정렬, 멀티라인. 텍스트 영역 전체 화면 가운데 정렬
    * 버전 표시: 화면 하단에 중앙 정렬하여 표시, 하단에 마진 추가
- 뉴스 리스트
  + RSS로 제공되는 뉴스 목록이 표시됩니다.
  + 뉴스 리스트에는 각 뉴스의 썸네일, 제목, 본문의 일부, 주요 키워드 3개가 표시되어야 합니다.
  + 각 뉴스 항목(item)을 선택하면 뉴스 상세보기 화면으로 이동할 수 있습니다.
  + 주요 키워드 추출 방법: 각 뉴스에서 키워드를 추출하는 방법은 다음의 순서를 따르면 됩니다.
    * 뉴스 본문의 내용으로부터
    * 2글자 이상의 단어들 중에서(주의 한글의 경우 조사, 어미는 고려하지 않습니다. 띄어쓰기만 고려합니다.)
    * 등장 빈도수가 높은 순서대로 3건(빈도수가 같을 경우 문자정렬 오름차순 적용) 을 추출합니다.
  + 리스트를 당겨서 새로고침 할 수 있도록 처리해줍니다.
- 뉴스 상세보기
  + 리스트에서 선택한 뉴스의 기사 본문을 읽을 수 있습니다.
  + 제목, 주요 키워드, 뉴스 원문이 표시됩니다.
  + 뉴스 원문은 WebView를 사용해 표시합니다.

### 사용한 라이브러리

- Foundation
  + AppCompat
  + Android KTX
- Architecture
  + DataBinding
  + ViewModel
  + LiveData
- UI
  + CoordinatorLayout
  + ListAdapter
- Third party
  + Koin
  + Glide
  + Retrofit2
  + Jsoup
  + Kotlin Coroutines

### 참조

- [github.com/android/architecture-components-samples](https://github.com/android/architecture-components-samples)
- [github.com/android/sunflower](https://github.com/android/sunflower)
- [https://twinw.tistory.com/46](https://twinw.tistory.com/46)
