package com.zy.zy_filesystem.pojo;

import java.util.List;
import java.util.Set;

/**  
*   
* 项目名称：bookSystem  
* 类名称：Role  
* 类描述：  权限描述实体类
* 创建人：zhangyi  
* 创建时间：2019年2月17日 下午3:08:05  
* 修改人：zhangyi  
* 修改时间：2019年2月17日 下午3:08:05  
* 修改备注：  
* @version   
*   
*/
public class Role {
	
	private Integer roleId;//主键
	private String roleName;//角色名称
	private Set<Action> action;//该角色拥有的操作权限集合
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public Set<Action> getAction() {
		return action;
	}
	public void setAction(Set<Action> action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", action=" + action + "]";
	}
	
	
}
