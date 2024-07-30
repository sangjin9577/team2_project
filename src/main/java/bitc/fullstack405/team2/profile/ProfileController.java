package bitc.fullstack405.team2.profile;

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
//
//  @Autowired
//  private ProfileService profileService;
//
////  프로필 기본 페이지
////  @RequestMapping("/profile")
////  public String getProfileMain() {
////
////    return "profile/profilemain";  // profilemain.html을 반환
////  }
//
//  @RequestMapping("/profile")
//  public ModelAndView selectProfile(@RequestParam("userId") String userId) throws Exception{
//    ModelAndView mv = new ModelAndView("profile/profilemain");
//
//    List<ProfileDTO> profileList =  profileService.selectProfileList(userId);
//    mv.addObject("profileList", profileList);
//
//    return mv;
//  }

  @RequestMapping("/profile")
  public ModelAndView profileMain() throws Exception {
    ModelAndView mv = new ModelAndView("profile/profilemain");

    List<ProfileDTO> profileList = profileService.selectProfileList();
    mv.addObject("profileList", profileList);

    return mv;
  }

  @RequestMapping("/profiledetail")
  public ModelAndView profileDetail(@RequestParam("userId") String userId) throws Exception {
    ModelAndView mv = new ModelAndView("profile/profiledetail");

    ProfileDTO profile = profileService.selectProfileDetail(userId);
    mv.addObject("profile", profile);

    return mv;
  }
}