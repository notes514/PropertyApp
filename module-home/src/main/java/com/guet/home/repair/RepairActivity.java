package com.guet.home.repair;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.guet.base.activity.MvvmBaseActivity;
import com.guet.common.image.picker.GlideImageLoader;
import com.guet.common.image.picker.ImagePickerAdapter;
import com.guet.common.image.picker.SelectDialog;
import com.guet.common.adapter.ScreenAutoAdapter;
import com.guet.common.router.RouterActivityPath;
import com.guet.common.utils.TitleBarUtils;
import com.guet.home.R;
import com.guet.home.databinding.HomeActivityRepairBinding;
import com.guet.home.repair.bean.RepairCustomViewModel;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.ui.ImagePreviewDelActivity;
import com.lzy.imagepicker.view.CropImageView;
import com.zhouyou.http.subsciber.IProgressDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dhxstart
 * @date 2022/4/14 22:56
 */
@Route(path = RouterActivityPath.Home.PAGE_REPAIR)
public class RepairActivity extends MvvmBaseActivity<HomeActivityRepairBinding, RepairViewModel>
        implements IRepairView, ImagePickerAdapter.OnRecyclerViewItemClickListener {
    private static final String TAG = "RepairActivity";

    public static final int IMAGE_ITEM_ADD = -1;
    public static final int REQUEST_CODE_SELECT = 100;
    public static final int REQUEST_CODE_PREVIEW = 101;

    private ImagePickerAdapter adapter;
    // 当前选择的所有图片
    private ArrayList<ImageItem> selImageList;
    //允许选择图片最大数
    private final int maxImgCount = 8;

    private IProgressDialog mProgressDialog = () -> {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("请稍候...");
        return dialog;
    };

    @Override
    protected int getLayoutId() {
        return R.layout.home_activity_repair;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ScreenAutoAdapter.match(this, 375.0f);
        super.onCreate(savedInstanceState);
        // ARouter inject 注入
        ARouter.getInstance().inject(this);
        viewDataBinding.included.titleBar.setTitle("设备问题");
        TitleBarUtils.clickLeftBack(viewDataBinding.included.titleBar, this);
        viewModel.initModel();
        initImagePicker();
        initWidget();
    }

    private void initImagePicker() {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);                      //显示拍照按钮
//        imagePicker.setCrop(true);                            //允许裁剪（单选才有效）
//        imagePicker.setSaveRectangle(true);                   //是否按矩形区域保存
        imagePicker.setSelectLimit(maxImgCount);              //选中数量限制
        imagePicker.setMultiMode(true);                      //多选
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);                       //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);                      //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);                         //保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);                         //保存文件的高度。单位像素
    }

    private void initWidget() {
        selImageList = new ArrayList<>();
        adapter = new ImagePickerAdapter(this, selImageList, maxImgCount);
        adapter.setOnItemClickListener(this);

        viewDataBinding.rvRepair.setLayoutManager(new GridLayoutManager(this, 4));
        viewDataBinding.rvRepair.setHasFixedSize(true);
        viewDataBinding.rvRepair.setAdapter(adapter);


        RepairCustomViewModel repairCustomViewModel = new RepairCustomViewModel();
        viewDataBinding.tv1.setOnClickListener(v1 -> {
            repairCustomViewModel.repairType = viewDataBinding.tv1.getText().toString();
            viewDataBinding.tv1.setBackground(this.getResources().getDrawable(R.drawable.common_shape_dotted_border_grey1));
        });
        viewDataBinding.tv2.setOnClickListener(v1 -> {
            repairCustomViewModel.repairType = viewDataBinding.tv2.getText().toString();
        });
        viewDataBinding.tv3.setOnClickListener(v1 -> {
            repairCustomViewModel.repairType = viewDataBinding.tv3.getText().toString();
        });
        viewDataBinding.tv4.setOnClickListener(v1 -> {
            repairCustomViewModel.repairType = viewDataBinding.tv4.getText().toString();
        });
        viewDataBinding.btnCommit.setOnClickListener(v -> {
            repairCustomViewModel.repairContent = viewDataBinding.homeEtContent.getText().toString();
            viewModel.upload(selImageList, repairCustomViewModel, mProgressDialog);
        });
    }

    private void showDialog(SelectDialog.SelectDialogListener listener, List<String> names) {
        SelectDialog dialog = new SelectDialog(this, com.guet.common.R.style.transparentFrameWindowStyle, listener, names);
        if (!this.isFinishing()) {
            dialog.show();
        }
    }

    @Override
    protected RepairViewModel getViewModel() {
        return ViewModelProviders.of(this).get(RepairViewModel.class);
    }

    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            //添加图片返回
            if (data != null && requestCode == REQUEST_CODE_SELECT) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                if (images != null) {
                    selImageList.addAll(images);
                    adapter.setImages(selImageList);
                }
            }
        } else if (resultCode == ImagePicker.RESULT_CODE_BACK) {
            //预览图片返回
            if (data != null && requestCode == REQUEST_CODE_PREVIEW) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_IMAGE_ITEMS);
                if (images != null) {
                    selImageList.clear();
                    selImageList.addAll(images);
                    adapter.setImages(selImageList);
                }
            }
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        if (position == IMAGE_ITEM_ADD) {
            List<String> names = new ArrayList<>();
            names.add("拍照");
            names.add("相册");
            showDialog((parent, view1, position1, id) -> {
                switch (position1) {
                    case 0: // 直接调起相机
                        //打开选择,本次允许选择的数量
                        ImagePicker.getInstance().setSelectLimit(maxImgCount - selImageList.size());
                        Intent intent = new Intent(this, ImageGridActivity.class);
                        intent.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS, true); // 是否是直接打开相机
                        startActivityForResult(intent, REQUEST_CODE_SELECT);
                        break;
                    case 1:
                        //打开选择,本次允许选择的数量
                        ImagePicker.getInstance().setSelectLimit(maxImgCount - selImageList.size());
                        Intent intent1 = new Intent(this, ImageGridActivity.class);
                        startActivityForResult(intent1, REQUEST_CODE_SELECT);
                        break;
                    default:
                        break;
                }
            }, names);
        } else {//打开预览
            Intent intentPreview = new Intent(this, ImagePreviewDelActivity.class);
            intentPreview.putExtra(ImagePicker.EXTRA_IMAGE_ITEMS, (ArrayList<ImageItem>) adapter.getImages());
            intentPreview.putExtra(ImagePicker.EXTRA_SELECTED_IMAGE_POSITION, position);
            intentPreview.putExtra(ImagePicker.EXTRA_FROM_ITEMS, true);
            startActivityForResult(intentPreview, REQUEST_CODE_PREVIEW);
        }
    }

    @Override
    public void onSuccess() {
        finish();
        LogUtils.d("laodai", "添加成功！");
    }
}
