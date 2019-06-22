package com.bben.lookboard.ui.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseActivity;
import com.bben.lookboard.bean.BedInfoBean;
import com.bben.lookboard.bean.SettingEvenBus;
import com.bben.lookboard.db.database.BedInfoBeanDbDao;
import com.bben.lookboard.db.entity.BedInfoBeanDb;
import com.bben.lookboard.presenter.contract.activity.MainContract;
import com.bben.lookboard.presenter.impl.activity.MainActivityPresenter;
import com.bben.lookboard.service.nettyUtils.NettyService;
import com.bben.lookboard.ui.adapter.PatientInfoApadter;
import com.bben.lookboard.utils.AreaClickListener;
import com.bben.lookboard.utils.GreenDaoUtil;
import com.bben.lookboard.utils.PreferUtil;
import com.blankj.utilcode.utils.EmptyUtils;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainContract.View {

    MainActivityPresenter mPresenter = new MainActivityPresenter();
    public static MainActivity mainActivity = null;
    @BindView(R.id.tv_superN)
    TextView tvSuperN;
    @BindView(R.id.tv_oneN)
    TextView tvOneN;
    @BindView(R.id.tv_twoN)
    TextView tvTwoN;
    @BindView(R.id.tv_notN)
    TextView tvNotN;
    private BedInfoBeanDbDao collectionInfoDao;
    private PatientInfoApadter apadter;
    public BedInfoBean data;
    public BedInfoBean.DataBean.PatientVosBean patientVosBean;
    public List<BedInfoBean.DataBean.PatientVosBean> patientVosBeans;
    String[] levels = {"特级护理", "Ⅰ级护理", "Ⅱ级护理"};

    String[] birthdays = {"30", "25", "65", "32", "55", "23", "42", "32", "47", "46", "22", "33", "66"};
    public String[] names = {"薛庆龄", "邓滨海", "韩丽华", "郑依辰", "叶仁杰", "姜淑珏", "常艳艳", "严清月", "龙凤超", "黎晨龙",
            "闫秋彤", "姜兆阳", "汤佳豪", "温学心", "赖骏之", "孔敬仁", "史有政", "阮轩羽", "安泽楷", "祖少辰",
            "娄宏涛", "年东鹏", "雍同实", "廉洪光", "卓思明", "鲁展博", "江志炫", "冯天骁", "袁浩文", "余菲",
            "袁浩文", "范圆宇", "邱志强", "彭瑞凯", "孙朝阳", "徐水天", "程云起", "朱文会", "高洛奇", "马允泽",
            "何飞妙", "谢松鹏", "吕建佳", "韩佳悦", "高洛奇", "郭子月", "彭俊松", "沈华兰", "习瀚天", "肖志豪"};
    private int superN = 0, oneN = 0, twoN = 0, ontN = 0;

    @BindView(R.id.rl_base_info)
    RecyclerView rlBaseInfo;

    @BindView(R.id.settings_area)
    View settingsArea;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_bedtotal)
    TextView tvBedtotal;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    public void detachView() {
        mPresenter.detachView();
    }

    @Override
    public void initView() {

        setSwipeBackEnable(false);
        if (!PreferUtil.getInstance().getIsFirst()) {
            startActivityIn(new Intent(this, SettingActivity.class), this);
        }
        collectionInfoDao = GreenDaoUtil.getDaoSession().getBedInfoBeanDbDao();
        settingsArea.setOnClickListener(new AreaClickListener(5, 500, new AreaClickListener.ClickEvent() {
            @Override
            public void onEvent() {
                startActivityIn(new Intent(MainActivity.this, SettingActivity.class), MainActivity.this);
            }
        }));

//        mPresenter.bedcardGetbedinfo( true , "wardId", "1");
        mainActivity = this;
//        mPresenter.test("op","GetJson");
//        startService(new Intent().setComponent(new ComponentName("com.bben.lookboard",
//                "com.bben.lookboard.service.SeverSocket")));

        startService(new Intent(this, NettyService.class));
        initApadterDate();

    }

    public void initApadterDate() {
        patientVosBeans = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            patientVosBean = new BedInfoBean.DataBean.PatientVosBean();
            patientVosBean.setBedId(i + 1);
            patientVosBean.setHasMore(true);
            patientVosBean.setName(names[i]);
            patientVosBean.setNurseLevel(levels[(int) (Math.random() * levels.length)]);
            patientVosBean.setAge(birthdays[(int) (Math.random() *
                    birthdays.length)]);
            patientVosBean.setCureNo("CN-" + "1121" + String.valueOf(i));
            patientVosBean.setNurseName("何聪");
            if (i % 2 == 1) {
                patientVosBean.setSex(1);
            } else {
                patientVosBean.setSex(0);
            }

            patientVosBeans.add(patientVosBean);
        }

        ontN = 0;
        superN = 0;
        oneN = 0;
        twoN = 0;
        for (int i = 0; i < patientVosBeans.size(); i++) {
            if (EmptyUtils.isNotEmpty(patientVosBeans.get(i).getNurseLevel())) {
                if (patientVosBeans.get(i).getNurseLevel().contains("特级护理")) {
                    superN++;
                } else if (patientVosBeans.get(i).getNurseLevel().contains("Ⅰ级护理")) {
                    oneN++;
                } else if (patientVosBeans.get(i).getNurseLevel().contains("Ⅱ级护理")) {
                    twoN++;
                }
            } else {
                ontN++;
            }
        }
        tvSuperN.setText(String.valueOf(superN));
        tvOneN.setText(String.valueOf(oneN));
        tvTwoN.setText(String.valueOf(twoN));
        tvNotN.setText(String.valueOf(ontN));

        apadter = new PatientInfoApadter(patientVosBeans
                , this);
        rlBaseInfo.setLayoutManager(new GridLayoutManager(this, 5));
        rlBaseInfo.setAdapter(apadter);

    }


    public void bedcardGetbedinfo() {
        mPresenter.bedcardGetbedinfo(false, "wardId", "1");
    }

    @Override
    protected void initTime(String date, String time) {
        if (tvDate != null)
            tvDate.setText(date);
        if (tvTime != null)
            tvTime.setText(time);
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void bedcardGetbedinfoSuccess(BedInfoBean data) {
        BedInfoBeanDb b = collectionInfoDao.queryBuilder().where(
                BedInfoBeanDbDao.Properties.Id.eq(0)).unique();
        BedInfoBeanDb bedInfoBeanDb = new BedInfoBeanDb();
        if (b != null) {
            bedInfoBeanDb.setId(b.getId());
            bedInfoBeanDb.setBedInfoBean(data);
            collectionInfoDao.update(bedInfoBeanDb);
        } else {
            bedInfoBeanDb.setId(Long.valueOf(0));
            bedInfoBeanDb.setBedInfoBean(data);
            collectionInfoDao.insert(bedInfoBeanDb);
        }
        initData();
    }

    @Subscribe
    public void getEventBus(SettingEvenBus settingEvenBus) {
        mPresenter.bedcardGetbedinfo(true, "wardId", "1");
    }

    private void initData() {

        BedInfoBeanDb infoBeanDb = collectionInfoDao.queryBuilder().where(
                BedInfoBeanDbDao.Properties.Id.eq(0)).unique();
        if (infoBeanDb != null) {
            data = infoBeanDb.getBedInfoBean();
            ontN = 0;
            superN = 0;
            oneN = 0;
            twoN = 0;
            for (int i = 0; i < data.getData().getPatientVos().size(); i++) {
                if (EmptyUtils.isNotEmpty(data.getData().getPatientVos().get(i).getNurseLevel())) {
                    if (data.getData().getPatientVos().get(i).getNurseLevel().contains("特级护理")) {
                        superN++;
                    } else if (data.getData().getPatientVos().get(i).getNurseLevel().contains("Ⅰ级护理")) {
                        oneN++;
                    } else if (data.getData().getPatientVos().get(i).getNurseLevel().contains("Ⅱ级护理")) {
                        twoN++;
                    }
                } else {
                    ontN++;
                }
            }
            tvSuperN.setText(String.valueOf(superN));
            tvOneN.setText(String.valueOf(oneN));
            tvTwoN.setText(String.valueOf(twoN));
            tvNotN.setText(String.valueOf(ontN));
            apadter = new PatientInfoApadter(data.getData().getPatientVos(), this);
            rlBaseInfo.setLayoutManager(new GridLayoutManager(this, 5));
            rlBaseInfo.setAdapter(apadter);
            tvBedtotal.setText(String.valueOf(apadter.getItemCount()));

        }
    }
}
