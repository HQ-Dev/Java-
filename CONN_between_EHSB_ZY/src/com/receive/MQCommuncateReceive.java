package com.receive;

import com.ewell.mq.queue.MessageEntity;
import com.ewell.mq.queue.QueueTools;
import com.ewell.mq.queue.async.config.ConfigUtil;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueueManager;

import java.io.IOException;

/**
 * @author Archy
 **/
public class MQCommuncateReceive {

    /**
     * 根据服务 Id 从对应的队列中获取消息，方法提供超时等待设置，单位：秒
     *
     * @param qmr 队列管理器实例
     * @param fid 服务 Id
     * @param waitInterval 超时等待时间
     * @return MessageEntiry 消息实例
     * @throws MQException
     * @throws IOException
     */
    public MessageEntity getMsg(MQQueueManager qmr, String fid, int waitInterval) throws MQException, IOException {
        return null;
    }

    /**
     * 根据服务 Id 从对应的队列中获取消息，方法提供超时等待设置，单位：秒
     *
     * @param qmr 队列管理器实例
     * @param fid 服务 Id
     * @param sign 队列序号
     * @param waitInterval 超时等待时间
     * @return MessageEntiry 消息实例
     * @throws MQException
     * @throws IOException
     */
    public MessageEntity getMsg(MQQueueManager qmr, String fid, String sign, int waitInterval) throws MQException, IOException {
        return null;
    }


}


