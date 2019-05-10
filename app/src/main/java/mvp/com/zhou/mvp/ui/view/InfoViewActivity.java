package mvp.com.zhou.mvp.ui.view;

import android.view.View;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.ui.presenter.InfoPresenterImpl;
import mvp.com.zhou.mvp.ui.view.base.BaseActivity;

public class InfoViewActivity extends BaseActivity<InfoPresenterImpl> {
    @Override
    public InfoPresenterImpl initPresent() {
        return new InfoPresenterImpl();
    }

    @Override
    public void initView() {
        setContentView(R.layout.act_info);
    }

    @Override
    public String setTitleText() {
        return "个人信息";
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onMyClick(View v) {

    }
}
