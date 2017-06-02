package com.xml.消息解析;

/**
 * Created by Administrator on 2017/5/24 0024.
 */
public class MyConstants {

     static String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
            "<POOR_IN200901UV ITSVersion=\"XML_1.0\" xmlns=\"urn:hl7-org:v3\"\n" +
            "                 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "                 xsi:schemaLocation=\"urn:hl7-org:v3 POOR_IN200901UV.xsd\"\n" +
            "                 xmlns:namexsi=\"http://java.sun.com/xml/ns/j2ee\">\n" +
            "    <!-- 消息ID -->\n" +
            "    <id root=\"\"/>\n" +
            "    <!-- 消息创建时间 -->\n" +
            "    <creationTime value=\"20120106110000\"/>\n" +
            "    <!-- 消息发送系统的状态: P(Production); D(Debugging); T(Training) -->\n" +
            "    <processingCode code=\"P\"/>\n" +
            "    <!-- 消息处理模式: A(Archive); I(Initial load); R(Restore from archive); T(Current\n" +
            "        processing) -->\n" +
            "    <processingModeCode code=\"R\"/>\n" +
            "    <!-- 消息应答: AL(Always); ER(Error/reject only); NE(Never) -->\n" +
            "    <acceptAckCode code=\"AL\" value=\"dsdsdsdasdsd\" fds=\"ds\"/>\n" +
            "    <!-- 接受者 -->\n" +
            "    <receiver typeCode=\"RCV\">\n" +
            "        <device classCode=\"DEV\" determinerCode=\"INSTANCE\">\n" +
            "            <!-- 接受者ID -->\n" +
            "            <id/>\n" +
            "        </device>\n" +
            "    </receiver>\n" +
            "    <!-- 发送者 -->\n" +
            "    <sender typeCode=\"SND\">\n" +
            "        <device classCode=\"DEV\" determinerCode=\"INSTANCE\">\n" +
            "            <!-- 发送者ID -->\n" +
            "            <id/>\n" +
            "        </device>\n" +
            "    </sender>\n" +
            "    <!-- 封装的消息内容(按Excel填写) -->\n" +
            "    <controlActProcess classCode=\"CACT\" moodCode=\"EVN\">\n" +
            "        <subject typeCode=\"SUBJ\">\n" +
            "            <observationRequest classCode=\"OBS\" moodCode=\"RQO\">\n" +
            "                <subject typeCode=\"SBJ\">\n" +
            "                    <patient classCode=\"PAT\">\n" +
            "                        <!--个人信息 -->\n" +
            "                        <patientPerson classCode=\"PSN\">\n" +
            "                            <!--患者姓名 -->\n" +
            "                            <name xsi:type=\"BAG_EN\">\n" +
            "                                <item>\n" +
            "                                    <part value=\"张三\"/>\n" +
            "                                </item>\n" +
            "                            </name>\n" +
            "                        </patientPerson>\n" +
            "                    </patient>\n" +
            "                </subject>\n" +
            "            </observationRequest>\n" +
            "        </subject>\n" +
            "    </controlActProcess>\n" +
            "</POOR_IN200901UV>";

}
