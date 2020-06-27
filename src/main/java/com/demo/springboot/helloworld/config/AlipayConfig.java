package com.demo.springboot.helloworld.config;

import java.io.FileWriter;
import java.io.IOException;



import java.io.FileWriter;
import java.io.IOException;

    /* *
     *类名：AlipayConfig
     *功能：基础配置类
     *详细：设置帐户有关信息及返回路径
     *修改日期：2017-04-05
     *说明：
     *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
     *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
     */

    public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

        // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
        public static String app_id = "2016102800774974";

        // 商户私钥，您的PKCS8格式RSA2私钥
        public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCumGHxvTxeK3OLnBlqJiptbZByDJLO0+N3tv3MbbHZl5xBW+dfj938wvll/NNFdvSFDIs1tzt9Z3Oh7oW3AuHxFebbq2CJoQ8jBNXrxZQIgnh3qNr5w0AEyMUnS66Guj9BZaL//dmKaqj8173NuPbgoaGOPOcZbhdzr2P8Pj2Nof2pnDDFYn1quf90LkP+ygXFqLpadfqQ7JgnLJT/kV65gK0Q4YGOtwbU+vs6Lw8856bkcBuU15C0aM+zvaoQX0DsG7cl6qDliwPfzjp8oRN5ixP/WNRaLB/q08EWmYSTtzWErh5ks9/lscxwEE+ipeUdDCD1zXDv+JVnKauxIPuvAgMBAAECggEAEZXln5yo3O9RdwllAe0QLu9vMh2UF+L9sUwsKhAObtU3dtnT5ystd80Ho78gZInDvTbzOpjXFB18Zx4IN9PBgC/tjcioM5SWWrec+F9xNp41lg/a5ndFFnZGbVvRG17dCjA7h79AzxFJLhZo1rS/oQaGqDX4LPaKxCsxTfHS71XsCQQwzerirrj88oYwZ/1EsMAYp/iHjO1xTTEw3bHQczbZIuAFp6WyGvHzeLzVxq2VF4NQj41v+bUlP6OP3pwMIQryzND8VugAKeNMrA8d+PiS2LZZDIvzJs1ojj3TjFphKZYm61mG0o+633Fb49kP1gprmXv8F6n+SWE9HWlJoQKBgQDUAXdbUKsuDWM3w3dkp6GnNz7mrA2npDmb52kIk8Mgj8xbFjYALrc3nom5cal5UTSXtrKL/opjVEOj08B5nz224vKoO9m2Fw5ShYvjy++pMBjN4HaHrLi757DUA4yYP9Qs/LQWpn397do1gkHfEgA3JM4cZ1I9Q0Tp6neKtyl6sQKBgQDS04g9MY7Cci19cRFagVOL0G26ZI8zueUfINXj4QRqaX08d0U3eCWXusOw+72u6koV2HFt0CoPHrccGVrd6DvX8gEoXUu0Zk4wwXqW8CYIDHW7ipzjlRh/UwtfG2mey6YCXbsbMS6L1HOXvJVDGsBzj12jmvJHbaOTxt2Lo/i0XwKBgCLN5tFX6fJSglJaRZSBrJkuCaaG4mr+G/MLR4P/9g23bb4aZF0dTjjUTxnhngfrm+24MZGoBQIPiFcx4SxWRyRqF5ok0TYCjPhhMjkAduTYn4nU6sCVS3KVs8Lqnj80Y1nLVqlNRevVC3izXKsJYn2rDic9kxO5omugcWWVcjrRAoGBAMI6ISSHOIdJG0Ga3irsRGTlc4GpzQgRddVUsdjL3/6NCtSe6QSuSqvbYxf1BI5VyEUR74YEpgrh+D4J2d3gaumKSai/MtSS/+wJA4B05AS8Pea2T82W+Uer4SkQnyCta1Z4tbzadZBa/NdI5JY62hxccx8by6MkjfPB3S8dtC2vAoGAJ+J3unpWgJZk0IFvqsZKG44AloAwd93nTBDrk1tJxEu3Qu47fXmLqIF3q/h/uOBz17gDBZdZ3x8Qv/KzQ+xjgyMev9LNUl2BEDDFIHiUCYmG8+taWEEDJDI+LD3OfWFTCE4uJ8UoCKh1kDkfyVIuBEtN/O66Dtq7yoytf9vIAeA=";

        // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
        public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuudoKSMYm/5RpsvtLBuY93GTA9BTEWgHQfZpS6l35lr6ASJ/yaWG+MS9c4w1Huoh+FxuExmJs4rVUOdYh1xeW6X5Jp3Gb6sPBe7s5LGVIB8D6ku0ysvmR8yvq9H+qmCNKTFIJZKWDKpX+UFwsK/Hke3MjHBs/AS0/6gZHYNMiryHwCK8FK9/ztdMbOQGzQSgvtI2ql4k4lLUq/qIrHbf/pfbaRDB/OZ5Fb73g9q6Xvmj6R/mS5mz0i5bR6wdCfxiVQTzEWn1GrUNaKhSXzT2uzx0HdAEBZVfGnxsqClsgw7OkbOCWAdq6CgEteej+EfoTEpedwDyz1fs/j31jZQ+LwIDAQAB";

        // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
        public static String notify_url = "http://321l939v35.zicp.vip:80/aliPay/notify";

        // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//        public static String return_url = "http://321l939v35.zicp.vip:80/aliPay/return";
        public static String return_url = "https://www.baidu.com";
        // 签名方式
        public static String sign_type = "RSA2";

        // 字符编码格式
        public static String charset = "utf-8";

        // 支付宝网关
        public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

        // 支付宝网关
        public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        /**
         * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
         * @param sWord 要写入日志里的文本内容
         */
        public static void logResult(String sWord) {
            FileWriter writer = null;
            try {
                writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
                writer.write(sWord);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
