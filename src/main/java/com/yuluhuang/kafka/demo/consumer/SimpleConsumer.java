/**
 * @Title
 * @Project kafka-demo
 * @Package com.yuluhuang.kafka.demo.consumer
 * @Description
 * @author ylh
 * @date 2018-11-02 17:18
 * @version
 */
package com.yuluhuang.kafka.demo.consumer;

import com.google.gson.Gson;
import com.yuluhuang.kafka.demo.common.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.sun.activation.registries.LogSupport.log;

/**
 * @author ylh
 * @Description
 * @date 2018-11-02 17:18
 */
@Slf4j
@Component
public class SimpleConsumer {
    private final Gson gson = new Gson();

    @KafkaListener(topics = "${kafka.topic.default}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(MessageEntity messageEntity) {
        log(gson.toJson(messageEntity));
    }
}
