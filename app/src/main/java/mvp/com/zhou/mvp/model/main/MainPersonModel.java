package mvp.com.zhou.mvp.model.main;


import mvp.com.zhou.mvp.utils.bean.PigFarmInfo;
import mvp.com.zhou.mvp.utils.bean.PigFieldInfo;
import mvp.com.zhou.mvp.utils.callback.CallBackListListener;
import mvp.com.zhou.mvp.model.base.BaseModel;
import mvp.com.zhou.mvp.view.base.BaseView;

/**
 * @Auther: test
 * @Date: 2018/7/27 15:34
 * @Description:
 */
public interface MainPersonModel extends BaseModel {
    void getFarmInfoFromNet(BaseView view, CallBackListListener<PigFarmInfo> listListener);

    void getFieldInfoFromNet(BaseView view, CallBackListListener<PigFieldInfo> listListener);

    void keepFarmInfo(String farmName, String farmId);

    void keepFieldInfo(String name, String id, String fq2pz);
}
