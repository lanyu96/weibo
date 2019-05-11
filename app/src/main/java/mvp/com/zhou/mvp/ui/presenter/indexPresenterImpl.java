package mvp.com.zhou.mvp.ui.presenter;

import mvp.com.zhou.mvp.ui.model.indexModel;
import mvp.com.zhou.mvp.ui.model.indexModelImpl;
import mvp.com.zhou.mvp.ui.presenter.base.BasePresenterImpl;
import mvp.com.zhou.mvp.ui.view.indexView;

public class indexPresenterImpl extends BasePresenterImpl<indexView, indexModel> {

    @Override
    public void initData() {

    }

    @Override
    public indexModel initModel() {
        return new indexModelImpl();
    }
}
