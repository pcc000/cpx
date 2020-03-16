package com.project.cpx.entity.query;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/1 19:29
 * @Description:
 */
public class Page {

    private static Integer MAX_PAGE_SIZE = 2000;
    private static Integer DEFAULT_PAGE_SIZE = 20;
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalRecored;

    public Page() {
    }

    public Integer getPageSize() {
        return this.pageSize != null && this.pageSize >= 1 ? this.pageSize : DEFAULT_PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        } else if (pageSize > MAX_PAGE_SIZE) {
            this.pageSize = MAX_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
    }

    public Integer getCurrentPage() {
        return this.currentPage != null && this.currentPage >= 1 ? this.currentPage : 1;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageTotal() {
        if (this.totalRecored == null) {
            return 0;
        } else {
            int tp = this.totalRecored / this.getPageSize();
            if (this.totalRecored % this.getPageSize() > 0) {
                ++tp;
            }

            return tp;
        }
    }

    public Integer getTotalRecored() {
        return this.totalRecored;
    }

    public void setTotalRecored(Integer totalRecored) {
        this.totalRecored = totalRecored;
    }

    public Integer getOffset() {
        return (this.getCurrentPage() - 1) * this.getPageSize();
    }
}
