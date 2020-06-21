package com.demo.springboot.helloworld.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Order {
    private int id;
    private String orderno;//订单号
    private int uid;//用户id

    private int hotel_id;//用户id
    private String hotel;//酒店名

    private int room_id;//酒店名
    private Double totleprice;//订单金额
    private Date checkin;//预定时间
    private Date checkout;//创建时间
    private Date createtime;//创建时间
    private String mobile;
    private String email;
    private String status;
    //
    private Integer page;
    private Integer pageSize;
    private Integer level;

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public String getOrderno() { return orderno; }

    public void setOrderno(String orderno) { this.orderno = orderno; }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() { return uid; }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Double getTotleprice() {
        return totleprice;
    }

    public void setTotleprice(Double totleprice) {
        this.totleprice = totleprice;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
