package com.bben.lookboard.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.bben.lookboard.R;
import com.bben.lookboard.bean.BedInfoBean;
import com.bben.lookboard.bean.PatientInfoBean;
import com.bben.lookboard.utils.CommonUtil;
import com.blankj.utilcode.utils.TimeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class PatientInfoApadter extends BaseQuickAdapter<BedInfoBean.DataBean.PatientVosBean, BaseViewHolder> {

    private Context mContext;
    private List<BedInfoBean.DataBean.PatientVosBean> data;
    private int EpochSecond;

    public PatientInfoApadter(List<BedInfoBean.DataBean.PatientVosBean> data, Context mContext) {
        super(R.layout.item_patient, data);
        this.mContext = mContext;
        this.data = data;
    }

    public void setEpochSecond(int EpochSecond) {
        this.EpochSecond = EpochSecond;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final BedInfoBean.DataBean.PatientVosBean item) {
        RelativeLayout itemBg = helper.getView(R.id.rl_item_patient);
        RelativeLayout rlNo = helper.getView(R.id.rl_no);
        ImageView ivSex = helper.getView(R.id.iv_sex);
        if (item.isHasMore()) {
            if (item.getNurseLevel().contains("特级护理")) {
                itemBg.setBackgroundResource(R.drawable.item_patient_super_bg);
                rlNo.setBackgroundResource(R.drawable.item_super_bg);
            } else if (item.getNurseLevel().contains("Ⅰ级护理")) {
                itemBg.setBackgroundResource(R.drawable.item_patient_one_bg);
                rlNo.setBackgroundResource(R.drawable.item_patient_one);
            } else if (item.getNurseLevel().contains("Ⅱ级护理")) {
                itemBg.setBackgroundResource(R.drawable.item_patient_two_bg);
                rlNo.setBackgroundResource(R.drawable.item_patient_two);
            }
            helper.setText(R.id.tv_name, item.getName());
            helper.setText(R.id.tv_bednum, "0" + String.valueOf(helper.getPosition() + 1));
            helper.setText(R.id.tv_cureno, "住院号: " + item.getCureNo());
            helper.setText(R.id.tv_nurselevel, item.getNurseLevel());

//            String age = String.valueOf(CommonUtil.getAgeByBirth(TimeUtils.string2Date(TimeUtils.millis2String(TimeUtils.string2Millis(item.getBirthday(), "yyyy-MM-dd"))),
//             TimeUtils.string2Date(TimeUtils.millis2String(EpochSecond * 1000L)))) + "岁";

            helper.setText(R.id.tv_age, item.getAge() + "岁");

            switch (item.getSex()) {
                case 0:
                    ivSex.setBackgroundResource(R.drawable.man_icon);
                    break;
                case 1:
                    ivSex.setBackgroundResource(R.drawable.gilr_icon);
                    break;
                default:
                    ivSex.setBackgroundResource(R.drawable.gilr_icon);
                    break;
            }
//            if (item.getSex() ==0) {
//                ivSex.setBackgroundResource(R.drawable.man_icon);
//            } else {
//                ivSex.setBackgroundResource(R.drawable.gilr_icon);
//            }

        } else {
            itemBg.setBackgroundResource(R.drawable.item_patient_not_bg);
            rlNo.setBackgroundResource(R.drawable.item_patient_not);
            helper.setText(R.id.tv_name, "");
            helper.setText(R.id.tv_bednum, "0" + String.valueOf(helper.getPosition() + 1));
            helper.setText(R.id.tv_cureno, "空床位");
            helper.setText(R.id.tv_nurselevel, "");
            helper.setText(R.id.tv_age, "");
            ivSex.setVisibility(View.GONE);
        }
    }
}
