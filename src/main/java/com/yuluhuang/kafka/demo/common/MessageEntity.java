/**
 * @Title
 * @Project kafka-demo
 * @Package com.yuluhuang.kafka.demo.common
 * @Description
 * @author ylh
 * @date 2018-11-02 16:29
 * @version
 */
package com.yuluhuang.kafka.demo.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ylh
 * @Description
 * @date 2018-11-02 16:29
 */
@Getter
@Setter
@EqualsAndHashCode
public class MessageEntity {
    private String title;
    private String body;

    @Override
    public String toString() {
        return "MessageEntity{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
