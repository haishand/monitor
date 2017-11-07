package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Devicedata;
import po.DevicedataExample;

public interface DevicedataMapper {
    long countByExample(DevicedataExample example);

    int deleteByExample(DevicedataExample example);

    int deleteByPrimaryKey(Integer code);

    int insert(Devicedata record);

    int insertSelective(Devicedata record);

    List<Devicedata> selectByExample(DevicedataExample example);

    Devicedata selectByPrimaryKey(Integer code);

    int updateByExampleSelective(@Param("record") Devicedata record, @Param("example") DevicedataExample example);

    int updateByExample(@Param("record") Devicedata record, @Param("example") DevicedataExample example);

    int updateByPrimaryKeySelective(Devicedata record);

    int updateByPrimaryKey(Devicedata record);
}