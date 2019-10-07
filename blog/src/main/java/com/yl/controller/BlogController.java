package com.yl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yl.bean.Blog;
import com.yl.service.BlogService;
import com.yl.service.TypeBlogService;
import com.yl.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yi
 * @desciption 博客控制器
 * @date 2019/9/3
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;
    @Resource
    private TypeBlogService typeBlogService;

    /**
     * 进入列表页
     *
     * @param model
     * @return java.lang.String
     * @author YL
     * @date 2019/9/18 10:00
     */
    @RequestMapping("/list")
    public String list(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue =
            "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogService.selectAll();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        return "/blog/list";
    }

    /**
     * 进入添加界面
     *
     * @param
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
     * @author yl
     * @date 2019/10/3 17:25
     * @param title
     * @param content
     * @param types
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @ResponseBody
    @PostMapping("/save")
    public Map<String, Object> save(String title, String content, Integer[] types) {
        Blog blog = new Blog()
                .setContent(content)
                .setTitle(title);
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
     * @param title
     * @param content
     * @return java.lang.String
     * @author YL
     * @date 2019/9/15 11:57
     */
    @RequestMapping("/preview")
    public String preview(String title, String content, Model model) {
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        return "/blog/preview";
    }

    /**
     * 编辑文章
     *
     * @param id
     * @param model
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
     * @param id
     * @param title
     * @param content
     * @return java.lang.String
     * @author YL
     * @date 2019/9/17 17:41
     */
    @ResponseBody
    @RequestMapping("/update")
    public Map<String, Object> update(Integer id, String title, String content, Integer[] types) {
        Blog blog = new Blog()
                .setId(id)
                .setTitle(title)
                .setContent(content);
        int rows = blogService.updateBlog(blog,types);
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
     * @param id
     * @param isShow
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author YL
     * @date 2019/9/20 16:46
     */
    @ResponseBody
    @RequestMapping("/updateStatus")
    public Map<String, Object> updateStatus(Integer id, Integer isShow) {
        Blog blog = new Blog()
                .setIsShow(isShow)
                .setId(id);
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
     * @param ids
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
