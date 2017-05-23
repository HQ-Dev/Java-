package com.request;

import com.ibm.mq.MQException;
import com.ibm.mq.MQQueueManager;

/**
 * @author Archy
 **/
public class ConnectToMQ {

    /**
     * 获取连接 MQ 的队列管理器实例
     *
     * @param gateKeeper 连接对象在配置文件中的节点名
     * @return MQQueueManager 队列管理器实例
     * @throws MQException
     */
    public MQQueueManager connect(String gateKeeper) throws MQException {
        return null;
    }

    /**
     * 断开 MQ 连接
     *
     * @param qmr
     * @throws MQException
     */
    public void disconnectMQ(MQQueueManager qmr) throws MQException {
        // 断开连接
    }



}
