package com.guet.home.discover.bean;

import com.guet.common.contract.BaseCustomViewModel;

import java.io.Serializable;
import java.util.List;

/**
 * 应用模块:
 * <p>
 * 类描述: 热门分类
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-15
 */
public class CategoryCardBean extends BaseCustomViewModel implements Serializable {
    private String type;
    private DataBeanX data;
    private Object tag;
    private int id;
    private int adIndex;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdIndex() {
        return adIndex;
    }

    public void setAdIndex(int adIndex) {
        this.adIndex = adIndex;
    }

    public static class DataBeanX {
        private String dataType;
        private HeaderBean header;
        private int count;
        private Object adTrack;
        private Object footer;
        private List<ItemListBean> itemList;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }

        public Object getFooter() {
            return footer;
        }

        public void setFooter(Object footer) {
            this.footer = footer;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        public static class HeaderBean {
            private int id;
            private String title;
            private String font;
            private Object subTitle;
            private Object subTitleFont;
            private String textAlign;
            private Object cover;
            private Object label;
            private String actionUrl;
            private Object labelList;
            private String rightText;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getFont() {
                return font;
            }

            public void setFont(String font) {
                this.font = font;
            }

            public Object getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(Object subTitle) {
                this.subTitle = subTitle;
            }

            public Object getSubTitleFont() {
                return subTitleFont;
            }

            public void setSubTitleFont(Object subTitleFont) {
                this.subTitleFont = subTitleFont;
            }

            public String getTextAlign() {
                return textAlign;
            }

            public void setTextAlign(String textAlign) {
                this.textAlign = textAlign;
            }

            public Object getCover() {
                return cover;
            }

            public void setCover(Object cover) {
                this.cover = cover;
            }

            public Object getLabel() {
                return label;
            }

            public void setLabel(Object label) {
                this.label = label;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }

            public Object getLabelList() {
                return labelList;
            }

            public void setLabelList(Object labelList) {
                this.labelList = labelList;
            }

            public String getRightText() {
                return rightText;
            }

            public void setRightText(String rightText) {
                this.rightText = rightText;
            }
        }

        public static class ItemListBean {
            private String type;
            private SquareCard data;
            private Object tag;
            private int id;
            private int adIndex;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public SquareCard getData() {
                return data;
            }

            public void setData(SquareCard data) {
                this.data = data;
            }

            public Object getTag() {
                return tag;
            }

            public void setTag(Object tag) {
                this.tag = tag;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getAdIndex() {
                return adIndex;
            }

            public void setAdIndex(int adIndex) {
                this.adIndex = adIndex;
            }

        }
    }
}
