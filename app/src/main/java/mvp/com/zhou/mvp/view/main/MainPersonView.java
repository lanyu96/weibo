package mvp.com.zhou.mvp.view.main;


import java.util.List;

import mvp.com.zhou.mvp.utils.callback.CallBackPositionListener;
import mvp.com.zhou.mvp.view.base.BaseFragmentView;

/**
 * @Auther: test
 * @Date: 2018/7/27 15:22
 * @Description:
 */
public interface MainPersonView extends BaseFragmentView {

    void showSelectDialog(List<String> list, CallBackPositionListener listener);

    void setFarm(String farm);

    void setField(String field);
}
