package com.hjh.lm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/a")
public class TestController {
    @RequestMapping(value = "/a", method = RequestMethod.GET)
    @ResponseBody
    public String say(){
        return "hi";
    }
}
