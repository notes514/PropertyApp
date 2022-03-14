package com.guet.home.nominate.adapter;

import java.util.ArrayList;

import androidx.databinding.BindingAdapter;

import com.guet.home.nominate.adapter.provider.NetBannerProvider;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.bannerview.constants.PageStyle;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-13
 */
public class BannerAdapter {

    @BindingAdapter("initBannerView")
    public static void initBannerView(BannerViewPager bannerViewPager, ArrayList<String> list) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.shoupaiyun.cn%2Fupload%2Fimage%2F20200526%2F1dad04aacf8ac0901a2ce514b3210949.jpg&refer=http%3A%2F%2Fpic.shoupaiyun.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1649815901&t=ca19c8f5fc0bf13b30c8453b2b0bb58b");
        list1.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fskfw.sxlab.cn%2Fstorage%2Fimages%2F8b435b3d45b18c7effed252f3c62ba6b.jpg&refer=http%3A%2F%2Fskfw.sxlab.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1649815901&t=6e2b6f4ed97663b808a9cbd52b9e4a22");
        list1.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.shoupaiyun.cn%2Fupload%2Fimage%2F20200526%2Ffec525d1bc9d863830f28712748fc7a3.jpg&refer=http%3A%2F%2Fpic.shoupaiyun.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1649815901&t=e6951a5fc499b0e1f11c773b9faa744f");
        list1.add("http://img.kaiyanapp.com/1eaf8827688ea3b910b7b6b6cb192a5f.png?imageMogr2/quality/60/format/jpg");

        bannerViewPager.setHolderCreator(NetBannerProvider::new)
                .setPageStyle(PageStyle.MULTI_PAGE_OVERLAP)
                .create(list1);
    }
}
