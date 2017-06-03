package com.connect;

import com.ewell.mq.queue.MessageEntity;
import com.ewell.mq.queue.QueueTools;
import com.ewell.mq.queue.async.EwellMQMutiImpl;
import com.ewell.mq.queue.async.QueueCallback;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueueManager;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author Archy
 **/
public class ReceivePushMsg {
    /**
     * 根据服务 ID 将消息发送到相应队列，并返回消息 ID
     *
     * @param qmr 队列管理器实例
     * @param fid 服务 ID
     * @param msg 消息内容，不能为 null
     * @return 消息 Id （为什么返回的是消息 ID ？应该是这样得到一个消息 ID ，从而从服务方得到数据，通过消息 ID 进行制定获取，然后解析）
     * @throws MQException
     * @throws IOException
     */
    public String putMessage(MQQueueManager qmr, String fid, String msg) throws MQException, IOException {
        return null;
    }
    /**
     * 根据服务 ID 将消息发送到相应队列，并返回消息 ID
     *
     * @param qmr 队列管理器实例
     * @param fid 服务 ID
     * @param sign 队列序号（当需要为一个服务设置 3 个及以上队列时设置）
     * @param msg 消息内容，不能为 null
     * @return
     * @throws MQException
     * @throws IOException
     */
    public String putMessage(MQQueueManager qmr, String fid, String sign, String msg) throws MQException, IOException  {

        return "";
    }



    /*******************************************************************************************************
     * *********************************** 单向放送场景下的 服务消费方 *********************************** *
     *******************************************************************************************************/
    private static Logger logger = LoggerFactory.getLogger(ReceivePushMsg.class);
    // 推送数据实时监控与解析
    public static void mutiRecieveMessage() {
        // 异步消息获取对象创建
        QueueTools queueTools = new QueueTools();
        EwellMQMutiImpl multiImpl = queueTools.getMutiMQImpl();

        // 设置操作对象。第一个参数为配置文件中队列管理器配置标签名； 第二个参数为配置文件中取消息对应的标签名。
        multiImpl.init("QMGR.S09","COLLECT");
        try {
            multiImpl.run(new QueueCallback() {
                @Override
                public void onMessage(MessageEntity messageEntity) throws Exception {
                    // 这里加入了 dom4j 与 jaxen 进行消息处理的范例代码，仅供参考
                    SAXReader saxReader = new SAXReader();
                    byte[] bytes = messageEntity.getMsg().getBytes("utf-8");
                    Document document = saxReader.read(new ByteArrayInputStream(bytes));
                    Element element = (Element) document.selectSingleNode("/ESBEntry/MsgInfo/Msg");
                    String action = element.attributeValue("action");
                    String OUTHOSP_NO = element.elementText("OUTHOSP_NO");
                }

                @Override
                public void onException(Exception e) {
                    e.printStackTrace();
                    logger.debug("");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
