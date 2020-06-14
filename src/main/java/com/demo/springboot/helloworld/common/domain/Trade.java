package com.demo.springboot.helloworld.common.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Trade {
    private Integer outTradeNo;

    private String tradeNo;

    private Integer hotelId;

    private BigDecimal tradeAmount;

    private String tradeComment;

    private Integer tradeUserId;

    private Date tradeCreateTime;

    private String tradeTitle;

    private Integer tradeState;

    private Integer roomId;

    public Integer getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(Integer outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getTradeComment() {
        return tradeComment;
    }

    public void setTradeComment(String tradeComment) {
        this.tradeComment = tradeComment == null ? null : tradeComment.trim();
    }

    public Integer getTradeUserId() {
        return tradeUserId;
    }

    public void setTradeUserId(Integer tradeUserId) {
        this.tradeUserId = tradeUserId;
    }

    public Date getTradeCreateTime() {
        return tradeCreateTime;
    }

    public void setTradeCreateTime(Date tradeCreateTime) {
        this.tradeCreateTime = tradeCreateTime;
    }

    public String getTradeTitle() {
        return tradeTitle;
    }

    public void setTradeTitle(String tradeTitle) {
        this.tradeTitle = tradeTitle == null ? null : tradeTitle.trim();
    }

    public Integer getTradeState() {
        return tradeState;
    }

    public void setTradeState(Integer tradeState) {
        this.tradeState = tradeState;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}