package bitc.fullstack405.team2.profile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfileController {
  @Autowired
  private ProfileService profileService;

//  세션 로그인 정보 없이 유저 정보 가져오기
//  @RequestMapping("/profile")
//  public ModelAndView profileMain() throws Exception {
//    ModelAndView mv = new ModelAndView("profile/profilemain");
//
//    List<ProfileDTO> profileList = profileService.selectProfileList();
//    mv.addObject("profileList", profileList);
//
//    return mv;
//  }

//  유저 정보 MYPAGE 가기
  @RequestMapping("/profile")
  public ModelAndView profileMain(HttpServletRequest req) throws Exception {
    ModelAndView mv = new ModelAndView("profile/profilemain");

    HttpSession session = req.getSession();
    String userId = (String) session.getAttribute("userId");

    ProfileDTO profile = profileService.selectProfile(userId);
    mv.addObject("profile", profile);

    return mv;
  }

//  유저 정보 상세보기
  @RequestMapping("/profiledetail")
  public ModelAndView profileDetail(HttpServletRequest req) throws Exception {
    ModelAndView mv = new ModelAndView("profile/profiledetail");

    // HttpServletRequest 써서 userId 를 세션에서 받아오기
    HttpSession session = req.getSession();
    String userId = (String) session.getAttribute("userId");

    ProfileDTO profile = profileService.selectProfileDetail(userId);
    mv.addObject("profile", profile);

    return mv;
  }

//  유저 정보 수정
  @RequestMapping("/profileedit")
  public ModelAndView profileEdit(HttpServletRequest req) throws Exception {
    ModelAndView mv = new ModelAndView("profile/profileedit");

    HttpSession session = req.getSession();
    String userId = (String) session.getAttribute("userId");

    ProfileDTO profile = profileService.selectProfileUpdate(userId);
    mv.addObject("profile", profile);

    return mv;
  }

}