package com.zz.csms.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author zz
 * @date 2020/3/28 23:04
 */
public class CsmsResponse<T> implements Serializable {
    /** 成功的返回码 **/

    @JSONField(serialize = false, deserialize = false)
    public final static int SUCCESS = 200;

    private int code;

    private String subCode;

    private String msg = "";

    private String developerInfo;

    private CsmsResult<T> result;

    /**
     * 返回成功,根据subCode填充提示信息
     *
     * @param subCode：错误码
     * @return 返回结果
     */
    public static <T> CsmsResponse<T> sendSuccess(String subCode) {
        CsmsResponse<T> result = new CsmsResponse<>();
        result.setCode(200);
        result.setSubCode(subCode);
        result.setResult(new CsmsResult<>());
        return result;
    }

    /**
     * 返回成功，自定义提示信息
     *
     * @param subCode：错误码
     * @return 返回结果
     */
    public static <T> CsmsResponse<T> sendSuccess(String subCode, String message) {
        CsmsResponse<T> result = new CsmsResponse<>();
        result.setCode(200);
        result.setSubCode(subCode);
        result.setMsg(message);
        result.setResult(new CsmsResult<>());
        return result;
    }

    /**
     * 发送成功消息,根据subCode填充提示信息（带数据）
     *
     * @param data:业务数据
     * @return 返回结果
     */
    public static <T> CsmsResponse<T> sendSuccessData(String subCode, CsmsResult<T> data) {
        CsmsResponse<T> result = new CsmsResponse<>();
        result.setCode(200);
        result.setSubCode(subCode);
        result.setResult(data);
        return result;
    }

    /**
     * 发送成功消息,自定义填充提示信息（带数据）
     *
     * @param data：业务数据
     * @return 返回结果
     */
    public static <T> CsmsResponse<T> sendSuccessData(String subCode, String message, CsmsResult<T> data) {
        CsmsResponse<T> result = new CsmsResponse<>();
        result.setCode(200);
        result.setSubCode(subCode);
        result.setMsg(message);
        result.setResult(data);
        return result;
    }

    /**
     * 发送错误消息,根据subCode填充提示信息
     *
     * @param code：200成功
     *            xxx失败
     * @param subCode：错误编码
     * @return 返回结果
     */
    public static <T> CsmsResponse<T> sendFailure(int code, String subCode) {
        CsmsResponse<T> result = new CsmsResponse<>();
        result.setCode(code);
        result.setSubCode(subCode);
        result.setResult(new CsmsResult<>());
        return result;
    }

    /**
     * 发送错误消息,自定义填充提示信息
     *
     * @param code：200成功
     *            xxx失败
     * @param subCode：错误编码
     * @param error：错误信息
     * @return
     */
    public static <T> CsmsResponse<T> sendFailure(int code, String subCode, String error) {
        CsmsResponse<T> result = new CsmsResponse<>();
        result.setCode(code);
        result.setSubCode(subCode);
        result.setMsg(error);
        result.setResult(new CsmsResult<>());
        return result;
    }





    /**
     * 是否调用成功
     *
     * @return
     */
    @JSONField(serialize = false, deserialize = false)
    public boolean isSuccess() {
        return SUCCESS == this.code ? true : false;
    }

    /**
     * 打印返回结果
     */
    public void print() {
        System.out.println(JSON.toJSONString(this));
    }

    /**
     * 返回数据
     *
     * @return
     */
    @JSONField(serialize = false, deserialize = false)
    public T getData() {

        if (null != this.result) {
            return result.getData();
        }

        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public CsmsResult<T> getResult() {
        return result;
    }

    public void setResult(CsmsResult<T> result) {
        this.result = result;
    }

    /**
     * @return the developerInfo
     */
    public String getDeveloperInfo() {
        return developerInfo;
    }

    /**
     * @param developerInfo
     *            要设置的 developerInfo
     */
    public void setDeveloperInfo(String developerInfo) {
        this.developerInfo = developerInfo;
    }
}
