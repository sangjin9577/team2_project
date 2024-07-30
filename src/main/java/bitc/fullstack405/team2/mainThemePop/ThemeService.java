package bitc.fullstack405.team2.mainThemePop;

import java.util.List;

public interface ThemeService {

  ThemeCafeDTO selectTheme(int idx) throws Exception ;

  List<ThemeDTO> selectThemeList() throws Exception ;

  List<ThemeCafeDTO> selectThemeCafeList() throws Exception ;

  ThemeDTO selectCafe() throws Exception ;

  List<ThemeCafeDTO> mainItemsList(int idx) throws Exception;

  List<ThemeCafeDTO> selectReviewList() throws Exception;

  List<ThemeCafeDTO> selectAjaxReviewList(int cafeIdx, int themeIdx) throws Exception;
}
