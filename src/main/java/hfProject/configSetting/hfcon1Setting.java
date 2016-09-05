package hfProject.configSetting;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by hf on 16/9/5.
 */

@ConfigurationProperties(prefix = "hf1",locations = "classpath:config/hfcon1.properties")
public class Hfcon1Setting {

    private String name;
    private String age;
    private String location;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
