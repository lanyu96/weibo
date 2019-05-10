package mvp.com.zhou.mvp.ui.presenter;

import android.arch.lifecycle.LifecycleOwner;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import mvp.com.zhou.mvp.MyApp;
import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.constant.SPConstants;
import mvp.com.zhou.mvp.httputil.RetrofitManager;
import mvp.com.zhou.mvp.ui.bean.PigFarmInfo;
import mvp.com.zhou.mvp.ui.bean.PigFieldInfo;
import mvp.com.zhou.mvp.ui.callback.CallBackListListener;
import mvp.com.zhou.mvp.ui.callback.CallBackPositionListener;
import mvp.com.zhou.mvp.ui.dialog.DialogUtils;
import mvp.com.zhou.mvp.ui.model.LoginModel;
import mvp.com.zhou.mvp.ui.model.LoginModelImpl;
import mvp.com.zhou.mvp.ui.presenter.base.BasePresenterImpl;
import mvp.com.zhou.mvp.ui.view.LoginView;


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


