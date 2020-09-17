package com.servicesAdmin.util.hospital.equipment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.interfaceDAO.GYDAO;
import com.util.SysFinal;
import com.util.UtilSql;
import com.util.UtilValiDate;
/**
 * 系统医院设备 service 实现类
 * 操作人： 曾晓
 */ 
@Service("utilHospitalEquipmentServiceImp")
public class UtilHospitalEquipmentServiceImp implements UtilHospitalEquipmentService {
	@Resource
	private GYDAO gyDAOimp;// dao操作类

	/************************系统生成方法开始******************************/

	/**
	 *获取系统医院设备查询sql
	 */
	private void getSQL(Map<String, String> mapStr,StringBuffer sql,Map<String, Object> mapSQLParameter) throws Exception {
		sql.append("select t.equipment_id,t.equipment_sbdh,t.equipment_sbmc,t.equipment_tpsbts,t.equipment_cd,t.equipment_sccj,t.equipment_sbxh,t.equipment_sbcs,t.equipment_sblx,t.equipment_gmrq,t.equipment_yt,t.equipment_sbjzje,t.equipment_gjsxqk,t.equipment_llsjsm,t.equipment_syqk,t.hospital_id,t.gxsj,t.bz,t.lrsj,t.zt,t.lrzh");
		sql.append(",equipment_cxbz,equipment_jgdm from util_hospital_equipment t where t.hospital_id=hospital_id");
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		if (UtilValiDate.isEmpty(mapStr.get("equipment_id"))) {
			sql.append(" and t.equipment_id=:equipment_id ");
		}else {
			if (UtilValiDate.isEmpty(mapStr.get("equipment_sbdh"))) {
				sql.append(" and t.equipment_sbdh like :equipment_sbdh");
				mapSQLParameter.put("equipment_sbdh", "%" + mapStr.get("equipment_sbdh") + "%");
			}
			if (UtilValiDate.isEmpty(mapStr.get("equipment_sbmc"))) {
				sql.append(" and t.equipment_sbmc like :equipment_sbmc");
				mapSQLParameter.put("equipment_sbmc", "%" + mapStr.get("equipment_sbmc") + "%");
			}
		}
	}

	/**
	 *获取系统医院设备信息列表
	 */
	public List<Map<String, Object>> tBody(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		if (!UtilValiDate.isEmpty(mapStr.get(SysFinal.ISSORT_KEY))){ //由于从菜单进入没有带入参数，这里给入判断进行开启排序
			mapStr.put(SysFinal.ISSORT_KEY,"y");
		}
		List<Map<String, Object>> list_Map = this.gyDAOimp.findSqlPageList(sql, mapSQLParameter,mapStr);
		list_Map.add(this.gyDAOimp.findSqlCount(sql, mapSQLParameter));
		return list_Map;
	}

	/**
	 *获取一条系统医院设备信息
	 */
	public Map<String, Object> find_Map(Map<String, String> mapStr)throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		this.getSQL(mapStr, sql, mapSQLParameter);
		return this.gyDAOimp.findSqlMap(sql, mapSQLParameter);
	}

	/**
	 *新增操作
	 */
	public Map<String, Object> add_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("insert into util_hospital_equipment");
		sql.append("( equipment_cxbz,equipment_jgdm,equipment_sbdh,equipment_sbmc,equipment_tpsbts,equipment_cd,equipment_sccj,equipment_sbxh,equipment_sbcs,equipment_sblx,equipment_gmrq,equipment_yt,equipment_sbjzje,equipment_gjsxqk,equipment_llsjsm,equipment_syqk,hospital_id");
		sql.append(UtilSql.getFieldInsertKey());
		sql.append("values( :equipment_cxbz,:equipment_jgdm,:equipment_sbdh,:equipment_sbmc,:equipment_tpsbts,:equipment_cd,:equipment_sccj,:equipment_sbxh,:equipment_sbcs,:equipment_sblx,:equipment_gmrq,:equipment_yt,:equipment_sbjzje,:equipment_gjsxqk,:equipment_llsjsm,:equipment_syqk,:hospital_id");
		sql.append(UtilSql.getFieldInsertVal());
		mapSQLParameter.put("equipment_cxbz", mapStr.get("equipment_cxbz"));
		mapSQLParameter.put("equipment_jgdm", mapStr.get("equipment_jgdm"));
		mapSQLParameter.put("equipment_sbdh", mapStr.get("equipment_sbdh"));
		mapSQLParameter.put("equipment_sbmc", mapStr.get("equipment_sbmc"));
		mapSQLParameter.put("equipment_tpsbts", mapStr.get("equipment_tpsbts"));
		mapSQLParameter.put("equipment_cd", mapStr.get("equipment_cd"));
		mapSQLParameter.put("equipment_sccj", mapStr.get("equipment_sccj"));
		mapSQLParameter.put("equipment_sbxh", mapStr.get("equipment_sbxh"));
		mapSQLParameter.put("equipment_sbcs", mapStr.get("equipment_sbcs"));
		mapSQLParameter.put("equipment_sblx", mapStr.get("equipment_sblx"));
		mapSQLParameter.put("equipment_gmrq", mapStr.get("equipment_gmrq"));
		mapSQLParameter.put("equipment_yt", mapStr.get("equipment_yt"));
		mapSQLParameter.put("equipment_sbjzje", mapStr.get("equipment_sbjzje"));
		mapSQLParameter.put("equipment_gjsxqk", mapStr.get("equipment_gjsxqk"));
		mapSQLParameter.put("equipment_llsjsm", mapStr.get("equipment_llsjsm"));
		mapSQLParameter.put("equipment_syqk", mapStr.get("equipment_syqk"));
		mapSQLParameter.put("hospital_id", mapStr.get("login_hospital_id"));
		UtilSql.setMapVal(mapSQLParameter, mapStr);
		mapStr.put("equipment_id", this.gyDAOimp.exeSqlGetId(sql, mapSQLParameter));
		return this.find_Map(mapStr);
	}

	/**
	 *修改系统医院设备操作
	 */
	public Map<String, Object> update_Data(Map<String, String> mapStr) throws Exception{
		mapStr.put("gxsj", UtilSql.getGXSJ());
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("update util_hospital_equipment set gxsj=:gxsj");
		if(null!=mapStr.get("equipment_sbdh")){
			sql.append(",equipment_sbdh=:equipment_sbdh");
			mapSQLParameter.put("equipment_sbdh", mapStr.get("equipment_sbdh"));
		}
		if(null!=mapStr.get("equipment_jgdm")){
			sql.append(",equipment_jgdm=:equipment_jgdm");
			mapSQLParameter.put("equipment_jgdm", mapStr.get("equipment_jgdm"));
		}
		if(null!=mapStr.get("equipment_cxbz")){
			sql.append(",equipment_cxbz=:equipment_cxbz");
			mapSQLParameter.put("equipment_cxbz", mapStr.get("equipment_cxbz"));
		}
		if(null!=mapStr.get("equipment_sbmc")){
			sql.append(",equipment_sbmc=:equipment_sbmc");
			mapSQLParameter.put("equipment_sbmc", mapStr.get("equipment_sbmc"));
		}
		if(null!=mapStr.get("equipment_tpsbts")){
			sql.append(",equipment_tpsbts=:equipment_tpsbts");
			mapSQLParameter.put("equipment_tpsbts", mapStr.get("equipment_tpsbts"));
		}
		if(null!=mapStr.get("equipment_cd")){
			sql.append(",equipment_cd=:equipment_cd");
			mapSQLParameter.put("equipment_cd", mapStr.get("equipment_cd"));
		}
		if(null!=mapStr.get("equipment_sccj")){
			sql.append(",equipment_sccj=:equipment_sccj");
			mapSQLParameter.put("equipment_sccj", mapStr.get("equipment_sccj"));
		}
		if(null!=mapStr.get("equipment_sbxh")){
			sql.append(",equipment_sbxh=:equipment_sbxh");
			mapSQLParameter.put("equipment_sbxh", mapStr.get("equipment_sbxh"));
		}
		if(null!=mapStr.get("equipment_sbcs")){
			sql.append(",equipment_sbcs=:equipment_sbcs");
			mapSQLParameter.put("equipment_sbcs", mapStr.get("equipment_sbcs"));
		}
		if(null!=mapStr.get("equipment_sblx")){
			sql.append(",equipment_sblx=:equipment_sblx");
			mapSQLParameter.put("equipment_sblx", mapStr.get("equipment_sblx"));
		}
		if(null!=mapStr.get("equipment_gmrq")){
			sql.append(",equipment_gmrq=:equipment_gmrq");
			mapSQLParameter.put("equipment_gmrq", mapStr.get("equipment_gmrq"));
		}
		if(null!=mapStr.get("equipment_yt")){
			sql.append(",equipment_yt=:equipment_yt");
			mapSQLParameter.put("equipment_yt", mapStr.get("equipment_yt"));
		}
		if(null!=mapStr.get("equipment_sbjzje")){
			sql.append(",equipment_sbjzje=:equipment_sbjzje");
			mapSQLParameter.put("equipment_sbjzje", mapStr.get("equipment_sbjzje"));
		}
		if(null!=mapStr.get("equipment_gjsxqk")){
			sql.append(",equipment_gjsxqk=:equipment_gjsxqk");
			mapSQLParameter.put("equipment_gjsxqk", mapStr.get("equipment_gjsxqk"));
		}
		if(null!=mapStr.get("equipment_llsjsm")){
			sql.append(",equipment_llsjsm=:equipment_llsjsm");
			mapSQLParameter.put("equipment_llsjsm", mapStr.get("equipment_llsjsm"));
		}
		if(null!=mapStr.get("equipment_syqk")){
			sql.append(",equipment_syqk=:equipment_syqk");
			mapSQLParameter.put("equipment_syqk", mapStr.get("equipment_syqk"));
		}
		if(null!=mapStr.get("bz")){
			sql.append(",bz=:bz");
			mapSQLParameter.put("bz", mapStr.get("bz"));
		}
		if(null!=mapStr.get("edit_zt")){
			sql.append(",zt=:edit_zt");
			mapSQLParameter.put("edit_zt", mapStr.get("edit_zt"));
		}
		sql.append(" where equipment_id=:equipment_id");
		mapSQLParameter.put("equipment_id", mapStr.get("equipment_id"));
		mapSQLParameter.put("gxsj", mapStr.get("gxsj"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		return this.find_Map(mapStr);
	}

	/**
	 *删除系统医院设备操作
	 */
	public void delete_Data(Map<String, String> mapStr) throws Exception{
		StringBuffer sql = new StringBuffer(); Map<String, Object> mapSQLParameter = new HashMap<String, Object>();
		sql.append("delete from util_hospital_equipment where equipment_id=:equipment_id");
		mapSQLParameter.put("equipment_id", mapStr.get("id"));
		this.gyDAOimp.exeSqlBool(sql, mapSQLParameter);
		
	}

	/************************系统生成方法完毕******************************/
}