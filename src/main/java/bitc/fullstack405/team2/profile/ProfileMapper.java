package bitc.fullstack405.team2.profile;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfileMapper {
  List<ProfileDTO> selectProfileList() throws Exception;

  ProfileDTO selectProfileDetail(String userId) throws Exception;
}
