package mvp.com.zhou.mvp.ui.view;

import android.view.View;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.ui.presenter.indexPresenterImpl;
import mvp.com.zhou.mvp.ui.view.base.BaseActivity;

public class indexViewActivity extends BaseActivity<indexPresenterImpl> implements indexView {
    @Override
    public indexPresenterImpl initPresent() {
        return new indexPresenterImpl();
    }

    @Override
    public void initView() {
        setContentView(R.layout.act_index_web);
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
