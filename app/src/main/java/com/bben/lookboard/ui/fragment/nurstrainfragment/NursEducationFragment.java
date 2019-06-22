package com.bben.lookboard.ui.fragment.nurstrainfragment;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseFragment;
import com.bben.lookboard.base.Constant;

public class NursEducationFragment extends BaseFragment {


    public static NursEducationFragment newInstance() {
        NursEducationFragment nursEducationFragment = new NursEducationFragment();
        return nursEducationFragment;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_nurs_educat;
    }

    @Override
    public void attachView() {

    }

}
