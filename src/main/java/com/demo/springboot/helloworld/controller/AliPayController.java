package com.demo.springboot.helloworld.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.demo.springboot.helloworld.common.domain.Order;
import com.demo.springboot.helloworld.common.domain.OrderDetail;
import com.demo.springboot.helloworld.common.domain.Room;
import com.demo.springboot.helloworld.config.AlipayConfig;
import com.demo.springboot.helloworld.service.AccessBackService;
import com.demo.springboot.helloworld.service.MailService;
import com.demo.springboot.helloworld.service.RoomService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* *
 *类名：AlipayController
 *功能：基础功能类
 *详细：后台接口
 * 编写者:何成阳
 *说明：
 */

@RequestMapping("/aliPay")
@Controller
public class AliPayController {
    @Autowired
    private MailService mailService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private AccessBackService accessBackService;


    @RequestMapping(value = "/goPay")
    public @ResponseBody
//    String pay(@RequestBody Map<String,Object> map) throws UnsupportedEncodingException {
    String pay(HttpServletRequest request) throws UnsupportedEncodingException {
        //在声明里抛出异常为了加强代码可阅读性
        System.out.println("Ok");
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);// 支付成功后的返回连接,请自行指定
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);// 异步通知连接,逻辑已写好,但表结构不同,请务必使用我的表

        //获得参数
//        String user=null;
//        if(map.containsKey("user"))
//        {
//            user =map.get("user").toString();
//            System.out.println(user);
//        }
//
//        if(map.containsKey("hotelID"))
//        {
//            int hotelId = Integer.parseInt(map.get("user").toString());
//            System.out.println(hotelId);
//        }
//        String hotelname=null;
//        if(map.containsKey("hotel"))
//        {
//            hotelname =map.get("hotel").toString();
//            System.out.println(hotelname);
//        }
//        int hotelId =-1;
//        if(map.containsKey("hotel"))
//        {
//            hotelId = Integer.parseInt(map.get("hotel").toString());
//            System.out.println(hotelId);
//        }
//        int roomId=0;
//        if(map.containsKey("room"))
//        {
//            roomId = Integer.parseInt(map.get("room").toString());
//            System.out.println(roomId);
//        }
//        String comment=null;
//        if(map.containsKey("comment"))
//        {
//            comment = map.get("room").toString();
//            System.out.println(comment);
//        }
//--------------------------接收json数据使用上面的-----------------
        String user = null;
        user = new String(request.getParameter("user"));
        System.out.println(user);

        String hotelname = null;
        hotelname = request.getParameter("hotel").toString();
        System.out.println(hotelname);

        int hotelId;
        hotelId = Integer.parseInt(request.getParameter("hotelId").toString());
        System.out.println(hotelId);

        int roomId = Integer.parseInt(request.getParameter("room").toString());
        System.out.println(roomId);

        String comment = null;
        comment = request.getParameter("comment").toString();
        System.out.println(comment);

        String price_string = null;
        price_string = request.getParameter("price").toString();
        System.out.println(price_string);


//        String price_string = map.get("price").toString();
        if (price_string.equals(null))
            return "订单数据异常";
        double price_double = Double.parseDouble(price_string);

//        String man=map.containsKey("man")==true?"man":null;
//        String child=map.containsKey("child")==true?"child":null;
//        String baby=map.containsKey("baby")==true?"baby":null;
        //顶单标题

        String subject = "订单人群" + "man" + "+" + "child" + "+" + "baby";
        // 注入数据库 此时订单状态为(wait_buyer_pay)
        if (!roomService.isRoomEmpty(roomId))
            return "亲,宁来晚了哟,房间已被预订,再选一个吧";
        Room room = new Room();
        room.setRoomId(roomId);
        room.setRoomState(1);
        roomService.updateRoomSelective(room);
        //更新房间状态
        Order order = new Order();
        order.setStatus("WAIT_BUYER_PAY");
        order.setEmail(user);
        order.setHotel(hotelname);
        order.setHotel_id(hotelId);
        order.setMobile("1234567890");
        order.setRoom_id(roomId);
        order.setUid(1);
        order.setTotleprice(price_double);
        //插入订单
        accessBackService.insertOrderInfo(order);
        String out_trade_no = Integer.toString(order.getId());
        System.out.println("订单号" + out_trade_no);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(order.getId());
        orderDetail.setRoom(roomId);
        orderDetail.setRemark(comment);
        orderDetail.setPrice(price_double);
        orderDetail.setRoomtype("大床房");
        accessBackService.insertOrderDetail(orderDetail);

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + price_string + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + comment + "\","
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
    public String return_message(HttpServletRequest request) throws UnsupportedEncodingException {
        System.out.println("return");
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
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
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");


//            model.addAttribute("out_trade_no",out_trade_no);
//            model.addAttribute("trade_no",trade_no);
//            model.addAttribute("total_amount",total_amount);
            System.out.println("trade_no:" + trade_no + "<br/>out_trade_no:" + out_trade_no + "<br/>total_amount:" + total_amount);

        }else {
            System.out.println("验签失败");
        }
        System.out.println( "test");
        return "/admin/index.html";
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
        Order order = new Order();

        if(signVerified) {//验证成功
            //商户订单号

           String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号

            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //交易状态

            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

            String title = new String (request.getParameter("subject").getBytes("ISO-8859-1"),"UTF-8");
            if (trade_status.equals("TRADE_FINISHED")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知

                System.out.println("trade_finished");
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
                System.out.println("trade_success");
                // 设置订单info
                order.setId(Integer.parseInt(out_trade_no));
                order.setOrderno(trade_no);
                order.setStatus("TRADE_SUCCESS");
                accessBackService.updateOrderState(order);
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setId(Integer.parseInt((out_trade_no)));
                orderDetail.setOrderno(trade_no);
                mailService.sendSimpleMail("hcy1256349091@gmail.com", "订单已支付", "订单号" + out_trade_no + "\n欢迎再次光临");
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
