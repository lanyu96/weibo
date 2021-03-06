package mvp.com.zhou.mvp.model;


import mvp.com.zhou.mvp.utils.bean.PigFarmInfo;
import mvp.com.zhou.mvp.utils.bean.PigFieldInfo;
import mvp.com.zhou.mvp.utils.callback.CallBackListListener;
import mvp.com.zhou.mvp.model.base.BaseModel;
import mvp.com.zhou.mvp.view.base.BaseActivityView;

/**
 * @Auther: test
 * @Date: 2018/7/27 15:50
 * @Description:
 */
public interface LoginModel extends BaseModel {
    void login(BaseActivityView context, String user, String pass, CallBackListListener<PigFarmInfo> listener);
   //void get(String user, String pass, CallBackListener<PigFarmInfo> listener);
    void keepFarmInfo(String farmName, String farmId);

    //获取分厂信息
    void getFieldInfoFromNet(BaseActivityView context, final CallBackListListener<PigFieldInfo> listener);

    void keepFieldInfo(String name, String id, String fq2pz);
}
