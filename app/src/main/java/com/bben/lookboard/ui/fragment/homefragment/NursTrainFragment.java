package com.bben.lookboard.ui.fragment.homefragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseFragment;
import com.bben.lookboard.base.BaseFragmentPageAdapter;
import com.bben.lookboard.base.Constant;
import com.bben.lookboard.ui.fragment.nurstrainfragment.NursEducationFragment;
import com.bben.lookboard.utils.PreferUtil;

import java.util.ArrayList;

import butterknife.BindView;

public class NursTrainFragment extends BaseFragment {


    private BaseFragmentPageAdapter myAdapter;
    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    public  static  NursTrainFragment nursTrainFragment;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.vp)
    ViewPager vp;


    public static NursTrainFragment newInstance() {
         nursTrainFragment = new NursTrainFragment();
        return nursTrainFragment;
    }


    @Override
    public void loadData() {
     setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_nurs_train;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void initView(Bundle bundle) {
        mTitleList.add("护士教育");
        mTitleList.add("护理须知");
        mTitleList.add("入院流程");
        mTitleList.add("出院流程");

        mFragments.add(NursEducationFragment.newInstance());
        mFragments.add(NursEducationFragment.newInstance());
        mFragments.add(NursEducationFragment.newInstance());
        mFragments.add(NursEducationFragment.newInstance());

        myAdapter = new BaseFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
        vp.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(vp);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        switch (PreferUtil.getInstance().getThemeType()){
            case "def":
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4));
                break;
            case "green":
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4_green));
                break;
            case "night":
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4_night));
                break;
            case "red":
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4_red));
                break;
            case "violet":
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4_violet));
                break;
        }

    }


    public  void setTabLayoutTheme(int color){
        if(tabLayout!=null){
            tabLayout.setBackgroundColor(color);
        }
    }


}
