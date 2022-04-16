package com.guet.home.nominate.bean;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.guet.common.contract.VideoHeaderBean;

/**
 * @author dhxstart
 * @date 2022/4/5 16:01
 */
@SuppressLint("ParcelCreator")
public class NoticeBean implements Parcelable {
    /**
     * 通知ID
     */
    private Integer id;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 发布状态:0-关闭，1-开启
     */
    private String status;

    /**
     * 发布时间
     */
    private String releaseTime;

    /**
     * 图片
     */
    public String imageUrl;

    public NoticeBean() {
    }

    protected NoticeBean(Parcel parcel) {
        this.id = parcel.readInt();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.status = parcel.readString();
        this.releaseTime = parcel.readString();
        this.imageUrl = parcel.readString();
    }

    public static final Creator<NoticeBean> CREATOR = new Creator<NoticeBean>() {
        @Override
        public NoticeBean createFromParcel(Parcel source) {
            return new NoticeBean(source);
        }

        @Override
        public NoticeBean[] newArray(int size) {
            return new NoticeBean[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "NoticeBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
