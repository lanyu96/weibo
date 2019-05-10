package mvp.com.zhou.mvp.ui.view.main;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.ui.adapter.weibo.JinVAdapter;
import mvp.com.zhou.mvp.ui.bean.weibo.JVBean;
import mvp.com.zhou.mvp.ui.presenter.main.MainOperatePresenterImpl;
import mvp.com.zhou.mvp.ui.view.base.BaseFragment;
import mvp.com.zhou.mvp.utils.SimpleDividerItemDecoration;


public class MainOperateViewFrag extends BaseFragment<MainOperatePresenterImpl> implements MainOperateView {
    private RecyclerView jinVRv;
    private List<JVBean> list;
    private JinVAdapter adapter;

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
        list.add(new JVBean(R.drawable.h01,"c1","娱乐界小花","https://weibo.com/u/6118573751","30万","100"));
        list.add(new JVBean(R.drawable.h02,"c2","剧星娱乐","https://weibo.com/u/2013822757","29万","50"));
        list.add(new JVBean(R.drawable.h03,"c3","芒果练习生","https://weibo.com/u/3863471918","29万","50"));
        list.add(new JVBean(R.drawable.h04,"c4","八组娱乐姐","https://weibo.com/u/5929694220","23万","50"));
        list.add(new JVBean(R.drawable.h05,"c5","娱乐星鲜爆","https://weibo.com/u/5924809418","22万","50"));
        list.add(new JVBean(R.drawable.h06,"c6","音乐时尚汇","https://weibo.com/u/5924406866","20万","50"));
        list.add(new JVBean(R.drawable.h07,"c7","芒果捞八组","https://weibo.com/u/5919408339","20万","50"));
        list.add(new JVBean(R.drawable.h08,"c8","娱乐管八卦说","https://weibo.com/u/6363067905","16万","30"));
        list.add(new JVBean(R.drawable.h09,"c9","芒果捞八卦","https://weibo.com/u/6395898458","13万","30"));
        list.add(new JVBean(R.drawable.h10,"d1","娱乐界女神","https://weibo.com/u/3007919083","12万","30"));
        list.add(new JVBean(R.drawable.h11,"d2","娱乐柠檬精","https://weibo.com/u/5920907161","10万","30"));
        list.add(new JVBean(R.drawable.h12,"d3","影视综帮","https://weibo.com/u/5923937105","10万","30"));
        list.add(new JVBean(R.drawable.h13,"d4","芒果捞音乐榜","https://weibo.com/u/5932006081","10万","30"));
        list.add(new JVBean(R.drawable.h14,"d5","八组芒果酱","https://weibo.com/u/5942432306","10万","30"));
        list.add(new JVBean(R.drawable.h15,"d6","娱乐小鑫仔","https://weibo.com/u/6444968430","10万","30"));


//        list.addAll(mPresenter.setJVData());

        jinVRv = (RecyclerView) findViewById(R.id.jinV_number_rv);
        jinVRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
//        jinVRv.setItemViewCacheSize(16);
//        jinVRv.setDrawingCacheEnabled(true);
//        jinVRv.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        adapter = new JinVAdapter(getContext(), list);
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
    public void onMyClick(View v) {

        switch (v.getId()){

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
