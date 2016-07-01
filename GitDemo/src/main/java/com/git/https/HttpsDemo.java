package com.git.https;

import java.io.IOException;

public class HttpsDemo {

    public static void main(String[] args) throws IOException {
        
        String string = HttpsUtils.get("https://api.bs.test.gomeplus.com/v2/ext/praise/like?id=56d95697fe0e3448b8d8cd86&type=1&pageNum=0&pageSize=0", null );
        System.out.println(string);
        
    }
}
