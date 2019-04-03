package cn.itcast.core.service;
/**
 * 品牌管理
 * @author lx
 *
 */

import cn.itcast.core.dao.good.BrandDao;
import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.pojo.good.BrandQuery;
import cn.itcast.core.pojo.good.BrandQuery.Criteria;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;
    //查询所有品牌结果集
    public List<Brand> findAll(){
        return brandDao.selectByExample(null);
    }
    //查询分页对象
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        // TODO Auto-generated method stub
        //分页插件
        PageHelper.startPage(pageNum, pageSize);
        //select * from 表   limit 开始行,每页数
        //查询所有品牌结果集
        Page<Brand>  p =  (Page<Brand>) brandDao.selectByExample(null);
        return new PageResult(p.getTotal(), p.getResult());
    }
    //条件查询
    public PageResult search(Integer pageNum, Integer pageSize,Brand brand) {
        // TODO Auto-generated method stub
        //分页插件
        PageHelper.startPage(pageNum, pageSize);

        BrandQuery brandQuery = new BrandQuery();
        Criteria createCriteria = brandQuery.createCriteria();

        //判断品牌名称是否有值
        if(null != brand.getName() && !"".equals(brand.getName().trim())){
            createCriteria.andNameLike("%"+brand.getName().trim()+"%");
        }
        //判断品牌的首字段是否有值
        if(null != brand.getFirstChar() && !"".equals(brand.getFirstChar().trim())){
            createCriteria.andFirstCharEqualTo(brand.getFirstChar().trim());
        }
        //查询所有品牌结果集
        Page<Brand>  p =  (Page<Brand>) brandDao.selectByExample(brandQuery);
        return new PageResult(p.getTotal(), p.getResult());
    }
    //添加
    public void add( Brand brand){
        brandDao.insertSelective(brand);
        //insert into tb_brand (id,name,firstChar,....100个字段) values (null,宝马,B,....100个null)
        //insert into tb_brand (name,firstChar) values (宝马,B)  Mysql 数据样子一样吗? 一样 性能呢?不一样
    }
    //修改
    public void update( Brand brand){

        brandDao.updateByPrimaryKeySelective(brand);
    }
    //删除
    public void delete(Long[] ids){
        //1:遍历   6
//		for (Long id : ids) {
//			brandDao.deleteByPrimaryKey(id);
//		}
        //2:直接发送 一个Sql  delete from tb_brand where id in (49,48,47)
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.createCriteria().andIdIn(Arrays.asList(ids));
        brandDao.deleteByExample(brandQuery);
        //3:手写Sql 大企业

    }
    //根据ID查询一个品牌
    public Brand findOne(Long id){
        return brandDao.selectByPrimaryKey(id);
    }
}
