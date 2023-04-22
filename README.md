# deploy-challenge-study
웹개발 배포 챌린지 스터디 레포지토리입니다.

<br>

# 📢 스터디 규칙
1. 매주 스터디는 2시간을 기본으로 한다. 스터디장이 기술소개시간 1시간 , 스터디원 2명이 발표 진행 1시간을 맡는다, 해당발표 내용은 이 [deploy-challenge-study](https://github.com/mooh2jj/deploy-challenge-study)를 `fork`한 후 본인 Repository에서 각 `본인이름의 디렉토리`에 `PR(Pull Request)`하여 정리해주면 된다.
  * fork&PR 영상 참고 -> https://www.youtube.com/watch?v=yr6IzOGoMsQ

2. 발표자들 2명은 과제한 내용 또는 공부한 내용을 발표한다.(발표는 하고싶은 분을 1순위, 없다면 당일날 랜덤으로 정해집니다)
3. 발표시 CodeReview인 점을 감안하여 개발한 내용을 중심으로 발표가 이루어져야 한다.(이론적인 내용도 좋지만 직접 코드를 작성한걸로 발표하는 걸 권장드립니다)
4. 나머지 스터디원들도 매주 해당 내용 숙지를 위해 스터디한 내용 학습, 학습한 내용을 `해당 본인이름의 디렉토리`에 `PR`하여 정리한다. 


<br>

# 📅 스터디 일정(04/01 ~ 04/22)

<details>
<summary>1주차(04/01)</summary>
<div markdown="1">

* OT 진행 - 스터디 취지, 방향, 구성 방식 설명
* 백앤드 프로젝트 배포 구조도(springBoot - jenkins- docker)
* gradle 빌드 실습

* 과제 
``` 
1) 해당 레포지토리 fork & PR 해보기 
 
2) SpringBoot 간단한 REST API 만들어서 gradle jar 빌드 후 실행하기

3) 배포 환경설정 구축 및 배포
 * 만든 SpringBoot jar 프로젝트를 Docker 이미지로 만들기 -> 로컬에서 Docker 컨테이너 실행하기
 * AWS 가입 -> EC2 인스턴스 만들기  
 * EC2 서버에 gradle jar 배포하기 (jar 실행)
❗challenge - MySQL AWS EC2 인스턴스 만들고 jar 파일 배포한 EC2 인스턴스와 연동, 실행 성공시키기!
```

* 개발도구 설치 : https://www.notion.so/bb4d80cb1a094696b8ff27f4cd52bb00
* intelliJ 설정 : https://www.notion.so/IntelliJ-404f4523081d4868a6ea7fb09cbd630e
* 1주차 정리 : https://www.notion.so/1week-48ad0851088b497fa8335c1cf133f7e6

</details>

<details>
<summary>2주차(04/08)</summary>
<div markdown="1">

* 과제 내용 복습
* docker 명령어
* gradle vs gradlew
* AWS EC2 인스턴스(Ubuntu20.04) 내 서버 설정
* docker 설치
* jenkins 설치

* 과제 
``` 
1) SCP 명령어 실습 - 추후 내용 보강 후 알려드림
2) jenkins 내 publish-over-ssh 수동설치 후 private&pulbic key 설정등록하기
3) worker-instance 에 docker run 실행 시키기
```

* 2주차 정리 : https://www.notion.so/2week-e03d67a16de34b6a9f67ef4d42a2cb51

</details>

<details>
<summary>3주차(04/15)</summary>
<div markdown="1">

* jenkins 인스턴스 -> worker 인스턴스 로 docker 명령어 전달
* ssh 원격 접속을 위한 설정 (개인키 & 공개키 등록)
* Freestyle 프로젝트 설정
* 실습

* 과제 
``` 
- 못다한 Freestyle 프로젝트 진행 + ver2 프로젝트까지 진행
  => 3week 노션 정리에서 참조!
```

* 3주차 정리 : https://www.notion.so/3week-a987f01ccbb34baba6d24fb0aeb75752

</details>

<details>
<summary>4주차(04/21)</summary>
<div markdown="1">

* jenkins 인스턴스 -> worker 인스턴스 로 docker 명령어 전달
* ssh Agent 플러그인으로 원격 접속을 위한 설정 (개인키 등록)
* pipeline 프로젝트 설정 script 방식의 프로세스 
* git webhook 설정으로 자동배포화 구동

* 과제 
``` 
- 못다한 배포 프로젝트 정리 - 끝까지 완성한 경험 딱 한번!이면 됨
```

* 4주차 정리 : https://www.notion.so/4week-c12c4078e43f45b5b169b0b594a8c749

</details>

 <br>

 <br>


# 🎃 주의사항

1. 발표 내용에 대한 리뷰, 질문이 너무 날카로워 해당 발표자에 대한 강한 감정적인 언행은 주의해주세요 😫!
2. 질문을 받은 발표자도 Code 또는 발표내용 등을 자신과 동일시하여 지적한 것에 대해 너무 불쾌히 여기지 말으셨으면 좋겠습니다 😂!
3. 리뷰, 피드백의 핵심은 `문제점들을 찾고 발전하는 것`이라는 걸 잊지 말아주세요!
4. 보증금은 `최소 3번`은 스터디에 합류한 분들에게만 지급된다는 점 잊지 말아주세요!
