package mvp.com.zhou.mvp.ui.view.main;


import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import mvp.com.zhou.mvp.MyApp;
import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.constant.SPConstants;
import mvp.com.zhou.mvp.ui.bean.eventbus.StyleSelectMessage;
import mvp.com.zhou.mvp.ui.callback.CallBackPositionListener;
import mvp.com.zhou.mvp.ui.dialog.DialogUtils;
import mvp.com.zhou.mvp.ui.presenter.main.MainPersonPresenterImpl;
import mvp.com.zhou.mvp.ui.view.LoginViewActivity;
import mvp.com.zhou.mvp.ui.view.SplashActivity;
import mvp.com.zhou.mvp.ui.view.base.BaseFragment;
import mvp.com.zhou.mvp.utils.util.PreferencesService;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


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


    }

    @Override
    public void initEvent() {
        llFarm.setOnClickListener(this);
        llFeild.setOnClickListener(this);
        tvLogout.setOnClickListener(this);
//        selectStyleLl.setOnClickListener(this);
        getUpdate.setOnClickListener(this);
        modify_password.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (MyApp.getPreferencesService().getValue("user", "").equals("芒果娱乐宣传")) {
            tvPerson.setText(MyApp.getPreferencesService().getValue("user",""));
            phoneTv.setText("13567423654");
            tvFarm.setText("edbhru126");
            baojiaTv.setText(" - ");
            tvFeild.setText(" - ");
            styleTv.setText(" - ");
            jinTv.setText(" - ");
        } else if (MyApp.getPreferencesService().getValue("user", "").equals("b3")) {
            tvPerson.setText(MyApp.getPreferencesService().getValue("user",""));
            tvFarm.setText("xintian1015521");
            baojiaTv.setText("300");
            tvFeild.setText("娱乐小少年");
            styleTv.setText("57万");
            jinTv.setText("金");
            phoneTv.setText("17853723426");


        }


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

                showProgress("正在检查更新");

                SystemClock.sleep(300);


                hideProgress();

                showToast("已是最新版本");




                break;
                //修改密码
            case R.id.fragment_person_modify_password_ll:
//                Intent intent = new Intent(getActivity(), ModifyPasswordViewActivity.class);
//                startActivity(intent);

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

}
