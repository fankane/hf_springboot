package hfProject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hf on 16/9/7.
 */
@RestController
@RequestMapping("/rc")
public class RedirectController {

    @RequestMapping("/redirect")
    public void redirectTest(HttpServletResponse response) {
        try {
            response.sendRedirect("/boot/hf-boot");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
