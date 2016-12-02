package com.svenou.myapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
public class ServerProfileLoader {

    private Log log = LogFactory.getLog(ServerProfileLoader.class);

    /**
     * memory test data
     */
    public static final String MODE_TEST = "test";
    /**
     * Local DataBase
     */
    public static final String MODE_LOCAL = "local";

    /**
     * OpenShit DataBase
     */
    public static final String MODE_PRO = "pro";

    /**
     * local, pro, test
     */
    public static final String currentServerMode = MODE_TEST;

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
