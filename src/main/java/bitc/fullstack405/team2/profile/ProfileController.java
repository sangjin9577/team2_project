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