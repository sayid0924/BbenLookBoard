package com.bben.lookboard.ui.fragment.todyworkfragment;

import android.os.Bundle;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseFragment;
import com.bben.lookboard.base.Constant;
import com.bben.lookboard.bean.GeneralViewBean;
import com.bben.lookboard.ui.adapter.GeneralViewApadter;
import com.bben.lookboard.view.TextViewVertical;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GeneralViewFragment extends BaseFragment {

    private List<GeneralViewBean> beanDynamicList = new ArrayList<>();
    private List<GeneralViewBean> beanNurseList = new ArrayList<>();
    private GeneralViewBean beanNurse;
    private GeneralViewBean beanDynamic;
    private GeneralViewApadter adapterNurse;
    private GeneralViewApadter apadterDynamic;

    String[] titles = {"留置导尿", "氧气吸入",
            "会阴护理", "胃肠减压", "雾化吸入", "口腔护理", "辅助排痰", "腹腔引流", "深V置管", "盆腔闭式引流", "T管引流", "颈前引流",
            "腋窝引流", "擦浴", "温室孔引流", "翻身", "计24小时尿量", "造口护理", "胸带固定", "多重耐药菌", "基础代谢率", "观察血运", "神志瞳孔",
            "跌倒/坠床高风险", "口服药(带)", "压疮高风险", "切口沙袋压迫", "禁食", "流质", "糖尿病饮食", "半流质", "普食", "软食", "低盐饮食",
            "低脂饮食", "低蛋白饮食"};

    String[] Dynamics = {"现住", "今日入住", "今日出院", "病危", "病重", "今日手术", "明日手术", "I级护理", "II级护理", "III级护理", "今日输血", "心电监测",};


    //    @BindView(R.id.rv_nurse)
//    RecyclerView rvNurse;
//    @BindView(R.id.srl_nurse)
//    SwipeRefreshLayout srlNurse;
//
//    @BindView(R.id.rv_dynamic)
//    RecyclerView rvDynamic;
    @BindView(R.id.tv_statistics)
    TextViewVertical tvStatistice;
    @BindView(R.id.tv_bed)
    TextViewVertical tvBed;
    @BindView(R.id.tv_nursing)
    TextViewVertical tvNursing;
    @BindView(R.id.tv_call)
    TextViewVertical tvCall;

    public static GeneralViewFragment newInstance() {
        GeneralViewFragment generalViewFragment = new GeneralViewFragment();
        return generalViewFragment;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_generalview;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void initView(Bundle bundle) {
        tvBed.setText("床位信息");
        tvNursing.setText("护理信息");
        tvStatistice.setText("统计信息");
        tvCall.setText("呼叫信息");


//        initNurseDate();
//        adapterNurse = new GeneralViewApadter(beanNurseList,getSupportActivity());
//        rvNurse.setLayoutManager(new LinearLayoutManager(getSupportActivity()));
//        rvNurse.setAdapter(adapterNurse);
//        srlNurse.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                beanNurseList.clear();
//                initNurseDate();
//                adapterNurse.notifyDataSetChanged();
//                srlNurse.setRefreshing(false);
//            }
//        });
//
//        initDyanmicDate();
//        apadterDynamic = new GeneralViewApadter(beanDynamicList,getSupportActivity());
//        rvDynamic.setLayoutManager(new LinearLayoutManager(getSupportActivity()));
//        rvDynamic.setAdapter(apadterDynamic);
//        srlDyanmic.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                beanDynamicList.clear();
//                initDyanmicDate();
//                apadterDynamic.notifyDataSetChanged();
//                srlDyanmic.setRefreshing(false);
//            }
//        });

    }

    private void initDyanmicDate() {

        for (int i = 0; i < Dynamics.length; i++) {
            beanDynamic = new GeneralViewBean();
            beanDynamic.setTitle(Dynamics[i]);
            beanDynamic.setCountNo(String.valueOf((int) (Math.random() * 10 + 1)));
            List<GeneralViewBean.GeneralViewBeanChildren> childrenList = new ArrayList<>();
            for (int n = 0; n < (int) (Math.random() * 10 + 1); n++) {
                GeneralViewBean.GeneralViewBeanChildren children = new GeneralViewBean.GeneralViewBeanChildren();
                children.setBeadNo(String.valueOf((int) (Math.random() * 50)));
                childrenList.add(children);
            }
            beanDynamic.setGeneralViewBeanChildren(childrenList);
            beanDynamicList.add(beanDynamic);
        }
    }

    private void initNurseDate() {

        for (int i = 0; i < titles.length; i++) {
            beanNurse = new GeneralViewBean();
            beanNurse.setTitle(titles[i]);
            beanNurse.setCountNo(String.valueOf((int) (Math.random() * 10 + 1)));
            List<GeneralViewBean.GeneralViewBeanChildren> childrenList = new ArrayList<>();
            for (int n = 0; n < (int) (Math.random() * 10 + 1); n++) {
                GeneralViewBean.GeneralViewBeanChildren children = new GeneralViewBean.GeneralViewBeanChildren();
                children.setBeadNo(String.valueOf((int) (Math.random() * 50)));
                childrenList.add(children);
            }
            beanNurse.setGeneralViewBeanChildren(childrenList);
            beanNurseList.add(beanNurse);
        }
    }

}
