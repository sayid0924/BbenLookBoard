package com.bben.lookboard.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bben.lookboard.R;
import com.bben.lookboard.view.LoadingPage;
import com.bben.lookboard.view.dialog.CustomDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/11/4 0004.
 */

public abstract class BaseFragment extends Fragment implements Stateful {


    public LoadingPage mLoadingPage;
    protected FragmentActivity activity;
    protected View contentView;
    private boolean mIsVisible = false;     // fragment是否显示了
    private boolean isPrepared = false;
    private boolean isFirst = true; //只加载一次界面
    private Unbinder bind;
    private CustomDialog mDialogWaiting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        if (mLoadingPage == null) {
            mLoadingPage = new LoadingPage(getContext()) {
                @Override
                protected void initView() {
                    if (isFirst) {
                        BaseFragment.this.contentView = this.contentView;
                        bind = ButterKnife.bind(BaseFragment.this, contentView);
                        BaseFragment.this.initView(getArguments());
                        isFirst = false;
                    }
                }

                @Override
                protected void loadData() {
                    BaseFragment.this.loadData();
                }

                @Override
                protected int getLayoutId() {
                    return BaseFragment.this.getLayoutResId();
                }
            };
        }
        isPrepared = true;
        loadBaseData();
        return mLoadingPage;
    }


    @Override
    public void setState(int state) {
        mLoadingPage.state = state;
        mLoadingPage.showPage();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {//fragment可见
            mIsVisible = true;
            onVisible();
        } else {//fragment不可见
            mIsVisible = false;
        }
    }

    /**
     * 显示等待提示框
     */
    public Dialog showWaitingDialog(String tip) {
        hideWaitingDialog();
        View view = View.inflate(getSupportActivity(), R.layout.dialog_waiting, null);
        if (!TextUtils.isEmpty(tip))
            ((TextView) view.findViewById(R.id.tvTip)).setText(tip);
        mDialogWaiting = new CustomDialog(getSupportActivity(), view, R.style.MyDialog);
        mDialogWaiting.show();
        mDialogWaiting.setCancelable(true);
        return mDialogWaiting;
    }


    /**
     * 隐藏等待提示框
     */
    public void hideWaitingDialog() {
        if (mDialogWaiting != null) {
            mDialogWaiting.dismiss();
            mDialogWaiting = null;
        }
    }


    /**
     * 显示时加载数据,需要这样的使用
     * 注意声明 isPrepared，先初始化
     * 生命周期会先执行 setUserVisibleHint 再执行onActivityCreated
     * 在 onActivityCreated 之后第一次显示加载数据，只加载一次
     */

    protected void onVisible() {
        if (isFirst) {
//            setupActivityComponent(BaseApplication.getBaseApplication().getAppComponent());
            attachView();
        }
        loadBaseData();//根据获取的数据来调用showView()切换界面
    }

    public void loadBaseData() {
        if (!mIsVisible || !isPrepared || !isFirst) {
            return;
        }
        loadData();

    }

    public abstract void loadData();

    public abstract int getLayoutResId();

    public abstract void attachView();

    protected void initView(Bundle bundle) {
    }

//    protected abstract void setupActivityComponent(AppComponent appComponent);

    public FragmentActivity getSupportActivity() {
        return super.getActivity();
    }

}
