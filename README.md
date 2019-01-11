# rabbitmq 
## 参考 https://www.cnblogs.com/boshen-hzb/p/6841982.html
## rabbitMQ
### hello目录下 单生产者和单消费者；单生产者-多消费者；多生产者-多消费者
### topic目录下 可以根据binding_key自由的绑定不同的队列；完全匹配，模糊匹配(#和*)
### fanout目录下 就是我们熟悉的广播模式或者订阅模式，给Fanout转发器发送消息，绑定了这个转发器的所有队列都收到这个消息
### 不同的两个系统(A和B)，可以通过绑定相同的队列来传递消息。当A发送消息到队列，B系统崩溃，消息不会丢失；等B系统正常运行以后，还会获取到对应的消息；
### 注释掉Fanout中3个接收的@RabbitListener注解，请求send方法，打开@RabbitListener注解重新运行项目，会接收到正常的消息；

