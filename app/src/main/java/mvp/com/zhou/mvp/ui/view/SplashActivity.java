package mvp.com.zhou.mvp.ui.view;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import mvp.com.zhou.mvp.MyApp;
import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.database.HDBUtils;
import mvp.com.zhou.mvp.database.JDBUtils;
import mvp.com.zhou.mvp.database.XDBUtils;
import mvp.com.zhou.mvp.httputil.HttpRequest;
import mvp.com.zhou.mvp.ui.bean.AppInfo;
import mvp.com.zhou.mvp.ui.bean.weibo.JVBean;
import mvp.com.zhou.mvp.ui.callback.CallBackListener;
import mvp.com.zhou.mvp.utils.AppUpdate;

public class SplashActivity extends AppCompatActivity {

    private boolean isProgressing = false;
    private ProgressDialog progressDialog;
    private TextView startingTv;
    private int count;
    private int failCount;
    @SuppressLint("HandlerLeak")
    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    startingTv.setText("正在启动.");
                    break;
                case 2:
                    startingTv.setText("正在启动..");
                    break;
                case 3:
                    startingTv.setText("正在启动...");
                    break;
                case 4:
//                    Toast.makeText(SplashActivity.this, "获取更新失败", Toast.LENGTH_LONG);
                    getUpdateFail();
                    break;
                default:

                    break;
            }
            super.handleMessage(msg);
        }//
    };
    private Timer timer;
    private Boolean isGetUpdateComplete = false;
    private JDBUtils jdbUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_view);
        jdbUtils = new JDBUtils(this);
        List<JVBean> list = jdbUtils.queryData();
        if (list.size() < 15) {
            checkUpdate();
        }
        init();
        jumpLogin();


    }

    private void init() {
        startingTv = findViewById(R.id.welcome_starting_tv);
        count = 0;
        failCount = 0;
//        Button btn = findViewById(R.id.versionchecklib_version_dialog_cancel);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(SplashActivity.this, "test1111", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private void jumpLogin() {

        timer = new Timer();
        //参数1:每次执行的任务代码  参数2:延时多少毫秒执行   参数3:任务间隔
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //此处写倒计时空间和判断语句
                //当满足条件后,调用cancel()方法结束当前循环
                if (isGetUpdateComplete) {
                    cancel();
                }
                count++;
                //如果更新拉取为返回结果,则不跳转到登录界面
                if (failCount >= 12) {
                    myHandler.obtainMessage(4).sendToTarget();
                } else if (count >= 5 && isGetUpdateComplete) {
                    count--;
                    //失败次数计数
                    failCount++;
                } else if (count == 5) {
                    Intent intent = new Intent(SplashActivity.this, LoginViewActivity.class);
                    startActivity(intent);
                    finish();
                } else if (count % 3 == 0) {
                    Message msg = new Message();
                    msg.what = 1;
                    myHandler.sendMessage(msg);
                } else if (count % 3 == 1) {
                    myHandler.obtainMessage(2).sendToTarget();
                } else if (count % 3 == 2) {
                    myHandler.obtainMessage(3).sendToTarget();
                }
            }
        }, 250, 250);
    }

    /**
     * 检查更新,如果发现新版本则弹出发现新版本对话框
     */
    private void checkUpdate() {
//初始化数据
        List<JVBean> list = new ArrayList<>();
        list.add(new JVBean(R.drawable.h01, "c1", "娱乐界小花", "https://weibo.com/u/6118573751", "30万", "100", "15623437832", "hdvn32", "黄V"));
        list.add(new JVBean(R.drawable.h02, "c2", "剧星娱乐", "https://weibo.com/u/2013822757", "29万", "50", "14523437562", "jdhc37", "黄V"));
        list.add(new JVBean(R.drawable.h03, "c3", "芒果练习生", "https://weibo.com/u/3863471918", "29万", "50", "19823437832", "dhbv34", "黄V"));
        list.add(new JVBean(R.drawable.h04, "c4", "八组娱乐姐", "https://weibo.com/u/5929694220", "23万", "50", "15623256832", "sjcn95", "黄V"));
        list.add(new JVBean(R.drawable.h05, "c5", "娱乐星鲜爆", "https://weibo.com/u/5924809418", "22万", "50", "15639875297", "sufn34", "黄V"));
        list.add(new JVBean(R.drawable.h06, "c6", "音乐时尚汇", "https://weibo.com/u/5924406866", "20万", "50", "15623437832", "djhv56", "黄V"));
        list.add(new JVBean(R.drawable.h07, "c7", "芒果捞八组", "https://weibo.com/u/5919408339", "20万", "50", "15623434985", "ksmn43", "黄V"));
        list.add(new JVBean(R.drawable.h08, "c8", "娱乐管八卦说", "https://weibo.com/u/6363067905", "16万", "30", "15623437832", "zx1234", "黄V"));
        list.add(new JVBean(R.drawable.h09, "c9", "芒果捞八卦", "https://weibo.com/u/6395898458", "13万", "30", "15623437123", "ksnd43", "黄V"));
        list.add(new JVBean(R.drawable.h10, "d1", "娱乐界女神", "https://weibo.com/u/3007919083", "12万", "30", "15623432345", "kmcj12", "黄V"));
        list.add(new JVBean(R.drawable.h11, "d2", "娱乐柠檬精", "https://weibo.com/u/5920907161", "10万", "30", "15623434567", "kishbs", "黄V"));
        list.add(new JVBean(R.drawable.h12, "d3", "影视综帮", "https://weibo.com/u/5923937105", "10万", "30", "16323436789", "ushd04", "黄V"));
        list.add(new JVBean(R.drawable.h13, "d4", "芒果捞音乐榜", "https://weibo.com/u/5932006081", "10万", "30", "12523432134", "juws72", "黄V"));
        list.add(new JVBean(R.drawable.h14, "d5", "八组芒果酱", "https://weibo.com/u/5942432306", "10万", "30", "16823436964", "oirv98", "黄V"));
        list.add(new JVBean(R.drawable.h15, "d6", "娱乐小鑫仔", "https://weibo.com/u/6444968430", "10万", "30", "16323437321", "ombq19", "黄V"));

        HDBUtils hdbUtils = new HDBUtils(this);

        String[] title = {"icon", "name", "phoneNumber", "wxNumber", "wbName", "fensi",
                "money", "JH", "wbIndex"};
        String[] value = {};

        for (int i = 0; i < list.size(); i++) {
            JVBean bean = list.get(i);
            value = new String[]{String.valueOf(bean.getHead()), bean.getName(), bean.getPhoneNumber()
                    , bean.getWxNumber(), bean.getWBName(), bean.getFenSi(), bean.getMoney(), bean.getJinOrHuang()
                    , bean.getIndexSrc()};
            hdbUtils.addData(title, value);
        }

        list = new ArrayList<>();
        list.add(new JVBean(R.drawable.j01, "a1", "电视圈大哥", "https://weibo.com/u/1812690611", "300万", "1800", "15289321543", "kmb50", "金V"));
        list.add(new JVBean(R.drawable.j02, "a2", "娱乐神算子", "https://weibo.com/u/2613127473", "300万", "1800", "14873275085", "okfq94", "金V"));
        list.add(new JVBean(R.drawable.j03, "a3", "卫视剧透社", "https://weibo.com/u/3945344172", "153万", "1200", "14322678422", "nbcr43", "金V"));
        list.add(new JVBean(R.drawable.j04, "a4", "卫视小鲜肉", "https://weibo.com/u/6040188827", "11万", "800", "14567863245", "mbgt54", "金V"));
        list.add(new JVBean(R.drawable.j05, "a5", "娱乐主人公", "https://weibo.com/u/6363118660", "101万", "700", "13288675489", "nbcs56", "金V"));
        list.add(new JVBean(R.drawable.j06, "a6", "娱乐一番姐", "https://weibo.com/u/5269405674", "97万", "600", "18957664345", "jnbv67", "金V"));
        list.add(new JVBean(R.drawable.j07, "a7", "芒果文娱", "https://weibo.com/u/6196420604", "94万", "600", "15755436777", "98jnoi", "金V"));
        list.add(new JVBean(R.drawable.j08, "a8", "娱乐屋", "https://weibo.com/u/6486325817", "89万", "500", "17836543333", "zaqogy", "金V"));
        list.add(new JVBean(R.drawable.j09, "a9", "影视捣蛋", "https://weibo.com/u/2865573464", "84万", "500", "16432667543", "mnvr56", "金V"));
        list.add(new JVBean(R.drawable.j10, "b1", "娱评员", "https://weibo.com/u/6523325161", "71万", "400", "1433685543", "mnts78", "金V"));
        list.add(new JVBean(R.drawable.j11, "b2", "每日娱乐饭", "https://weibo.com/u/6385017934", "60万", "300", "16786543332", "mnbr45", "金V"));
        list.add(new JVBean(R.drawable.j12, "b3", "娱乐小少年", "https://weibo.com/u/6079561687", "57万", "300", "17853723426", "xintian1015521", "金V"));
        list.add(new JVBean(R.drawable.j13, "b4", "影视路透社", "https://weibo.com/u/6034913285", "53万", "300", "17755437776", "koln23", "金V"));
        list.add(new JVBean(R.drawable.j14, "b5", "娱乐圈安利", "https://weibo.com/u/5395677687", "53万", "300", "16484367788", "lbxa98", "金V"));
        list.add(new JVBean(R.drawable.j15, "b6", "影视最时尚", "https://weibo.com/u/5218850241", "50万", "200", "18765443333", "nbfdtgu", "金V"));

        jdbUtils = new JDBUtils(this);

        String[] title1 = {"icon", "name", "phoneNumber", "wxNumber", "wbName", "fensi",
                "money", "JH", "wbIndex"};
        String[] value1 = {};

        for (int i = 0; i < list.size(); i++) {
            JVBean bean = list.get(i);
            value1 = new String[]{String.valueOf(bean.getHead()), bean.getName(), bean.getPhoneNumber()
                    , bean.getWxNumber(), bean.getWBName(), bean.getFenSi(), bean.getMoney(), bean.getJinOrHuang()
                    , bean.getIndexSrc()};
            jdbUtils.addData(title1, value1);
        }


        //宣传号
        list = new ArrayList<>();
        list.add(new JVBean("芒果娱乐宣传", "13567423654", "edbhru126"));

        XDBUtils xdbUtils = new XDBUtils(this);

        String[] title2 = {"name", "phoneNumber", "wxNumber"};
        String[] value2 = {};

        for (int i = 0; i < list.size(); i++) {
            JVBean bean = list.get(i);
            value2 = new String[]{bean.getName(), bean.getPhoneNumber(), bean.getWxNumber()};
            xdbUtils.addData(title2, value2);
        }
        //app版本信息的url
//        String appUpdateVersionUrl = "";
//        String jsonData = OkHttp3Util.getJsonData(appUpdateVersionUrl);

//        JsonObject jsonObject = new JsonObject(jsonData);
//        showProgress(MyApp.getRes().getString(R.string.loading));
//        HttpRequest.getAppData(new CallBackListener<AppInfo>() {
//            @Override
//            public void onSuccess(AppInfo appInfo) {
////                hideProgress();
//                if (SplashActivity.this.isFinishing()) {
//                    return;
//                }
//                //检查更新
//                String nowVersion = MyApp.getVersion();
//                //服务器端版本号
//                String newVersion = appInfo.getResult().get(0).getFversion();
//
//                //test
////                String newVersion = "1.0.4";
//
//                Log.i("TEST11", newVersion);
//                //新版本App的下载地址
//                String downloadUrl = appInfo.getResult().get(0).getFaddress();
//                //版本更新提醒的标题
//                String title = getString(R.string.updateTitle);
//                //版本更新提醒的详细信息
//                String updateContent = appInfo.getResult().get(0).getFcontext().replace("##", "\n");
//                Log.i("TEST111", "当前版本" + nowVersion);
//                //如果当前版本与远程最新版本不符,则调用App更新下载的方法
//                if (!nowVersion.equals(newVersion)) {
//                    isGetUpdateComplete = true;
//                    Intent intent = new Intent(SplashActivity.this, LoginViewActivity.class);
//                    startActivity(intent);
//                    finish();
//                    AppUpdate.sendRequest(SplashActivity.this, title, updateContent, downloadUrl);
//
//
//                }
//
//
//            }
//
//
//            @Override
//            public void onError(String error) {
////                hideProgress();
//                if (SplashActivity.this.isFinishing()) {
//                    return;
//                }
//                isGetUpdateComplete = true;
//                getUpdateFail();
//
//            }
//        });

    }

    /**
     * 检查更新,如果发现新版本则弹出发现新版本对话框
     */
    private void myUpdate(final Context context) {


        HttpRequest.getAppData(new CallBackListener<AppInfo>() {
            @Override
            public void onSuccess(AppInfo appInfo) {
                hideProgress();
                if (SplashActivity.this.isFinishing()) {
                    return;
                }
                //检查更新
                String nowVersion = MyApp.getVersion();
                //服务器端版本号
//                String newVersion = appInfo.getResult().get(0).getFversion();
                String newVersion = "1.2.1";
                //test
//                String newVersion = "1.0.4";
                if (nowVersion.equals(newVersion)) {
                    hideProgress();
                    Toast.makeText(context, "已是最新版本", Toast.LENGTH_SHORT).show();
                }

                Log.i("TEST11", newVersion);
                //新版本App的下载地址
//                String downloadUrl = appInfo.getResult().get(0).getFaddress();

                String downloadUrl = "http://47.110.9.80:8080/lanyu/app/weibo.apk";
                //版本更新提醒的标题
                String title = "发现新版本";
                //版本更新提醒的详细信息
                String updateContent = appInfo.getResult().get(0).getFcontext().replace("##", "\n");
                //如果当前版本与远程最新版本不符,则调用App更新下载的方法

                if (!nowVersion.equals(newVersion)) {
                    AppUpdate.sendRequest(context, title, "1、优化了运行速度\n2、修复了一些BUG", downloadUrl);
                }
            }

            @Override
            public void onError(String error) {
                hideProgress();
                if (SplashActivity.this.isFinishing()) {
                    return;
                }
                hideProgress();
                Toast.makeText(context, "获取更新失败", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //App开启时 更新 错误弹窗
    private void getUpdateFail() {
        timer.cancel();
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setTitle("警告");
        builder.setMessage("网络异常,请检查");
        builder.setCancelable(false);
        builder.setPositiveButton("再试一次", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                isGetUpdateComplete = false;
                count = 0;
                failCount = 0;
                checkUpdate();
                jumpLogin();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();


    }

    //应用中手动点击检查更新
    public void upDate(Context context) {
        showProgress("正在检查更新", false, context);
        myUpdate(context);


    }

    //显示正在检查更新
    public void showProgress(String msg, boolean flag, Context context) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
        }
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(flag);
        progressDialog.setCanceledOnTouchOutside(flag);
        try {
            progressDialog.show();
        } catch (Exception e) {

        }

        isProgressing = true;
    }

    public void hideProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        isProgressing = false;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }

        myHandler.removeCallbacksAndMessages(null);
    }
}
