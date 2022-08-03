package sinexcel.test;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@RabbitListener(queues = "delayed_queue_bom")//监听的队列名称 TestDirectQueue
public class ReceiverBom {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String itemNumber) {
        logger.info("delayed_queue_bom消费者收到消息  : " + itemNumber);
    }

}
