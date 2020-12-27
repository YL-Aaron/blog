package com.yl.controller.admin;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.yl.bean.ApiReturn;
import com.yl.config.SystemConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author YL
 * @date 14:24 2020/12/27
 */
@Slf4j
@RestController
@RequestMapping("admin/common")
public class CommonController {

    @Autowired
    private SystemConfig systemConfig;

    /**
     * 上传图片
     *
     * @param file 文件流
     * @return com.yl.bean.ApiReturn
     * @author YL
     * @date 2019/12/13 16:30
     */
    @RequestMapping("/upload")
    public ApiReturn upload(MultipartFile file) {
        if (file.isEmpty()) {
            return new ApiReturn(500, "上传失败");
        }
        String fileName = file.getOriginalFilename();
        assert fileName != null;
        fileName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        long id = snowflake.nextId();
        String newFileName = id + "." + fileName;
        String path = systemConfig.getUpload() + newFileName;
        File dest = new File(path);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return new ApiReturn(200, "上传成功", systemConfig.getAccess() + newFileName);
        } catch (IOException e) {
            log.error(e.getMessage(), "upload image error");
        }
        return new ApiReturn(500, "上传失败");
    }
}
