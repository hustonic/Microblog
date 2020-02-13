package com.huston.microblog.mblog;

import org.junit.jupiter.api.Test;

/**
 * @author huxiantao-cn@foxmail.com
 */
public class OtherTest {

    @Test
    public void testUnicode(){
        String s="\uD83D\uDC93\uD83D\uDC94\uD83D\uDC95\uD83D\uDC96\uD83D\uDC97\uD83D\uDC99\uD83D\uDC9A\uD83D\uDC9B\uD83D\uDC9C\uD83D\uDC9D\uD83D\uDC9E\uD83D\uDC9F";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i+=2) {
            System.out.print("'"+chars[i]+chars[i+1]+"',");
        }
    }
}
