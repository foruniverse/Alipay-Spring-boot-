package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Room;

public interface RoomService {
    public Boolean isRoomEmpty(int roomId);
    public void updateRoomSelective(Room room);
}
