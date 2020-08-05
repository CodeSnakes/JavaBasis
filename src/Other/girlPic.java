package Other;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.File;


/**
 * @author yichangkong
 * @create 2020-05-28-14:34
 */
public class girlPic {
    public static void createFongImg(String path){
        String base = "LoveBaby";
        try{
            BufferedImage image = ImageIO.read(new File(path));
            BufferedImage newImage = new BufferedImage(image.getWidth(),image.getHeight(),image.getType());
            Graphics2D graphics2D = (Graphics2D) newImage.getGraphics();
            graphics2D.setFont(new Font("ËÎÌו",Font.BOLD,10));
            int index = 0;
            for(int y = 0; y < image.getHeight(); y += 6){
                for (int x = 0; x < image.getWidth(); x += 6){
                    int pxcolor = image.getRGB(x,y);
                    int r = (pxcolor & 0xff0000) >> 16,
                            g = (pxcolor & 0xff00) >> 8,
                            b = pxcolor & 0xff;
                    graphics2D.setColor(new Color(r, g, b));
                    graphics2D.drawString(String.valueOf(base.charAt(index % base.length())), x, y);
                    index++;
                }
            }
            ImageIO.write(newImage, "JPG", new FileOutputStream("test3.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }
    };
    public static void main(String args[]){
    girlPic.createFongImg("D:\\ideaProjects\\src\\resource\\test.jpg");
        System.out.println("OK");
    }
}
