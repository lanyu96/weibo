package mvp.com.zhou.mvp.utils.bean;

import java.io.Serializable;

/**
 * @Auther: test
 * @Date: 2018/10/19 11:36
 * @Description:
 */
public class PigFarmInfo implements Serializable {
    private String id;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
