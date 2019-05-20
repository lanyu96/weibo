package mvp.com.zhou.mvp.presenter;

import mvp.com.zhou.mvp.model.indexModel;
import mvp.com.zhou.mvp.model.indexModelImpl;
import mvp.com.zhou.mvp.presenter.base.BasePresenterImpl;
import mvp.com.zhou.mvp.view.indexView;

public class indexPresenterImpl extends BasePresenterImpl<indexView, indexModel> {

    @Override
    public void initData() {

    }

    @Override
    public indexModel initModel() {
        return new indexModelImpl();
    }
}
