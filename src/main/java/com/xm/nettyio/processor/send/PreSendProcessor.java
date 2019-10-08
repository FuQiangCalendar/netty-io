package com.xm.nettyio.processor.send;


import com.xm.nettyio.bean.MessageBean;

@FunctionalInterface
public interface PreSendProcessor {

    void preSend(MessageBean message);

}
