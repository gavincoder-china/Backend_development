package com.example.consumer.util;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * **********************************************************
 *
 * @Project:  生成二维码
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-10-09 16:48
 * @description:
 ************************************************************/
public class QRCodeUtil {


        public static ByteArrayOutputStream createQrGen(String url) throws IOException {
            //如果有中文，可使用withCharset("UTF-8")方法

            //设置二维码url链接，图片宽度250*250，JPG类型
            return QRCode.from(url).withSize(250, 250).to(ImageType.JPG).stream();
        }


}
