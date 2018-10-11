package com.gkhn.wms.util;

 

import java.io.Serializable;
import java.util.List;

/**
 * EasyUIDataGrid控件实体�?
 * @author huangwei
 * @datatime2017�?9�?28日上�?10:27:01
 */
public class EasyUIDataGridResult implements Serializable {
	private long total;
	private List rows;
	private int zh;
	
	
	public int getZh() {
		return zh;
	}
	public void setZh(int zh) {
		this.zh = zh;
	}
	/**
	 * 获取EasyUIDataGrid返回总数
	 * @return
	 * @author  huangwei
	 * @company hcyy
	 * @datatime 2017�?9�?28日上�?10:27:24
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * 设置EasyUIDataGrid总数
	 * @param total
	 * @author  huangwei
	 * @company hcyy
	 * @datatime 2017�?9�?28日上�?10:27:40
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	/**
	 * 获取列表数量
	 * @return 数据集合
	 * @author  huangwei
	 * @company hcyy
	 * @datatime 2017�?9�?28日上�?10:27:52
	 */
	public List getRows() {
		return rows;
	}
	/**
	 * 设置列表数量list集合
	 * @param rows 数据集合
	 * @author  huangwei
	 * @company hcyy
	 * @datatime 2017�?9�?28日上�?10:28:07
	 */
	public void setRows(List rows) {
		this.rows = rows;
	}

}