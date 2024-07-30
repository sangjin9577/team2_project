package bitc.fullstack405.team2.profile;

import java.util.List;

public interface ProfileService {
  List<ProfileDTO> selectProfileList() throws Exception;

  ProfileDTO selectProfileDetail(String userId) throws Exception;
//
//  public List<ProfileDTO> selectProfileList(String userId) throws Exception;

}
