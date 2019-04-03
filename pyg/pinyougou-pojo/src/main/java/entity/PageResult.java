package entity;

import java.io.Serializable;
import java.util.List;

/**
 * 封装分页结果对象
 * @Author: keyuzhang
 * @Date: 2019/3/30 15:35
 * @Version 1.0
 */
public class PageResult implements Serializable {
    //总记录数
    private Long total;
    //当前页的结果集
    private List<?> rows;

    public PageResult(Long total, List <?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List <?> getRows() {
        return rows;
    }

    public void setRows(List <?> rows) {
        this.rows = rows;
    }
}
