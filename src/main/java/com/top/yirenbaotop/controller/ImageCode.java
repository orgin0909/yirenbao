package com.top.yirenbaotop.controller;

import com.top.yirenbaotop.util.SecurityCode;
import com.top.yirenbaotop.util.SecurityImage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class ImageCode {

    @GetMapping("/imageCode")
    public void imageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.生成验证码 四位中等难度的验证码
        String securityCode = SecurityCode.getSecurityCode();

        //将验证码保存在session中 校验是否正确
        HttpSession session = request.getSession();
        session.setAttribute("securityCode", securityCode);

        //2.将验证码转为验证码图片
        BufferedImage bufferedImage =  SecurityImage.createImage(securityCode);
        //设置响应内容的格式 图片
        response.setContentType("image/jpeg");
        //3.设置响应对象头部属性值
        //浏览器中不缓存图片信息
        response.setHeader("Pragma" , "No-cache");
        response.setHeader("Cache-Contro" , "No-cache");
        //设置失效时间
        response.setHeader("Expires","0");
        //4.
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());

    }

    @RequestMapping("/verify")
    public Boolean verify(HttpSession session, @RequestParam("imgCode") String imgCode){
        String securityCode = (String) session.getAttribute("securityCode");
        if(!securityCode.equals(imgCode)){
            return false;
        }

        return true;
    }


}
