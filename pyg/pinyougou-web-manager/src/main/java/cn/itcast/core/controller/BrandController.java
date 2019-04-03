package cn.itcast.core.controller;

import cn.itcast.core.pojo.good.Brand;
import cn.itcast.core.service.BrandService;
import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import entity.WebManagerAddResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 品牌管理
 *
 * @Author: keyuzhang
 * @Date: 2019/3/29 18:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    //获取所有品牌
    @RequestMapping("/findAll")
    public List <Brand> findAll() {
        return brandService.findAll();
    }

    //查询分页对象
    @RequestMapping("/findPage")
    public PageResult findPage(Integer pageNum, Integer pageSize) {
        return brandService.findPage(pageNum, pageSize);
    }
    //条件查询
    @RequestMapping("/search")
    public PageResult search(Integer pageNum, Integer pageSize,@RequestBody(required = false) Brand brand) {
        return brandService.search(pageNum,pageSize,brand);
    }

    //添加
    @RequestMapping("/add")
    public WebManagerAddResult add(@RequestBody Brand brand) {
        try {
            brandService.add(brand);
            return new WebManagerAddResult(true,"保存成功");
        } catch (Exception e) {
            return new WebManagerAddResult(false,"保存失败");
        }
    }
    //更改
    @RequestMapping("/update")
    public WebManagerAddResult update(@RequestBody Brand brand) {
        try {
            brandService.update(brand);
            return new WebManagerAddResult(true,"修改成功");
        } catch (Exception e) {
            return new WebManagerAddResult(false,"修改失败");
        }
    }
    //删除
    @RequestMapping("/delete")
    public WebManagerAddResult delete(Long[] ids){
        System.out.println("ids="+ids.toString());
        try {
            brandService.delete(ids);
            return new WebManagerAddResult(true,"修改成功");
        } catch (Exception e) {
            return new WebManagerAddResult(false,"修改失败");
        }
    }
    //查询单体
    @RequestMapping("/findOne")
    public Brand findOne(Long id){
        System.out.println("id="+id);
        return brandService.findOne(id);
    }

}
