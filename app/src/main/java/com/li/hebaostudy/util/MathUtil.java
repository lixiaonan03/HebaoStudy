package com.li.hebaostudy.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 作者：lxn on 2015/12/16 14:25
 * 描述：Utilone ————数字金额运算的工具类
 */
public class MathUtil {
    //默认获取的小数点的后2位
    private static final int FORMAT = 2;

    /**
     * BigDecimal类型的数字和int 类型相乘之后的截取小数点后2位的结果
     * @param price  BigDecimal类型 eg:商品单价
     * @param count  int类型  eg:商品数量
     * @return
     */
    public static BigDecimal getMultiply(BigDecimal price,int count) {
        BigDecimal allprice = price.multiply(new BigDecimal(count));
        allprice= subDigit(allprice,FORMAT);
        return allprice;
    }
    /**
     * BigDecimal类型的数字和int 类型相乘之后以四舍五入的方式取整
     * @param price  BigDecimal类型 eg:商品单价
     * @param count  int类型  eg:商品数量
     * @return  整数结果BigDecimal类型
     */
    public static BigDecimal getMultiplyToInt(BigDecimal price,int count) {
        BigDecimal allprice = price.multiply(new BigDecimal(count));
        allprice= subDigit(allprice,0);
        return allprice;
    }

    /**
     * BigDecimal类型的数字和int 类型相乘之后
     * @param price BigDecimal类型 eg:商品单价
     * @param count int类型  eg:商品数量
     * @param digit int类型  获取小数点后几位
     * @return
     */
   public static BigDecimal getMultiply(BigDecimal price,int count,int digit) {
        BigDecimal allprice = price.multiply(new BigDecimal(count));
        allprice= subDigit(allprice,digit);
        return allprice;
    }

    /**
     * 截取到小数点后几位
     * @param price  BigDecimal类型的数字
     * @param digit  要获取的小数点后几位
     * @return
     */
    public static BigDecimal subDigit(BigDecimal price,int digit){
        BigDecimal returnBigdecimal=price.setScale(digit, BigDecimal.ROUND_HALF_UP);
        return returnBigdecimal;
    }
    /**
     * 把一个数字转换成百分比显示   eg:  20  转成 20%
     * @param math
     * @return
     */
    public static String mathByPercentage(double math){
        DecimalFormat df1 = new DecimalFormat("##.00%");    //##.00%   百分比格式，后面不足2位的用0补齐
        return df1.format(math/100);
    }
     /**
     * 把一个double 数字转换成 小数点后2位显示的
     * @param math
     * @return
     */
    public static String mathTodecimaltwo(double math){
        //这种方式是四舍五入的
        BigDecimal b = new BigDecimal(String.valueOf(math));
        b=b.setScale(2, BigDecimal.ROUND_HALF_UP);//四舍五入的
        return b.toString();
    }
    /**
     * 将数字以千为单位，用“，”分割。
     *
     * @param str1
     *            eg:123456.76
     * @return String str eg: 123,456.76
     */
    public static String getMoneyString(String str1) {
        char firstWord = str1.charAt(0);
        if ("-".equals(firstWord + "")) {
            str1 = str1.replace("-", "");
        } else {
        }
        String[] str = str1.split("\\.");
        str1 = str[0];
        str1 = new StringBuilder(str1).reverse().toString(); // 先将字符串颠倒顺序
        String str2 = "";
        for (int i = 0; i < str1.length(); i++) {
            if (i * 3 + 3 > str1.length()) {
                str2 += str1.substring(i * 3, str1.length());
                break;
            }
            str2 += str1.substring(i * 3, i * 3 + 3) + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        // 最后再将顺序反转过来
        if (str.length > 1) {
            str1 = new StringBuilder(str2).reverse().toString() + "." + str[1];
        } else {
            str1 = new StringBuilder(str2).reverse().toString();
        }
        if ("-".equals(firstWord + "")) {
            str1 = "-" + str1;

        }
        return str1;
    }
}
