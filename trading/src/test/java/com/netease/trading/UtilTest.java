package com.netease.trading;

import com.netease.trading.util.MD5Util;
import org.junit.Test;

import java.util.Date;

public class UtilTest {


    @Test
    public void testMD5() {
        String reyub = MD5Util.getMD5("reyub");
        System.out.println("reyub " + reyub);
        String s1 = MD5Util.getMD5("123");
        System.out.println("s1 " + s1);
    }

    @Test
    public void testDate() {
        System.out.println(new Date(1555322390000L));
    }

}
