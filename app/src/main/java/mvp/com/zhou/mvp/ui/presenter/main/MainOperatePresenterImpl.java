package mvp.com.zhou.mvp.ui.presenter.main;


import java.util.ArrayList;
import java.util.List;

import mvp.com.zhou.mvp.database.HDBUtils;
import mvp.com.zhou.mvp.ui.bean.MainFunction;
import mvp.com.zhou.mvp.ui.bean.weibo.JVBean;
import mvp.com.zhou.mvp.ui.model.main.MainOperateModel;
import mvp.com.zhou.mvp.ui.model.main.MainOperateModelImpl;
import mvp.com.zhou.mvp.ui.presenter.base.BasePresenterImpl;
import mvp.com.zhou.mvp.ui.view.main.MainOperateView;

/**
 * @Auther: test
 * @Date: 2018/7/27 15:27
 * @Description:
 */
public class MainOperatePresenterImpl extends BasePresenterImpl<MainOperateView, MainOperateModel> {
    private List<MainFunction> mList;

    @Override
    public void initData() {
        mList = new ArrayList<>();
    }

    @Override
    public MainOperateModel initModel() {
        return new MainOperateModelImpl();
    }

    //将功能填入
    public List<MainFunction> getFunction() {
        if (mList.size() == 0) {
            mModel.addFunction(mList, getView().getContext());
        }
        return mList;
    }

    public void initHuangInfoData() {
//        HDBUtils hdbUtils = new HDBUtils(getView().getContext());
//        List<JVBean> list = mModel.initInfoData();
//        for (int i = 0; i < list.size(); i++) {
//            JVBean bean = list.get(i);
//
//        }

    }

}
