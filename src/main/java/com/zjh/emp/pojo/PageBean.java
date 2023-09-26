package com.zjh.emp.pojo;

import java.util.List;

/****************************
 * @project empservice
 * @package com.zjh.emp.pojo
 * @className PageBean
 * @author Zjiah
 * @date 2023/9/25 17:38
 * @Description:   *
 ****************************/
public class PageBean {
    private Long total;

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    private List rows;

    public PageBean() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getrows() {
        return rows;
    }

    public void setrows(List rows) {
        this.rows = rows;
    }

    public PageBean(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}
