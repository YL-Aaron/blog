package com.yl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * 文件访问配置虚拟路径
 *
 * @author YL
 * @date 15:10 2019/12/12
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {

    private final UploadConfig uploadConfig;

    public FileConfig(UploadConfig uploadConfig) {
        this.uploadConfig = uploadConfig;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(uploadConfig.getAccess() + "/**").addResourceLocations("file:" + uploadConfig.getUpload() + File.separator);
    }
}
