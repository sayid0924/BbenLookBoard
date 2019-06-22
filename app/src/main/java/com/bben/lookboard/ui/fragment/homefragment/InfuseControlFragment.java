package com.bben.lookboard.ui.fragment.homefragment;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseFragment;
import com.bben.lookboard.base.Constant;

public class InfuseControlFragment extends BaseFragment {


    public static InfuseControlFragment newInstance() {
        InfuseControlFragment infuseControlFragment = new InfuseControlFragment();
        return infuseControlFragment;
    }


    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_infuse_control;
    }

    @Override
    public void attachView() {

    }
}
