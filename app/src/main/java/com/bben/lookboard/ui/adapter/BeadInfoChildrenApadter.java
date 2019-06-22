package com.bben.lookboard.ui.adapter;

import android.content.Context;

import com.bben.lookboard.R;
import com.bben.lookboard.bean.BeadInfoBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class BeadInfoChildrenApadter extends BaseQuickAdapter<BeadInfoBean.NurseLevel, BaseViewHolder> {

    private Context mContext;
    private List<BeadInfoBean.NurseLevel> data;

    public BeadInfoChildrenApadter(List<BeadInfoBean.NurseLevel> data, Context mContext) {
        super(R.layout.item_beadinfochildren, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final BeadInfoBean.NurseLevel item) {
        helper.setText(R.id.tv_beadno,item.getDev());
    }
}
