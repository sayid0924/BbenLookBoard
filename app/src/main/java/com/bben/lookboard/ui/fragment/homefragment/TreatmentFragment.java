package com.bben.lookboard.ui.fragment.homefragment;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseFragment;
import com.bben.lookboard.base.Constant;

public class TreatmentFragment extends BaseFragment {

    public static TreatmentFragment newInstance() {
        TreatmentFragment treatmentFragment = new TreatmentFragment();
        return treatmentFragment;
    }



    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_treatment;
    }

    @Override
    public void attachView() {

    }
}
