package bitc.fullstack405.team2.mainThemePop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThemeServiceImpl implements
    ThemeService {
  @Autowired
  private ThemeMapper themeMapper;

  @Override
  public ThemeDTO selectTheme(int themeIdx) throws Exception {
    return themeMapper.selectTheme(themeIdx);
  }

  @Override
  public List<ThemeDTO> selectThemeList() throws Exception {
    return themeMapper.selectThemeList();
  }

  @Override
  public ThemeDTO selectCafe() throws Exception {
    return themeMapper.selectCafe();
  }
}
