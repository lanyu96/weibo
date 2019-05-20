package mvp.com.zhou.mvp.presenter;

import android.arch.lifecycle.LifecycleOwner;

import org.jetbrains.annotations.NotNull;

import mvp.com.zhou.mvp.view.MyApp;
import mvp.com.zhou.mvp.utils.constant.SPConstants;
import mvp.com.zhou.mvp.utils.bean.RetrofitManager;
import mvp.com.zhou.mvp.model.LoginModel;
import mvp.com.zhou.mvp.model.LoginModelImpl;
import mvp.com.zhou.mvp.presenter.base.BasePresenterImpl;
import mvp.com.zhou.mvp.view.LoginView;


/**
 * @Auther: test
 * @Date: 2018/7/27 16:04
 * @Description:
 */
public class LoginPresenterImpl extends BasePresenterImpl<LoginView, LoginModel> {


    @Override
    public void initData() {

    }

    @Override
    public LoginModel initModel() {
        return new LoginModelImpl();
    }


    public void login() {
        //登陆时重置cookie
        RetrofitManager.initCookie();
        final String user;
        user = getView().getUser();

        final String pass = getView().getPassWord();
        if (isEmpty(getView().getUser())) {
            getView().showToast("用户名不能为空");
            return;
        }


    }


    public void initLoginInfo() {
        getView().initLoginInfo(MyApp.getPreferencesService().getValue(SPConstants.LOGIN_USER, ""), MyApp.getPreferencesService().getValue(SPConstants.LOGIN_PASSWORD, ""));
    }

    @Override
    public void onDestroy(@NotNull LifecycleOwner owner) {
        super.onDestroy(owner);
        if (mModel != null) {
            mModel = null;
        }

    }
}


