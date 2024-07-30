package bitc.fullstack405.team2.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    public List<ProfileDTO> selectProfileList() throws Exception {
        return profileMapper.selectProfileList();
    }

    @Override
    public ProfileDTO selectProfileDetail(String userId) throws Exception {
        return profileMapper.selectProfileDetail(userId);
    }
}
