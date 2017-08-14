package com.daxueit.springmvc.beans.spel;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/13.
 */
@Component
public class SpELBean {
    @Value("Hello SpEL!")
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;

    @Value("#{demoService.testValue}")
    private String fromAnother;

    @Value("classpath:com/daxueit/springmvc/beans/spel/spel.txt")
    private Resource testFile;

    @Value("http://www.baidu.com")
    private Resource baiduUrl;

    @Value("${project.name}")
    private String projectName;

    @Autowired
    private Environment environment;

    public String outputResource() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("normal:").append(normal).append("<br/>");
            stringBuilder.append("osName:").append(osName).append("<br/>");
            stringBuilder.append("randomNumber:").append(randomNumber).append("<br/>");
            stringBuilder.append("fromAnother:").append(fromAnother).append("<br/>");
            stringBuilder.append("testFile:").append(IOUtils.toString(testFile.getInputStream())).append("<br/>");
            stringBuilder.append("baiduUrl:").append(IOUtils.toString(baiduUrl.getInputStream())).append("<br/>");
            stringBuilder.append("projectName:").append(projectName).append("<br/>");
            stringBuilder.append("projectUrl:").append(environment.getProperty("project.url")).append("<br/>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
