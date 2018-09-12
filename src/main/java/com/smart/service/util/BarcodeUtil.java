package com.smart.service.util;

import com.alibaba.druid.util.StringUtils;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @createdBy:jx
 * @crteat:2018-03-30
 */
public class BarcodeUtil {
    @Autowired
    private QiniuyunServiceManager qiniuyunManager;

    /**
     * 生成到流
     *
     * @param msg
     * @param ous
     */
    public static void generate(String msg, OutputStream ous) {
        if (StringUtils.isEmpty(msg) || ous == null) {
            return;
        }
        Code128Bean bean = new Code128Bean();
        // 精细度
        final int dpi = 160;
        // module宽度
        final double moduleWidth = UnitConv.in2mm(2.0f / dpi);
        // 配置对象
        bean.setModuleWidth(moduleWidth);
        bean.doQuietZone(true);
        String format = "image/png";


        try {
            // 输出到流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format, dpi,
                    BufferedImage.TYPE_BYTE_BINARY, false, 0);
            // 生成条形码
            bean.generateBarcode(canvas, msg);

            // 结束绘制
            canvas.finish();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
