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


    /*******************************************************************************************************
     * ***********************************  服务消费方请求响应场景 *************************************** *
     *******************************************************************************************************/
    // 发送请求并获取响应消息
    public static void putReqAndGetResp() {
        QueueTools queueTool = new QueueTools();
        MQQueueManager queueManager = null;
        String msgId = null;
        // 请求的数据
        String reqMsg = "reqMsg";
        // 响应的数据
        String respMsg = null;

        try {
            // 连接 MQ，获取队列管理器实例，该实例如不调用断开方法将长期保持连接。连接函数会自动读取配置文件标签名为 “QMGR.S09”下的配置信息进行连接
            queueManager = queueTool.connect("QMGR.S09");
            // 发送请求消息
            msgId = queueTool.putMsg(queueManager,"BS10001_0", reqMsg);
            // 获取响应消息
            respMsg = queueTool.getMsgById(queueManager, "BS10001_0", msgId, 10);

            // 此处为获取响应数据后的业务处理

        } catch(MQException e) {
            // 2033 表示队列中没有消息
            if (e.reasonCode == 2033) {

            } else {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 断开 MQ 连接
            if (queueManager != null) {
                try {
                    queueManager.disconnect();
                } catch (MQException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MQCommuncateReceive receive = new MQCommuncateReceive();
        MQCommuncateReceive.putReqAndGetResp();
    }


}


