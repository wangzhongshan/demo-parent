package pers.wzsframework.demo.javase.common;

import java.text.DecimalFormat;

/**
 * Created by wangzhongshan on 2017/5/18.
 */
public class NumberTest {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("￥#,##0.00");
        System.out.println(decimalFormat.format(011100.1));

    }
}
