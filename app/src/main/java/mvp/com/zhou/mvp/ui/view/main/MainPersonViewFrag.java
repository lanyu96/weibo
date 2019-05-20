package mvp.com.zhou.mvp.ui.view.main;


import android.content.Intent;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mvp.com.zhou.mvp.MyApp;
import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.database.HDBUtils;
import mvp.com.zhou.mvp.database.JDBUtils;
import mvp.com.zhou.mvp.database.XDBUtils;
import mvp.com.zhou.mvp.httputil.HttpContants;
import mvp.com.zhou.mvp.ui.bean.weibo.JVBean;
import mvp.com.zhou.mvp.ui.callback.CallBackPositionListener;
import mvp.com.zhou.mvp.ui.dialog.DialogUtils;
import mvp.com.zhou.mvp.ui.presenter.main.MainPersonPresenterImpl;
import mvp.com.zhou.mvp.ui.view.ChangeInfo;
import mvp.com.zhou.mvp.ui.view.LoginViewActivity;
import mvp.com.zhou.mvp.ui.view.SplashActivity;
import mvp.com.zhou.mvp.ui.view.base.BaseFragment;
import mvp.com.zhou.mvp.utils.MyWebView;
import mvp.com.zhou.mvp.utils.util.PreferencesService;


public class MainPersonViewFrag extends BaseFragment<MainPersonPresenterImpl> implements MainPersonView {

    private TextView tvPerson;
    private LinearLayout llFarm;
    private TextView tvFarm;
    private LinearLayout llFeild;
    private TextView tvFeild;

    private TextView tvLogout;
    private TextView selectStyleTv;
    private LinearLayout selectStyleLl;
    private LinearLayout getUpdate;
    private LinearLayout modify_password;

    private List<String> mList;
    private TextView styleTv;
    private PreferencesService ps;
    private TextView tvRealPerson;
    private TextView baojiaTv;
    private TextView jinTv;
    private TextView phoneTv;
    private JDBUtils dbUtils;
    private LinearLayout changeInfoLl;
    private HDBUtils hdbUtils;
    private JDBUtils jdbUtils;
    private XDBUtils xdbUtils;

    @Override
    public MainPersonPresenterImpl initPresent() {
        return new MainPersonPresenterImpl();
    }

    @Override
    public View setContentUI(LayoutInflater inflater, ViewGroup container) {
        View view = View.inflate(getContext(), R.layout.fragment_main_person_view, null);
        return view;
    }


    @Override
    public void initView() {
        tvPerson = (TextView) findViewById(R.id.tv_person_name);
        tvRealPerson = (TextView) findViewById(R.id.tv_person_real_name);

        llFarm = (LinearLayout) findViewById(R.id.ll_person_farm);
        tvFarm = (TextView) findViewById(R.id.tv_person_farm);
        llFeild = (LinearLayout) findViewById(R.id.ll_person_feild);
        tvFeild = (TextView) findViewById(R.id.tv_person_feild);
        tvLogout = (TextView) findViewById(R.id.tv_person_logout);
//        selectStyleTv = (TextView) findViewById(R.id.tv_person_select_style_tv);
//        selectStyleLl = (LinearLayout) findViewById(R.id.ll_person_select_style_ll);
        getUpdate = (LinearLayout) findViewById(R.id.fragment_person_get_update_ll);

        ps = MyApp.getPreferencesService();
        baojiaTv = (TextView) findViewById(R.id.tv_person_baojia);

        modify_password = (LinearLayout) findViewById(R.id.fragment_person_modify_password_ll);
        styleTv = (TextView) findViewById(R.id.tv_person_select_style_tv);

        jinTv = (TextView) findViewById(R.id.fragment_person_is_jin_tv);
        phoneTv = (TextView) findViewById(R.id.tv_person_real_name);
        mList = new ArrayList<>();

        changeInfoLl = (LinearLayout) findViewById(R.id.fragment_person_set_info_ll);

        dbUtils = new JDBUtils(getContext());
        List<JVBean> list = dbUtils.queryData();
        if (list.size() == 0 || list.get(0).getName().equals("")) {
//            dbUtils.addData(new String[]{"name", "phoneNumber", "wxNumber", "wbName", "money"}
//                    , new String[]{"b3", "17853723426", "xintian1015521", "娱乐小少年", "300"});
            queryInfo();
        } else {
            queryInfo();

        }

//        if (!(list.get(0).getName().equals("b3") || list.get(0).getName().equals("芒果娱乐宣传"))) {
//
//        }

    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        queryInfo();
//    }

    @Override
    public void onResume() {
        super.onResume();
        queryInfo();
    }

    private void queryInfo() {
        String name = MyApp.getPreferencesService().getValue("user", "");
        String phoneNumber = "";
        String wxNumber = "";
        String wbName = "";
        String money = "";
        String fensi = "";
        String jh = "";

        String Xname = MyApp.getPreferencesService().getValue("user", "");
        String XphoneNumber = "";
        String Xwx ="";
        switch (HttpContants.dbNumber) {
            case 0:
                hdbUtils = new HDBUtils(getContext());
                JVBean jvBean = hdbUtils.queryForName(MyApp.getPreferencesService().getValue("user", ""));
                phoneNumber = jvBean.getPhoneNumber();
                wxNumber = jvBean.getWxNumber();
                wbName = jvBean.getWBName();
                money = jvBean.getMoney();
                fensi = jvBean.getFenSi();
                jh = jvBean.getJinOrHuang();
                break;
            case 1:
                jdbUtils = new JDBUtils(getContext());
                JVBean jvBean1 = jdbUtils.queryForName(MyApp.getPreferencesService().getValue("user", ""));
                phoneNumber = jvBean1.getPhoneNumber();
                wxNumber = jvBean1.getWxNumber();
                wbName = jvBean1.getWBName();
                money = jvBean1.getMoney();
                fensi = jvBean1.getFenSi();
                jh = jvBean1.getJinOrHuang();
                break;
            case 2:
                xdbUtils = new XDBUtils(getContext());
                JVBean jvBean2 = xdbUtils.queryForName(MyApp.getPreferencesService().getValue("user", ""));
                XphoneNumber = jvBean2.getPhoneNumber();
                Xwx = jvBean2.getWxNumber();
                break;
        }
//        List<JVBean> list1 = dbUtils.queryData();
//        String name = list1.get(11).getName();
//        String phoneNumber = list1.get(11).getPhoneNumber();
//        String wxNumber = list1.get(11).getWxNumber();
//        String wbName = list1.get(11).getWBName();
//        String money = list1.get(11).getMoney();
//        String fensi = list1.get(11).getFenSi();
//        String jh = list1.get(11).getJinOrHuang();
        if (HttpContants.dbNumber == 2) {
            tvPerson.setText(Xname);
            phoneTv.setText(XphoneNumber);
            tvFarm.setText(Xwx);
            baojiaTv.setText(" - ");
            tvFeild.setText(" - ");
            styleTv.setText(" - ");
            jinTv.setText(" - ");
        } else {
            tvPerson.setText(name);
            tvFarm.setText(wxNumber);
            baojiaTv.setText(money);
            tvFeild.setText(wbName);
            styleTv.setText(fensi);
            jinTv.setText(jh);
            phoneTv.setText(phoneNumber);


        }
    }

    @Override
    public void initEvent() {
        llFarm.setOnClickListener(this);
        llFeild.setOnClickListener(this);
        tvLogout.setOnClickListener(this);
//        selectStyleLl.setOnClickListener(this);
        getUpdate.setOnClickListener(this);
        modify_password.setOnClickListener(this);
        changeInfoLl.setOnClickListener(this);
    }

    @Override
    public void initData() {



//        tvFarm.setText(MyApp.getPreferencesService().getValue(SPConstants.FARM_NAME,""));
//        tvFeild.setText(MyApp.getPreferencesService().getValue(SPConstants.FIELD_NAME,""));
//        styleTv.setText(MyApp.getPreferencesService().getValue(SPConstants.STYLE_ID,""));
//        tvRealPerson.setText(MyApp.getPreferencesService().getValue(SPConstants.USERNAME,""));
        mList.add("标准");
        mList.add("简约");
    }


    @Override
    public void onMyClick(View v) {
        switch (v.getId()){
            case R.id.ll_person_farm:
//                mPresenter.getFarmInfofromNet();

                break;
            case R.id.ll_person_feild:
//                mPresenter.selectField();
                break;
            case R.id.tv_person_logout:
                startActivity(new Intent(getContext(), LoginViewActivity.class));
                finishUI();
                break;
            case R.id.ll_person_select_style_ll:



                break;

                //检查更新
            case R.id.fragment_person_get_update_ll:
//                new SplashActivity().upDate(getContext());

                new SplashActivity().upDate(getContext());




                break;
                //修改密码
            case R.id.fragment_person_modify_password_ll:
//                Intent intent = new Intent(getActivity(), ModifyPasswordViewActivity.class);
//                startActivity(intent);

                break;
            case R.id.fragment_person_set_info_ll:
                startActivity(new Intent(getContext(), ChangeInfo.class));
                break;
        }
    }

    @Override
    public void showSelectDialog(List<String> list, final CallBackPositionListener listener) {
        new DialogUtils().showSelectDialog(getContext(), list, new DialogUtils.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                listener.onSuccess(position);
            }
        });
    }

    @Override
    public void setFarm(String farm){
        tvFarm.setText(farm);
    }

    @Override
    public void setField(String field){
        tvFeild.setText(field);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dbUtils != null) {
            dbUtils.setClose();
        }
        if (jdbUtils != null) {
            jdbUtils.setClose();
        }
        if (hdbUtils != null) {
            hdbUtils.setClose();
        }
        if (xdbUtils != null) {
            xdbUtils.setClose();
        }


    }
}
