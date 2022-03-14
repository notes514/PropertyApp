package com.guet.home.nominate.bean.viewmodel;

import com.guet.common.contract.BaseCustomViewModel;

import java.time.LocalDateTime;

/**
 * 物业通知实体
 *
 * @author dhxstart
 * @date 2022/4/5 14:42
 */
public class NoticeViewModel extends BaseCustomViewModel {
    /**
     * 通知ID
     */
    public Integer id;

    /**
     * 公告标题
     */
    public String title;

    /**
     * 公告内容
     */
    public String content;

    /**
     * 发布状态:0-关闭，1-开启
     */
    public String status;

    /**
     * 发布时间
     */
    public String releaseTime;

    /**
     * 图片
     */
    public String imageUrl;

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
    public String gmtCreate;

    /**
     * 更新时间
     */
    public String gmtModified;
}
