package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.AlarmData;
import po.AlarmDataExample;

public interface AlarmDataMapper {
    long countByExample(AlarmDataExample example);

    int deleteByExample(AlarmDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AlarmData record);

    int insertSelective(AlarmData record);

    List<AlarmData> selectByExample(AlarmDataExample example);

    AlarmData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AlarmData record, @Param("example") AlarmDataExample example);

    int updateByExample(@Param("record") AlarmData record, @Param("example") AlarmDataExample example);

    int updateByPrimaryKeySelective(AlarmData record);

    int updateByPrimaryKey(AlarmData record);
}