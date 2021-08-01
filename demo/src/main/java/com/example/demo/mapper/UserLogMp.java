package com.example.demo.mapper;

import java.util.List;
import com.example.demo.model.Userlog;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserLogMp {
  // mapper 내림차순으로 start 부터 시작해서 end 갯수 만큼 찾아주는 select 문
  @Select("SELECT * FROM log order by idx DESC LIMIT #{start}, #{end}")
  List<Userlog> findAll(@Param("start") int start,@Param("end") int end);

  // database에 userLog 객체를 넣어주는 mapper
  @Insert("INSERT INTO LOG (idx, currentUserIPv4, date, inCheckStr, checkResult) VALUES (#{idx},#{currentUserIPv4},#{date},#{inCheckStr},#{checkResult})")
  void Insert(Userlog user);

  // 현재 database에 들어가있는 data의 수
  @Select("SELECT COUNT(idx) from log")
  int findIdx();

  // 현재 시간을 알려주는 데이터베이스 select 문
  @Select("SELECT NOW()")
  String findNow();
}