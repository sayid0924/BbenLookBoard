package com.bben.lookboard.ui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bben.lookboard.R;
import com.bben.lookboard.bean.BloodPressureBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class BloodPressureApadter extends BaseQuickAdapter<BloodPressureBean, BaseViewHolder> {

    private Context mContext;
    private List<BloodPressureBean> data;

    public BloodPressureApadter(List<BloodPressureBean> data, Context mContext) {
        super(R.layout.item_bloodpressure, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final BloodPressureBean item) {
        helper.setText(R.id.tv_title, item.getTitle());

        helper.setText(R.id.tv_countNo,item.getCountNo());
        RecyclerView recyclerView = helper.getView(R.id.title_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        BloodPressureChildrenApadter adapter = new BloodPressureChildrenApadter(item.getBloodPressureChildren(),mContext);
        recyclerView.setAdapter(adapter);
    }
}
