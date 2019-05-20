package mvp.com.zhou.mvp.view.main;


import java.util.List;

import mvp.com.zhou.mvp.utils.bean.weibo.JVBean;
import mvp.com.zhou.mvp.view.base.BaseFragmentView;

/**
 * @Auther: test
 * @Date: 2018/7/27 15:22
 * @Description:
 */
public interface MainReportView extends BaseFragmentView {


    void setData(List<JVBean> list);
}
