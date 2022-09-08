package com.studentmgmtsystem.viraj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {

    @RequestMapping("/viraj")
    public String firstHandler()
    {
        return "Viraj Spring Boot Application is running";
    }
}
