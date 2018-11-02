/**
 * @Title
 * @Project kafka-demo
 * @Package com.yuluhuang.kafka.demo.common
 * @Description
 * @author ylh
 * @date 2018-11-02 16:34
 * @version
 */
package com.yuluhuang.kafka.demo.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ylh
 * @Description
 * @date 2018-11-02 16:34
 */
@Getter
@Setter
public class Response {

    private int code;
    private String message;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
