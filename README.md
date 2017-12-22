# webflux-study
webflux-study

## What Is It?
Reactive Programming is a style of micro-architecture involving intelligent routing and consumption of events, all combining to change behaviour. 

![webflux-overview](https://docs.spring.io/spring-framework/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/images/webflux-overview.png)

### webflux-mongo
WebFlux With MongoDB

### Usage:      
http://localhost:8080


### Tips:
#### 基于Docker使用mongo

在 docker 上运行 MongoDB
首先，获取 MongoDB 的镜像：
```bash
 $ docker pull mongo
```
然后启动 MongoDB 容器
```bash
$ docker run -d --name any-mongo -p 27017:27017 mongo
```
#### Idea下的一个插件Docker使用mongo   

DEA 有 MongoDB 的插件，可以方便的查看 MongoDB 里面的数据，插件名字：Mongo Plugin
![Mongo Plugin Server](http://images2017.cnblogs.com/blog/280044/201712/280044-20171222111839740-1709953968.png)




参考
>[Notes on Reactive Programming Part I: The Reactive Landscape](https://spring.io/blog/2016/06/07/notes-on-reactive-programming-part-i-the-reactive-landscape)