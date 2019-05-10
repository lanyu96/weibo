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
import mvp.com.zhou.mvp.ui.presenter.main.MainReportPresenterImpl;
import mvp.com.zhou.mvp.ui.view.base.BaseFragment;
import mvp.com.zhou.mvp.utils.SimpleDividerItemDecoration;


public class MainReportViewFrag extends BaseFragment<MainReportPresenterImpl> implements MainReportView {


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
        list = new ArrayList<>();
        list.add(new JVBean(R.drawable.j01,"a1","电视圈大哥","https://weibo.com/u/1812690611","301万","1700"));
        list.add(new JVBean(R.drawable.j02,"a2","娱乐神算子","https://weibo.com/u/2613127473","310万","1800"));
        list.add(new JVBean(R.drawable.j03,"a3","卫视剧透社","https://weibo.com/u/3945344172","153万","1200"));
        list.add(new JVBean(R.drawable.j04,"a4","卫视小鲜肉","https://weibo.com/u/6040188827","110万","800"));
        list.add(new JVBean(R.drawable.j05,"a5","娱乐主人公","https://weibo.com/u/6363118660","101万","700"));
        list.add(new JVBean(R.drawable.j06,"a6","娱乐一番姐","https://weibo.com/u/5269405674","97万","600"));
        list.add(new JVBean(R.drawable.j07,"a7","芒果文娱","https://weibo.com/u/6196420604","94万","600"));
        list.add(new JVBean(R.drawable.j08,"a8","娱乐屋","https://weibo.com/u/6486325817","89万","500"));
        list.add(new JVBean(R.drawable.j09,"a9","影视捣蛋","https://weibo.com/u/2865573464","84万","500"));
        list.add(new JVBean(R.drawable.j10,"b1","娱评员","https://weibo.com/u/6523325161","71万","400"));
        list.add(new JVBean(R.drawable.j11,"b2","每日娱乐饭","https://weibo.com/u/6385017934","60万","300"));
        list.add(new JVBean(R.drawable.j12,"b3","娱乐小少年","https://weibo.com/u/6079561687","57万","300"));
        list.add(new JVBean(R.drawable.j13,"b4","影视路透社","https://weibo.com/u/6034913285","53万","300"));
        list.add(new JVBean(R.drawable.j14,"b5","娱乐圈安利","https://weibo.com/u/5395677687","53万","300"));
        list.add(new JVBean(R.drawable.j15,"b6","影视最时尚","https://weibo.com/u/5218850241","50万","200"));


//        list.addAll(mPresenter.setJVData());

        jinVRv = (RecyclerView) findViewById(R.id.jinV_number_rv);
        jinVRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        adapter = new JinVAdapter(getContext(), list);
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
    public void initData() {
    }


    @Override
    public void onMyClick(View v) {

    }
}



