package com.connect;

import com.ewell.mq.queue.QueueTools;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueueManager;
import com.parse.ParseUtil;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/24 0024.
 */
public class ConnectToEWell {

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
            respMsg = queueTool.getMsgById(queueManager, "BS10001_0", msgId, 15);

            // 此处为获取响应数据后的业务处理
            File xmlFile = new File("D:\\my_projects\\Java-\\CONN_between_EHSB_ZY\\src\\com\\xml\\exampleToParse.xml");
            ParseUtil.parseXMLFile("s:subject/s:observationRequest/s:subject/s:patient/s:patientPerson/s:name/s:item/s:part/@value", xmlFile);

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
}
