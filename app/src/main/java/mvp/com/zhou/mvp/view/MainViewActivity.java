package mvp.com.zhou.mvp.view;


import android.graphics.Color;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;
import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.presenter.MainPresenterImpl;
import mvp.com.zhou.mvp.view.base.BaseActivity;
import mvp.com.zhou.mvp.view.main.MainHomeViewFrag;
import mvp.com.zhou.mvp.view.main.MainOperateViewFrag;
import mvp.com.zhou.mvp.view.main.MainPersonViewFrag;
import mvp.com.zhou.mvp.view.main.MainReportViewFrag;


public class MainViewActivity extends BaseActivity<MainPresenterImpl> implements MainView {
    private MainHomeViewFrag mainHomeViewFrag;
    private MainOperateViewFrag mainOperateViewFrag;
    private MainReportViewFrag mainReportViewFrag;
    private MainPersonViewFrag mainPersonViewFrag;
    private NavigationTabBar navigationTabBar;


    @Override
    public MainPresenterImpl initPresent() {
        return new MainPresenterImpl();
    }

    @Override
    public void initView() {
//        instance = this;
        setContentView(R.layout.activity_main_view);

    }

    @Override
    public void initEvent() {



    }

    @Override
    public void initData() {
        //实例化fragment


        mainOperateViewFrag = new MainOperateViewFrag();
        mainReportViewFrag = new MainReportViewFrag();
        mainPersonViewFrag = new MainPersonViewFrag();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.act_main_all_fragment_fl, mainOperateViewFrag)
                .add(R.id.act_main_all_fragment_fl,mainReportViewFrag)
                .add(R.id.act_main_all_fragment_fl,mainPersonViewFrag).commitAllowingStateLoss();
        getSupportFragmentManager().beginTransaction().show(mainOperateViewFrag)
                .hide(mainReportViewFrag)
                .hide(mainPersonViewFrag).commitAllowingStateLoss();


        navigationTabBar = findViewById(R.id.act_main_ntb_horizontal);

        //设置底部Tab 图标的标题
        String[] titles = new String[]{ "黄V","金V", "我"};
        ArrayList<View> views = new ArrayList<>();
        //设置每个View的不同背景
//        int[] viewBgs = new int[]{Color.RED, Color.GRAY, Color.BLUE};
        //设置底部Tab的各个图标
        int[] icons = new int[]{R.drawable.icon_setting,R.drawable.icon_qita, R.drawable.icon_me};
        //用来生成各个不同选项的
        ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            models.add(
                    new NavigationTabBar.Model.Builder(
                            getResources().getDrawable(icons[i]),
                            Color.parseColor("#00000000"))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_sixth))
                            .title(titles[i])
//                            .badgeTitle("NTB")    //角标
                            .build()
            );
            View view = new View(this);
//            view.setBackgroundColor(viewBgs[i]);
//            views.add(view);
        }
//        viewPager.setAdapter(new TabAdapter(this, views));
        navigationTabBar.setModels(models);
        navigationTabBar.setModelIndex(0);
        navigationTabBar.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
            @Override
            public void onStartTabSelected(NavigationTabBar.Model model, int index) {
                switch (index) {
                    case 0:
                        getSupportFragmentManager().beginTransaction().show(mainOperateViewFrag)
                                .hide(mainPersonViewFrag)
                                .hide(mainReportViewFrag)
                                .commitAllowingStateLoss();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().show(mainReportViewFrag)
                                .hide(mainPersonViewFrag)
                                .hide(mainOperateViewFrag).commitAllowingStateLoss();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().show(mainPersonViewFrag)
                                .hide(mainOperateViewFrag)
                                .hide(mainReportViewFrag)
                                .commitAllowingStateLoss();
                }

            }

            @Override
            public void onEndTabSelected(NavigationTabBar.Model model, int index) {

            }
        });
    }


    @Override
    public void click(View v) {
        onMyClick(v);
    }


    @Override
    public void onMyClick(View v) {
        switch (v.getId()) {
//            case R.id.ll_main_home:
//                selectTab(0);
//                break;
//            case R.id.ll_main_operate:
////                String style = MyApp.getPreferencesService().getValue(SPConstants.STYLE_ID, "");
////                if (style.equals("简约")) {
////
////                    newStyle = true;
////                }else if (style.equals("标准")) {
////                    newStyle = false;
////                }
//                selectTab(1);
//                break;
//            case R.id.ll_main_report:
//                selectTab(2);
//                break;
//            case R.id.ll_main_person:
//                selectTab(3);
//                break;
        }
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        //解注册EventBus
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
