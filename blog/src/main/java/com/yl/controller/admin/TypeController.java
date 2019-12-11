package com.yl.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yl.bean.Type;
import com.yl.service.TypeService;
import com.yl.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类型控制器
 *
 * @author YL
 * @date 17:57 2019/9/24
 */
@Controller
@RequestMapping("/type")
public class TypeController {

    @Resource
    private TypeService typeService;

    /**
     * 进入类型列表
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @return java.lang.String
     * @author YL
     * @date 2019/9/27 15:13
     */
    @RequestMapping("/list")
    public String list(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Type> blogs = typeService.selectAll();
        PageInfo<Type> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        return "type/list";
    }

    /**
     * 删除类型
     *
     * @param ids
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author YL
     * @date 2019/9/27 15:34
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public Map<String, Object> delete(String ids) {
        String[] id = StringUtil.ids(ids);
        int rows = typeService.deleteByPrimaryKeys(id);
        Map<String, Object> map = new HashMap<>(2);
        if (rows > 0) {
            map.put("result", "删除成功");
        } else {
            map.put("result", "删除失败");
        }
        return map;
    }

    /**
     * 更新类型
     *
     * @param id
     * @param name
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author YL
     * @date 2019/9/27 15:37
     */
    @ResponseBody
    @RequestMapping("/update")
    public Map<String, Object> update(Integer id, String name) {
        Type type = new Type()
                .setId(id).setName(name);
        int rows = typeService.updateByPrimaryKeySelective(type);
        Map<String, Object> map = new HashMap<>(2);
        if (rows > 0) {
            map.put("result", "修改成功");
        } else {
            map.put("result", "修改失败");
        }
        return map;
    }

    /**
     * 编辑类型
     *
     * @param id
     * @param model
     * @return java.lang.String
     * @author YL
     * @date 2019/9/27 15:40
     */
    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        Type type = typeService.selectByPrimaryKey(id);
        model.addAttribute("type", type);
        return "type/edit";
    }

    /**
     * 进入添加界面
     *
     * @param
     * @return java.lang.String
     * @author YL
     * @date 2019/9/27 15:41
     */
    @RequestMapping("/add")
    public String add() {
        return "type/add";
    }

    /**
     * 保存类型
     *
     * @param name
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author YL
     * @date 2019/9/27 15:42
     */
    @ResponseBody
    @PostMapping("/save")
    public Map<String, Object> save(String name) {
        Type type = new Type()
                .setName(name);
        int rows = typeService.insertSelective(type);
        Map<String, Object> map = new HashMap<>(2);
        if (rows > 0) {
            map.put("result", "添加成功");
        } else {
            map.put("result", "添加失败");
        }
        return map;
    }

    /**
     * 博客添加页的下拉框
     *
     * @param
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author YL
     * @date 2019/9/29 15:36
     */
    @RequestMapping("/typeDropDown")
    @ResponseBody
    public Map<String, Object> typeDropDown() {
        Map<String, Object> result = new HashMap<>(2);
        List<Type> type = typeService.selectAll();
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < type.size(); i++) {
            Map<String, Object> temp = new HashMap<>(2);
            temp.put("name", type.get(i).getName());
            temp.put("value", type.get(i).getId());
            data.add(temp);
        }
        result.put("data", data);
        return result;
    }
}
