package com.bben.lookboard.ui.fragment.todyworkfragment;

import android.os.Bundle;
import android.widget.TextView;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseFragment;
import com.bben.lookboard.base.Constant;
import com.blankj.utilcode.utils.TimeUtils;

import butterknife.BindView;

public class WorkTablefragment  extends BaseFragment {

    @BindView(R.id.tv_date)
    TextView tvDate;

    public static WorkTablefragment newInstance() {
        WorkTablefragment workTablefragment = new WorkTablefragment();
        return workTablefragment;
    }



    @Override
    public void loadData() {
         setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_worktable;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void initView(Bundle bundle) {
       tvDate.setText(TimeUtils.getNowTimeString("yyyy-MM-dd EEEE"));
    }
}
