package mvp.com.zhou.mvp.ui.view.main;


import java.util.List;

import mvp.com.zhou.mvp.ui.bean.weibo.JVBean;
import mvp.com.zhou.mvp.ui.view.base.BaseFragmentView;

/**
 * @Auther: test
 * @Date: 2018/7/27 15:22
 * @Description:
 */
public interface MainReportView extends BaseFragmentView {


    void setData(List<JVBean> list);
}
