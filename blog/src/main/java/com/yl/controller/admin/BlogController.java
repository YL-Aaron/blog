package com.yl.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yl.bean.Blog;
import com.yl.bean.BlogSearch;
import com.yl.service.BlogService;
import com.yl.service.TypeBlogService;
import com.yl.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yi
 * @desciption 博客控制器
 * @date 2019/9/3
 */
@Slf4j
@Controller
@RequestMapping("/admin/blog")
public class BlogController {

    @Resource
    private BlogService blogService;
    @Resource
    private TypeBlogService typeBlogService;


    /**
     * 列表
     *
     * @param pageNum  页码
     * @param pageSize 每页条数
     * @return java.lang.String
     * @author YL
     * @date 2019/12/16 10:01
     */
    @RequestMapping("/list")
    public String list(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, BlogSearch search) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogService.selectAll(search);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("search", search);
        return "/blog/list";
    }

    /**
     * 进入添加界面
     *
     * @return java.lang.String
     * @author YL
     * @date 2019/9/18 10:01
     */
    @RequestMapping("/add")
    public String add() {
        return "/blog/add";
    }


    /**
     * 保存文章
     *
     * @param blog  博客实体
     * @param types 博客类型数组
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author YL
     * @date 2019/12/13 17:54
     */
    @ResponseBody
    @PostMapping("/save")
    public Map<String, Object> save(Blog blog, Integer[] types) {
        int rows = blogService.insertBlog(blog, types);
        Map<String, Object> map = new HashMap<>(2);
        if (rows > 0) {
            map.put("result", "添加成功");
        } else {
            map.put("result", "添加失败");
        }
        return map;
    }

    /**
     * 预览
     *
     * @return java.lang.String
     * @author YL
     * @date 2019/9/15 11:57
     */
    @RequestMapping("/preview")
    public String preview(Integer id,Model model) {
        Blog blog = blogService.selectById(id);
        model.addAttribute("blog", blog);
        return "/blog/preview";
    }

    /**
     * 编辑文章
     *
     * @param id 主键
     * @return java.lang.String
     * @author YL
     * @date 2019/9/17 16:56
     */
    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        Blog blog = blogService.selectByPrimaryKey(id);
        List<Integer> list = typeBlogService.selectByBlogId(id);
        model.addAttribute("blog", blog);
        model.addAttribute("checked", list);
        return "/blog/edit";
    }


    /**
     * 更新博客
     *
     * @param blog  博客实体
     * @param types 博客类型数组
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author YL
     * @date 2019/12/13 17:56
     */
    @ResponseBody
    @RequestMapping("/update")
    public Map<String, Object> update(Blog blog, Integer[] types) {
        int rows = blogService.updateBlog(blog, types);
        Map<String, Object> map = new HashMap<>(2);
        if (rows > 0) {
            map.put("result", "修改成功");
        } else {
            map.put("result", "修改失败");
        }
        return map;
    }


    /**
     * 修改显示状态
     *
     * @param blog 博客实体
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author YL
     * @date 2019/12/16 9:58
     */
    @ResponseBody
    @RequestMapping("/updateStatus")
    public Map<String, Object> updateStatus(Blog blog) {
        int rows = blogService.updateByPrimaryKeySelective(blog);
        Map<String, Object> map = new HashMap<>(2);
        if (rows > 0) {
            map.put("result", "状态变更成功");
        } else {
            map.put("result", "状态变更失败");
        }
        return map;
    }

    /**
     * 删除博客
     *
     * @param ids 多选删除
     * @return java.lang.String
     * @author YL
     * @date 2019/9/18 10:04
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public Map<String, Object> delete(String ids) {
        String[] id = StringUtil.ids(ids);
        int rows = blogService.deleteByPrimaryKeys(id);
        Map<String, Object> map = new HashMap<>(2);
        if (rows > 0) {
            map.put("result", "删除成功");
        } else {
            map.put("result", "删除失败");
        }
        return map;
    }


}
