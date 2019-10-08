package com.xm.nettyio.processor.receive;

import com.xm.nettyio.bean.MessageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName DefaultReceiveProcessor
 * @Description
 * @Author Wangjunkai
 * @Date 2019/9/3 10:19
 **/
@Slf4j
@Component("defaultType")
public class DefaultReceiveProcessor implements PostReceiveProcessor {

    @Override
    public void onMessage(MessageBean message) {
        log.info("收到用户{}信息:{}", message.getSendUser(), message.getMessage());
    }
}