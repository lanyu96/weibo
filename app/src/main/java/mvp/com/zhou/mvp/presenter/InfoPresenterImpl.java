package mvp.com.zhou.mvp.presenter;

import mvp.com.zhou.mvp.model.InfoModel;
import mvp.com.zhou.mvp.model.InfoModelImpl;
import mvp.com.zhou.mvp.presenter.base.BasePresenterImpl;
import mvp.com.zhou.mvp.view.InfoView;

public class InfoPresenterImpl extends BasePresenterImpl<InfoView, InfoModel> {
    @Override
    public void initData() {

    }

    @Override
    public InfoModel initModel() {
        return new InfoModelImpl();
    }
}
