package pers.wzs.demo.jdk8.common;

import java.awt.*;

/**
 * Created by wangzhongshan on 2017/12/23.
 */
public class FontTest {
    public static void main(String[] args) {
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = e.getAllFonts();
        for (Font font : fonts) {
            System.out.println(font.getName() + "   " + font.getFamily());
        }
        System.out.println("############################");
        String[] fontName = e.getAvailableFontFamilyNames();
        for (String s : fontName) {
            System.out.println(s);
        }
    }
}
