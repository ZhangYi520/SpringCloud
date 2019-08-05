package com.zy.zy_filesystem.pojo;
/**  
*   
* 项目名称：bookSystem  
* 类名称：action  
* 类描述：  功能
* 创建人：zhangyi  
* 创建时间：2019年2月17日 下午3:10:15  
* 修改人：zhangyi  
* 修改时间：2019年2月17日 下午3:10:15  
* 修改备注：  
* @version   
*   
*/
public class Action {

	private Integer actionId;//主键
	private String actionName;//功能名称
	private String actionDesc;//功能描述（路径）
	public Integer getActionId() {
		return actionId;
	}
	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getActionDesc() {
		return actionDesc;
	}
	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}
	@Override
	public String toString() {
		return "action [actionId=" + actionId + ", actionName=" + actionName + ", actionDesc=" + actionDesc + "]";
	}
	
}
