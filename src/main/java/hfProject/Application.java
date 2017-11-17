package hfProject;

import hfProject.configSetting.hfcon1Setting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hf on 16/9/2.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties({hfcon1Setting.class})
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
