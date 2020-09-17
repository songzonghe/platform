package com.controllerAdmin.util.carousel;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.carousel.UtilCarouselService;
import com.util.UtilJson;
import com.util.UtilValiDate;
/**
 * 轮播图 controller 实现类 
 * 操作人： 张龙
 */ 
@Controller
public class UtilCarouselController  extends ControllerUtil {

	@Resource
	private UtilCarouselService  utilCarouselServiceImp;

	/************************系统生成方法开始******************************/

	/**
	 *分页获取轮播图信息
	 */
	@RequestMapping(value ="/utilCarousel_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.tBodyUtil(utilCarouselServiceImp.tBody(mapStr),mapStr,"form/util/carousel/utilCarousel_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开添加轮播图页面
	 */
	@RequestMapping(value ="/utilCarousel_addPage.do")
	public String addPage(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			return this.returnPage("form/util/carousel/utilCarousel_addPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行轮播图修改和新增操作
	 */
	@RequestMapping(value ="/utilCarousel_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("carousel_id"))) {
				utilCarouselServiceImp.update_Data(mapStr);
				this.respBack(mapStr, resp);
			} else { 
				utilCarouselServiceImp.add_Data(mapStr);
				this.respBack(mapStr, resp);
			} 	
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 * 编辑器查看、编辑
	 */
	@RequestMapping(value ="/utilCarousel_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if(UtilValiDate.isEmpty(mapStr.get("carousel_id"))){
				return this.findByIdUtil(utilCarouselServiceImp.find_Map(mapStr),"form/util/carousel/utilCarousel_lookPage.jsp", req, resp);
			}
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *打开修改轮播图页面
	 */
	@RequestMapping(value ="/utilCarousel_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			req.setAttribute("map", mapStr);
			mapStr.put("carousel_id",req.getParameter("carousel_id"));
			if(UtilValiDate.isEmpty(mapStr.get("carousel_id"))){
				return this.editPageUtil(utilCarouselServiceImp.find_Map(mapStr),"form/util/carousel/utilCarousel_editPage.jsp",req,resp);
			}
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行删除轮播图信息操作
	 */
	@RequestMapping(value ="/utilCarousel_deleteData.do")
	public void deleteData(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			utilCarouselServiceImp.delete_Data(mapStr);
			this.respBack(UtilJson.mapToJson(mapStr),resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		
	}
	/************************系统生成方法完毕******************************/
}

