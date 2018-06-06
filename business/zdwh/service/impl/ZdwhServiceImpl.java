package com.green.yxyl.business.zdwh.service.impl;

import com.green.yxyl.base.util.CommonUtil;
import com.green.yxyl.business.zdwh.dao.ZdwhDao;
import com.green.yxyl.business.zdwh.pojo.ZdwhBean;
import com.green.yxyl.business.zdwh.service.ZdwhService;
import com.green.yxyl.business.zdwh.web.ZdwhAction;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 卞兴舜
 * @ClassName: ZdwhServiceImpl
 * @Description: 站点维护模块业务层接口实现类
 * @date 2017年05月17日
 */
public class ZdwhServiceImpl implements ZdwhService {
    /**
     * 日志
     */
    private Logger log = Logger.getLogger(ZdwhAction.class);
    /**
     * 注入dao
     */
    private ZdwhDao zdwhDao;
    /**
     * 设置结果标识常量，执行成功：1  执行失败：0
     */
    private static final String ERROR = "0";
    private static final String SUCCESS = "1";

    /**
     * (非 Javadoc)
     * Title: queryByPage
     * Description: 分页查询站点
     *
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @param zdwhBean
     * @return
     * @throws Exception
     */
    @Override
    public ZdwhBean queryByPage(String page, String rows, String sort, String order, ZdwhBean zdwhBean) throws Exception {
        log.debug("-->>进入ZdwhServiceImpl-->>执行queryByPage()分页查询站点");
        //当前页
        int intPage = Integer.parseInt((page == null || page == "0") ? "1" : page);
        //每页显示条数  
        int number = Integer.parseInt((rows == null || rows == "0") ? "10" : rows);
        //每页的开始记录  第一页为1  第二页为number +1   
        int start = (intPage - 1) * number;
        if (zdwhBean == null) {
            zdwhBean = new ZdwhBean();
        }
        zdwhBean.setPageSize(number);
        zdwhBean.setDir(order);
        zdwhBean.setStart(start);
        zdwhBean.setSort(sort);
        //查询
        List<ZdwhBean> listZdwhBean = new ArrayList<ZdwhBean>();
        listZdwhBean = zdwhDao.queryByPage(zdwhBean);
        //创建结果
        ZdwhBean resultBean = new ZdwhBean();
        resultBean.setListZdwhBean(listZdwhBean);
        resultBean.setCount(zdwhDao.countAll(zdwhBean));
        log.debug("-->>结束ZdwhServiceImpl-->>执行queryByPage()分页查询站点-->>结束");
        return resultBean;
    }

    /**
     * (非 Javadoc)
     * Title: queryCs
     * Description: 查询城市列表
     *
     * @param zdwhBean
     * @return
     * @throws Exception
     */
    @Override
    public List<ZdwhBean> queryCs(ZdwhBean zdwhBean) throws Exception {
        log.debug("-->>进入ZdwhServiceImpl-->>执行queryJg()查询城市列表");
        //查询
        List<ZdwhBean> listZdwhBean = new ArrayList<ZdwhBean>();
        listZdwhBean = zdwhDao.queryCs(zdwhBean);
        log.debug("-->>结束ZdwhServiceImpl-->>queryCs()查询城市列表-->>结束");
        return listZdwhBean;
    }

    /**
     * (非 Javadoc)
     * Title: insert
     * Description: 添加
     *
     * @param zdwhBean
     * @return
     * @throws Exception
     */
    @Override
    public ZdwhBean insert(ZdwhBean zdwhBean) throws Exception {
        log.debug("-->>进入ZdwhServiceImpl-->>执行insert()添加");
        //创建结果
        ZdwhBean resultBean = new ZdwhBean();
        //设置初始标识
        resultBean.setFlag(ERROR);
        //流水号
        zdwhBean.setLsh(CommonUtil.getUuid());
        //获取最大城市代码
        String maxzddm = zdwhDao.queryMaxZddm(zdwhBean);
        if(maxzddm == null){
            maxzddm = "0";
        }
        //处理等级代码自增
        int i=Integer.valueOf(maxzddm)+1;
        //为了拼接字符串使用
        StringBuffer sb=new StringBuffer();
        //累加后转成字符串
        String num=String.valueOf(i);
        //补全前面缺失的0
        for (int j = 0; j < 4-num.length(); j++) {
            sb.append("0");
        }
        if(num.length()<=4){
            num=sb.toString()+num;
        }
        //城市代码
        zdwhBean.setZddm(num);
        //执行添加
        int result = zdwhDao.insert(zdwhBean);
        if (result > 0) {
            resultBean.setFlag(SUCCESS);
        }
        log.debug("-->>结束ZdwhServiceImpl-->>执行insert()添加-->>结束");
        return resultBean;
    }

    /**
     * (非 Javadoc)
     * Title: update
     * Description: 修改
     *
     * @param zdwhBean
     * @return
     * @throws Exception
     */
    @Override
    public ZdwhBean update(ZdwhBean zdwhBean) throws Exception {
        log.debug("-->>进入ZdwhServiceImpl-->>执行update()修改");
        //创建结果
        ZdwhBean resultBean = new ZdwhBean();
        //设置初始标识
        resultBean.setFlag(ERROR);
        //执行添加
        int result = zdwhDao.update(zdwhBean);
        if (result > 0) {
            resultBean.setFlag(SUCCESS);
        }
        log.debug("-->>结束ZdwhServiceImpl-->>执行update()修改-->>结束");
        return resultBean;
    }

    /**
     * (非 Javadoc)
     * Title: delete
     * Description: 删除
     *
     * @param lshs
     * @return
     * @throws Exception
     */
    @Override
    public ZdwhBean delete(String lshs, String user_ids) throws Exception {
        log.debug("-->>进入ZdwhServiceImpl-->>执行delete()删除");
        //创建结果
        ZdwhBean resultBean = new ZdwhBean();
        //设置初始标识
        resultBean.setFlag(ERROR);
        //字符串转化成list
        String[] str = lshs.split(",");
        List<String> srt_list = Arrays.asList(str);
        if (srt_list.size() > 0) {
            int result = zdwhDao.delete(srt_list);
            if (result > 0) {
                resultBean.setFlag(SUCCESS);
            }
        }
        log.debug("-->>结束ZdwhServiceImpl-->>执行delete()删除-->>结束");
        return resultBean;
    }


    //------------------------------------------------------getter,setter------------------------------------------------------

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public ZdwhDao getZdwhDao() {
        return zdwhDao;
    }

    public void setZdwhDao(ZdwhDao zdwhDao) {
        this.zdwhDao = zdwhDao;
    }

    public static String getError() {
        return ERROR;
    }

    public static String getSuccess() {
        return SUCCESS;
    }

}
