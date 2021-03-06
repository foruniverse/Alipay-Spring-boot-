package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Room;
import com.demo.springboot.helloworld.common.domain.RoomExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper {
    long countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExample(RoomExample example);

    Room selectByPrimaryKey(Integer roomId);

    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
}