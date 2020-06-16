package com.demo.springboot.helloworld.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;

import com.demo.springboot.helloworld.common.domain.Room;
import com.demo.springboot.helloworld.common.domain.Trade;
import com.demo.springboot.helloworld.service.MailService;
import com.demo.springboot.helloworld.service.RoomService;
import com.demo.springboot.helloworld.service.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.demo.springboot.helloworld.config.AlipayConfig;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.lang.String;

@RequestMapping("/aliPay")
@Controller
public class AliPayController {
    @Autowired
    private MailService mailService;

    @Autowired
    private TradeService tradeService;

    @Autowired
    private RoomService roomService;


    /*
        支付接口
        @params hotel_id
        @params room_id
        @params total_amount
        @params user_id

        传参方式使用httpservletRequest request
     */
    @RequestMapping("/goPay")
    public @ResponseBody
    String pay( HttpServletRequest request) throws UnsupportedEncodingException {
        //在声明里抛出异常为了加强代码可阅读性
        System.out.println("Ok");
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);// 支付成功后的返回连接,请自行指定
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);// 异步通知连接,逻辑已写好,但表结构不同,请务必使用我的表


        String body = null;
        body = new String(request.getParameter("trade_comment").getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(body);
        //订单标题=系统订单号+酒店ID+房间Id+金额
        Timestamp ts= new Timestamp(new Date().getTime());
        String temp=new String(request.getParameter("room_id").getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(temp);
        int roomId=Integer.valueOf(temp);
        temp=new String(request.getParameter("hotel_id").getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(temp);
        int hotelId=Integer.valueOf(temp);
            System.out.println(roomId);
        // 获取房间id
        String total_amount=new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
            System.out.println(total_amount);

        String subject = "酒店ID"+hotelId+"房间ID"+roomId+"用户ID"+1;

        // 注入数据库 此时订单状态为(0)

        if(!roomService.isRoomEmpty(roomId))
            return "亲,宁来晚了哟,房间已被预订,再选一个吧";

        Trade trade = new Trade();
        trade.setTradeAmount(BigDecimal.valueOf(Double.valueOf(total_amount)));
        trade.setTradeComment(body);
        trade.setHotelId(hotelId);
        trade.setRoomId(roomId);
        trade.setTradeCreateTime(ts);
        trade.setTradeState(0);
        trade.setTradeUserId(1);// 获取当前登录用户ID
        trade.setTradeTitle(subject);
        //更改房间状态,只要进入了此步逻辑,无论是否付款成功都将订单改为已预订
        Room room=new Room();
        room.setRoomId(roomId);
        room.setRoomState(1);
        roomService.updateRoomSelective(room); // 更新房间状态
        tradeService.insertInitial(trade);
        //插入订单
        String out_trade_no=Integer.toString(trade.getOutTradeNo());
        System.out.println("订单号"+out_trade_no);
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求

        // 金额从房间信息中得到

       String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
            System.out.println("finished");
            //输出
            System.out.println(result);

            return result;
        } catch (AlipayApiException e) {
            e.printStackTrace();
            System.out.println("failed");
            // 这里可能应该撤销之前对数据库的操作,但支付宝的文档这里是没有看懂的,所以啥也没做
            return "支付宝出了一点幺儿子,等会儿再试吧";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/return")
    public String return_message(HttpServletRequest request, HttpServletResponse response , Model model) throws UnsupportedEncodingException {
        System.out.println("return");
        Map<String,String> params = new HashMap<String,String>();
        Map<java.lang.String, java.lang.String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = false; //调用SDK验证签名
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");


            model.addAttribute("out_trade_no",out_trade_no);
            model.addAttribute("trade_no",trade_no);
            model.addAttribute("total_amount",total_amount);
            System.out.println("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);

        }else {
            System.out.println("验签失败");
        }
        System.out.println( "test");
        return "/test";
    }

    //这一块是异步通知,用来验证支付信息是否正确,请不要修改
    @ResponseBody
    @RequestMapping(value="/notify",method =RequestMethod.POST)
    public String notify_message(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        System.out.println("notify");
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = false; //调用SDK验证签名
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        //——请在这里编写您的程序（以下代码仅作参考）——

	/* 实际验证过程建议商户务必添加以下校验：
	1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
	2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
	3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
	4、验证app_id是否为该商户本身。

	这里的异常处理没有想明白怎么做,所以就没做
	反正支付宝大部分情况应该不会打脸,流在后面在想一想
	*/
        Trade trade = new Trade();

        if(signVerified) {//验证成功
            //商户订单号

           String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号

            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //交易状态
            String trade_status = null;

            trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

            String title = new String (request.getParameter("subject").getBytes("ISO-8859-1"),"UTF-8");
            if(trade_status.equals("TRADE_FINISHED")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知

                System.out.println("trade_finished");
            }else if (trade_status.equals("TRADE_SUCCESS")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
                System.out.println("trade_success");
                trade.setTradeState(1);
                trade.setOutTradeNo(Integer.valueOf(out_trade_no));
                trade.setTradeNo(trade_no);
                tradeService.updateTradeState(trade);
                mailService.sendSimpleMail("hcy1256349091@gmail.com","订单已支付","订单号"+out_trade_no+"\n欢迎再次光临");
            }

            System.out.println("success");
            return "success";// 必须返回,否则支付宝会不停验证
        }else {//验证失败
           System.out.println("fail");
            return "fail";
            //调试用，写文本函数记录程序运行情况是否正常
            //String sWord = AlipaySignature.getSignCheckContentV1(params);
            //AlipayConfig.logResult(sWord);
        }

        //——请在这里编写您的程序（以上代码仅作参考）——
    }

//    @ResponseBody
    /*退款
        接收参数如下所示

     */
    @RequestMapping("/refund")
    public String  refund(HttpServletRequest request,Model model) throws UnsupportedEncodingException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

        //商户订单号，商户网站订单系统中唯一订单号
        String out_trade_no = new String(request.getParameter("WIDTRout_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        //支付宝交易号
        String trade_no = new String(request.getParameter("WIDTRtrade_no").getBytes("ISO-8859-1"), "UTF-8");
        //请二选一设置
        //需要退款的金额，该金额不能大于订单金额，必填
        String refund_amount = new String(request.getParameter("WIDTRrefund_amount").getBytes("ISO-8859-1"), "UTF-8");
        //退款的原因说明
        String refund_reason = new String(request.getParameter("WIDTRrefund_reason").getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(refund_reason);
        //标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
//        String out_request_no = new String(request.getParameter("WIDTRout_request_no").getBytes("ISO-8859-1"),"UTF-8");
        String out_request_no = "13";
        System.out.println(out_request_no);
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"trade_no\":\"" + trade_no + "\","
                + "\"refund_amount\":\"" + refund_amount + "\","
                + "\"refund_reason\":\"" + refund_reason + "\","
                + "\"out_request_no\":\"" + out_request_no + "\"}");

        //请求
        String result = null;
        try {
            result = alipayClient.execute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return "退款失败";
        }
        //输出
        JSONObject json = new JSONObject(result);
        JSONObject temp = json.getJSONObject("alipay_trade_refund_response");
        String msg = temp.getString("msg");
        System.out.println(msg);
        String out_trade_no_1,refund_fee;
        if (msg.equals("Success"))
        {       model.addAttribute("msg", msg);
            out_trade_no_1 = temp.getString("out_trade_no");
            refund_fee = temp.getString("refund_fee");
        }
        else {
            out_trade_no_1="fail";
            refund_fee="fail";
        }
        model.addAttribute("out_trade_no",out_trade_no_1);
        model.addAttribute("refund_fee",refund_fee);
        System.out.println(result);
        //打印表单 form

        return "/refund";
    }

    //@ResponseBody
    @RequestMapping("/query")
    public String query(HttpServletRequest request , HttpServletResponse response) throws UnsupportedEncodingException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

        //商户订单号，商户网站订单系统中唯一订单号
        String out_trade_no = new String(request.getParameter("WIDTQout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
        //支付宝交易号
        String trade_no = new String(request.getParameter("WIDTQtrade_no").getBytes("ISO-8859-1"),"UTF-8");
        //请二选一设置

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","+"\"trade_no\":\""+ trade_no +"\"}");

        //请求
        String result = null;
        try {
            result = alipayClient.execute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();

        }
        //输出
       System.out.println(result);
        return  result;
    }


}
