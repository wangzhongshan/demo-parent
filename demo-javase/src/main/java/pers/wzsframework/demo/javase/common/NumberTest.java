package pers.wzsframework.demo.javase.common;

import java.text.DecimalFormat;

/**
 * Created by wangzhongshan on 2017/5/18.
 */
public class NumberTest {
    public static void main(String[] args) {
//        DecimalFormat decimalFormat = new DecimalFormat("￥#,##0.00");
//        System.out.println(decimalFormat.format(011100.1));

        float a = getFloat();
        System.out.println(a < 6.5);
    }

    private static float getFloat() {
        return 1f + 4.5f;
    }
}
