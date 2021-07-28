
// Mapper 인터페이스 생성



package com.example.demo.test.mapper;

import java.util.List;
import com.example.demo.test.vo.TestVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper {
    List<TestVo> selectTest();
}