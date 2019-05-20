package mvp.com.zhou.mvp.view;


import java.util.List;

import mvp.com.zhou.mvp.utils.callback.CallBackPositionListener;
import mvp.com.zhou.mvp.view.base.BaseActivityView;


/**
 * @Auther: test
 * @Date: 2018/7/27 16:28
 * @Description:
 */
public interface LoginView extends BaseActivityView {

    /**
     * 初始化登陆信息
     *
     * @param user
     * @param pass
     */
    void initLoginInfo(String user, String pass);

    /**
     *
     */
    void gotoMainAct();

    /**
     * 获取用户名
     */
    String getUser();

    /**
     * 获取密码
     */
    String getPassWord();

    void showSelectDialog(List<String> list, CallBackPositionListener listener);
}
