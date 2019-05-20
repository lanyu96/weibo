package mvp.com.zhou.mvp.model.main;


import android.content.Context;

import java.util.List;

import mvp.com.zhou.mvp.utils.callback.CallBackListListener;
import mvp.com.zhou.mvp.model.base.BaseModel;


/**
 * @Auther: test
 * @Date: 2018/7/27 15:34
 * @Description:
 */
public interface MainHomeModel extends BaseModel {

    void addProductTableData(Context context, CallBackListListener<List> listener);
}
