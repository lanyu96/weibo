package mvp.com.zhou.mvp.model.main;


import android.content.Context;

import java.util.List;

import mvp.com.zhou.mvp.utils.bean.MainFunction;
import mvp.com.zhou.mvp.model.base.BaseModel;


/**
 * @Auther: test
 * @Date: 2018/7/27 15:34
 * @Description:
 */
public interface MainOperateModel extends BaseModel {

    void addFunction(List<MainFunction> mList, Context context);


//    List<JVBean> initInfoData();
}
