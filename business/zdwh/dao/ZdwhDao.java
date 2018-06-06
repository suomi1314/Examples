package com.green.yxyl.business.zdwh.dao;

import com.green.yxyl.business.zdwh.pojo.ZdwhBean;

import java.util.List;

/**
 * @author 卞兴舜
 * @ClassName: ZdwhDao
 * @Description: 站点维护模块Dao层
 * @date 2017年05月17日
 */
public interface ZdwhDao {
    /**
     * @param @param  zdwhBean
     * @param @return
     * @return int
     * @throws
     * @Title: countAll
     * @Description: 分页查询站点记录数
     */
    public int countAll(ZdwhBean zdwhBean);

    /**
     * @param @param  zdwhBean
     * @param @return
     * @return List<CswhBean>
     * @throws
     * @Title: queryByPage
     * @Description: 分页查询站点
     */
    public List<ZdwhBean> queryByPage(ZdwhBean zdwhBean);

    /**
     * @param @param  zdwhBean
     * @param @return
     * @return List<CswhBean>
     * @throws
     * @Title: queryCs
     * @Description: 查询城市列表
     */
    public List<ZdwhBean> queryCs(ZdwhBean zdwhBean);

    /**
     * @param @param  zdwhBean
     * @param @return
     * @return int
     * @throws
     * @Title: insert
     * @Description: 添加
     */
    public int insert(ZdwhBean zdwhBean);

    /**
     * @param @param  zdwhBean
     * @param @return
     * @return int
     * @throws
     * @Title: update
     * @Description: 修改
     */
    public int update(ZdwhBean zdwhBean);

    /**
     * @param @param  lshs
     * @param @return
     * @return int
     * @throws
     * @Title: delete
     * @Description: 删除
     */
    public int delete(List<String> lshs);

    /**
     * 查询最大站点代码
     * @param zdwhBean
     * @return
     */
    String queryMaxZddm(ZdwhBean zdwhBean);
}
