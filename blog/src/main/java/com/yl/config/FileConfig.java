package com.yl.config;

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

    private final SystemConfig systemConfig;

    public FileConfig(SystemConfig systemConfig) {
        this.systemConfig = systemConfig;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(systemConfig.getAccess() + "/**").addResourceLocations("file:" + systemConfig.getUpload() + File.separator);
    }
}
