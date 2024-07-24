package bitc.fullstack405.team2.mainThemePop;

import java.util.List;

public interface ThemeService {
  ThemeDTO selectTheme(int themeIdx) throws Exception ;
  List<ThemeDTO> selectThemeList() throws Exception ;

  ThemeDTO selectCafe() throws Exception ;
}
