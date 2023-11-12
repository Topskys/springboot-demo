package com.example.demo.controller;

import cn.hutool.core.map.MapUtil;
import com.example.demo.common.Const;
import com.example.demo.util.Result;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class KaptchaController extends BaseController {

    @Autowired
    Producer producer;

    /**
     * 获取生成的验证码图片
     * @return
     * @throws IOException
     */
    public Result captcha() throws IOException {
        String key= UUID.randomUUID().toString();
        String code=producer.createText();

        BufferedImage image=producer.createImage(code);
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        ImageIO.write(image,"jpg",outputStream);

        BASE64Encoder encoder=new BASE64Encoder();
        String str="data:image/jpeg;base64,";
        String base64Image=str+encoder.encode(outputStream.toByteArray());

        redisUtil.hashMapSet(Const.CAPTCHA_KEY,key, code, Const.CAPTCHA_EXPIRE_TIME);

        return Result.ok(
                MapUtil.builder()
                .put("key",key)
                .put("base64Image",base64Image)
        );
    }
}
