package com.top.yirenbaotop.controller;
import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Random;

@RestController
public class CodeController {
    private static final long serialVersionUID = 1L;
    //短信平台相关参数
//这个不用改
    private String apiUrl = "https://sms_developer.zhenzikj.com";
    //榛子云系统上获取
    private String appId = "102725";
    private String appSecret = "f3c97925-1f8a-4d9b-9ec6-1e789cc18a03";


    @RequestMapping("/code")
    public boolean getCode(@RequestParam("memPhone") String memPhone, HttpSession httpSession){

            try {
                //JSONObject json = null;
                //随机生成验证码
                String code = String.valueOf(new Random().nextInt(999999));
                //将验证码通过榛子云接口发送至手机
                ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
                String result = client.send(memPhone, "您的验证码为:" + code + "，该码有效期为5分钟，该码只能使用一次!");

                //json = JSONObject.parseObject(result);
                //if (!code.equals("0")){//发送短信失败
                    //return  false;
                //}
                //将验证码存到session中,同时存入创建时间
                //以json存放，这里使用的是阿里的fastjson
                //json = new JSONObject();
                //json.put("memPhone",memPhone);
                //json.put("code",code);
                //json.put("createTime",System.currentTimeMillis());
                // 将认证码存入SESSION
                httpSession.setAttribute("code",code);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }

        return false;
    }
}
