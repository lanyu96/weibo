package mvp.com.zhou.mvp.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.database.DBUtils;
import mvp.com.zhou.mvp.ui.bean.weibo.JVBean;

public class ChangeInfo extends AppCompatActivity {

    private TextView nameTv;
    private EditText phoneEt;
    private EditText wxNumberEt;
    private EditText wbNameEt;
    private EditText baojiaEt;
    private TextView saveTv;
    private DBUtils dbUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);

        nameTv = findViewById(R.id.tv_person_name);
        phoneEt = findViewById(R.id.tv_person_phone);
        wxNumberEt = findViewById(R.id.tv_person_wx);
        wbNameEt = findViewById(R.id.tv_person_wb);
        baojiaEt = findViewById(R.id.tv_person_baojia);

        dbUtils = new DBUtils(this);

        List<JVBean> list1 = dbUtils.queryData();
        String name = list1.get(0).getName();
        String phoneNumber = list1.get(0).getPhoneNumber();
        String wxNumber = list1.get(0).getWxNumber();
        String wbName = list1.get(0).getWBName();
        String money = list1.get(0).getMoney();

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
                ,wxNumberEt.getText().toString().trim()
                ,wbNameEt.getText().toString().trim()
                ,baojiaEt.getText().toString().trim()
                ,nameTv.getText().toString()};
                dbUtils.update(set,where,str);
                finish();
            }
        });
    }
}
