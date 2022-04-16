package com.guet.home.nominate.bean.viewmodel;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.guet.common.contract.BaseCustomViewModel;
import com.guet.home.nominate.bean.NoticeBean;

import java.time.LocalDateTime;

/**
 * 物业通知实体
 *
 * @author dhxstart
 * @date 2022/4/5 14:42
 */
@SuppressLint("ParcelCreator")
public class NoticeViewModel extends BaseCustomViewModel implements Parcelable {
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

    public NoticeViewModel() {
    }

    protected NoticeViewModel(Parcel parcel) {
        this.id = parcel.readInt();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.status = parcel.readString();
        this.releaseTime = parcel.readString();
        this.imageUrl = parcel.readString();
    }

    public static final Creator<NoticeViewModel> CREATOR = new Creator<NoticeViewModel>() {
        @Override
        public NoticeViewModel createFromParcel(Parcel source) {
            return new NoticeViewModel(source);
        }

        @Override
        public NoticeViewModel[] newArray(int size) {
            return new NoticeViewModel[0];
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
        dest.writeString(this.releaseTime);
        dest.writeString(this.imageUrl);
    }
}
