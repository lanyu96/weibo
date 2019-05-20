package mvp.com.zhou.mvp.view.main;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.database.JDBUtils;
import mvp.com.zhou.mvp.utils.bean.adapter.weibo.JinVAdapter;
import mvp.com.zhou.mvp.utils.bean.weibo.JVBean;
import mvp.com.zhou.mvp.presenter.main.MainReportPresenterImpl;
import mvp.com.zhou.mvp.view.base.BaseFragment;
import mvp.com.zhou.mvp.utils.SimpleDividerItemDecoration;


public class MainReportViewFrag extends BaseFragment<MainReportPresenterImpl> implements MainReportView {

    private JDBUtils dbUtils;
    private RecyclerView jinVRv;
    private List<JVBean> list;
    private JinVAdapter adapter;

    @Override
    public MainReportPresenterImpl initPresent() {
        return new MainReportPresenterImpl();
    }

    @Override
    public View setContentUI(LayoutInflater inflater, ViewGroup container) {
        View view = View.inflate(getContext(), R.layout.fragment_main_report_view, null);
        return view;
    }

    @Override
    public void initView() {
        dbUtils = new JDBUtils(getContext());
        List<JVBean> list1 = dbUtils.queryData();
//        if (list1.size() == 0 || list1.get(0).getName().equals("")) {
//            dbUtils.addData(new String[]{"name", "phoneNumber", "wxNumber", "wbName", "money"}
//                    , new String[]{"b3", "17853723426", "xintian1015521", "娱乐小少年", "300"});
//            list1 = dbUtils.queryData();
//        }
//        String name = list1.get(0).getName();
//        String phoneNumber = list1.get(0).getPhoneNumber();
//        String wxNumber = list1.get(0).getWxNumber();
//        String wbName = list1.get(0).getWBName();
//        String money = list1.get(0).getMoney();


        list = new ArrayList<>();





//        list.addAll(mPresenter.setJVData());

//        JDBUtils jdbUtils = new JDBUtils(getContext());
//        List<JVBean> list = jdbUtils.queryData();
        list.addAll(list1);

        jinVRv = (RecyclerView) findViewById(R.id.jinV_number_rv);
        jinVRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        adapter = new JinVAdapter(getContext(), this.list);
        jinVRv.setHasFixedSize(true);
        jinVRv.addItemDecoration(new SimpleDividerItemDecoration(getContext(),20, 1));
        jinVRv.setAdapter(adapter);
//        mPresenter.setDataView();
    }

    @Override
    public void setData(List<JVBean> list) {
//        this.list.addAll(list);
//        adapter.notifyDataSetChanged();
    }

    @Override
    public void initEvent() {


    }

    @Override
    public void onResume() {
        super.onResume();
        List<JVBean> list1 = dbUtils.queryData();
        list.clear();
        list.addAll(list1);

        adapter.notifyDataSetChanged();
        jinVRv.setAdapter(adapter);
    }

    @Override
    public void initData() {
    }


    @Override
    public void onMyClick(View v) {

    }
}



