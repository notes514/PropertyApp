package com.guet.home.suggestions.bean;

import java.time.LocalDateTime;

/**
 * @author dhxstart
 * @date 2022/4/21 18:29
 */
public class SuggestionsCustomViewModel {
    /**
     * 投诉ID
     */
    public Integer id;

    /**
     * 投诉人员（业主）ID
     */
    public Integer ownerId;

    /**
     * 投诉类型
     */
    public String complaintType;

    /**
     * 投诉内容
     */
    public String complaintContent;

    /**
     * 处理状态：0-待受理，1-受理中，2-受理完毕
     */
    public String status;

    /**
     * 处理人
     */
    public String handler;

    /**
     * 逻辑删除:0-未删除（默认），1-已删除
     */
    public String deleted;

    /**
     * 乐观锁
     */
    public Integer version;

    /**
     * 创建时间
     */
    public LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    public LocalDateTime gmtModified;
}
