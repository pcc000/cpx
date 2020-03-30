package com.project.cpx.entity.query;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/1 19:27
 * @Description:
 */
public class BaseQuery extends Page{

    private String start;

    private String end;

    public static final String ASC = "ASC";

    public static final String DESC = "DESC";

    private String column;

    private String sort;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public static String getASC() {
        return ASC;
    }

    public static String getDESC() {
        return DESC;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


}
