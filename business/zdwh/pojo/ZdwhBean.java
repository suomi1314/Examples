package com.green.yxyl.business.zdwh.pojo;

import com.green.yxyl.base.web.BaseBean;

import java.util.List;

/**
 * @author 卞兴舜
 * @ClassName: ZdwhBean
 * @Description: 站点维护模块bean层
 * @date 2017年05月17日
 */
public class ZdwhBean extends BaseBean {
    /**
     * 编号
     */
    private String lsh;
    /**
     * 删除标记
     */
    private String scbj;
    /**
     * username
     */
    private String user_name;
    /**
     * user_id
     */
    private String user_id;
    /**
     * 站点代码
     */
    private String zddm;
    /**
     * 站点名称
     */
    private String zdmc;
    /**
     * 站点地址
     */
    private String zddz;
    /**
     * 站点经度
     */
    private String zdjd;
    /**
     * 站点纬度
     */
    private String zdwd;
    /**
     * 开始时间
     */
    private String kssj;
    /**
     * 结束时间
     */
    private String jssj;
    /**
     * 城市代码
     */
    private String csdm;
    /**
     * 城市名称
     */
    private String csmc;
    /**
     * 开始记录
     */
    private int start;
    /**
     * 每页显示数目
     */
    private int pageSize;
    /**
     * 排序依据
     */
    private String sort;
    /**
     * 升序或降序
     */
    private String dir;
    /**
     * 升序或降序
     */
    private String order;
    /**
     * listbean
     */
    private List<ZdwhBean> listZdwhBean;
    /**
     * 记录数
     */
    private int count;
    /**
     * 成功标识
     */
    private String flag;

    //------------------------------------------------------getter,setter------------------------------------------------------


    public void setZdmc(String zdmc) {
        this.zdmc = zdmc;
    }

    public String getZddz() {
        return zddz;
    }

    public void setZddz(String zddz) {
        this.zddz = zddz;
    }

    public String getZdjd() {
        return zdjd;
    }

    public void setZdjd(String zdjd) {
        this.zdjd = zdjd;
    }

    public String getZdwd() {
        return zdwd;
    }

    public void setZdwd(String zdwd) {
        this.zdwd = zdwd;
    }

    public String getKssj() {
        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    public String getJssj() {
        return jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj;
    }

    public String getZddm() {
        return zddm;
    }

    public void setZddm(String zddm) {
        this.zddm = zddm;
    }

    public String getZdmc() {
        return zdmc;
    }

    public String getCsdm() {
        return csdm;
    }

    public void setCsdm(String csdm) {
        this.csdm = csdm;
    }

    public String getCsmc() {
        return csmc;
    }

    public void setCsmc(String csmc) {
        this.csmc = csmc;
    }

    @Override
    public String getLsh() {
        return lsh;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String getUser_id() {
        return user_id;
    }

    @Override
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    @Override
    public String getScbj() {
        return scbj;
    }

    @Override
    public void setScbj(String scbj) {
        this.scbj = scbj;
    }

    @Override
    public int getStart() {
        return start;
    }

    @Override
    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String getSort() {
        return sort;
    }

    @Override
    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String getDir() {
        return dir;
    }

    @Override
    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<ZdwhBean> getListZdwhBean() {
        return listZdwhBean;
    }

    public void setListZdwhBean(List<ZdwhBean> listZdwhBean) {
        this.listZdwhBean = listZdwhBean;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String getFlag() {
        return flag;
    }

    @Override
    public void setFlag(String flag) {
        this.flag = flag;
    }


}
