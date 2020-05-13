package com.zy.common_thirdparty.base;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: SpringCloud
 * @description: 项目版本信息
 * @author: zhang yi
 * @create: 2020-05-13 16:04
 */
@Component
@ConfigurationProperties(prefix = "myblog")
@Data
public class ProjectVersion {

    private String name;

    private String version;

}
