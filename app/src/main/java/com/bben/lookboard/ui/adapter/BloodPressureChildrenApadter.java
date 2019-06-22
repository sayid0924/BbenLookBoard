package com.bben.lookboard.ui.adapter;

import android.content.Context;

import com.bben.lookboard.R;
import com.bben.lookboard.bean.BloodPressureBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class BloodPressureChildrenApadter extends BaseQuickAdapter<BloodPressureBean.BloodPressureChildren, BaseViewHolder> {

    private Context mContext;
    private List<BloodPressureBean.BloodPressureChildren> data;

    public BloodPressureChildrenApadter(List<BloodPressureBean.BloodPressureChildren> data, Context mContext) {
        super(R.layout.item_bloodpressurechildren, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final BloodPressureBean.BloodPressureChildren item) {
         helper.setText(R.id.tv_beadno,item.getBeadNo());
    }
}
