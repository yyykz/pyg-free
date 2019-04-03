package cn.itcast.core.service;

import cn.itcast.core.pojo.good.Brand;
import entity.PageResult;

import java.util.List;

/**
 * @Author: keyuzhang
 * @Date: 2019/3/29 18:06
 * @Version 1.0
 */

public interface BrandService {
    //查询所有品牌结果集
    List<Brand> findAll();
    //查询分页对象
    PageResult findPage(Integer pageNum, Integer pageSize);
    //条件查询
    PageResult search(Integer pageNum, Integer pageSize,Brand brand);
    //添加
    void add(Brand brand);
    //查询单体
    Brand findOne(Long id);
    //更改
    void update(Brand brand);
    //删除
    void delete(Long[] ids);

}
