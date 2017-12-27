package com.svenou.myapp;

import com.svenou.buildConfig.BuildConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/*
* @fixme
* 加入了gradle buildConfig插件，
* generateBuildConfig task必须设置成 execute after sync 和 execute after make
* (否则,每次打包的时候就需要手动跑一次 generateBuildConfig task)
* */
@Configuration
public class ServerProfileLoader {

    private static final Log log = LogFactory.getLog(ServerProfileLoader.class);

    /**
     * memory test data
     */
//    public static final String MODE_TEST = "test";
    public static final String MODE_TEST = BuildConfig.MODE_TEST;
    /**
     * Local DataBase
     */
//    public static final String MODE_LOCAL = "local";
    public static final String MODE_LOCAL = BuildConfig.MODE_LOCAL;

    /**
     * OpenShit DataBase
     */
//    public static final String MODE_PRO = "pro";
    public static final String MODE_PRO = BuildConfig.MODE_PRO;

    /**
     * local, pro, test
     */
//    public static final String currentServerMode = MODE_TEST;
    public static final String currentServerMode = BuildConfig.currentServerMode;

    private static final Resource[] localResourceProperties = new Resource[]{
            new ClassPathResource("com/svenou/myapp/local-jdbc.properties"),
            new ClassPathResource("com/svenou/myapp/local-cs-integration.properties"),
            new ClassPathResource("com/svenou/myapp/resources-config.properties")
    };

    private static final Resource[] testResourceProperties = new Resource[]{
            new ClassPathResource("com/svenou/myapp/local-jdbc.properties"),
            new ClassPathResource("com/svenou/myapp/local-cs-integration.properties"),
            new ClassPathResource("com/svenou/myapp/resources-config.properties")
    };

    private static final Resource[] proResourceProperties = new Resource[]{
            new ClassPathResource("com/svenou/myapp/pro-cs-integration.properties"),
            new ClassPathResource("com/svenou/myapp/pro-cs-integration.properties"),
            new ClassPathResource("com/svenou/myapp/resources-config.properties")
    };

    @Bean
    public static PropertyPlaceholderConfigurer propertyConfigurer() throws IOException {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocations(getResourceProperties());
        log.info("------- start with currentServerMode: " + currentServerMode + "------- ");
        return configurer;
    }

    private static Resource[] getResourceProperties() {
        if (currentServerMode.equalsIgnoreCase(MODE_LOCAL)) {
            return localResourceProperties;
        } else if (currentServerMode.equalsIgnoreCase(MODE_PRO)) {
            return proResourceProperties;
        } else if (currentServerMode.equalsIgnoreCase(MODE_TEST)) {
            return testResourceProperties;
        }
        return null;
    }

}
