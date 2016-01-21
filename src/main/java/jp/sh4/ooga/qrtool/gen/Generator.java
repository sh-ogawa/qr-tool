package jp.sh4.ooga.qrtool.gen;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by sh-ogawa on 2016/01/21.
 */
public class Generator {

    /**
     * Generate GR Image
     * @param content Writing context into QRCode.
     * @return Image
     * @throws WriterException Failuer generated QRCode
     */
    public static BufferedImage generate(final String content) throws WriterException {

        BarcodeFormat format = BarcodeFormat.QR_CODE;
        int width = 160;
        int height = 160;

        Hashtable<EncodeHintType, ErrorCorrectionLevel> hints =
                new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);

        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(content, format, width, height, hints);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
