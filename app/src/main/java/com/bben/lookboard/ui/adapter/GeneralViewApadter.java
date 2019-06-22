package com.bben.lookboard.ui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bben.lookboard.R;
import com.bben.lookboard.bean.GeneralViewBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class GeneralViewApadter extends BaseQuickAdapter<GeneralViewBean, BaseViewHolder> {

    private Context mContext;
    private List<GeneralViewBean> data;

    public GeneralViewApadter(List<GeneralViewBean> data, Context mContext) {
        super(R.layout.item_generalview, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final GeneralViewBean item) {
        helper.setText(R.id.tv_title, item.getTitle());
//        helper.setText(R.id.tv_countNo,item.getCountNo());
        RecyclerView recyclerView = helper.getView(R.id.title_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        GeneralViewChildrenApadter adapter = new GeneralViewChildrenApadter(item.getGeneralViewBeanChildren(),mContext);
        recyclerView.setAdapter(adapter);

    }
}
