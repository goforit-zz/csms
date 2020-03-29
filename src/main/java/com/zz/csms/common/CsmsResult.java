package com.zz.csms.common;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;

/**
 * @author zz
 * @date 2020/3/28 23:24
 */
public class CsmsResult<T> implements Serializable {
    /** 业务数据封装 **/
    private T data;

    /** 分页信息 **/
    private PageInfo pageInfo;

    /** 请求流水号 **/
    private String contextId = String.valueOf(-1L);


    /** 构造函数 **/
    public CsmsResult() {

    }

    /** getter & setter **/

    public T getData() {
        return data;
    }



    public void setData(T data) {
        this.data = data;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getContextId() {
        return contextId;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }



    /**
     * 返回结果集（带数据）
     *
     * @param data:业务数据
     * @return
     */
    public static <T> CsmsResult<T> buildCsmsResult(T data) {

        CsmsResult<T> result = new CsmsResult<>();

        result.setData(data);

        return result;
    }

    /**
     * 返回结果集（带数据和分页信息）
     *
     * @param data：业务数据
     * @param pageInfo：分页信息
     * @return
     */
    public static <T> CsmsResult<T> buildCsmsResult(T data, PageInfo pageInfo) {
        CsmsResult<T> result = new CsmsResult<>();

        result.setData(data);
        result.setPageInfo(pageInfo);
        return result;
    }
}
