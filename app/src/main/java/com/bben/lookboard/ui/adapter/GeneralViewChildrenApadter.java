package com.bben.lookboard.ui.adapter;

import android.content.Context;

import com.bben.lookboard.R;
import com.bben.lookboard.bean.GeneralViewBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class GeneralViewChildrenApadter extends BaseQuickAdapter<GeneralViewBean.GeneralViewBeanChildren, BaseViewHolder> {

    private Context mContext;
    private List<GeneralViewBean.GeneralViewBeanChildren> data;

    public GeneralViewChildrenApadter(List<GeneralViewBean.GeneralViewBeanChildren> data, Context mContext) {
        super(R.layout.item_bloodpressurechildren, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final GeneralViewBean.GeneralViewBeanChildren item) {
         helper.setText(R.id.tv_beadno,item.getBeadNo());
    }
}
