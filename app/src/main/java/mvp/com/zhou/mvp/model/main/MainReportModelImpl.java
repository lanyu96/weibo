package mvp.com.zhou.mvp.model.main;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import mvp.com.zhou.mvp.R;
import mvp.com.zhou.mvp.utils.bean.weibo.JVListBean;
import mvp.com.zhou.mvp.model.base.BaseModelImpl;


/**
 * @Auther: test
 * @Date: 2018/7/27 15:34
 * @Description:
 */
public class MainReportModelImpl extends BaseModelImpl implements MainReportModel {


    JVListBean jvListBean = new JVListBean();

    private List<List> list = new ArrayList<>();
    private List<String> listName = new ArrayList<>();
    private List<String> listWBName = new ArrayList<>();
    private List<String> listIndex = new ArrayList<>();
    private List<String> listFenSi = new ArrayList<>();
    private List<String> listMoney = new ArrayList<>();
    private List<Integer> listInt = new ArrayList<>();
    private List<Drawable> drawList = new ArrayList<>();

    public JVListBean setListBean() {


        return jvListBean;
    }

    @Override
    public List<List> getJVBeanList() {

        listName.add("a1");
        listName.add("a2");
        listName.add("a3");
        listName.add("a4");
        listName.add("a5");
        listName.add("a6");
        listName.add("a7");
        listName.add("a8");
        listName.add("a9");
        listName.add("b1");
        listName.add("b2");
        listName.add("b3");
        listName.add("b4");
        listName.add("b5");
        listName.add("b6");


//        drawList.add(R.drawable.j01);


        listInt.add(R.drawable.j01);
        listInt.add(R.drawable.j02);
        listInt.add(R.drawable.j03);
        listInt.add(R.drawable.j04);
        listInt.add(R.drawable.j05);
        listInt.add(R.drawable.j06);
        listInt.add(R.drawable.j07);
        listInt.add(R.drawable.j08);
        listInt.add(R.drawable.j09);
        listInt.add(R.drawable.j10);
        listInt.add(R.drawable.j11);
        listInt.add(R.drawable.j12);
        listInt.add(R.drawable.j13);
        listInt.add(R.drawable.j14);
        listInt.add(R.drawable.j15);

        listWBName.add("a1");
        listWBName.add("a2");
        listWBName.add("a3");
        listWBName.add("a4");
        listWBName.add("a5");
        listWBName.add("a6");
        listWBName.add("a1");
        listWBName.add("a1");
        listWBName.add("a1");
        listWBName.add("a1");
        listWBName.add("a1");
        listWBName.add("a1");
        listWBName.add("a1");
        listWBName.add("a1");
        listWBName.add("a1");

        listIndex.add("a1");
        listIndex.add("a2");
        listIndex.add("a3");
        listIndex.add("a4");
        listIndex.add("a5");
        listIndex.add("a6");
        listIndex.add("a1");
        listIndex.add("a1");
        listIndex.add("a1");
        listIndex.add("a1");
        listIndex.add("a1");
        listIndex.add("a1");
        listIndex.add("a1");
        listIndex.add("a1");
        listIndex.add("a1");

        listFenSi.add("a1");
        listFenSi.add("a2");
        listFenSi.add("a3");
        listFenSi.add("a4");
        listFenSi.add("a5");
        listFenSi.add("a6");
        listFenSi.add("a1");
        listFenSi.add("a1");
        listFenSi.add("a1");
        listFenSi.add("a1");
        listFenSi.add("a1");
        listFenSi.add("a1");
        listFenSi.add("a1");
        listFenSi.add("a1");
        listFenSi.add("a1");

        listMoney.add("a1");
        listMoney.add("a2");
        listMoney.add("a3");
        listMoney.add("a4");
        listMoney.add("a5");
        listMoney.add("a6");
        listMoney.add("a1");
        listMoney.add("a1");
        listMoney.add("a1");
        listMoney.add("a1");
        listMoney.add("a1");
        listMoney.add("a1");
        listMoney.add("a1");
        listMoney.add("a1");
        listMoney.add("a1");

        list.add(listIndex);
        list.add(listFenSi);
        list.add(listInt);
        list.add(listMoney);
        list.add(listWBName);
        list.add(listName);


        return list;

    }

//    @Override
//    public List<String> name() {
//        listName.add("a1");
//        listName.add("a2");
//        listName.add("a3");
//        listName.add("a4");
//        listName.add("a5");
//        listName.add("a6");
//        listName.add("a1");
//        listName.add("a1");
//        listName.add("a1");
//        listName.add("a1");
//        listName.add("a1");
//        listName.add("a1");
//        listName.add("a1");
//        listName.add("a1");
//        listName.add("a1");
//        return listName;
//
//    }
//    @Override
//    public List<Integer> head() {
//
//        listInt.add(R.drawable.j01);
//        listInt.add(R.drawable.j02);
//        listInt.add(R.drawable.j03);
//        listInt.add(R.drawable.j04);
//        listInt.add(R.drawable.j01);
//        listInt.add(R.drawable.j01);
//        listInt.add(R.drawable.j01);
//        listInt.add(R.drawable.j01);
//        listInt.add(R.drawable.j01);
//        listInt.add(R.drawable.j01);
//        listInt.add(R.drawable.j01);
//        listInt.add(R.drawable.j01);
//        listInt.add(R.drawable.j01);
//        listInt.add(R.drawable.j01);
//        listInt.add(R.drawable.j01);
//
//        return listInt;
//    }

//    @Override
//    public List<String> WBName() {
//
//        listWBName.add("a1");
//        listWBName.add("a2");
//        listWBName.add("a3");
//        listWBName.add("a4");
//        listWBName.add("a5");
//        listWBName.add("a6");
//        listWBName.add("a1");
//        listWBName.add("a1");
//        listWBName.add("a1");
//        listWBName.add("a1");
//        listWBName.add("a1");
//        listWBName.add("a1");
//        listWBName.add("a1");
//        listWBName.add("a1");
//        listWBName.add("a1");
//
//        return listWBName;
//    }

//    @Override
//    public List<String> IndexStr() {
//
//        listIndex.add("a1");
//        listIndex.add("a2");
//        listIndex.add("a3");
//        listIndex.add("a4");
//        listIndex.add("a5");
//        listIndex.add("a6");
//        listIndex.add("a1");
//        listIndex.add("a1");
//        listIndex.add("a1");
//        listIndex.add("a1");
//        listIndex.add("a1");
//        listIndex.add("a1");
//        listIndex.add("a1");
//        listIndex.add("a1");
//        listIndex.add("a1");
//
//        return listIndex;
//    }
//    @Override
//    public List<String> Fensi() {
//        listFenSi.add("a1");
//        listFenSi.add("a2");
//        listFenSi.add("a3");
//        listFenSi.add("a4");
//        listFenSi.add("a5");
//        listFenSi.add("a6");
//        listFenSi.add("a1");
//        listFenSi.add("a1");
//        listFenSi.add("a1");
//        listFenSi.add("a1");
//        listFenSi.add("a1");
//        listFenSi.add("a1");
//        listFenSi.add("a1");
//        listFenSi.add("a1");
//        listFenSi.add("a1");
//
//        return listFenSi;
//    }
//    @Override
//    public List<String> Money() {
//        listMoney.add("a1");
//        listMoney.add("a2");
//        listMoney.add("a3");
//        listMoney.add("a4");
//        listMoney.add("a5");
//        listMoney.add("a6");
//        listMoney.add("a1");
//        listMoney.add("a1");
//        listMoney.add("a1");
//        listMoney.add("a1");
//        listMoney.add("a1");
//        listMoney.add("a1");
//        listMoney.add("a1");
//        listMoney.add("a1");
//        listMoney.add("a1");
//
//        return listMoney;
//    }
}
