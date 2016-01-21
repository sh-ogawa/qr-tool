package jp.sh4.ooga.qrtool.gen;

import com.google.zxing.WriterException;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by tie207035 on 2016/01/21.
 */
public class GeneratorTest {

    private Path outPath = Paths.get("src/test/resources/out/barcode.png");

    @Before
    public void setting() throws IOException {
        Files.deleteIfExists(outPath);
    }

    @Test
    public void Generated_QRCode(){

        boolean flg = true;
        try {
            BufferedImage image = Generator.generate("http://qiita.com/sh-ogawa");
            ImageIO.write(image, "png", Files.createFile(outPath).toFile());
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            flg = false;
        }
        assertEquals(true, flg);
    }


}
