package com.guet.community.supply.bean;


import android.os.Parcel;
import android.os.Parcelable;

import com.guet.common.contract.BaseCustomViewModel;

/**
 * 供求实体
 *
 * @author dhxstart
 * @date 2022/1/9 19:54
 */
public class SupplyCustomViewModel extends BaseCustomViewModel implements Parcelable {
    /**
     * 供求ID
     */
    public Integer id;

    /**
     * 供求人员（业主）ID
     */
    public Integer ownerId;

    /**
     * 供求人员（业主）名称
     */
    public String ownerName;

    /**
     * 用户头像Url
     */
    public String avatarUrl;

    /**
     * 供求标题
     */
    public String title;

    /**
     * 供求描述
     */
    public String content;

    /**
     * 供求地点
     */
    public String address;

    /**
     * 供求商品图片
     */
    public String imageUrl;

    /**
     * 状态:0-供求未开始（默认），1-供求进行中，2-供求已结束
     */
    public String status;

    /**
     * 逻辑删除:0-未删除（默认），1-已删除
     */
    public String deleted;

    /**
     * 乐观锁
     */
    public Integer version;

    /**
     * 供求开始时间
     */
    public String startTime;

    /**
     * 供求截止时间
     */
    public String endTime;

    /**
     * 创建时间
     */
    public String gmtCreate;

    /**
     * 更新时间
     */
    public String gmtModified;

    public SupplyCustomViewModel() {
    }

    protected SupplyCustomViewModel(Parcel parcel) {
        this.id = parcel.readInt();
        this.ownerId = parcel.readInt();
        this.ownerName = parcel.readString();
        this.avatarUrl = parcel.readString();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.address = parcel.readString();
        this.imageUrl = parcel.readString();
        this.status = parcel.readString();
        this.startTime = parcel.readString();
    }

    public static final Creator<SupplyCustomViewModel> CREATOR = new Creator<SupplyCustomViewModel>() {
        @Override
        public SupplyCustomViewModel createFromParcel(Parcel source) {
            return new SupplyCustomViewModel(source);
        }

        @Override
        public SupplyCustomViewModel[] newArray(int size) {
            return new SupplyCustomViewModel[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.ownerId);
        dest.writeString(this.ownerName);
        dest.writeString(this.avatarUrl);
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeString(this.address);
        dest.writeString(this.imageUrl);
        dest.writeString(this.status);
        dest.writeString(this.startTime);
    }
}
