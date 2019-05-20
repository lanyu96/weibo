package mvp.com.zhou.mvp.utils.bean.weibo;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class JVBean implements Serializable {
    private int head;
    private String name;
    private String WBName;
    private String indexSrc;
    private String fenSi;
    private String money;

    private Drawable icon;

    private String phoneNumber;

    private String wxNumber;

    private String jinOrHuang;


    public JVBean() {

    }


    public JVBean(String name, String phoneNumber, String wxNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.wxNumber = wxNumber;
    }

    public JVBean(int head, String name, String WBName, String indexSrc, String fenSi, String money, String phoneNumber, String wxNumber, String jinOrHuang) {
        this.head = head;
        this.name = name;
        this.WBName = WBName;
        this.indexSrc = indexSrc;
        this.fenSi = fenSi;
        this.money = money;
        this.phoneNumber = phoneNumber;
        this.wxNumber = wxNumber;
        this.jinOrHuang = jinOrHuang;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWxNumber() {
        return wxNumber;
    }

    public void setWxNumber(String wxNumber) {
        this.wxNumber = wxNumber;
    }

    public String getJinOrHuang() {
        return jinOrHuang;
    }

    public void setJinOrHuang(String jinOrHuang) {
        this.jinOrHuang = jinOrHuang;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWBName() {
        return WBName;
    }

    public void setWBName(String WBName) {
        this.WBName = WBName;
    }

    public String getIndexSrc() {
        return indexSrc;
    }

    public void setIndexSrc(String indexSrc) {
        this.indexSrc = indexSrc;
    }

    public String getFenSi() {
        return fenSi;
    }

    public void setFenSi(String fenSi) {
        this.fenSi = fenSi;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
