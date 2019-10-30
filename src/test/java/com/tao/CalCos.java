package com.tao;

import java.text.NumberFormat;

/**
 * @author liutao
 * @path src/com.tao
 * @date 2019/10/30  23:25
 */
public class CalCos {
    public static void main(String[] args) {
        double[] a = {1, 2, 2};
        double[] b = {1, 2, 1};
        System.out.println(getPercentFormat(cal(a, b), 3, 2));
    }

    static double cal(double[] a, double[] b) {
        if (a.length != b.length) {
            return 0;
        }
        double dot = 0;
        double modA = 0;
        double modB = 0;
        for (int i = 0; i < a.length; i++) {
            dot += (a[i] * b[i]);
            modA += Math.pow(a[i], 2);
            modB += Math.pow(b[i], 2);
        }
        return dot / (Math.sqrt(modA) * Math.sqrt(modB));
    }

    public static String getPercentFormat(double d, int IntegerDigits, int FractionDigits) {
        NumberFormat nf = java.text.NumberFormat.getPercentInstance();
        nf.setMaximumIntegerDigits(IntegerDigits);//小数点前保留几位
        nf.setMinimumFractionDigits(FractionDigits);// 小数点后保留几位
        String str = nf.format(d);
        return str;
    }

}
