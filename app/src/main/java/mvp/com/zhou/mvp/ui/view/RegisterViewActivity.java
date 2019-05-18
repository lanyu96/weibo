package mvp.com.zhou.mvp.ui.view;

import android.view.View;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.ui.presenter.RegisterPresenterImpl;
import mvp.com.zhou.mvp.ui.view.base.BaseActivity;

public class RegisterViewActivity extends BaseActivity<RegisterPresenterImpl> implements RegisterView {
    @Override
    public RegisterPresenterImpl initPresent() {
        return new RegisterPresenterImpl();
    }

    @Override
    public void initView() {
        setContentView(R.layout.act_register);
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
