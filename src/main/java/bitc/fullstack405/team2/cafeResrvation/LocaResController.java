package bitc.fullstack405.team2.cafeResrvation;

import bitc.fullstack405.team2.PopCafe.CafeDTO;
import bitc.fullstack405.team2.PopCafe.CafeService;
import bitc.fullstack405.team2.mainThemePop.ThemeCafeDTO;
import bitc.fullstack405.team2.mainThemePop.ThemeDTO;
import bitc.fullstack405.team2.mainThemePop.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LocaResController {

  @Autowired
  ThemeService themeService;

  @Autowired
  ResService resService;


  // 주소에서 카페이름, idx 받아오기
  @RequestMapping("/{cafeName}/{cafeIdx}")
  public ModelAndView HongdaeSelect(@PathVariable String cafeName, @PathVariable int cafeIdx) throws Exception {
    // requestparam 대신 pathvariable 쓰니까 됨
    
    // 카페이름 받아오고 뷰 주소에 붙임
    ModelAndView mv = new ModelAndView("reservation/" + (cafeName));
    List<ThemeCafeDTO> themeList = themeService.mainItemsList(cafeIdx);
    mv.addObject("themeList", themeList);

    return mv;
  }


  @GetMapping("/{cafeName}/{cafeIdx}/{date}")
  public String selectDate(@PathVariable(name = "date") String date){
   return date;
  }

  // 예약 정보 입력 페이지로 이동
  @RequestMapping("/{cafeName}/{cafeIdx}/{themeIdx}/{time}")
  public ModelAndView CafeResInfo(@PathVariable int themeIdx) throws Exception{
    ModelAndView mv = new ModelAndView("reservation/test_writeResInfo");
    ThemeCafeDTO themeInfo = themeService.selectTheme(themeIdx);
    mv.addObject("themeInfo", themeInfo);
    return mv;
  }

  @ResponseBody
  @RequestMapping(value="/ajax/restimelist", method = RequestMethod.POST)
  public Object resTime(@RequestParam("cafeIdx") int cafeIdx) throws Exception {
    // 해당 지점+테마에 시간 행 다 불러와서 제이쿼리로 비교
    // 예약 안했으면 null 임
    List<ResDTO> restimeList = resService.selectResTime(cafeIdx);

    return restimeList;
  }



  


}
