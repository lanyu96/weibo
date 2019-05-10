package mvp.com.zhou.mvp.ui.model.main;


import android.content.Context;

import java.util.List;

import mvp.com.zhou.mvp.ui.callback.CallBackListListener;
import mvp.com.zhou.mvp.ui.model.base.BaseModel;


/**
 * @Auther: test
 * @Date: 2018/7/27 15:34
 * @Description:
 */
public interface MainHomeModel extends BaseModel {

    void addProductTableData(Context context, CallBackListListener<List> listener);
}
