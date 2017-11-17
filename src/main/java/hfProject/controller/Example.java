package hfProject.controller;

/**
 * Created by hf on 16/9/2.
 */

import hfProject.configSetting.hfcon1Setting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boot")
public class Example {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    @Autowired
    hfcon1Setting t ;

    @RequestMapping("/hf-boot")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/hf-sayHi/{name}/{age}")
    String sayHi(@PathVariable String name,@PathVariable int age) {
        String returnStr = "Hi %s,Are you %d years old?";
        return String.format(returnStr,name,age);
    }

    @RequestMapping("/hf-sayHello")
    String sayHello(@RequestParam("name") String name,@RequestParam("id") long id) {
        String returnStr = "<p style=\"color:#ff8800\"> Hi %s,your number is %d </p>";
        return String.format(returnStr,name,id);
    }

    @Value("${mysql.url}") private String mysqlUrl;
    @Value("${mysql.name}") private String mysqlName;
    @Value("${mysql.pwd}") private String mysqlPwd;

    @RequestMapping("/getconfig")
    String getConfig() {

        StringBuffer returnStr = new StringBuffer().append("<ul><li>mysql url:").append(mysqlUrl).append("</li>")
                .append("<li>mysql name:").append(mysqlName).append("</li>")
                .append("<li>mysql pwd:").append(mysqlPwd).append("</li></ul>");
        return returnStr.toString();
    }

    @RequestMapping("/getmyconfig")
    String getMyConfig() {
        StringBuffer returnStr = new StringBuffer().append("<ul><li>hf1.name:").append(t.getName()).append("</li>")
                .append("<li>hf1.age:").append(t.getAge()).append("</li>")
                .append("<li>hf1.location:").append(t.getLocation()).append("</li></ul>");
        return returnStr.toString();
    }

    @RequestMapping("/logback")
    String printLog() {
        logger.info("hufan test info  ");
        logger.warn("hufan test warn");
        logger.error("hufan test error");
        StringBuffer returnStr = new StringBuffer().append("<ul><li>hf1.name:").append(t.getName()).append("</li>")
                .append("<li>hf1.age:").append(t.getAge()).append("</li>")
                .append("<li>hf1.location:").append(t.getLocation()).append("</li></ul>");
        return returnStr.toString();
    }

}
