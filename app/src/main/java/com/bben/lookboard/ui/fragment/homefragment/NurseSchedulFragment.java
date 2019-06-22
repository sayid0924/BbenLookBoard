package com.bben.lookboard.ui.fragment.homefragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseFragment;
import com.bben.lookboard.base.Constant;
import com.bben.lookboard.bean.NurseSchedulBean;
import com.bben.lookboard.ui.adapter.NurseSchedulApadter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class NurseSchedulFragment extends BaseFragment {


    private NurseSchedulApadter mAdapterDay;
    private List<NurseSchedulBean> dataDay = new ArrayList<>();

    private NurseSchedulApadter mAdapterNight;
    private List<NurseSchedulBean> dataNight = new ArrayList<>();

    private NurseSchedulApadter mAdapterAtNight;
    private List<NurseSchedulBean> dataAtNight = new ArrayList<>();

    private NurseSchedulApadter mAdapterRecess;
    private List<NurseSchedulBean> dataRecess = new ArrayList<>();

    @BindView(R.id.rv_day)
    RecyclerView rvDay;

    @BindView(R.id.rv_night)
    RecyclerView rvNight;

    @BindView(R.id.rv_at_night)
    RecyclerView rvAtNight;

    @BindView(R.id.rv_recess)
    RecyclerView rvRecess;

    public static NurseSchedulFragment newInstance() {
        NurseSchedulFragment nurseSchedulFragment = new NurseSchedulFragment();
        return nurseSchedulFragment;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_nurs_schedul;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void initView(Bundle bundle) {

        initDateDay();
        mAdapterDay = new NurseSchedulApadter(dataDay, getSupportActivity());
        rvDay.setLayoutManager(new GridLayoutManager(getSupportActivity(),5));
        rvDay.setAdapter(mAdapterDay);

        initDateNight();
        mAdapterNight = new NurseSchedulApadter(dataNight, getSupportActivity());
        rvNight.setLayoutManager(new GridLayoutManager(getSupportActivity(),5));
        rvNight.setAdapter(mAdapterNight);

        initDateAtNight();
        mAdapterAtNight = new NurseSchedulApadter(dataAtNight, getSupportActivity());
        rvAtNight.setLayoutManager(new GridLayoutManager(getSupportActivity(),5));
        rvAtNight.setAdapter(mAdapterAtNight);

        initDateRecess();
        mAdapterRecess = new NurseSchedulApadter(dataRecess, getSupportActivity());
        rvRecess.setLayoutManager(new GridLayoutManager(getSupportActivity(),5));
        rvRecess.setAdapter(mAdapterRecess);

    }

  public  void  initDateDay(){
        dataDay.add(new NurseSchedulBean("A1","博宇"));
        dataDay.add(new NurseSchedulBean("A2","厉辉"));
        dataDay.add(new NurseSchedulBean("A3","君博"));
        dataDay.add(new NurseSchedulBean("连1","昌瀚"));
        dataDay.add(new NurseSchedulBean("连2","昆琦"));
        dataDay.add(new NurseSchedulBean("行政","彬彬"));
        dataDay.add(new NurseSchedulBean("责护1","景彰"));
        dataDay.add(new NurseSchedulBean("责护2","泰清"));
  }

  public  void initDateNight(){
      dataNight.add(new NurseSchedulBean("P","奇思"));
      dataNight.add(new NurseSchedulBean("助夜","高昂"));
  }

  public  void  initDateAtNight(){
      dataAtNight.add(new NurseSchedulBean("N","宏阔"));
  }

  public void  initDateRecess(){

      dataRecess.add(new NurseSchedulBean("产假","阳州"));
      dataRecess.add(new NurseSchedulBean("产假","建木"));

      dataRecess.add(new NurseSchedulBean("进修","光远"));
      dataRecess.add(new NurseSchedulBean("进修","昂雄"));

      dataRecess.add(new NurseSchedulBean("休息","礼骞"));
      dataRecess.add(new NurseSchedulBean("休息","越彬"));
      dataRecess.add(new NurseSchedulBean("休息","涵涵"));
      dataRecess.add(new NurseSchedulBean("休息","智晖"));

  }
}
