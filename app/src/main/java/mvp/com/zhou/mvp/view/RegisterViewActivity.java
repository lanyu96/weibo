package mvp.com.zhou.mvp.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.suke.widget.SwitchButton;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.database.HDBUtils;
import mvp.com.zhou.mvp.database.JDBUtils;
import mvp.com.zhou.mvp.database.XDBUtils;
import mvp.com.zhou.mvp.presenter.RegisterPresenterImpl;
import mvp.com.zhou.mvp.view.base.BaseActivity;

public class RegisterViewActivity extends BaseActivity<RegisterPresenterImpl> implements RegisterView {

    private SwitchButton switchButton;
    private EditText nameEt;
    private EditText phoneEt;
    private EditText wxNumberEt;
    private EditText wbNameEt;
    private EditText baojiaEt;
    private EditText fensiEt;
    private EditText jhEt;
    private EditText indexEt;
    private TextView btn;
    private XDBUtils xdbUtils;
    private JDBUtils jdbUtils;
    private HDBUtils hdbUtils;

    @Override
    public RegisterPresenterImpl initPresent() {
        return new RegisterPresenterImpl();
    }

    @Override
    public void initView() {
        setContentView(R.layout.act_register);
        nameEt = findViewById(R.id.tv_person_name);
        phoneEt = findViewById(R.id.tv_person_phone);
        wxNumberEt = findViewById(R.id.tv_person_wx);
        wbNameEt = findViewById(R.id.tv_person_wb);
        baojiaEt = findViewById(R.id.tv_person_baojia);
        fensiEt = findViewById(R.id.tv_person_fensi);
        jhEt = findViewById(R.id.tv_person_jin_huang);
        indexEt = findViewById(R.id.tv_person_index);
        btn = findViewById(R.id.tv_person_save);
        initButton();

    }

    private void initButton() {
        switchButton = findViewById(R.id.tv_person_switch_button);

        switchButton.setChecked(false);
        switchButton.isChecked();
        switchButton.toggle();     //switch state
        switchButton.toggle(false);//switch without animation
        switchButton.setShadowEffect(true);//disable shadow effect
        switchButton.setEnabled(true);//disable button
        switchButton.setEnableEffect(false);//disable the switch animation
        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (isChecked) {
                    baojiaEt.setText("");
                    wbNameEt.setText("");
                    fensiEt.setText("");
                    jhEt.setText("");
                    indexEt.setText("");

                }
            }
        });
    }

    @Override
    public void initEvent() {
        btn.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onMyClick(View v) {
        switch (v.getId()) {
            case R.id.tv_person_save:
                boolean checked = switchButton.isChecked();
                if (checked) {
                    xdbUtils = new XDBUtils(this);
                    String[] title2 = {"name", "phoneNumber", "wxNumber"};
                    String[] value2 = {nameEt.getText().toString().trim()
                            , phoneEt.getText().toString().trim()
                            , wxNumberEt.getText().toString().trim()};
                    xdbUtils.addData(title2, value2);
                    showToast("注册成功");
                    finishUI();

                } else {
                    String trim = fensiEt.getText().toString().trim();
                    String[] title1 = {"icon", "name", "phoneNumber", "wxNumber", "wbName", "fensi",
                            "money", "JH", "wbIndex"};

                    String[] value1 = new String[]{String.valueOf(R.drawable.icon), nameEt.getText().toString().trim()
                            , phoneEt.getText().toString().trim()
                            , wxNumberEt.getText().toString().trim()
                            , wbNameEt.getText().toString().trim()
                            , fensiEt.getText().toString().trim()+"万"
                            , baojiaEt.getText().toString().trim()
                            , "金V"
                            , indexEt.getText().toString().trim()};
                    String[] value2 = new String[]{String.valueOf(R.drawable.icon), nameEt.getText().toString().trim()
                            , phoneEt.getText().toString().trim()
                            , wxNumberEt.getText().toString().trim()
                            , wbNameEt.getText().toString().trim()
                            , fensiEt.getText().toString().trim()+"万"
                            , baojiaEt.getText().toString().trim()
                            , "黄V"
                            , indexEt.getText().toString().trim()};
                    try {
                        if (!TextUtils.isEmpty(trim) && Integer.valueOf(trim) > 49) {
                            jdbUtils = new JDBUtils(this);
                            jdbUtils.addData(title1, value1);
                            showToast("注册成功");
                            finishUI();
                        } else if (!TextUtils.isEmpty(trim) && Integer.valueOf(trim) < 50) {
                            hdbUtils = new HDBUtils(this);
                            hdbUtils.addData(title1, value2);
                            showToast("注册成功");
                            finishUI();
                        } else {
                            showToast("请填写粉丝数");
                            break;
                        }
                    } catch (Exception e) {
                        showToast("粉丝数请填写纯数字");
                        break;
                    }


                }

                break;
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (xdbUtils != null) {
            xdbUtils.setClose();
        }
        if (jdbUtils != null) {
            jdbUtils.setClose();
        }

        if (hdbUtils != null) {
            hdbUtils.setClose();

        }
    }
}
