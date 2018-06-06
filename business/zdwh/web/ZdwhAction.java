package com.green.yxyl.business.zdwh.web;

import com.green.yxyl.base.web.BaseAction;
import com.green.yxyl.business.zdwh.pojo.ZdwhBean;
import com.green.yxyl.business.zdwh.service.ZdwhService;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 卞兴舜
 * @ClassName: ZdwhAction
 * @Description: 站点维护模块Action
 * @date 2017年05月17日
 */
public class ZdwhAction extends BaseAction {

    /**
     * 日志
     */
    private Logger log = Logger.getLogger(ZdwhAction.class);
    /**
     * 注入service
     */
    private ZdwhService zdwhServiceImpl;
    //从前台接受的参数
    /**
     * 每页显示记录数
     */
    private int limit;
    /**
     * 分页开始
     */
    private int start;
    /**
     * 排序的列
     */
    private String sort;
    /**
     * 每页显示的记录数
     */
    private String rows;
    /**
     * 当前第几页
     */
    private String page;
    /**
     * 排序的顺序
     */
    private String order;
    /**
     * 前台参数
     */
    private ZdwhBean zdwhBean;
    /**
     * 前台参数,删除数据的lsh
     */
    private String ids;
    /**
     * 前台参数,删除数据的user_id
     */
    private String user_ids;

    //返回给前台的参数
    /**
     * 返回的map
     */
    private Map<String, Object> resultMap;
    /**
     * 结果参数
     */
    private ZdwhBean resultBean;
    /**
     * 结果list
     */
    private List<ZdwhBean> resultList;

    /**
     * @param @return
     * @return String
     * @throws
     * @Title: queryByPage
     * @Description: 分页查询
     */
    public String queryByPage() {
        log.debug("-->>CswhAction->>查询所有-->>queryByPage");
        ZdwhBean formBean = new ZdwhBean();
        try {

            if (zdwhBean != null) {
                if (zdwhBean.getZdmc() != null) {
                    String zdmc = new String(zdwhBean.getZdmc().getBytes("ISO-8859-1"), "UTF-8");
                    zdwhBean.setZdmc(zdmc);
                }
            }
            formBean = zdwhServiceImpl.queryByPage(page, rows, sort, order, zdwhBean);
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("total", formBean.getCount());
            m.put("rows", formBean.getListZdwhBean());
            resultMap = m;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.debug("-->>CswhAction->>结束查询所有-->>queryByPage");
        zdwhBean = null;
        return "result";
    }

    /**
     * @param @return
     * @return String
     * @throws
     * @Title: queryCs
     * @Description:查询城市列表
     */
    public String queryCs() {
        log.debug("-->>CswhAction->>查询城市列表-->>queryCs");
        try {
            resultList = zdwhServiceImpl.queryCs(zdwhBean);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.debug("-->>CswhAction->>结束查询城市列表-->>queryCs");
        zdwhBean = null;
        return "result";
    }

    /**
     * @param @return
     * @return String
     * @throws
     * @Title: insert
     * @Description: 添加
     */
    public String insert() {
        log.debug("-->>进入ZdwhAction-->>执行insert()添加");
        try {
            //添加
            resultBean = zdwhServiceImpl.insert(zdwhBean);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error(e.getMessage());
        }
        log.debug("-->>结束ZdwhAction");
        zdwhBean = null;
        return "result";
    }

    /**
     * @param @return
     * @return String
     * @throws
     * @Title: update
     * @Description: 修改
     */
    public String update() {
        log.debug("-->>进入ZdwhAction-->>执行update()修改");
        try {
            //修改
            resultBean = zdwhServiceImpl.update(zdwhBean);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error(e.getMessage());
        }
        log.debug("-->>结束ZdwhAction");
        zdwhBean = null;
        return "result";
    }

    /**
     * @param @return
     * @return String
     * @throws
     * @Title: delete
     * @Description: 删除
     */
    public String delete() {
        log.debug("-->>进入ZdwhAction-->>执行delete()删除");
        try {
            //删除
            resultBean = zdwhServiceImpl.delete(ids, user_ids);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error(e.getMessage());
        }
        log.debug("-->>结束ZdwhAction");
        ids = null;
        return "result";
    }

    //------------------------------------------------------getter,setter------------------------------------------------------

    public List<ZdwhBean> getResultList() {
        return resultList;
    }

    public void setResultList(List<ZdwhBean> resultList) {
        this.resultList = resultList;
    }

    public Logger getLog() {
        return log;
    }

    public String getUser_ids() {
        return user_ids;
    }

    public void setUser_ids(String user_ids) {
        this.user_ids = user_ids;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public ZdwhService getZdwhServiceImpl() {
        return zdwhServiceImpl;
    }

    public void setZdwhServiceImpl(ZdwhService zdwhServiceImpl) {
        this.zdwhServiceImpl = zdwhServiceImpl;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public ZdwhBean getZdwhBean() {
        return zdwhBean;
    }

    public void setZdwhBean(ZdwhBean zdwhBean) {
        this.zdwhBean = zdwhBean;
    }

    @Override
    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    @Override
    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public ZdwhBean getResultBean() {
        return resultBean;
    }

    public void setResultBean(ZdwhBean resultBean) {
        this.resultBean = resultBean;
    }


}
