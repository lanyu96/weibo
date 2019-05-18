package mvp.com.zhou.mvp.ui.presenter;

import mvp.com.zhou.mvp.ui.model.RegisterModel;
import mvp.com.zhou.mvp.ui.model.RegisterModelImpl;
import mvp.com.zhou.mvp.ui.presenter.base.BasePresenterImpl;
import mvp.com.zhou.mvp.ui.view.RegisterView;

public class RegisterPresenterImpl extends BasePresenterImpl<RegisterView, RegisterModel> {
    @Override
    public void initData() {

    }

    @Override
    public RegisterModel initModel() {
        return new RegisterModelImpl();
    }
}
