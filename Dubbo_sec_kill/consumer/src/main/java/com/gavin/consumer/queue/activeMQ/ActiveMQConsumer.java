package com.gavin.consumer.queue.activeMQ;


import com.alibaba.dubbo.config.annotation.Reference;
import com.gavin.provider.service.SecKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActiveMQConsumer {

    @Reference
    private SecKillService secKillService;

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息

    @JmsListener(destination = "seckill")
    public void receiveQueue(Long id) {
        //收到通道的消息之后执行秒杀操作(超卖)
        //String[] array = message.split(";");

        log.info("进入消息队列了*************");

        String result = secKillService.payProduct(id);

    }
}
