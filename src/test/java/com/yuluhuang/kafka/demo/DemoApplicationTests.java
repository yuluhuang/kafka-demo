package com.yuluhuang.kafka.demo;

import com.yuluhuang.kafka.demo.common.MessageEntity;
import com.yuluhuang.kafka.demo.consumer.SimpleConsumer;
import com.yuluhuang.kafka.demo.producer.SimpleProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    SimpleProducer simpleProducer;
    @Autowired
    SimpleConsumer simpleConsumer;

    @Value("${kafka.topic.default}")
    private String topic;

    @Test
    public void contextLoads() {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setBody("123");
        messageEntity.setTitle("456");
        simpleProducer.send(topic, "key", messageEntity);
    }

}
