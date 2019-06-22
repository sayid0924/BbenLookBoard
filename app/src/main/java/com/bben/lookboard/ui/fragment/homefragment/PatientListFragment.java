package com.bben.lookboard.ui.fragment.homefragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseApplication;
import com.bben.lookboard.base.BaseFragment;
import com.bben.lookboard.base.Constant;
import com.bben.lookboard.bean.PatientListBean;
import com.bben.lookboard.bean.SettingEvenBus;
import com.bben.lookboard.presenter.contract.fragment.PatientListContract;
import com.bben.lookboard.presenter.impl.fragment.PatientListFragmentPresenter;
import com.bben.lookboard.ui.adapter.PatientListApadter;
import com.bben.lookboard.utils.PreferUtil;
import com.bben.lookboard.view.SpacesItemDecoration;
import com.blankj.utilcode.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

public class PatientListFragment extends BaseFragment implements PatientListContract.View {

    private List<PatientListBean.DataBean> patientListAll = new ArrayList<>();
    private List<PatientListBean.DataBean> patientListDanger = new ArrayList<>();
    private List<PatientListBean.DataBean> patientListPeril = new ArrayList<>();
    private List<PatientListBean.DataBean> patientListSuper = new ArrayList<>();
    private List<PatientListBean.DataBean> patientListOne = new ArrayList<>();
    private List<PatientListBean.DataBean> patientListTwo = new ArrayList<>();
    private List<PatientListBean.DataBean> patientListThree = new ArrayList<>();
    private List<PatientListBean.DataBean> patientListEmpty = new ArrayList<>();
    private List<PatientListBean.DataBean> patientListPresent = new ArrayList<>();
    private List<PatientListBean.DataBean> patientListHospitalized = new ArrayList<>();
    private List<PatientListBean.DataBean> patientListOperation = new ArrayList<>();

    private PatientListApadter apadter;
    private PatientListFragmentPresenter presenter = new PatientListFragmentPresenter();
    private ScheduledFuture scheduledFuture;
    private boolean isAuto;


    @BindView(R.id.title_list)
    RecyclerView rvTitle;
    @BindView(R.id.rl_all)
    RelativeLayout rlAll;

    @BindView(R.id.rl_danger)
    RelativeLayout rlDanger;
    @BindView(R.id.rl_peril)
    RelativeLayout rlPeril;
    @BindView(R.id.rl_super)
    RelativeLayout rlSuper;
    @BindView(R.id.rl_one)
    RelativeLayout rlOne;
    @BindView(R.id.rl_two)
    RelativeLayout rlTwo;
    @BindView(R.id.rl_three)
    RelativeLayout rlThree;
    @BindView(R.id.rl_empty)
    RelativeLayout rlEmpty;
    @BindView(R.id.rl_present)
    RelativeLayout rlPresent;
    @BindView(R.id.rl_hospitalized)
    RelativeLayout rlHospitalized;
    @BindView(R.id.rl_operation)
    RelativeLayout rlOperation;
    @BindView(R.id.rl_adjust)
    RelativeLayout rlAdjust;
    @BindView(R.id.ll_sb)
    RelativeLayout llSb;
    @BindView(R.id.rl_autoscroll)
    RelativeLayout rlAutoScroll;

    @BindView(R.id.tv_message_all)
    TextView tvMessageAll;
    @BindView(R.id.tv_ms_danger)
    TextView tvMessageDanger;
    @BindView(R.id.tv_message_perill)
    TextView tvMessagePerill;
    @BindView(R.id.tv_message_super)
    TextView tvMessageSuper;
    @BindView(R.id.tv_message_one)
    TextView tvMessageOne;
    @BindView(R.id.tv_message_two)
    TextView tvMessageTwo;
    @BindView(R.id.tv_message_three)
    TextView tvMessageThree;
    @BindView(R.id.tv_message_empty)
    TextView tvMessageEmpty;
    @BindView(R.id.tv_message_present)
    TextView tvMessagePresent;
    @BindView(R.id.tv_message_hospitalized)
    TextView tvMessageHospitalized;
    @BindView(R.id.tv_message_operation)
    TextView tvMessageOperation;
    @BindView(R.id.tv_item_value)
    TextView tvItemValue;
    @BindView(R.id.tv_item_spacing_value)
    TextView tvItemSpacing_Value;
    @BindView(R.id.tv_typeface_value)
    TextView tvTypefaceValue;
    @BindView(R.id.tv_width_value)
    TextView tvWidthValue;
    @BindView(R.id.tv_hight_value)
    TextView tvHightValue;
    @BindView(R.id.tv_auto_scroll)
    TextView tvAutoScroll;
    @BindView(R.id.iv_item_cut)
    ImageView ivCut;
    @BindView(R.id.iv_item_add)
    ImageView ivAdd;
    @BindView(R.id.iv_item_spacing_cut)
    ImageView ivItemSpacing_Cut;
    @BindView(R.id.iv_item_spacing_add)
    ImageView ivItemSpacing_Add;
    @BindView(R.id.iv_typeface_add)
    ImageView ivTypefaceAdd;
    @BindView(R.id.iv_typeface_cut)
    ImageView ivTypefaceCut;
    @BindView(R.id.iv_width_cut)
    ImageView ivWidthCut;
    @BindView(R.id.iv_width_add)
    ImageView ivWidthAdd;
    @BindView(R.id.iv_hight_add)
    ImageView ivHightAdd;
    @BindView(R.id.iv_hight_cut)
    ImageView ivHightCut;


    public static PatientListFragment newInstance() {
        PatientListFragment patientListFragment = new PatientListFragment();
        return patientListFragment;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_beadinfo;
    }

    @Override
    public void attachView() {
        presenter.attachView(this);
    }

    @Override
    protected void initView(Bundle bundle) {
        EventBus.getDefault().register(this);
        FetchPatientList();

        apadter = new PatientListApadter(patientListAll, getSupportActivity());

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(PreferUtil.getInstance().getWidthValue(), PreferUtil.getInstance().getHightValue());
        apadter.setLayoutParams(params);
        apadter.setTextSize(PreferUtil.getInstance().getTypefaceNameValue(), PreferUtil.getInstance().getTypefaceValue(),PreferUtil.getInstance().getInfusionTypefaceValue());
        apadter.setItemSize(Integer.MAX_VALUE);
        rvTitle.addItemDecoration(new SpacesItemDecoration(8));
        rvTitle.setLayoutManager(new GridLayoutManager(getSupportActivity(), PreferUtil.getInstance().getItemValue()));

        scheduledFuture = BaseApplication.MAIN_EXECUTOR.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                isAuto = true;
                rvTitle.smoothScrollBy(0, 10);
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);

        rvTitle.setAdapter(apadter);

        tvItemValue.setText(String.valueOf(PreferUtil.getInstance().getItemValue()));
        tvTypefaceValue.setText(String.valueOf(PreferUtil.getInstance().getTypefaceValue()));
        tvWidthValue.setText(String.valueOf(PreferUtil.getInstance().getWidthValue()));
        tvHightValue.setText(String.valueOf(PreferUtil.getInstance().getHightValue()));
        tvItemSpacing_Value.setText(String.valueOf(PreferUtil.getInstance().getItemSpacingValue()));

    }

    public void FetchPatientList() {
        presenter.FetchPatientList(getString(R.string.deptCode), PreferUtil.getInstance().getDeptCode());
        showWaitingDialog(getString(R.string.Loading));
    }

    @Subscribe
    public void getEventBus(SettingEvenBus settingEvenBus) {
        FetchPatientList();
    }

    @Override
    public void FetchPatientListSuccess(PatientListBean patientListBean) {
        hideWaitingDialog();
        initData(patientListBean);
    }

    @Override
    public void showError(String message) {
        hideWaitingDialog();
        ToastUtils.showLongToast(message);
    }

    public void initData(PatientListBean patientListBean) {
        this.patientListAll = patientListBean.getData();
        apadter.setNewData(patientListBean.getData());
        apadter.notifyDataSetChanged();
        for (int i = 0; i < patientListBean.getData().size(); i++) {
            switch (patientListBean.getData().get(i).getNurseLevelCode()) {
                case "1":
                    // Ⅰ级护理
                    patientListOne.add(patientListBean.getData().get(i));
                    break;
                case "2":
                    // Ⅱ级护理
                    patientListTwo.add(patientListBean.getData().get(i));
                    break;
                case "3":
                    // Ⅲ级护理
                    patientListThree.add(patientListBean.getData().get(i));
                    break;
                case "4":
                    // 重级护理
                    patientListDanger.add(patientListBean.getData().get(i));
                    break;
                case "5":
                    //危级护理
                    patientListPeril.add(patientListBean.getData().get(i));
                    break;
                case "6":
                    //特级护理
                    patientListSuper.add(patientListBean.getData().get(i));
                    break;

            }
        }
        tvMessageAll.setText(String.valueOf(patientListAll.size()));
        tvMessageDanger.setText(String.valueOf(patientListDanger.size()));
        tvMessagePerill.setText(String.valueOf(patientListPeril.size()));
        tvMessageSuper.setText(String.valueOf(patientListSuper.size()));
        tvMessageOne.setText(String.valueOf(patientListOne.size()));
        tvMessageTwo.setText(String.valueOf(patientListTwo.size()));
        tvMessageThree.setText(String.valueOf(patientListThree.size()));
        tvMessageEmpty.setText(String.valueOf(patientListEmpty.size()));
        tvMessagePresent.setText(String.valueOf(patientListPresent.size()));
        tvMessageOperation.setText(String.valueOf(patientListOperation.size()));
        tvMessageHospitalized.setText(String.valueOf(patientListHospitalized.size()));
    }

    @OnClick({R.id.rl_all, R.id.rl_danger, R.id.rl_peril, R.id.rl_super, R.id.rl_one, R.id.rl_two, R.id.rl_three, R.id.rl_empty,
            R.id.rl_present, R.id.rl_hospitalized, R.id.rl_operation, R.id.rl_adjust, R.id.iv_item_add, R.id.iv_item_cut, R.id.iv_typeface_add,
            R.id.iv_typeface_cut, R.id.iv_width_add, R.id.iv_width_cut, R.id.iv_hight_add, R.id.iv_hight_cut, R.id.rl_autoscroll, R.id.iv_item_spacing_add,
            R.id.iv_item_spacing_cut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_all:
                apadter.setNewData(patientListAll);
                apadter.setItemSize(Integer.MAX_VALUE);
                apadter.notifyDataSetChanged();
                scheduledFuture = BaseApplication.MAIN_EXECUTOR.scheduleWithFixedDelay(new Runnable() {
                    @Override
                    public void run() {
                        isAuto = true;
                        rvTitle.smoothScrollBy(0, 10);
                    }
                }, 1000, 1000, TimeUnit.MILLISECONDS);
                tvAutoScroll.setText(R.string.stop_rolling);
                break;
            case R.id.rl_danger:
                scheduledFuture.cancel(false);
                isAuto = false;
                apadter.setItemSize(patientListDanger.size());
                apadter.setNewData(patientListDanger);
                apadter.notifyDataSetChanged();
                break;
            case R.id.rl_peril:
                apadter.setNewData(patientListPeril);
                scheduledFuture.cancel(false);
                isAuto = false;
                apadter.setItemSize(patientListPeril.size());
                apadter.notifyDataSetChanged();
                break;
            case R.id.rl_super:
                apadter.setNewData(patientListSuper);
                scheduledFuture.cancel(false);
                isAuto = false;
                apadter.setItemSize(patientListSuper.size());
                apadter.notifyDataSetChanged();
                break;
            case R.id.rl_one:
                apadter.setNewData(patientListOne);
                scheduledFuture.cancel(false);
                isAuto = false;
                apadter.setItemSize(patientListOne.size());
                apadter.notifyDataSetChanged();
                break;
            case R.id.rl_two:
                apadter.setNewData(patientListTwo);
                scheduledFuture.cancel(false);
                isAuto = false;
                apadter.setItemSize(patientListTwo.size());
                apadter.notifyDataSetChanged();
                break;
            case R.id.rl_three:
                apadter.setNewData(patientListThree);
                scheduledFuture.cancel(false);
                isAuto = false;
                apadter.setItemSize(patientListThree.size());
                apadter.notifyDataSetChanged();
                break;
            case R.id.rl_empty:
                apadter.setNewData(patientListEmpty);
                scheduledFuture.cancel(false);
                isAuto = false;
                apadter.setItemSize(patientListEmpty.size());
                apadter.notifyDataSetChanged();
                break;
            case R.id.rl_present:
                apadter.setNewData(patientListPresent);
                scheduledFuture.cancel(false);
                isAuto = false;
                apadter.setItemSize(patientListPresent.size());
                apadter.notifyDataSetChanged();
                break;
            case R.id.rl_hospitalized:
                apadter.setNewData(patientListHospitalized);
                scheduledFuture.cancel(false);
                isAuto = false;
                apadter.setItemSize(patientListHospitalized.size());
                apadter.notifyDataSetChanged();
                break;
            case R.id.rl_operation:
                apadter.setNewData(patientListOperation);
                scheduledFuture.cancel(false);
                isAuto = false;
                apadter.setItemSize(patientListOperation.size());
                apadter.notifyDataSetChanged();
                break;
            case R.id.rl_adjust:
                if (llSb.getVisibility() == View.VISIBLE) {
                    llSb.setVisibility(View.GONE);
                } else {
                    llSb.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.iv_item_add:
                int itemValue = PreferUtil.getInstance().getItemValue();
                int addV = ++itemValue;
                rvTitle.setLayoutManager(new GridLayoutManager(getSupportActivity(), addV));
                apadter.notifyDataSetChanged();
                tvItemValue.setText(String.valueOf(addV));
                PreferUtil.getInstance().setItemValue(addV);
                break;
            case R.id.iv_item_cut:
                int cutItemValue = PreferUtil.getInstance().getItemValue();
                int cutV = --cutItemValue;
                rvTitle.setLayoutManager(new GridLayoutManager(getSupportActivity(), cutV));
                apadter.notifyDataSetChanged();
                tvItemValue.setText(String.valueOf(cutV));
                PreferUtil.getInstance().setItemValue(cutV);
                break;

//            case R.id.iv_item_spacing_add:
//                int itemSpacingAddValue = PreferUtil.getInstance().getItemSpacingValue();
//                int addS = ++ itemSpacingAddValue;
//                rvTitle.addItemDecoration(new SpacesItemDecoration(addS));
//                apadter.notifyDataSetChanged();
//                tvItemSpacing_Value.setText(String.valueOf(addS));
//                PreferUtil.getInstance().setItemSpacingValue(addS);
//                break;
//
//            case R.id.iv_item_spacing_cut:
//                int itemSpacingCutValue = PreferUtil.getInstance().getItemSpacingValue();
//                int cutS = -- itemSpacingCutValue;
//                rvTitle.addItemDecoration(new SpacesItemDecoration(cutS));
//                apadter.notifyDataSetChanged();
//                tvItemSpacing_Value.setText(String.valueOf(cutS));
//                PreferUtil.getInstance().setItemSpacingValue(cutS);
//                break;

            case R.id.iv_typeface_add:

                int addTypecfaceValue = PreferUtil.getInstance().getTypefaceValue();
                int addNameTypefaceValuie = PreferUtil.getInstance().getTypefaceNameValue();
                int addInfusionTypefaceValue = PreferUtil.getInstance().getInfusionTypefaceValue();
                int addN = ++addNameTypefaceValuie;
                int addT = ++addTypecfaceValue;
                int addI = ++addInfusionTypefaceValue;
                apadter.setTextSize(addN, addT,addI);
                apadter.notifyDataSetChanged();
                tvTypefaceValue.setText(String.valueOf(addT));
                PreferUtil.getInstance().setTypefaceValue(addT);
                PreferUtil.getInstance().setTypefaceNmeValue(addN);
                PreferUtil.getInstance().setInfusionTypefaceValue(addI);
                break;

            case R.id.iv_typeface_cut:

                int cutTypecfaceValue = PreferUtil.getInstance().getTypefaceValue();
                int cutNameTypefaceValue = PreferUtil.getInstance().getTypefaceNameValue();
                int cutInfusionTypefaceValue = PreferUtil.getInstance().getInfusionTypefaceValue();
                int cutN = --cutNameTypefaceValue;
                int cutT = --cutTypecfaceValue;
                int cutI = --cutInfusionTypefaceValue;
                apadter.setTextSize(cutN, cutT,cutI);
                apadter.notifyDataSetChanged();
                tvTypefaceValue.setText(String.valueOf(cutT));
                PreferUtil.getInstance().setTypefaceValue(cutT);
                PreferUtil.getInstance().setTypefaceNmeValue(cutN);
                PreferUtil.getInstance().setInfusionTypefaceValue(cutI);

                break;

            case R.id.iv_width_add:

                int addWidthValue = PreferUtil.getInstance().getWidthValue();
                int addW = ++addWidthValue;
                ViewGroup.LayoutParams addWParams = new ViewGroup.LayoutParams(addW, PreferUtil.getInstance().getHightValue());
                apadter.setLayoutParams(addWParams);
                apadter.notifyDataSetChanged();
                PreferUtil.getInstance().setWidthValue(addW);
                tvWidthValue.setText(String.valueOf(addW));
                break;

            case R.id.iv_width_cut:
                int cutWidthValue = PreferUtil.getInstance().getWidthValue();
                int cutW = --cutWidthValue;
                ViewGroup.LayoutParams cutWParams = new ViewGroup.LayoutParams(cutW, PreferUtil.getInstance().getHightValue());
                apadter.setLayoutParams(cutWParams);
                apadter.notifyDataSetChanged();
                PreferUtil.getInstance().setWidthValue(cutW);
                tvWidthValue.setText(String.valueOf(cutW));
                break;

            case R.id.iv_hight_add:
                int addHightValue = PreferUtil.getInstance().getHightValue();
                int addH = ++addHightValue;
                ViewGroup.LayoutParams addHParams = new ViewGroup.LayoutParams(PreferUtil.getInstance().getWidthValue(), addH);
                apadter.setLayoutParams(addHParams);
                apadter.notifyDataSetChanged();
                PreferUtil.getInstance().setHightValue(addH);
                tvHightValue.setText(String.valueOf(addH));
                break;

            case R.id.iv_hight_cut:
                int cutHightValue = PreferUtil.getInstance().getHightValue();
                int cutH = --cutHightValue;
                ViewGroup.LayoutParams cutHParams = new ViewGroup.LayoutParams(PreferUtil.getInstance().getWidthValue(), cutH);
                apadter.setLayoutParams(cutHParams);
                apadter.notifyDataSetChanged();
                PreferUtil.getInstance().setHightValue(cutH);
                tvHightValue.setText(String.valueOf(cutH));
                break;

            case R.id.rl_autoscroll:
                if (isAuto) {
                    scheduledFuture.cancel(false);
                    isAuto = false;
                    apadter.setItemSize(patientListAll.size());
                    apadter.notifyDataSetChanged();
                    tvAutoScroll.setText(R.string.start_rolling);
                } else {
                    apadter.setItemSize(Integer.MAX_VALUE);
                    apadter.notifyDataSetChanged();
                    scheduledFuture = BaseApplication.MAIN_EXECUTOR.scheduleWithFixedDelay(new Runnable() {
                        @Override
                        public void run() {
                            isAuto = true;
                            rvTitle.smoothScrollBy(0, 10);
                        }
                    }, 1000, 1000, TimeUnit.MILLISECONDS);
                    tvAutoScroll.setText(getString(R.string.stop_rolling));
                }
                break;
        }
    }
}
