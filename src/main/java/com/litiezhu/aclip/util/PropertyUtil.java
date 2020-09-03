package com.litiezhu.aclip.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author Li Kai
 */
@Slf4j
public class PropertyUtil {
    private static Properties properties;

    static {
        String propsFile = "application.properties";
        properties = new Properties();
        try {
            properties.load(new InputStreamReader(PropertyUtil.class.getClassLoader().getResourceAsStream(propsFile), "UTF-8"));
        } catch (IOException e) {
            log.error("配置文件读取异常", e);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key.trim());
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return value.trim();
    }

    public static String getPropertyOrDefault(String key,String defaultValue){

        String value = properties.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            value = defaultValue;
        }
        return value.trim();
    }
}
