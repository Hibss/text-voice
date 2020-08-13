package com.syz.hystrix.controller;

import com.syz.hystrix.service.TextService;
import com.syz.hystrix.utils.JacobUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TextController {

    @Autowired
    private TextService textService;

    @GetMapping("checkText")
    public String checkText(@RequestParam("text")String text){
        log.info(" {} checkText:{}",this.getClass().getSimpleName(),text);
        return textService.checkText(text);
    }


    @GetMapping("toVoice")
    public void toVoice(@RequestParam("text")String text){
        log.info(" {} toVoice text:{}",this.getClass().getSimpleName(),text);
        textService.toVoice(text);
    }
}
