package com.guet.more.event.bean;


import android.os.Parcel;
import android.os.Parcelable;

import com.guet.common.contract.BaseCustomViewModel;

/**
 * 活动实体
 *
 * @author dhxstart
 * @date 2022/1/9 19:54
 */
public class EventCustomViewModel extends BaseCustomViewModel  implements Parcelable {
    /**
     * 活动ID
     */
    public Integer id;

    /**
     * 活动标题
     */
    public String title;

    /**
     * 活动内容
     */
    public String content;

    /**
     * 活动地点
     */
    public String address;

    /**
     * 举办单位
     */
    public String organizer;

    /**
     * 状态:0-活动未开始（默认），1-活动进行中，2-活动已结束
     */
    public String status;

    public String imageUrl;

    /**
     * 活动开始时间
     */
    public String startTime;

    /**
     * 活动截止时间
     */
    public String endTime;

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

    public EventCustomViewModel() {
    }

    protected EventCustomViewModel(Parcel parcel) {
        this.id = parcel.readInt();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.status = parcel.readString();
        this.startTime = parcel.readString();
        this.endTime = parcel.readString();
        this.imageUrl = parcel.readString();
    }

    public static final Creator<EventCustomViewModel> CREATOR = new Creator<EventCustomViewModel>() {
        @Override
        public EventCustomViewModel createFromParcel(Parcel source) {
            return new EventCustomViewModel(source);
        }

        @Override
        public EventCustomViewModel[] newArray(int size) {
            return new EventCustomViewModel[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeString(this.status);
        dest.writeString(this.startTime);
        dest.writeString(this.endTime);
        dest.writeString(this.imageUrl);
    }
}
