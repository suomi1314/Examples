package com.green.yxyl.business.zdwh.service;

import com.green.yxyl.business.zdwh.pojo.ZdwhBean;

import java.util.List;

/**
 * @author 卞兴舜
 * @ClassName: ZdwhService
 * @Description: 站点维护模块业务层接口
 * @date 2017年05月17日
 */
public interface ZdwhService {
    /**
     * @param @param  page,rows,sort,order,zdwhBean
     * @param @return
     * @param @throws Exception
     * @return CswhBean
     * @throws
     * @Title: queryByPage
     * @Description: 分页查询站点
     */
    public ZdwhBean queryByPage(String page, String rows, String sort, String order, ZdwhBean zdwhBean) throws Exception;

    /**
     * @param @param  zdwhBean
     * @param @return
     * @param @throws Exception
     * @return List<CswhBean>
     * @throws
     * @Title: queryCs
     * @Description: 查询城市列表
     */
    public List<ZdwhBean> queryCs(ZdwhBean zdwhBean) throws Exception;

    /**
     * @param @param  zdwhBean
     * @param @return
     * @param @throws Exception
     * @return CswhBean
     * @throws
     * @Title: insert
     * @Description: 增加
     */
    public ZdwhBean insert(ZdwhBean zdwhBean) throws Exception;

    /**
     * @param @param  zdwhBean
     * @param @return
     * @param @throws Exception
     * @return CswhBean
     * @throws
     * @Title: update
     * @Description: 修改
     */
    public ZdwhBean update(ZdwhBean zdwhBean) throws Exception;

    /**
     * @param @param  lshs
     * @param @return
     * @param @throws Exception
     * @return CswhBean
     * @throws
     * @Title: delete
     * @Description: 删除
     */
    public ZdwhBean delete(String lshs, String user_ids) throws Exception;
}
