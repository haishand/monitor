package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.DeviceData;
import po.DeviceDataExample;

public interface DeviceDataMapper {
    long countByExample(DeviceDataExample example);

    int deleteByExample(DeviceDataExample example);

    int deleteByPrimaryKey(Integer code);

    int insert(DeviceData record);

    int insertSelective(DeviceData record);

    List<DeviceData> selectByExample(DeviceDataExample example);

    DeviceData selectByPrimaryKey(Integer code);

    int updateByExampleSelective(@Param("record") DeviceData record, @Param("example") DeviceDataExample example);

    int updateByExample(@Param("record") DeviceData record, @Param("example") DeviceDataExample example);

    int updateByPrimaryKeySelective(DeviceData record);

    int updateByPrimaryKey(DeviceData record);
}