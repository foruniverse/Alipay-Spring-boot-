package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Room;
import com.demo.springboot.helloworld.common.domain.RoomExample;
import com.demo.springboot.helloworld.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Boolean isRoomEmpty(int roomId) {
        RoomExample roomExample = new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andRoomIdEqualTo(roomId);
        List<Room> new_room = roomMapper.selectByExample(roomExample);
        return new_room.get(0).getRoomState()==0?true:false;
    }

    @Override
    public void updateRoomSelective(Room room)
    {
        RoomExample example = new RoomExample();

        RoomExample.Criteria criteria = example.createCriteria();
        criteria.andRoomIdEqualTo(room.getRoomId());
        System.out.println(room.getRoomId());
        List<Room> new_room=roomMapper.selectByExample(example);
        new_room.get(0).setRoomState(1);
        // 更改房间状态到已占用/预订
        roomMapper.updateByExampleSelective(new_room.get(0),example);
    }
}
