---
微服务模块
---
1.建module  
2.改POM  
3.写YML  
4.主启动  
5.业务类  

---
快捷键
---
1.psvm   快速生成main方法  
2.Ctrl + Alt + v    方法的返回值  
3.Ctrl + Alt + o    清除不需要的注解  
4.Ctrl+Alt+L        格式化代码  
5.Ctrl+H            显示类结构图（类的继承层次）  

6.Ctrl+Alt+T 可以把代码包在一个块内，例如：try/catch  

---
RestTemplate
---
RestTemplate：  RestTemplate提供了多种便捷访问远程Http服务的方法，是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集，实现80到8001的远程调用。  
[官网地址](https://docs.spring.io/spring-framework/docs/5.2.2.RELEASE/javadoc-api/org/springframework/web/client/RestTemplate.html)  
使用：  
使用restTemplate访问restful接口非常的简单粗暴，（url、requestMap、ResponseBean.class）这三个参数分别代表REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
