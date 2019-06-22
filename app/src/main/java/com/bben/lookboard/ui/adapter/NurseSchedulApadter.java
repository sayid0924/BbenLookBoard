package com.bben.lookboard.ui.adapter;

import android.content.Context;

import com.bben.lookboard.R;
import com.bben.lookboard.bean.NurseSchedulBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class NurseSchedulApadter extends BaseQuickAdapter<NurseSchedulBean, BaseViewHolder> {

    private Context mContext;
    private List<NurseSchedulBean> data;

    public NurseSchedulApadter(List<NurseSchedulBean> data, Context mContext) {
        super(R.layout.item_nurseschedul, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final NurseSchedulBean item) {
       helper.setText(R.id.tv_name,item.getName());
        helper.setText(R.id.tv_title,item.getTitle());

    }
}
