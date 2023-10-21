* 과제
``` 
1) 해당 레포지토리 fork & PR 해보기 (O) 
 
2) SpringBoot 간단한 REST API 만들어서 gradle jar 빌드 후 실행하기 (O)

3) 배포 환경설정 구축 및 배포 (0)
 * 만든 SpringBoot jar 프로젝트를 Docker 이미지로 만들기 -> 로컬에서 Docker 컨테이너 실행하기
 * AWS 가입 -> EC2 인스턴스 만들기  
 * EC2 서버에 gradle jar 배포하기 (jar 실행)
❗challenge - MySQL AWS EC2 인스턴스 만들고 jar 파일 배포한 EC2 인스턴스와 연동, 실행 성공시키기!
```
학습한 내용 정리
1. 내가 백엔드인데 AWS 클라우드를 왜 배워야 하는가?
   https://pos04167.tistory.com/167
2. AWS랑 친해지기(1) - 기본적인 배포
   https://pos04167.tistory.com/168
3. AWS랑 친해지기(2) - 시간 설정
   https://pos04167.tistory.com/169
4. AWS랑 친해지기(3) - Docker를 이용해서 배포하기
   https://pos04167.tistory.com/170

---

#### 1. AWS EC2 인스턴스 생성 (프로젝트 배포용도, MySQL 설치용도 따로)
(OS : `Ubuntu 20.04LTS` , 인스턴스유형 : `t2.micro`)
![](https://velog.velcdn.com/images/minbo2002/post/29feeba8-ae1d-437c-8202-4e1d25652294/image.png)

#### 2. EC2 -> 보안그룹 -> 인바운드 규칙 편집
에 들어가서 사용자 지정 TCP의 포트범위 8080 및 0.0.0.0/0 으로 설정하여 규칙을 저장한다.
이는 IPv4의 모든 아이피를 대상으로 8080포트의 접근을 허용한다는 의미다.
(MySQL 인스턴스는 포트범위 3306 및 0.0.0.0/0 으로 설정)
![](https://velog.velcdn.com/images/minbo2002/post/dc5ec6a8-6711-4149-90b9-20a1c671461e/image.png)

#### 3. MobaXterm(SSH 원격접속 프로그램)
을 통해서  Specify username은 ubuntu로 입력하고
Remote host 주소에 AWS EC2에서 생성한 인스턴스의 퍼블릭 `IPv4 주소`를 입력하고
Use private key에 키페어로 생성한 `pem 파일`을 입력하고 접속한다.
![](https://velog.velcdn.com/images/minbo2002/post/c122e125-720e-48a5-8da9-d5c66f376827/image.png)

---
## 수동으로 실행

<br>

1. 한국시간으로 타임존 변경
``` bash
sudo rm /etc/localtime

sudo ln -s /usr/share/zoneinfo/Asia/Seoul /etc/localtime

# 타임존 변경확인
date
```
<br>

2. swap 메모리 할당 (EC2 프리티어는 AWS가 권장하는 swap공간으로 RAM 1GB → 2GB)
``` bash
# dd 명령어로 swap 메모리를 할당
# 조금 기다려야 함
sudo dd if=/dev/zero of=/swapfile bs=128M count=32

# swap 파일의 읽기/쓰기 권한을 업데이트
sudo chmod 600 /swapfile

# Linux swap 영역을 설정
sudo mkswap /swapfile

# swap 공간에 파일을 추가하여 swap 파일을 즉시 사용
sudo swapon /swapfile

# 본 과정이 성공적으로 진행되었는지 확인
sudo swapon -s
```
``` bash
# /etc/fstab 파일을 편집하여 부팅 시 스왑 파일을 활성화
sudo vi /etc/fstab

# 파일 끝에 다음 줄을 새로 추가
/swapfile swap swap defaults 0 0

free
```
<br>

3. EC2 인스턴스내 MySQL 설치하기 (MobaXterm에서 MySQL 설치용도로 만든 EC2 인스턴스에 접속해서 진행)
``` bash
sudo apt-get update

sudo apt-get install mariadb-server

sudo systemctl status mariadb
```
``` bash
sudo mysql -u root # MySQL에 처음접근하면 비밀번호가 없다.
```
``` bash
# mysql) 들어와서 계정 생성 및 비밀번호 설정
mysql> CREATE USER 'kmb'@'%' IDENTIFIED BY '1234';
mysql> GRANT ALL PRIVILEGES ON *.* TO 'kmb'@'%';

exit
```
``` bash
mysql -u kmb -p # 만든 계정으로 접속한다음
```
``` bash
mysql> CREATE DATABASE {DB이름};  # DB 생성  ex) CREATE DATABASE coupon;
mysql> SHOW DATABASES;
```

``` bash
sudo vim /etc/mysql/mariadb.conf.d/50-server.cnf # 해당 경로로 가서 // bind-address 주석처리
```
![](https://velog.velcdn.com/images/minbo2002/post/7d3655bd-0391-4c3f-ac71-daa78b05f35b/image.png)
``` bash
sudo systemctl restart mysql
```
<br>

4. EC2 인스턴스내 gradle 빌드하기 (MobaXterm에서 프로젝트 배포용도로 만든 EC2 인스턴스에 접속해서 진행)

```bash
$ sudo apt update
$ sudo apt install openjdk-11-jdk

$ java -version

$ ## sudo apt-get install git ## ubuntu는 이미 git이 깔려있음.

$ git clone {깃헙에서 자신이 만든 레파지토리주소}  # git clone https://github.com/minbo2002/spring-project-challenge-study.git

$ chmod +x gradlew

$ ./gradlew clean build  # 만약 .gradlew clean build 할때 test코드 제외하려면  --> .gradlew clean build -x test

$ cd build/libs
$ nohup java -jar springstudy-0.0.1-SNAPSHOT.jar 2>&1 &

$ tail -f nohup.out
```
<br>

이후에 웹에서 배포된것을 확인하기 위해
`퍼블릭 IPv4주소:8080/api/coupon` 를 입력해보면
![](https://velog.velcdn.com/images/minbo2002/post/e3df1efc-1df4-4626-a246-48e6d35bf76e/image.png)

더미데이터 결과가 조회되는것을 확인할 수 있다.

---
## 쉘스크립트로 실행



먼저 수동으로 8080포트에서 실행중인 프로세스를 죽인다.
만약 netstat 명령어가 실행되지 않는다면 먼저 netstat tool을 설치
``` bash
sudo apt-get install net-tools  # Ubuntu 20.04 에서는 자주 쓰는 툴인 netstat 설치
```
```bash
$ netstat -nlpt  #현재 사용되고 있는 포트번호의 정보를 확인
```
![](https://velog.velcdn.com/images/minbo2002/post/8cc62ad1-0cdc-405a-91c3-21e05ddd6d20/image.png)
8080포트를 사용중인 프로세스의 PID가 17075임을 확인.
kill 명령어를 사용하여 실행중인 프로세스를 죽인다.
```bash
kill -9 17075  #kill -9 {PID번호}
```
<br>

이후에 아래의 명령어를 입력한다.
```bash
touch deploy.sh #deploy.sh 파일생성

vim deploy.sh #deploy.sh 파일내부로 일반모드로 진입

```
<br>

deploy.sh
```bash
# 전체 진행과정
# 1) i키를 누른다음 입력모드로 진입 -> 아래의 코드작성 -> 3) esc키 눌러서 입력모드에서 일반모드로 빠져나온다
# 4) : 키 눌러서 명령행모드로 진입 -> 5) wq 키 눌러서 저장하고 빠져나간다 (못빠져나간다면 :q! 명령어로 강제로 빠져나갈수 있다)

#!/bin/bash
# 1
REPOSITORY=/home/ubuntu
PROJECT_NAME={본인의 깃 레포지토리 프로젝트 이름}


# 2
cd $REPOSITORY/$PROJECT_NAME/

# 3
echo "> Git Pull"
git pull origin main


# 4
echo "> 프로젝트 Build 시작"
./gradlew clean build


# 5
echo "> git 디렉토리로 이동"
cd $REPOSITORY
echo "> Build 파일 복사"

cp $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/


# 6
echo "> 현재 구동중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -f ${PROJECT_NAME}.*.jar)

echo "현재 구동 중인 애플리케이션 pid: $CURRENT_PID"


# 7
if [ -z "$CURRENT_PID" ]; then
    echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
    echo "> kill -15 $CURRENT_PID"
    kill -15 $CURRENT_PID
    sleep 5
fi

echo "> 새 애플리케이션 배포"


# 8
JAR_NAME=$(ls -tr $REPOSITORY/ | grep jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"


# 9
nohup java -jar $REPOSITORY/$JAR_NAME 2>&1 &
```
이후에
```bash
$ chmod +x deploy.sh  #deploy.sh 파일 실행권한 부여

$ ./deploy.sh  #deploy.sh 파일 실행
```

웹에서 배포된것을 확인하기 위해
`퍼블릭 IPv4주소:8080/api/coupon` 를 입력해보면
![](https://velog.velcdn.com/images/minbo2002/post/e3df1efc-1df4-4626-a246-48e6d35bf76e/image.png)

더미데이터 결과가 조회되는것을 확인할 수 있다.
