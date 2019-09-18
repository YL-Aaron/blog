package com.yl.controller;

import com.yl.bean.Blog;
import com.yl.service.BlogService;
import com.yl.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    /**
     * 进入列表页
     *
     * @param model
     * @return java.lang.String
     * @author YL
     * @date 2019/9/18 10:00
     */
    @RequestMapping("/list")
    public String list(Model model) {
        List<Blog> blogs = blogService.selectAll();
        model.addAttribute("blogs", blogs);
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
     *
     * @param title
     * @param content
     * @return java.lang.String
     * @author YL
     * @date 2019/9/15 11:55
     */
    @ResponseBody
    @PostMapping("/save")
    public Map<String, Object> save(String title, String content) {
        Blog blog = new Blog()
                .setContent(content)
                .setTitle(title);
        blogService.insertSelective(blog);
        Map<String, Object> map = new HashMap<>(2);
        map.put("result", "添加成功");
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
        model.addAttribute("blog", blog);
        return "/blog/edit";
    }

    /**
     * 更新博客
     *
     * @param id
     * @param title
     * @param content
     * @param isShow
     * @return java.lang.String
     * @author YL
     * @date 2019/9/17 17:41
     */
    @RequestMapping("/update")
    public String update(Integer id, String title, String content, Integer isShow) {
        Blog blog = new Blog()
                .setId(id)
                .setTitle(title)
                .setContent(content)
                .setIsShow(isShow);
        blogService.updateByPrimaryKeySelective(blog);
        return "redirect:list";
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
        blogService.deleteByPrimaryKeys(id);
        Map<String, Object> result = new HashMap<>(2);
        result.put("result", "删除成功！");
        return result;
    }
}
