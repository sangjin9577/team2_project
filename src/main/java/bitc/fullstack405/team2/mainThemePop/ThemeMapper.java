package bitc.fullstack405.team2.mainThemePop;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ThemeMapper {
  List <ThemeDTO> selectThemeList() throws Exception;

  List <ThemeCafeDTO> selectThemeCafeList() throws Exception;

  ThemeDTO selectCafe() throws Exception;

  List<ThemeCafeDTO> mainItemsList(int idx) throws Exception;

  ThemeCafeDTO selectTheme(int idx) throws Exception;

  List<ThemeCafeDTO> selectReviewList() throws Exception;

  List<ThemeCafeDTO> selectAjaxReviewList(@Param("cafeIdx") int cafeIdx, @Param("themeIdx") int themeIdx) throws Exception;
}
