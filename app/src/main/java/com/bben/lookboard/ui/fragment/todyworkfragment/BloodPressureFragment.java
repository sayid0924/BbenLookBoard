package com.bben.lookboard.ui.fragment.todyworkfragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseFragment;
import com.bben.lookboard.base.Constant;
import com.bben.lookboard.bean.BloodPressureBean;
import com.bben.lookboard.ui.adapter.BloodPressureApadter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class BloodPressureFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private BloodPressureApadter mAdapter;
    private List<BloodPressureBean> dataBean = new ArrayList<>();

    String[] titles = {"tid", "bid", "q4h", "q6h", "q8h", "q1h", "q3h", "q5h", "q9h", "q2h", "q7h"};

    @BindView(R.id.title_list)
    RecyclerView Book_Dir_List;

    @BindView(R.id.srl_android)
    SwipeRefreshLayout srlAndroid;

    public static BloodPressureFragment newInstance() {
        BloodPressureFragment bloodPressureFragment = new BloodPressureFragment();
        return bloodPressureFragment;
    }


    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_blood_pressure;
    }

    @Override
    public void attachView() {

    }

    private void initDate(){
        for (int i = 0; i < 20; i++) {
            BloodPressureBean bloodPressureBean = new BloodPressureBean();
            bloodPressureBean.setTitle(titles[(int) (Math.random() * titles.length)]);
            bloodPressureBean.setCountNo(String.valueOf((int)(Math.random()*10+1)));
            List<BloodPressureBean.BloodPressureChildren> childrenList = new ArrayList<>();
            for (int n = 0; n < (int)(Math.random()*10+1); n++) {
                BloodPressureBean.BloodPressureChildren bloodPressureChildren = new BloodPressureBean.BloodPressureChildren();
                bloodPressureChildren.setBeadNo(String.valueOf((int) (Math.random() * 50)));
                childrenList.add(bloodPressureChildren);
            }
            bloodPressureBean.setBloodPressureChildren(childrenList);
            dataBean.add(bloodPressureBean);

        }
    }

    @Override
    protected void initView(Bundle bundle) {
        initDate();
        mAdapter = new BloodPressureApadter(dataBean, getSupportActivity());
        Book_Dir_List.setLayoutManager(new LinearLayoutManager(getSupportActivity()));
        Book_Dir_List.setAdapter(mAdapter);
        srlAndroid.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        dataBean.clear();
        initDate();
        mAdapter.notifyDataSetChanged();
        srlAndroid.setRefreshing(false);
    }
}
