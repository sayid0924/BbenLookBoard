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

public class JobContentFragment  extends BaseFragment {


    private BloodPressureApadter mAdapterBlood;
    private List<BloodPressureBean> dataBlood = new ArrayList<>();
    String[] titlesBlood = {"tid", "bid", "q4h", "q6h", "q8h", "q1h", "q3h", "q5h", "q9h", "q2h", "q7h"};


    private BloodPressureApadter mAdapterTemperature;
    private List<BloodPressureBean> dataTemperature = new ArrayList<>();
    String[] titlesTemperature = {"16:00", "17:00", "18:00", "19:00", "15:00", "14:00", "12:00", "11:00", "10:00", "9:00", "8:00"};

    private BloodPressureApadter mAdapterECG;
    private List<BloodPressureBean> dataECG = new ArrayList<>();
    String[] titlesECG = {"心电", "吸氧", "脉搏"};

    private BloodPressureApadter mAdapterSugar;
    private List<BloodPressureBean> dataSugar = new ArrayList<>();


    @BindView(R.id.rv_blood)
    RecyclerView rvBlood;
    @BindView(R.id.srl_blood)
    SwipeRefreshLayout srlBlood;


    @BindView(R.id.rv_temperature)
    RecyclerView rvTemperature;
    @BindView(R.id.srl_temperature)
    SwipeRefreshLayout srlTemperature;

    @BindView(R.id.rv_ecg)
    RecyclerView rvECG;
    @BindView(R.id.srl_ecg)
    SwipeRefreshLayout srlECG;

    @BindView(R.id.rv_sugar)
    RecyclerView rvSugar;
    @BindView(R.id.srl_sugar)
    SwipeRefreshLayout srlSugar;

    public  static  JobContentFragment  newInstance() {
        JobContentFragment jobContentFragment = new JobContentFragment();
        return jobContentFragment;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_jobcontent;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void initView(Bundle bundle) {

        initDateBlood();
        mAdapterBlood = new BloodPressureApadter(dataBlood, getSupportActivity());
        rvBlood.setLayoutManager(new LinearLayoutManager(getSupportActivity()));
        rvBlood.setAdapter(mAdapterBlood);
        srlBlood.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataBlood.clear();
                initDateBlood();
                mAdapterBlood.notifyDataSetChanged();
                srlBlood.setRefreshing(false);
            }
        });

        initDateTemperature();
        mAdapterTemperature = new BloodPressureApadter(dataTemperature, getSupportActivity());
        rvTemperature.setLayoutManager(new LinearLayoutManager(getSupportActivity()));
        rvTemperature.setAdapter(mAdapterTemperature);
        srlTemperature.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataTemperature.clear();
                initDateTemperature();
                mAdapterTemperature.notifyDataSetChanged();
                srlTemperature.setRefreshing(false);
            }
        });

        initDateECG();
        mAdapterECG = new BloodPressureApadter(dataECG, getSupportActivity());
        rvECG.setLayoutManager(new LinearLayoutManager(getSupportActivity()));
        rvECG.setAdapter(mAdapterECG);
        srlECG.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataECG.clear();
                initDateECG();
                mAdapterECG.notifyDataSetChanged();
                srlECG.setRefreshing(false);
            }
        });

        initDateSugar();
        mAdapterSugar = new BloodPressureApadter(dataSugar, getSupportActivity());
        rvSugar.setLayoutManager(new LinearLayoutManager(getSupportActivity()));
        rvSugar.setAdapter(mAdapterSugar);
        srlSugar.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataSugar.clear();
                initDateSugar();
                mAdapterSugar.notifyDataSetChanged();
                srlSugar.setRefreshing(false);
            }
        });
    }

    private void initDateECG(){
        for (int i = 0; i < 2; i++) {
            BloodPressureBean bloodPressureBean = new BloodPressureBean();
            bloodPressureBean.setTitle(titlesECG[(int) (Math.random() * titlesECG.length)]);
            bloodPressureBean.setCountNo(String.valueOf((int)(Math.random()*10+1)));
            List<BloodPressureBean.BloodPressureChildren> childrenList = new ArrayList<>();
            for (int n = 0; n < (int)(Math.random()*10+1); n++) {
                BloodPressureBean.BloodPressureChildren bloodPressureChildren = new BloodPressureBean.BloodPressureChildren();
                bloodPressureChildren.setBeadNo(String.valueOf((int) (Math.random() * 50)));
                childrenList.add(bloodPressureChildren);
            }
            bloodPressureBean.setBloodPressureChildren(childrenList);
            dataECG.add(bloodPressureBean);
        }
    }

    private void initDateTemperature(){
        for (int i = 0; i < 20; i++) {
            BloodPressureBean bloodPressureBean = new BloodPressureBean();
            bloodPressureBean.setTitle(titlesTemperature[(int) (Math.random() * titlesTemperature.length)]);
            bloodPressureBean.setCountNo(String.valueOf((int)(Math.random()*10+1)));
            List<BloodPressureBean.BloodPressureChildren> childrenList = new ArrayList<>();
            for (int n = 0; n < (int)(Math.random()*10+1); n++) {
                BloodPressureBean.BloodPressureChildren bloodPressureChildren = new BloodPressureBean.BloodPressureChildren();
                bloodPressureChildren.setBeadNo(String.valueOf((int) (Math.random() * 50)));
                childrenList.add(bloodPressureChildren);
            }
            bloodPressureBean.setBloodPressureChildren(childrenList);
            dataTemperature.add(bloodPressureBean);
        }
    }

    private void initDateBlood(){
        for (int i = 0; i < 20; i++) {
            BloodPressureBean bloodPressureBean = new BloodPressureBean();
            bloodPressureBean.setTitle(titlesBlood[(int) (Math.random() * titlesBlood.length)]);
            bloodPressureBean.setCountNo(String.valueOf((int)(Math.random()*10+1)));
            List<BloodPressureBean.BloodPressureChildren> childrenList = new ArrayList<>();
            for (int n = 0; n < (int)(Math.random()*10+1); n++) {
                BloodPressureBean.BloodPressureChildren bloodPressureChildren = new BloodPressureBean.BloodPressureChildren();
                bloodPressureChildren.setBeadNo(String.valueOf((int) (Math.random() * 50)));
                childrenList.add(bloodPressureChildren);
            }
            bloodPressureBean.setBloodPressureChildren(childrenList);
            dataBlood.add(bloodPressureBean);
        }
    }

    private void initDateSugar(){
        for (int i = 0; i < 20; i++) {
            BloodPressureBean bloodPressureBean = new BloodPressureBean();
            bloodPressureBean.setTitle(titlesBlood[(int) (Math.random() * titlesBlood.length)]);
            bloodPressureBean.setCountNo(String.valueOf((int)(Math.random()*10+1)));
            List<BloodPressureBean.BloodPressureChildren> childrenList = new ArrayList<>();
            for (int n = 0; n < (int)(Math.random()*10+1); n++) {
                BloodPressureBean.BloodPressureChildren bloodPressureChildren = new BloodPressureBean.BloodPressureChildren();
                bloodPressureChildren.setBeadNo(String.valueOf((int) (Math.random() * 50)));
                childrenList.add(bloodPressureChildren);
            }
            bloodPressureBean.setBloodPressureChildren(childrenList);
            dataSugar.add(bloodPressureBean);
        }
    }

}
