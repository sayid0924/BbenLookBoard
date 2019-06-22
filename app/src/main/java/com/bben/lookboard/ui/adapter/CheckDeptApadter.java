package com.bben.lookboard.ui.adapter;

import android.content.Context;
import android.view.View;

import com.bben.lookboard.R;
import com.bben.lookboard.bean.DeptCodeListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class CheckDeptApadter extends BaseQuickAdapter<DeptCodeListBean.DataBean, BaseViewHolder> {

    private Context mContext;
    private List<DeptCodeListBean.DataBean> data;
    private onItemClick onItemClick;

    public CheckDeptApadter(List<DeptCodeListBean.DataBean> data, Context mContext) {
        super(R.layout.item_dept, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final DeptCodeListBean.DataBean item) {

        helper.setText(R.id.tv_name,item.getName());

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClick!=null){
                    onItemClick.onItemClick(item);
                }
            }
        });
    }



    public  interface onItemClick {
        void onItemClick(DeptCodeListBean.DataBean c);

    }
    public  void  onItemClick(onItemClick onItemClick){
        this.onItemClick = onItemClick;
    }

}
