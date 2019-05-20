package mvp.com.zhou.mvp.presenter.main;


import java.util.ArrayList;
import java.util.List;

import mvp.com.zhou.mvp.utils.bean.weibo.JVBean;
import mvp.com.zhou.mvp.model.main.MainReportModel;
import mvp.com.zhou.mvp.model.main.MainReportModelImpl;
import mvp.com.zhou.mvp.presenter.base.BasePresenterImpl;
import mvp.com.zhou.mvp.view.main.MainReportView;

/**
 * @Auther: test
 * @Date: 2018/7/27 15:27
 * @Description:
 */
public class MainReportPresenterImpl extends BasePresenterImpl<MainReportView, MainReportModel> {
    private List<JVBean> list = new ArrayList<>();

    @Override
    public void initData() {
    }

    @Override
    public MainReportModel initModel() {
        return new MainReportModelImpl();
    }

    public void setDataView() {
        setJVData();
        getView().setData(list);
    }

    public List<JVBean> setJVData() {

//            JVBean bean = new JVBean();
        List<List> jvBeanList = mModel.getJVBeanList();
        for (int i = 0; i < jvBeanList.get(0).size(); i++) {
            JVBean bean = new JVBean();
            bean.setHead((int)jvBeanList.get(2).get(i));
            bean.setName((String)jvBeanList.get(5).get(i));
            bean.setWBName((String)jvBeanList.get(4).get(i));
            bean.setIndexSrc((String)jvBeanList.get(0).get(i));
            bean.setFenSi((String)jvBeanList.get(1).get(i));
            bean.setMoney((String)jvBeanList.get(3).get(i));
            list.add(bean);
            bean = null;
//            list.add(new JVBean(mModel.head().get(i), mModel.name().get(i), mModel.WBName().get(i), mModel.IndexStr().get(i)
//                    , mModel.Fensi().get(i), mModel.Money().get(i)));
        }

//        for (int i = 0; i < mModel.name().size(); i++) {
//
//            bean.setHead(mModel.head().get(i));
//            bean.setName(mModel.name().get(i));
//            bean.setWBName(mModel.WBName().get(i));
//            bean.setIndexSrc(mModel.IndexStr().get(i));
//            bean.setFenSi(mModel.Fensi().get(i));
//            bean.setMoney(mModel.Money().get(i));
//            list.add(bean);
////            list.add(new JVBean(mModel.head().get(i), mModel.name().get(i), mModel.WBName().get(i), mModel.IndexStr().get(i)
////                    , mModel.Fensi().get(i), mModel.Money().get(i)));
//        }


//        bean.setHead(R.drawable.j02);
//        bean.setName("a2");
//        bean.setWBName("娱乐神算子");
//        bean.setIndexSrc("https://weibo.com/u/2613127473");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j03);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("https://weibo.com/u/1812690611");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("https://weibo.com/u/1812690611");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("https://weibo.com/u/1812690611");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("https://weibo.com/u/1812690611");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("https://weibo.com/u/1812690611");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("https://weibo.com/u/1812690611");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("https://weibo.com/u/1812690611");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("https://weibo.com/u/1812690611");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("https://weibo.com/u/1812690611");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("https://weibo.com/u/1812690611");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("https://weibo.com/u/1812690611");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("https://weibo.com/u/1812690611");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("1");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);
//
//        bean.setHead(R.drawable.j01);
//        bean.setName("a1");
//        bean.setWBName("电视圈大哥");
//        bean.setIndexSrc("");
//        bean.setFenSi("301万");
//        bean.setMoney("1700");
//        list.add(bean);

        return list;

    }


}


