package mvp.com.zhou.mvp.ui.presenter;

import mvp.com.zhou.mvp.ui.model.InfoModel;
import mvp.com.zhou.mvp.ui.model.InfoModelImpl;
import mvp.com.zhou.mvp.ui.presenter.base.BasePresenterImpl;
import mvp.com.zhou.mvp.ui.view.InfoView;

public class InfoPresenterImpl extends BasePresenterImpl<InfoView, InfoModel> {
    @Override
    public void initData() {

    }

    @Override
    public InfoModel initModel() {
        return new InfoModelImpl();
    }
}
