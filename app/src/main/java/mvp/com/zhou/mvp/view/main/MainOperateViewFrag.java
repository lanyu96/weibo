package mvp.com.zhou.mvp.view.main;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.database.HDBUtils;
import mvp.com.zhou.mvp.utils.bean.adapter.weibo.JinVAdapter;
import mvp.com.zhou.mvp.utils.bean.weibo.JVBean;
import mvp.com.zhou.mvp.presenter.main.MainOperatePresenterImpl;
import mvp.com.zhou.mvp.view.base.BaseFragment;
import mvp.com.zhou.mvp.utils.SimpleDividerItemDecoration;


public class MainOperateViewFrag extends BaseFragment<MainOperatePresenterImpl> implements MainOperateView {
    private RecyclerView jinVRv;
    private List<JVBean> list;
    private JinVAdapter adapter;
    private HDBUtils hdbUtils;

    @Override
    public MainOperatePresenterImpl initPresent() {
        return new MainOperatePresenterImpl();
    }

    @Override
    public View setContentUI(LayoutInflater inflater, ViewGroup container) {
        View view = View.inflate(getContext(), R.layout.fragment_main_operate_view, null);
        return view;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();


//        list.addAll(mPresenter.setJVData());

        jinVRv = (RecyclerView) findViewById(R.id.jinV_number_rv);
        jinVRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
//        jinVRv.setItemViewCacheSize(16);
//        jinVRv.setDrawingCacheEnabled(true);
//        jinVRv.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        hdbUtils = new HDBUtils(getContext());
        List<JVBean> list1 = hdbUtils.queryData();
        list.addAll(list1);
        adapter = new JinVAdapter(getContext(), this.list);
        jinVRv.setHasFixedSize(true);
        jinVRv.addItemDecoration(new SimpleDividerItemDecoration(getContext(),20, 1));
        jinVRv.setAdapter(adapter);

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        List<JVBean> list1 = hdbUtils.queryData();
        list.clear();
        list.addAll(list1);

        adapter.notifyDataSetChanged();
        jinVRv.setAdapter(adapter);
    }

    @Override
    public void onMyClick(View v) {

        switch (v.getId()){

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
