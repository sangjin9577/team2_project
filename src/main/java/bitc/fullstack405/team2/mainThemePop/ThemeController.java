package bitc.fullstack405.team2.mainThemePop;

import bitc.fullstack405.team2.PopCafe.CafeDTO;
import bitc.fullstack405.team2.PopCafe.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ThemeController {

  @Autowired
  private ThemeService themeService;

  @Autowired
  private CafeService cafeService;

  @RequestMapping("/main")
  public String themeMain() throws Exception{
//    ModelAndView mv = new ModelAndView("main/main");
    return "main/main";
  }


  // 테마 정보 리스트 불러와보기
    @RequestMapping("/themepopup2")
  public ModelAndView selectThemeList() throws Exception {
    ModelAndView mv = new ModelAndView("main/main");
    List<ThemeCafeDTO> themeList = themeService.selectThemeCafeList();
    mv.addObject("themeList", themeList);

    return mv;
  }


  // 예약하기 단순 이동
  @RequestMapping("/reservation")
  public String goReservation() throws Exception{

    return "main/reservation";
  }

  @ResponseBody
  @RequestMapping(value = "/ajax/mainItems", method = RequestMethod.POST)
  public Object ajaxMainItems(@RequestParam("cafeIdx") int idx) throws Exception {
    List<ThemeCafeDTO> mainItems = themeService.mainItemsList(idx);
    return mainItems;
  }


}
