package mvp.com.zhou.mvp.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mvp.com.zhou.mvp.MyApp;
import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.ui.bean.weibo.JVBean;
import mvp.com.zhou.mvp.ui.dialog.weibo.InfoDialog;
import mvp.com.zhou.mvp.ui.presenter.InfoPresenterImpl;
import mvp.com.zhou.mvp.ui.view.base.BaseActivity;
import mvp.com.zhou.mvp.utils.util.PreferencesService;

public class InfoViewActivity extends BaseActivity<InfoPresenterImpl> {
    private TextView tvPerson;

    private TextView tvFarm;

    private TextView tvFeild;


    private TextView styleTv;

    private TextView baojiaTv;
    private TextView jinTv;
    private TextView phoneTv;
    private LinearLayout indexLl;
    private JVBean info;
    private LinearLayout baojiaLl;

    @Override
    public InfoPresenterImpl initPresent() {
        return new InfoPresenterImpl();
    }

    @Override
    public void initView() {
        setContentView(R.layout.act_info);

        tvPerson = (TextView) findViewById(R.id.tv_person_name);

        tvFarm = (TextView) findViewById(R.id.tv_person_farm);
        tvFeild = (TextView) findViewById(R.id.tv_person_feild);
//        selectStyleTv = (TextView) findViewById(R.id.tv_person_select_style_tv);
//        selectStyleLl = (LinearLayout) findViewById(R.id.ll_person_select_style_ll);

        baojiaTv = (TextView) findViewById(R.id.tv_person_baojia);
        baojiaLl = findViewById(R.id.fragment_person_baojia_ll);

        styleTv = (TextView) findViewById(R.id.tv_person_select_style_tv);

        jinTv = (TextView) findViewById(R.id.fragment_person_is_jin_tv);
        phoneTv = (TextView) findViewById(R.id.tv_person_real_name);

        indexLl = findViewById(R.id.fragment_person_index_ll);
    }

    @Override
    public String setTitleText() {
        return "个人信息";
    }

    @Override
    public void initEvent() {
        indexLl.setOnClickListener(this);
        baojiaLl.setOnClickListener(this);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
//        Bundle bundle = intent.getSerializableExtra("info");
//        assert bundle != null;
        info = (JVBean) intent.getSerializableExtra("info");
//
        tvPerson.setText(info.getName());
        tvFarm.setText(info.getWxNumber());
        baojiaTv.setText("点击查看详细报价");
        tvFeild.setText(info.getWBName());
        styleTv.setText(info.getFenSi());
        jinTv.setText(info.getJinOrHuang());
        phoneTv.setText(info.getPhoneNumber());


    }

    @Override
    public void onMyClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_person_index_ll:
                Intent intent = new Intent(this, indexViewActivity.class);
                intent.putExtra("index", info.getIndexSrc());
                startActivity(intent);
                break;
            case R.id.fragment_person_baojia_ll:
                final InfoDialog dialog = new InfoDialog(this);
                dialog.showInfoDialog(this, info.getName())
                        .setListener(new InfoDialog.OnClickListener() {
                            @Override
                            public void OnFinishClickListener() {
                                dialog.dismiss();
                            }
                        }).show();

                break;
        }
    }
}
