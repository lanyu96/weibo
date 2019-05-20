package mvp.com.zhou.mvp.presenter;

import mvp.com.zhou.mvp.model.RegisterModel;
import mvp.com.zhou.mvp.model.RegisterModelImpl;
import mvp.com.zhou.mvp.presenter.base.BasePresenterImpl;
import mvp.com.zhou.mvp.view.RegisterView;

public class RegisterPresenterImpl extends BasePresenterImpl<RegisterView, RegisterModel> {
    @Override
    public void initData() {

    }

    @Override
    public RegisterModel initModel() {
        return new RegisterModelImpl();
    }
}
