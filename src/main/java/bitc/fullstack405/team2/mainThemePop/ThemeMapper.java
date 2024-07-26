package bitc.fullstack405.team2.mainThemePop;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThemeMapper {
  List <ThemeDTO> selectThemeList() throws Exception;

  List <ThemeCafeDTO> selectThemeCafeList() throws Exception;

  ThemeDTO selectTheme(int idx) throws Exception;

  ThemeDTO selectCafe() throws Exception;

  List<ThemeCafeDTO> mainItemsList(int idx) throws Exception;
}
