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

# 📅 스터디 일정(12/17 ~ 01/07)

<details>
<summary>1주차(12/17)</summary>
<div markdown="1">

* 자기소개 시간
* 스터디 취지, 방향, 구성 방식 설명
* 과제 
``` 
1) 사용 툴 설치및 이해하기 
 * IntelliJ(얼티메이트 버전 추천-플러그인 사용 가능)
 * MySQL, DB 접속 HediSQL 
 * e2e 테스트용 postman
 * git/github

2) 해당 레포지토리 fork & PR 해보기 
 
3) SpringBoot, JPA(ORM), Mysql 사용 간단한 CRUD REST API 만들기(Entity 명은 각자 취향대로)

4) 배포 환경설정 구축
 * AWS 가입 -> EC2 인스턴스 만들기  
 * Docker 설치하기(윈도우의 경우 wsl2 설치해야)
```
* 환경셋팅 : https://www.notion.so/bb4d80cb1a094696b8ff27f4cd52bb00

 <br>
 
</div>
</details>

<details>
<summary>2주차(12/24)</summary>
<div markdown="1">

* 백앤드 프로젝트 배포 구조도(springBoot - jenkins- docker)
* 김종훈, 이여울님 발표
* gradle 빌드 jar, docker container 작동 로컬에서 확인
* crud -> jpa dto response 확인
* 정리 : https://www.notion.so/2week-48ad0851088b497fa8335c1cf133f7e6

* 과제 
``` 
1) aws ec2 인스턴스에서 프로젝트 gradle jar 실행하기, 
ec2 인스턴스 docker 설치 -> docker image 만들고 프로젝트 docker 실행하기

2) docker로 jenkins 설치하기(로컬, ec2) 

3) exception 처리를 위한 exceptionHandler 구현하기

4) 챌린지 과제 - Junit5 테스트 작성하기(controller, service)
```
</div>
</details>

<details>
<summary>3주차(01/07)</summary>
<div markdown="1">

* 코드리뷰 과제 - 현지수님 exceptionHander 커스터마이징, docker runtime 오류 문제
* AWS EC2 생성 -> docker 설치, docker 컨테이너 실행 확인
* 기본 docker 명령어 / 리눅스 명령어 정리
* jenkins가 사용되는 이유
* Jenkins freestyle 프로젝트 생성 & 원격서버 ssh 사용 docker 컨테이너 배포 (nohup이란?)
* 정리 : https://www.notion.so/3week-e03d67a16de34b6a9f67ef4d42a2cb51

* 과제 
``` 
1) MySQL docker 컨테이너 실행 및 기존 프로젝트 docker 컨테이너 연동하기

2) ssh 명령어, scp 명령어 사용해보기

3) 3주차 내용 때 한 jenkins Freestyle 프로젝트로 원격 서버 ssh 접속, docker 배포 해보기

4) 챌린지 과제 -  git Repository 연동 commit된 내용 반영 -> gradle jar 생성 
-> dockerizing(docker build -> push) -> ssh 서버 docker run 배포 해보기
```
</div>
</details>

<details>
<summary>4주차(01/14)</summary>
<div markdown="1">

* 코드리뷰 및 소개 기술 정리
* Jenkins 배포 자동화 과정(jenkins freestyle 프로젝트)
  1) git private 설정 - ssh Deploy key 등록
  2) git webhooks(핵심)
  3) gradle wrapper execute 설정
  4) docker build -> docker login -> docker push
  5) ssh 원격서버 -> docker run (docker rm & rmi)
* 정리 : https://www.notion.so/3week-e03d67a16de34b6a9f67ef4d42a2cb51

* 과제 
``` 
1) 지난 과정 docker 기술 리마인드 

2) MySQL docker 컨테이너 실행 및 기존 프로젝트 docker 컨테이너 연동하기 (AWS)

3) 챌린지 과제 - docker pipeline 프로젝트로 진행 
git Repository 연동 commit된 내용 반영 -> gradle jar 생성 
-> dockerizing(docker build -> push) -> ssh 서버 docker run 배포 해보기

```
</div>
</details>

<br>

# 🎃 주의사항

1. 발표 내용에 대한 리뷰, 질문이 너무 날카로워 해당 발표자에 대한 강한 감정적인 언행은 주의해주세요 😫!
2. 질문을 받은 발표자도 Code 또는 발표내용 등을 자신과 동일시하여 지적한 것에 대해 너무 불쾌히 여기지 말으셨으면 좋겠습니다 😂!
3. 리뷰, 피드백의 핵심은 `문제점들을 찾고 발전하는 것`이라는 걸 잊지 말아주세요!
4. 보증금은 `최소 3번`은 스터디에 합류한 분들에게만 지급된다는 점 잊지 말아주세요!
