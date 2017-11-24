# webflux-study
webflux-study

## 安装Mongo服务
基于docker的mongo服务
```bash
# 获取 MongoDB 的镜像
$ docker pull mongo
# 启动 MongoDB 容器
$ docker run -d --name any-mongo -p 27017:27017 mongo
```

windows下安装mongo并配置
```text
配置 MongoDB 服务
管理员模式打开命令行窗口

创建目录，执行下面的语句来创建数据库和日志文件的目录

mkdir c:\data\db
mkdir c:\data\log
创建配置文件

创建一个配置文件。该文件必须设置 systemLog.path 参数，包括一些附加的配置选项更好。

例如，创建一个配置文件位于 C:\mongodb\mongod.cfg，其中指定 systemLog.path 和 storage.dbPath。具体配置内容如下：

systemLog:
    destination: file
    path: c:\data\log\mongod.log
storage:
    dbPath: c:\data\db
安装 MongoDB服务

通过执行mongod.exe，使用--install选项来安装服务，使用--config选项来指定之前创建的配置文件。

"C:\mongodb\bin\mongod.exe" --config "C:\mongodb\mongod.cfg" --install
要使用备用 dbpath，可以在配置文件（例如：C:\mongodb\mongod.cfg）或命令行中通过 --dbpath 选项指定。

如果需要，您可以安装 mongod.exe 或 mongos.exe 的多个实例的服务。只需要通过使用 --serviceName 和 --serviceDisplayName 指定不同的实例名。只有当存在足够的系统资源和系统的设计需要这么做。

启动MongoDB服务

net start MongoDB
关闭MongoDB服务

net stop MongoDB
移除MongoDB服务

"C:\mongodb\bin\mongod.exe" --remove
```


## Mongo Plugin

小技巧：IDEA 有 MongoDB 的插件，可以方便的查看 MongoDB 里面的数据，插件名字：Mongo Plugin




## Add to github 
```bash
cd webflux-study
git init
git remote add origin git remote add origin https://github.com/helloworldtang/webflux-study.git
git pull origin master
git add .
git push orign master
```

## 参考
> [Spring Boot 2.0 - WebFlux With MongoDB](http://www.spring4all.com/article/239)        
> [Mongo 专题](http://www.cnblogs.com/softidea/p/6855209.html)








## todo: webflux下如何集成swagger

使用
```xml
        <dependency>
            <groupId>com.spring4all</groupId>
            <artifactId>spring-boot-starter-swagger</artifactId>
            <version>1.5.1.RELEASE</version>
        </dependency>
```
报错：
```text
Caused by: java.lang.IllegalStateException: Failed to introspect annotated methods on class springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration
	at org.springframework.core.type.StandardAnnotationMetadata.getAnnotatedMethods(StandardAnnotationMetadata.java:169) ~[spring-core-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassParser.retrieveBeanMethodMetadata(ConfigurationClassParser.java:390) ~[spring-context-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassParser.doProcessConfigurationClass(ConfigurationClassParser.java:315) ~[spring-context-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassParser.processConfigurationClass(ConfigurationClassParser.java:245) ~[spring-context-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassParser.processImports(ConfigurationClassParser.java:610) ~[spring-context-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	... 28 common frames omitted
Caused by: java.lang.NoClassDefFoundError: org/springframework/web/servlet/HandlerMapping
	at java.lang.Class.getDeclaredMethods0(Native Method) ~[na:1.8.0_144]
	at java.lang.Class.privateGetDeclaredMethods(Class.java:2701) ~[na:1.8.0_144]
	at java.lang.Class.getDeclaredMethods(Class.java:1975) ~[na:1.8.0_144]
	at org.springframework.core.type.StandardAnnotationMetadata.getAnnotatedMethods(StandardAnnotationMetadata.java:158) ~[spring-core-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	... 32 common frames omitted
Caused by: java.lang.ClassNotFoundException: org.springframework.web.servlet.HandlerMapping
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381) ~[na:1.8.0_144]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424) ~[na:1.8.0_144]
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:335) ~[na:1.8.0_144]
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357) ~[na:1.8.0_144]
	... 36 common frames omitted

```

添加starter-web依赖后,Swagger-ui.html中的get,list方法没有问题，但Post方法报错
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```

```text
2017-11-24 19:42:27.028 ERROR 5072 --- [nio-8080-exec-2] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class org.reactivestreams.Publisher]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `org.reactivestreams.Publisher` (no Creators, like default construct, exist): abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information
 at [Source: (PushbackInputStream); line: 1, column: 1]] with root cause

com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `org.reactivestreams.Publisher` (no Creators, like default construct, exist): abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information
 at [Source: (PushbackInputStream); line: 1, column: 1]
	at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67) ~[jackson-databind-2.9.2.jar:2.9.2]
	at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1451) ~[jackson-databind-2.9.2.jar:2.9.2]
	at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1027) ~[jackson-databind-2.9.2.jar:2.9.2]
	at com.fasterxml.jackson.databind.deser.AbstractDeserializer.deserialize(AbstractDeserializer.java:265) ~[jackson-databind-2.9.2.jar:2.9.2]
	at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4001) ~[jackson-databind-2.9.2.jar:2.9.2]
	at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3072) ~[jackson-databind-2.9.2.jar:2.9.2]
	at org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter.readJavaType(AbstractJackson2HttpMessageConverter.java:235) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter.read(AbstractJackson2HttpMessageConverter.java:223) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver.readWithMessageConverters(AbstractMessageConverterMethodArgumentResolver.java:206) ~[spring-webmvc-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.readWithMessageConverters(RequestResponseBodyMethodProcessor.java:157) ~[spring-webmvc-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.resolveArgument(RequestResponseBodyMethodProcessor.java:130) ~[spring-webmvc-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:124) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:161) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:131) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:102) ~[spring-webmvc-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:871) ~[spring-webmvc-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:777) ~[spring-webmvc-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:991) ~[spring-webmvc-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:925) ~[spring-webmvc-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:978) ~[spring-webmvc-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:881) ~[spring-webmvc-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:661) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:855) ~[spring-webmvc-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:742) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52) ~[tomcat-embed-websocket-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.springframework.boot.actuate.trace.WebRequestTraceFilter.doFilterInternal(WebRequestTraceFilter.java:119) ~[spring-boot-actuator-2.0.0.M6.jar:2.0.0.M6]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:99) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:108) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:81) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:200) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.springframework.boot.actuate.metrics.web.servlet.WebMvcMetricsFilter.filterWithMetrics(WebMvcMetricsFilter.java:95) ~[spring-boot-actuator-2.0.0.M6.jar:2.0.0.M6]
	at org.springframework.boot.actuate.metrics.web.servlet.WebMvcMetricsFilter.doFilterInternal(WebMvcMetricsFilter.java:72) ~[spring-boot-actuator-2.0.0.M6.jar:2.0.0.M6]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-5.0.1.RELEASE.jar:5.0.1.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:199) ~[tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96) [tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:478) [tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:140) [tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:81) [tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:87) [tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:342) [tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:803) [tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66) [tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868) [tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1459) [tomcat-embed-core-8.5.23.jar:8.5.23]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-8.5.23.jar:8.5.23]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) [na:1.8.0_144]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) [na:1.8.0_144]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-8.5.23.jar:8.5.23]
	at java.lang.Thread.run(Thread.java:748) [na:1.8.0_144]

```
