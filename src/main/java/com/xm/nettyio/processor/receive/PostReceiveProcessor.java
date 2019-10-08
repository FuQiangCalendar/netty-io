package com.xm.nettyio.processor.receive;


import com.xm.nettyio.bean.MessageBean;

@FunctionalInterface
public interface PostReceiveProcessor {

    void onMessage(MessageBean message);

}
