package com.syz.hystrix.utils;

import com.baidu.aip.contentcensor.AipContentCensor;
import org.json.JSONObject;

public class BaiduAipUtil {

    private static AipContentCensor censor;

    public static final String APP_ID = "21968363";
    public static final String API_KEY = "WgWiVPx7VzyCDeNw5SS2CGms";
    public static final String SECRET_KEY = "iP73sOyNuD0eGpDTwXQse16OiZ73DhXH";
    public static AipContentCensor getInstance() {
        if(null == censor) {
            synchronized (BaiduAipUtil.class) {
                if(null == censor) {
                    censor = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);

                    // 可选：设置网络连接参数
                    censor.setConnectionTimeoutInMillis(2000);
                    censor.setSocketTimeoutInMillis(60000);

                    // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//                    censor.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//                    censor.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

                    // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
                    // 也可以直接通过jvm启动参数设置此环境变量
//                    System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
                }
            }
        }
        return censor;
    }


    public static void main(String[] args) {
        AipContentCensor censor = BaiduAipUtil.getInstance();

        // 调用接口
        String path = "asd";
        JSONObject res = censor.textCensorUserDefined(path);
        //indentFactor 缩进因子。。。控制格式
        System.out.println(res.toString(10));

    }
}
