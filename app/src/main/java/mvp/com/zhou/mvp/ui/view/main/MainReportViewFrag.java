package mvp.com.zhou.mvp.ui.view.main;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.database.JDBUtils;
import mvp.com.zhou.mvp.ui.adapter.weibo.JinVAdapter;
import mvp.com.zhou.mvp.ui.bean.weibo.JVBean;
import mvp.com.zhou.mvp.ui.presenter.main.MainReportPresenterImpl;
import mvp.com.zhou.mvp.ui.view.base.BaseFragment;
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
        if (list1.size() == 0 || list1.get(0).getName().equals("")) {
            dbUtils.addData(new String[]{"name", "phoneNumber", "wxNumber", "wbName", "money"}
                    , new String[]{"b3", "17853723426", "xintian1015521", "娱乐小少年", "300"});
            list1 = dbUtils.queryData();
        }
        String name = list1.get(0).getName();
        String phoneNumber = list1.get(0).getPhoneNumber();
        String wxNumber = list1.get(0).getWxNumber();
        String wbName = list1.get(0).getWBName();
        String money = list1.get(0).getMoney();


        list = new ArrayList<>();



        list.add(new JVBean(R.drawable.j01,"a1","电视圈大哥","https://weibo.com/u/1812690611","300万","1800","15289321543","kmb50","金V"));
        list.add(new JVBean(R.drawable.j02,"a2","娱乐神算子","https://weibo.com/u/2613127473","300万","1800","14873275085","okfq94","金V"));
        list.add(new JVBean(R.drawable.j03,"a3","卫视剧透社","https://weibo.com/u/3945344172","153万","1200","14322678422","nbcr43","金V"));
        list.add(new JVBean(R.drawable.j04,"a4","卫视小鲜肉","https://weibo.com/u/6040188827","11万","800","14567863245","mbgt54","金V"));
        list.add(new JVBean(R.drawable.j05,"a5","娱乐主人公","https://weibo.com/u/6363118660","101万","700","13288675489","nbcs56","金V"));
        list.add(new JVBean(R.drawable.j06,"a6","娱乐一番姐","https://weibo.com/u/5269405674","97万","600","18957664345","jnbv67","金V"));
        list.add(new JVBean(R.drawable.j07,"a7","芒果文娱","https://weibo.com/u/6196420604","94万","600","15755436777","98jnoi","金V"));
        list.add(new JVBean(R.drawable.j08,"a8","娱乐屋","https://weibo.com/u/6486325817","89万","500","17836543333","zaqogy","金V"));
        list.add(new JVBean(R.drawable.j09,"a9","影视捣蛋","https://weibo.com/u/2865573464","84万","500","16432667543","mnvr56","金V"));
        list.add(new JVBean(R.drawable.j10,"b1","娱评员","https://weibo.com/u/6523325161","71万","400","1433685543","mnts78","金V"));
        list.add(new JVBean(R.drawable.j11,"b2","每日娱乐饭","https://weibo.com/u/6385017934","60万","300","16786543332","mnbr45","金V"));
        list.add(new JVBean(R.drawable.j12,"b3",wbName,"https://weibo.com/u/6079561687","57万",money,phoneNumber,wxNumber,"金V"));
        list.add(new JVBean(R.drawable.j13,"b4","影视路透社","https://weibo.com/u/6034913285","53万","300","17755437776","koln23","金V"));
        list.add(new JVBean(R.drawable.j14,"b5","娱乐圈安利","https://weibo.com/u/5395677687","53万","300","16484367788","lbxa98","金V"));
        list.add(new JVBean(R.drawable.j15,"b6","影视最时尚","https://weibo.com/u/5218850241","50万","200","18765443333","nbfdtgu","金V"));


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
    public void onResume() {
        super.onResume();
        List<JVBean> list1 = dbUtils.queryData();
        String name = list1.get(0).getName();
        String phoneNumber = list1.get(0).getPhoneNumber();
        String wxNumber = list1.get(0).getWxNumber();
        String wbName = list1.get(0).getWBName();
        String money = list1.get(0).getMoney();


        list = new ArrayList<>();



        list.add(new JVBean(R.drawable.j01,"a1","电视圈大哥","https://weibo.com/u/1812690611","300万","1800","15289321543","kmb50","金V"));
        list.add(new JVBean(R.drawable.j02,"a2","娱乐神算子","https://weibo.com/u/2613127473","300万","1800","14873275085","okfq94","金V"));
        list.add(new JVBean(R.drawable.j03,"a3","卫视剧透社","https://weibo.com/u/3945344172","153万","1200","14322678422","nbcr43","金V"));
        list.add(new JVBean(R.drawable.j04,"a4","卫视小鲜肉","https://weibo.com/u/6040188827","11万","800","14567863245","mbgt54","金V"));
        list.add(new JVBean(R.drawable.j05,"a5","娱乐主人公","https://weibo.com/u/6363118660","101万","700","13288675489","nbcs56","金V"));
        list.add(new JVBean(R.drawable.j06,"a6","娱乐一番姐","https://weibo.com/u/5269405674","97万","600","18957664345","jnbv67","金V"));
        list.add(new JVBean(R.drawable.j07,"a7","芒果文娱","https://weibo.com/u/6196420604","94万","600","15755436777","98jnoi","金V"));
        list.add(new JVBean(R.drawable.j08,"a8","娱乐屋","https://weibo.com/u/6486325817","89万","500","17836543333","zaqogy","金V"));
        list.add(new JVBean(R.drawable.j09,"a9","影视捣蛋","https://weibo.com/u/2865573464","84万","500","16432667543","mnvr56","金V"));
        list.add(new JVBean(R.drawable.j10,"b1","娱评员","https://weibo.com/u/6523325161","71万","400","1433685543","mnts78","金V"));
        list.add(new JVBean(R.drawable.j11,"b2","每日娱乐饭","https://weibo.com/u/6385017934","60万","300","16786543332","mnbr45","金V"));
        list.add(new JVBean(R.drawable.j12,"b3",wbName,"https://weibo.com/u/6079561687","57万",money,phoneNumber,wxNumber,"金V"));
        list.add(new JVBean(R.drawable.j13,"b4","影视路透社","https://weibo.com/u/6034913285","53万","300","17755437776","koln23","金V"));
        list.add(new JVBean(R.drawable.j14,"b5","娱乐圈安利","https://weibo.com/u/5395677687","53万","300","16484367788","lbxa98","金V"));
        list.add(new JVBean(R.drawable.j15,"b6","影视最时尚","https://weibo.com/u/5218850241","50万","200","18765443333","nbfdtgu","金V"));


//        list.addAll(mPresenter.setJVData());

        jinVRv = (RecyclerView) findViewById(R.id.jinV_number_rv);
        jinVRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        adapter = new JinVAdapter(getContext(), list);
        jinVRv.setHasFixedSize(true);
        jinVRv.addItemDecoration(new SimpleDividerItemDecoration(getContext(),20, 1));
        jinVRv.setAdapter(adapter);
    }

    @Override
    public void initData() {
    }


    @Override
    public void onMyClick(View v) {

    }
}



