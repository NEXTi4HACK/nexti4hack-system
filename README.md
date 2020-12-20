# 概要

Kotlin/Spring Security/Gradle/Docker/kubernetes の勉強用

##### 1.プロジェクトのrootディレクトリで以下を実行しアプリケーションをビルド
```
$ ./gradle :connect-web:bootJar
```

##### 2.Docker Imageを作成
```
$ docker-compose build
```

##### 3.Kubernetesにアプリケーションをデプロイ
```
$ kubectl create -f connect-db.yml 
$ kubectl create -f connect-webapp.yml
```

##### 4.Deploymentを公開するServiceオブジェクトを作成
```
$ kubectl expose deployment connect-webapp --type=LoadBalancer --name=connect-lb
```

##### 5.以下URLにアクセスしてログイン画面が開けば成功
http://localhost:18081/webapp/login