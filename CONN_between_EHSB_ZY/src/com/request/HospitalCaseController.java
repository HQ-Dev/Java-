//package com.request;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import javax.annotation.Resource;
//
//import net.sf.json.JSONArray;
//
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.ewell.mq.queue.QueueTools;
//import com.fh.controller.base.BaseController;
//import com.fh.controller.hospital.dao.HospitalCase;
//import com.fh.util.AppUtil;
//import com.fh.util.Const;
//import com.fh.util.Jurisdiction;
//import com.fh.util.PageData;
//import com.ibm.mq.MQException;
//import com.ibm.mq.MQQueueManager;
//
//@Controller
//@RequestMapping(value = "/hospitalcase")
//public class HospitalCaseController extends BaseController {
//
//	@Resource(name = "hospitalcaseimpl")
//	private HospitalCase hospitalcaseimpl;
//
//	/**
//	 * 根据医院流水号BRXH_OLD和病案号BAH获取病案图片路径
//	 *
//	 * @return
//	 */
//	@RequestMapping(value = "/getCasePhotoByNo")
//	@ResponseBody
//	public Object getCasePhotoByNo() {
//		logBefore(logger, "根据医院流水号BRXH_OLD和病案号BAH获取病案图片路径");
//		Map<String, Object> map = new HashMap<String, Object>();
//		PageData pd = new PageData();
//		pd = this.getPageData();
//		String result = "00";
//		String ip = "";
//		try {
//			ip = InetAddress.getLocalHost().getHostAddress();
//		} catch (UnknownHostException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		pd.put("URL", "http://" + ip + ":" + Const.Hospital_Port
//				+ Const.Hospital_Name);
//		try {
//			// if(Tools.checkKey("YCWLKJ", pd.getString("FKEY"))){
//			// //检验请求key值是否合法
//			if (AppUtil.checkParam("getCasePhotoByNo", pd)) { // 检查参数
//				List<PageData> l_pd = hospitalcaseimpl.listAllPotoByNo(pd);
//				map.put("pd", l_pd);
//				result = (null == pd) ? "02" : "01";
//			} else {
//				result = "03";
//			}
//			// }else{
//			// result = "05";
//			// }
//		} catch (Exception e) {
//			logger.error(e.toString(), e);
//		} finally {
//			map.put("result", result);
//			logAfter(logger);
//		}
//		return AppUtil.returnObject(new PageData(), map);
//	}
//
//	/**
//	 * 医院接口
//	 *
//	 * @return
//	 * @throws UnsupportedEncodingException
//	 */
//	@RequestMapping(value = "/putReqAndGetResp", produces = { MediaType.TEXT_PLAIN_VALUE
//			+ ";charset=utf-8" })
//	@ResponseBody
//	public Object putReqAndGetResp() throws UnsupportedEncodingException {
//		logBefore(logger, "医院接口");
//		PageData pd = new PageData();
//		pd = this.getPageData();
//		// Map<String,Object> map = new HashMap<String,Object>();
//		QueueTools qm = new QueueTools();
//		// QueueManage qm =new QueueManage();
//		MQQueueManager qmr = null;
//
//		// 消息Id
//		String msgId = null;
//		// 请求数据
//		String reqMsg = new String(pd.getString("reqmsg")
//				.getBytes("ISO-8859-1"), "utf-8");
//		logger.info("reqMsg:" + reqMsg);
//		// 传输类型
//		String msg_type = new String(pd.getString("msg_type").getBytes(
//				"ISO-8859-1"), "utf-8");
//		logger.info("msg_type:" + msg_type);
//		// 响应数据
//		String respMsg = null;
//		try {
//			// 连接MQ，获取队列管理器实例，该实例如果不调用方法进行断开操作可长期保持连接
//			qmr = qm.connect("QMGR.S46");
//			// qmr = qm.connectionMQ();
//			// 发送请求消息
//			msgId = qm.putMsg(qmr, msg_type, reqMsg);
//			// 获取响应消息
//			respMsg = qm.getMsgById(qmr, msg_type, msgId, 15);
//			logger.info("reqMsg1返回结果:" + respMsg);
//			// 此处为获取响应数据后的业务处理
//
//		} catch (MQException e) {
//			// 2033表示队列中没有消息
//			if (e.reasonCode == 2033) {
//				respMsg = "no message";
//			} else {
//				e.printStackTrace();
//				logger.error(e.toString(), e);
//				respMsg = "connect error";
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			logAfter(logger);
//			// 断开MQ连接
//			if (null != qmr) {
//				try {
//					qmr.disconnect();
//				} catch (MQException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		logger.info("reqMsg返回结果:" + respMsg);
//		return respMsg;
//	}
//
//	/**
//	 * 显示病人全部病案图片
//	 *
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/listAllPhoto")
//	public ModelAndView listAllPhoto(Model model) throws Exception {
//		PageData pd = new PageData();
//		pd = this.getPageData();
//
//		String Brxh = hospitalcaseimpl.findByIBrxhOld(pd);
//
//		ModelAndView mv = this.getModelAndView();
//		try {
//			JSONArray arr = JSONArray.fromObject(hospitalcaseimpl
//					.listAllPhoto(Brxh));
//			String json = arr.toString();
//			if (json.replace("[", "").replace("]", "").equals("")) {
//				mv.setViewName("hospital/medical_records/null");
//			} else {
//				json = json.replaceAll("MENU_ID", "id")
//						.replaceAll("PARENT_ID", "pId")
//						.replaceAll("MENU_NAME", "name")
//						.replaceAll("subMenu", "nodes")
//						.replaceAll("hasMenu", "checked")
//						.replaceAll("MENU_URL", "url");
//
//				model.addAttribute("zTreeNodes", json);
//				mv.addObject("BRXH", Brxh);
//				mv.setViewName("hospital/medical_records/records_photo");
//			}
//		} catch (Exception e) {
//			logger.error(e.toString(), e);
//		}
//		return mv;
//	}
//
//
//	/**
//	 * 显示病人全部病案图片byBaH
//	 *
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/listAllPhotoByBaH")
//	public ModelAndView listAllPhotoByBaH(Model model) throws Exception {
//		PageData pd = new PageData();
//		pd = this.getPageData();
//
//		//String Brxh = hospitalcaseimpl.findByIBrxhOld(pd);
//
//		ModelAndView mv = this.getModelAndView();
//		try {
//			JSONArray arr = JSONArray.fromObject(hospitalcaseimpl
//					.listAllPhotoByBah(pd));
//			String json = arr.toString();
//			if (json.replace("[", "").replace("]", "").equals("")) {
//				mv.setViewName("hospital/medical_records/null");
//			} else {
//				json = json.replaceAll("MENU_ID", "id")
//						.replaceAll("PARENT_ID", "pId")
//						.replaceAll("MENU_NAME", "name")
//						.replaceAll("subMenu", "nodes")
//						.replaceAll("hasMenu", "checked")
//						.replaceAll("MENU_URL", "url");
//				model.addAttribute("zTreeNodes", json);
//				//mv.addObject("BRXH", Brxh);
//				mv.setViewName("hospital/medical_records/records_photo");
//			}
//		} catch (Exception e) {
//			logger.error(e.toString(), e);
//		}
//		return mv;
//	}
//
//	/**
//	 * 查看图片
//	 *
//	 * @param
//	 * @return
//	 */
//	@RequestMapping(value = "/toPhoto")
//	public ModelAndView toPhoto(String id) throws Exception {
//		ModelAndView mv = this.getModelAndView();
//		PageData pd = new PageData();
//		try {
//			pd = this.getPageData();
//
//			pd = hospitalcaseimpl.findById(id); // 读取此ID的菜单数据
//			mv.addObject("pd", pd); // 放入视图容器
//			// pd.put("MENU_ID",pd.get("PARENT_ID").toString()); //用作读取父菜单信息
//			// mv.addObject("MENU_ID", pd.get("PARENT_ID").toString());
//			// //传入父菜单ID，作为子菜单的父菜单ID用
//			// mv.addObject("MSG", "edit");
//			// pd.put("MENU_ID",id); //复原本菜单ID
//			// mv.addObject("QX",Jurisdiction.getHC()); //按钮权限
//			mv.setViewName("hospital/medical_records/photo_view");
//		} catch (Exception e) {
//			logger.error(e.toString(), e);
//		}
//		return mv;
//	}
//
//}
