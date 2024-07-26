package bitc.fullstack405.team2.mainThemePop;

import bitc.fullstack405.team2.PopCafe.CafeDTO;
import bitc.fullstack405.team2.PopCafe.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThemeController {

  @Autowired
  private ThemeService themeService;

  @Autowired
  private CafeService cafeService;

  @RequestMapping("/main")
  public ModelAndView main() throws Exception{
    ModelAndView mv = new ModelAndView("test/main");

    return mv;
  }

  // 테마 정보 리스트 불러와보기
  @RequestMapping("/test/themepopup1")
  public ModelAndView selectTheme() throws Exception {
    ModelAndView mv = new ModelAndView("test/themepopup");

    ThemeDTO theme = themeService.selectTheme();
    // 테마 상세 정보 추가
    mv.addObject("theme", theme);

    CafeDTO cafe = cafeService.selectCafe();
    // 지점명 추가
    mv.addObject("cafe", cafe);

    return mv;
  }



//    @RequestMapping("/themepopup2")
//  public ModelAndView selectThemeList() throws Exception {
//    ModelAndView mv = new ModelAndView("test/themepopup");
//    List<ThemeDTO> themeList = themeService.selectThemeList();
//    mv.addObject("themeList", themeList);
//
//    return mv;
//  }

//  @RequestMapping("/test")
//  public ModelAndView selectThemeList() throws Exception {
//    ModelAndView mv = new ModelAndView("/test/dataLoadTest");
//    List<ThemeDTO> themeList = themeService.selectThemeList();
//    mv.addObject("themeList", themeList);
//
//    return mv;
//  }

  // 테마 이미지는 깃허브에 저장해서 폴더명으로 끌어올꺼니까 상관X
  // 팝업 누르면 팝업idx 로 상세정보, 리뷰 끌어오기
  // 리뷰는 어케 끌어옴 ?

  // review select list 로 게시판 목록 끌어오듯이 가져오기 테마 상세랑 다른 메소드 생성, 변수
  // 테마 번호, 리뷰 메뉴 카테고리 정보 받아서 구분
  // 팝업창에서 예약버튼 누르면 지점/시간별 페이지로 이동하는 리퀘스트맵핑 컨트롤러 필요함



}
