package com.mange.activity.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by lbm on 2017/11/22
 * @author lbm
 * M选n
 */
public class MyCombine {

    public static void main(String[] args) {
        Integer[] a = { 0, 1, 2, 3, 4, 5};
        int num = 3;
        MyCombine tp = new MyCombine();
        System.out.println(tp.combine(a, num).toString());
    }

    /**
     * 实现的算法
     * @param a 数据数组
     * @param num M选N中 N的个数
     * @return
     */
    private List<List<Integer>> combine(Integer[] a, int num) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        String[] b = new String[a.length];
        for (int i = 0; i < b.length; i++) {
            if (i < num) {
                b[i] = "1";
            } else {
                b[i] = "0";
            }
        }

        int point = 0;
        int nextPoint = 0;
        int count = 0;
        int sum = 0;
        String temp = "1";
        while (true) {
            // 判断是否全部移位完毕
            for (int i = b.length - 1; i >= b.length - num; i--) {
                if ("1".equals(b[i])) {
                    sum += 1;
                }
            }
            // 根据移位生成数据
            for (int i = 0; i < b.length; i++) {
                if ("1".equals(b[i])) {
                    point = i;
                    c.add(a[point]);
                    count++;
                    if (count == num) {
                        break;
                    }
                }
            }
            // 往返回值列表添加数据
            list.add(new ArrayList<>(c));

            // 当数组的最后num位全部为1 退出
            if (sum == num) {
                break;
            }
            sum = 0;

            // 修改从左往右第一个10变成01
            for (int i = 0; i < b.length - 1; i++) {
                if ("1".equals(b[i]) && "0".equals(b[i + 1])) {
                    point = i;
                    nextPoint = i + 1;
                    b[point] = "0";
                    b[nextPoint] = "1";
                    break;
                }
            }
            // 将 i-point个元素的1往前移动 0往后移动
            for (int i = 0; i < point - 1; i++) {
                for (int j = i; j < point - 1; j++) {
                    if ("0".equals(b[i])) {
                        temp = b[i];
                        b[i] = b[j + 1];
                        b[j + 1] = temp;
                    }
                }
            }
            // 清空 StringBuffer
            c.clear();
            count = 0;
        }
        //
        System.out.println("数据长度 " + list.size());
        return list;

    }
}
