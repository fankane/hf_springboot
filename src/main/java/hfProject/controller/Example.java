package hfProject.controller;

/**
 * Created by hf on 16/9/2.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boot")
public class Example {

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

}
