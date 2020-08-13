package com.syz.hystrix.service;

import com.syz.hystrix.utils.BaiduAipUtil;
import com.syz.hystrix.utils.JacobUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class TextService {

    private final String BAIDU_CHECK_TEXT_URL = "https://aip.baidubce.com/rest/2.0/solution/v1/text_censor/v2/user_defined";

    @Autowired
    private RestTemplate restTemplate;

    public String checkText(String text) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
//        map.add("text", text);
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//
//        ResponseEntity<String> response = restTemplate.postForEntity( BAIDU_CHECK_TEXT_URL, request , String.class );
        JSONObject jsonObject = BaiduAipUtil.getInstance().textCensorUserDefined(text);
        return jsonObject.toString(1);
    }

    public void toVoice(String text) {
        JacobUtil.textToSpeech(text);
    }
}
