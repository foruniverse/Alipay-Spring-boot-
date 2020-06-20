package com.demo.springboot.helloworld;

import com.demo.springboot.helloworld.common.domain.Room;
import com.demo.springboot.helloworld.common.domain.Trade;
import com.demo.springboot.helloworld.mapper.RoomMapper;
import com.demo.springboot.helloworld.mapper.TradeMapper;
import com.demo.springboot.helloworld.service.MailService;
import com.demo.springboot.helloworld.service.RoomService;
import com.demo.springboot.helloworld.service.TradeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@SpringBootTest
class HelloworldApplicationTests {

    @Autowired
    RoomMapper roomMapper;
    @Autowired
    TradeMapper tradeMapper;

    @Autowired
    TradeService tradeService;

    @Autowired
    RoomService roomService;



    @Autowired
    private MailService mailService;

    @Test
    public void sendmail() {
        mailService.sendSimpleMail("hcy1256349091@gmail.com","主题：你好普通邮件","内容：第一封邮件");
    }

    @Test
    public void sendmailHtml(){
        mailService.sendHtmlMail("hcy1256349091@gmail.com","主题：你好html邮件","<h1>内容：第一封html邮件</h1>");
    }

    @Test
    public void updateTradeState()
    {
        Trade trade =new Trade();

        trade.setOutTradeNo(7);
        trade.setTradeState(1);
        tradeService.updateTradeState(trade);
    }
    @Test
    public void insertRoom()
    {

        for(int i=1;i<=10;i++)
        {
            Room room = new Room();
            room.setHotelId(1);
            room.setRoomPrice((int) Math.random() % 200 );
            room.setRoomState(0);
            roomMapper.insertSelective(room);
        }
    }

    @Test
    public void insertInitial()
    {
        int hotelId=10;
        String total_amount="99.99";
        String body="hello worl";
        int roomId =9;
        Timestamp ts= new Timestamp(new Date().getTime());
        String subject="hotel_id"+"room_id";
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
        room.setRoomId (roomId);
        room.setRoomState (1);
        roomService.updateRoomSelective(room);
        int out_trade_no_temp =tradeService.insertInitial(trade);
        System.out.println(trade.getOutTradeNo());
    }

}
