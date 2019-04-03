package entity;

/**
 * 返回添加结果
 * @Author: keyuzhang
 * @Date: 2019/3/30 20:27
 * @Version 1.0
 */
public class WebManagerAddResult {
    private boolean flag;
    private String messgae;

    public WebManagerAddResult(boolean flag, String messgae) {
        this.flag = flag;
        this.messgae = messgae;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }
}
