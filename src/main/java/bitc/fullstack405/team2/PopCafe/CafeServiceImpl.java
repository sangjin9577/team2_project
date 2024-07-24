package bitc.fullstack405.team2.PopCafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeServiceImpl implements CafeService {

  @Autowired
  private CafeMapper cafeMapper;

  @Override
  public CafeDTO selectCafe() throws Exception {
    return cafeMapper.selectCafe();
  }
}
