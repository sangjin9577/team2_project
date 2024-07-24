package bitc.fullstack405.team2.PopCafe;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CafeMapper {

  CafeDTO selectCafe() throws Exception;
}
