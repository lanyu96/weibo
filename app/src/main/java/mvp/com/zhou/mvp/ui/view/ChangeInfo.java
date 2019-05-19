package mvp.com.zhou.mvp.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import mvp.com.zhou.mvp.MyApp;
import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.database.HDBUtils;
import mvp.com.zhou.mvp.database.JDBUtils;
import mvp.com.zhou.mvp.database.XDBUtils;
import mvp.com.zhou.mvp.httputil.HttpContants;
import mvp.com.zhou.mvp.ui.bean.weibo.JVBean;

public class ChangeInfo extends AppCompatActivity {

    private TextView nameTv;
    private EditText phoneEt;
    private EditText wxNumberEt;
    private EditText wbNameEt;
    private EditText baojiaEt;
    private TextView saveTv;
    private JDBUtils dbUtils;
    private JDBUtils jdbUtils;
    private HDBUtils hdbUtils;
    private XDBUtils xdbUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);

        nameTv = findViewById(R.id.tv_person_name);
        phoneEt = findViewById(R.id.tv_person_phone);
        wxNumberEt = findViewById(R.id.tv_person_wx);
        wbNameEt = findViewById(R.id.tv_person_wb);
        baojiaEt = findViewById(R.id.tv_person_baojia);

        String name = MyApp.getPreferencesService().getValue("user", "");
        String phoneNumber = "";
        String wxNumber = "";
        String wbName = "";
        String money = "";

        switch (HttpContants.dbNumber) {
            case 0:
                hdbUtils = new HDBUtils(this);
                JVBean jvBean = hdbUtils.queryForName(MyApp.getPreferencesService().getValue("user", ""));
                phoneNumber = jvBean.getPhoneNumber();
                wxNumber = jvBean.getWxNumber();
                wbName = jvBean.getWBName();
                money = jvBean.getMoney();
                break;
            case 1:
                jdbUtils = new JDBUtils(this);
                JVBean jvBean1 = jdbUtils.queryForName(MyApp.getPreferencesService().getValue("user", ""));
                phoneNumber = jvBean1.getPhoneNumber();
                wxNumber = jvBean1.getWxNumber();
                wbName = jvBean1.getWBName();
                money = jvBean1.getMoney();
                break;
            case 2:
                xdbUtils = new XDBUtils(this);
                JVBean jvBean2 = xdbUtils.queryForName(MyApp.getPreferencesService().getValue("user", ""));
                phoneNumber = jvBean2.getPhoneNumber();
                wxNumber = jvBean2.getWxNumber();
                break;
        }

        nameTv.setText(name);
        phoneEt.setText(phoneNumber);
        wxNumberEt.setText(wxNumber);
        wbNameEt.setText(wbName);
        baojiaEt.setText(money);


        saveTv = findViewById(R.id.tv_person_save);
        saveTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String set = "phoneNumber=? ,wxNumber=?,wbName=?,money=?";
                String where = "name=? ";
                String[] str = {phoneEt.getText().toString().trim()
                        , wxNumberEt.getText().toString().trim()
                        , wbNameEt.getText().toString().trim()
                        , baojiaEt.getText().toString().trim()
                        , nameTv.getText().toString()};

                switch (HttpContants.dbNumber) {
                    case 0:
                        hdbUtils.update(set, where, str);
                        break;
                    case 1:
                        jdbUtils.update(set, where, str);
                        break;
                    case 2:
                        String set1 = "phoneNumber=? ,wxNumber=?";
                        String[] str1 = new String[]{phoneEt.getText().toString().trim()
                                , wxNumberEt.getText().toString().trim()
                                , nameTv.getText().toString().trim()};
                        xdbUtils.update(set1, where, str1);
                        break;
                }
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
