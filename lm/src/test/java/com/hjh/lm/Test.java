package com.hjh.lm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class Test {
    @RequestMapping("/maintainregist")
    @ResponseBody
    @CrossOrigin
    public List<MaintainDataEntity> query() {
        List<MaintainDataEntity> result = new ArrayList<>();
        result.add(new MaintainDataEntity("1", "111", new Date(), "fine", "no thing to add"));
        result.add(new MaintainDataEntity("2", "222", new Date(), "fine", "no thing to add"));
        result.add(new MaintainDataEntity("3", "333", new Date(), "fine", "no thing to add"));
        result.add(new MaintainDataEntity("4", "444", new Date(), "fine", "no thing to add"));
        result.add(new MaintainDataEntity("5", "555", new Date(), "fine", "no thing to add"));

//        Map<String, List<MaintainDataEntity>> resultMap = new HashMap<>();
//        resultMap.put("maintainregist", result);

        return result;
    }

}
