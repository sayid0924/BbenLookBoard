package com.bben.lookboard.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bben.lookboard.R;
import com.bben.lookboard.bean.PatientListBean;
import com.bben.lookboard.utils.CommonUtil;
import com.bben.lookboard.view.FlikerProgressBar;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class PatientListApadter extends BaseQuickAdapter<PatientListBean.DataBean, BaseViewHolder> {

    private Context mContext;

    private ViewGroup.LayoutParams params;
    private int sizeTvName, sizeTv,sizeTvInfusion;
    private int itemSize;

    public PatientListApadter(List<PatientListBean.DataBean> data, Context mContext) {
        super(R.layout.item_beadinfo, data);
        this.mContext = mContext;
        this.params = new ViewGroup.LayoutParams(200, 300);
    }

    public void setLayoutParams(ViewGroup.LayoutParams params) {
        this.params = params;
    }

    public void setTextSize(int sizeTvName, int sizeTv,int sizeTvInfusion) {
        this.sizeTvName = sizeTvName;
        this.sizeTv = sizeTv;
        this.sizeTvInfusion = sizeTvInfusion;
    }

    public  void setItemSize(int itemSize){
        this.itemSize = itemSize;
    }

    @Nullable
    @Override
    public PatientListBean.DataBean getItem(int position) {
        int newPosition = position % getData().size();
        return getData().get(newPosition);
    }

    @Override
    public int getItemViewType(int position) {
        int count = getHeaderLayoutCount() + getData().size();
        if (count <= 0) {
            count = 1;
        }
        int newPosition = position % count;
        return super.getItemViewType(newPosition);
    }

    @Override
    public int getItemCount() {
        return itemSize;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void convert(final BaseViewHolder helper, final PatientListBean.DataBean item) {

        RelativeLayout rlNo = helper.getView(R.id.rl_no);
        RelativeLayout itemBg = helper.getView(R.id.ll_item_patient);
        TextView tvLevel = helper.getView(R.id.tv_level);
        FlikerProgressBar progressBar = helper.getView(R.id.round_flikerbar);
        FrameLayout flEmpty = helper.getView(R.id.fl_empty);
        LinearLayout llReal = helper.getView(R.id.ll_real);
        LinearLayout llInfusionStart = helper.getView(R.id.ll_infusion_start);

        itemBg.setBackgroundColor(Color.parseColor(item.getNurseLevelBgColor()));
        GradientDrawable myGrad = (GradientDrawable)rlNo.getBackground();

        TextView tvBedNo = helper.getView(R.id.tv_beadno);
        TextView tvName = helper.getView(R.id.tv_name);
        TextView tvCureNo = helper.getView(R.id.tv_cureNo);
        TextView tvSex = helper.getView(R.id.tv_sex);
        TextView tvAge = helper.getView(R.id.tv_age);
        TextView tvDoctorname = helper.getView(R.id.tv_doctorname);
        TextView tvDate = helper.getView(R.id.tv_date);
        TextView tvBuytype = helper.getView(R.id.tv_buytype);
        TextView tvInfusionVolume = helper.getView(R.id.tv_infusion_volume);
        TextView tvInfusionVolumeValue = helper.getView(R.id.tv_infusion_volume_value);
        TextView tvInfusionSpeed = helper.getView(R.id.tv_infusion_speed);
        TextView tvInfusionSpeedValue = helper.getView(R.id.tv_infusion_speed_value);
        TextView tvInfusionStart = helper.getView(R.id.tv_infusion_start);
        TextView tvEmpty = helper.getView(R.id.tv_empty);


        if(item.getBedStatus()==1){
          //  床位占用状态：0空闲 1使用
             llReal.setVisibility(View.VISIBLE);
//             llInfusionStart.setVisibility(View.VISIBLE);
             flEmpty.setVisibility(View.GONE);

            myGrad.setColor(Color.parseColor(item.getNurseLevelBgColor()));

            progressBar.setProgress(50);
            tvName.setText(CommonUtil.replaceString2Star(item.getName(),1,1));
            tvSex.setText(item.getSexText());
            tvAge.setText(item.getAge());
            tvCureNo.setText( item.getCureNo());
            tvDate.setText(item.getInTime());
            tvLevel.setText(item.getNurseLevelName());
//            tvLevel.setTextColor(Color.parseColor(item.getNurseLevelFontColor()));
            tvBedNo.setText(item.getBedName());
            tvDoctorname.setText(item.getDoctorName());

        }else {
            llReal.setVisibility(View.GONE);
            llInfusionStart.setVisibility(View.GONE);
            flEmpty.setVisibility(View.VISIBLE);
            myGrad.setColor(Color.parseColor("#212121"));
        }


        tvBedNo.setTextSize(sizeTvName);
        tvName.setTextSize(sizeTvName);
        tvCureNo.setTextSize(sizeTv);
        tvSex.setTextSize(sizeTv);
        tvAge.setTextSize(sizeTv);
        tvDoctorname.setTextSize(sizeTv);
        tvLevel.setTextSize(sizeTv);
        tvBuytype.setTextSize(sizeTv);
        tvDate.setTextSize(sizeTv);
        tvInfusionVolume.setTextSize(sizeTvInfusion);
        tvInfusionVolumeValue.setTextSize(sizeTvInfusion);
        tvInfusionSpeed.setTextSize(sizeTvInfusion);
        tvInfusionSpeedValue.setTextSize(sizeTvInfusion);
        tvInfusionStart.setTextSize(sizeTv);
        tvEmpty.setTextSize(sizeTvName);


        helper.itemView.setLayoutParams(params);

    }
}
