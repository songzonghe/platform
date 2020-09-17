package com.controllerAdmin.util.init.data;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controllerAdmin.ControllerUtil;
import com.servicesAdmin.util.init.data.UtilInitDataService;
import com.util.UtilValiDate;
/**
 * 基本数据 controller 实现类 
 * 操作人： 刘杰
 */ 
@Controller
public class UtilInitDataController  extends ControllerUtil {

	@Resource
	private UtilInitDataService  utilInitDataServiceImp;

	/**
	 *分页获取基本数据信息
	 */
	@RequestMapping(value ="/utilInitData_index.do")
	public String index(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if(!UtilValiDate.isEmpty(mapStr.get("init_type"))){
				if(UtilValiDate.isEmpty(req.getParameter("type"))){
					mapStr.put("init_type",req.getParameter("type"));
				}else{
					mapStr.put("init_type","1");
				}
			}
			return this.tBodyUtil(utilInitDataServiceImp.tBody(mapStr),mapStr,"form/util/init/data/utilInitData_index.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}

	/**
	 *进行基本数据修改和新增操作
	 */
	@RequestMapping(value ="/utilInitData_updateData.do")
	public String updateData(HttpServletRequest req,HttpServletResponse resp) {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			if (UtilValiDate.isEmpty(mapStr.get("init_id"))) {
				Map<String, Object> mapObj = utilInitDataServiceImp.update_Data(mapStr);
				return this.updateDataUpdate(mapObj,"form/util/init/data/utilInitData_tr.jsp",req,resp);
			}
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	/**
	 *打开修改基本数据页面
	 */
	@RequestMapping(value ="/utilInitData_editPage.do")
	public String editPage(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			return this.editPageUtil(utilInitDataServiceImp.find_Map(mapStr),"form/util/init/data/utilInitData_editPage.jsp",req,resp);
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
	
	/**
	 * 编辑器查看、编辑
	 */
	@RequestMapping(value ="/utilInitData_findById.do")
	public String findById(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		try {
			Map<String,String> mapStr = this.getMapStr(req);
			String type=req.getParameter("type");
			String init_id=req.getParameter("init_id");
			if(UtilValiDate.isEmpty(init_id)&&UtilValiDate.isEmpty(type)){
				String backUrl="form/util/init/data/text/init_dataLookText.jsp";
				if(type.equals("2")){
					backUrl="form/util/init/data/text/init_dataEditText.jsp";
				}
				mapStr.put("init_id",init_id);
				return this.findByIdUtil(utilInitDataServiceImp.find_Map(mapStr),backUrl, req, resp);
			}
		} catch (Exception e) {
			this.errorResp(e,resp);
		}
		return this.returnError();
	}
}

