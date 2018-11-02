/**
 * @Title
 * @Project kafka-demo
 * @Package com.yuluhuang.kafka.demo.producer
 * @Description
 * @author ylh
 * @date 2018-11-02 16:50
 * @version
 */
package com.yuluhuang.kafka.demo.producer;

import com.google.gson.Gson;
import com.yuluhuang.kafka.demo.common.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.Nullable;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author ylh
 * @Description
 * @date 2018-11-02 16:50
 */
@Slf4j
public class ProducerCallback implements ListenableFutureCallback<SendResult<String, MessageEntity>> {

    private final long startTime;
    private final String key;
    private final MessageEntity messageEntity;

    private final Gson gson = new Gson();


    public ProducerCallback(long startTime, String key, MessageEntity messageEntity) {
        this.startTime = startTime;
        this.key = key;
        this.messageEntity = messageEntity;
    }

    @Override
    public void onFailure(Throwable throwable) {
        throwable.printStackTrace();

    }

    @Override
    public void onSuccess(SendResult<String, MessageEntity> result) {

        if (result == null) {
            return;
        }

        long elansedTime = System.currentTimeMillis() - startTime;
        RecordMetadata metadata = result.getRecordMetadata();
        if (metadata != null) {
            StringBuilder record = new StringBuilder();
            record.append("message(")
                    .append("key =").append(key).append(",")
                    .append("message = ").append(gson.toJson(messageEntity)).append(")")
                    .append("sent to partition(").append(metadata.partition()).append(")")
                    .append("with offset(").append(metadata.offset()).append(")")
                    .append("in ").append(elansedTime).append("ms");


            System.out.println(record.toString());
        }
    }
}
