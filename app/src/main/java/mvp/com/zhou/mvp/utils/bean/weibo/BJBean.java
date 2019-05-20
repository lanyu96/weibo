package mvp.com.zhou.mvp.utils.bean.weibo;

public class BJBean {

    private String day3;
    private String day7;
    private String day15;
    private String day30;

    public BJBean() {
    }


    public BJBean(String day3, String day7, String day15, String day30) {
        this.day3 = day3;
        this.day7 = day7;
        this.day15 = day15;
        this.day30 = day30;
    }

    public String getDay3() {
        return day3;
    }

    public void setDay3(String day3) {
        this.day3 = day3;
    }

    public String getDay7() {
        return day7;
    }

    public void setDay7(String day7) {
        this.day7 = day7;
    }

    public String getDay15() {
        return day15;
    }

    public void setDay15(String day15) {
        this.day15 = day15;
    }

    public String getDay30() {
        return day30;
    }

    public void setDay30(String day30) {
        this.day30 = day30;
    }
}
