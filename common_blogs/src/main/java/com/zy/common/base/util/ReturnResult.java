package com.zy.common.base.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class ReturnResult implements Serializable {

    private static final long serialVersionUID = 579490911008573336L;

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状�??
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    private Boolean success;

    public static ReturnResult build(Integer code, String msg, Object data) {
        return new ReturnResult(code, msg, data);
    }

    public static ReturnResult ok(Object data) {
        return new ReturnResult(data);
    }

    public static ReturnResult error(Object data) {
        return new ReturnResult(500, "error", data);
    }

    public static ReturnResult error(String msg) {
        return new ReturnResult(500, msg, null);
    }

    public static ReturnResult expired() {
        return new ReturnResult(401, "登录信息已过期", null);
    }

    public static ReturnResult ok() {
        return new ReturnResult(null);
    }

    public ReturnResult() {

    }

    public static ReturnResult build(Integer code, String msg) {
        return new ReturnResult(code, msg, null);
    }

    public ReturnResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success=false;
    }

    public ReturnResult(Object data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
        this.success=true;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为ReturnResult对象
     *
     * @param jsonData json数据
     * @param clazz    ReturnResult中的object类型
     * @return
     */
    public static ReturnResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, ReturnResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转�?
     *
     * @param json
     * @return
     */
    public static ReturnResult format(String json) {
        try {
            return MAPPER.readValue(json, ReturnResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转�?
     *
     * @param jsonData json数据
     * @param clazz    集合中的类型
     * @return
     */
    public static ReturnResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

}
