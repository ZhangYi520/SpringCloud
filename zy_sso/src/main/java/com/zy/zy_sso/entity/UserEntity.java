package com.zy.zy_sso.entity;


import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
/**swagger提示*/
@ApiModel
@Com
public class UserEntity implements Serializable{/**
	 *
	 */
//	private static final long serialVersionUID = -1145199645904399906L;
	@ApiModelProperty(name = "id", value = "主键", required = false, dataType = "Integer")
	/**主键*/
	private Integer id;

	/**密码*/
	private String password;

	/**用户名*/
	private String userName;

	/**头像地址*/
	private String headImg = "";

	/**头像地址*/
	private String ct = "";

	/**token*/
	private String token;

	/**审核状态1*/
	private String checked;

	/**角色集合*/
	private List<RoleEntity> role;
	
}
