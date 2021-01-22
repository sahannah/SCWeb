package com.atguigu.crowd.test;

import org.junit.Test;
import util.CrowdUtil;

public class StringTest {
    @Test
    public void testMd5(){
        String source = "123123";
        String encode = CrowdUtil.md5(source);
        System.out.println(encode);

    }
}
