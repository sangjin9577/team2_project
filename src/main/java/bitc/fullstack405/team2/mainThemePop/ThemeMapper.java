package bitc.fullstack405.team2.mainThemePop;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThemeMapper {
  List <ThemeDTO> selectThemeList() throws Exception;
  ThemeDTO selectTheme() throws Exception;

  ThemeDTO selectCafe() throws Exception;
}
