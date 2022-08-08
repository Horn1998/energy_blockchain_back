package com.horn.energy_blockchain.entity;/*
 *@Author: horn
 *@DATE: 2022/8/7 0007 23:11
 *@Description:查询业务实体
 *@Version 1.0
 */

public class QueryDTO {
    private Integer pageNo;    //页码
    private Integer pageSize;  //页面大小
    private String keyword;    //关键字
    //省略getter、setter

    public QueryDTO() {
    }

    public QueryDTO(Integer pageNo, Integer pageSize, String keyword) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.keyword = keyword;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
