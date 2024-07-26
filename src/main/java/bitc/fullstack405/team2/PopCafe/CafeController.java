package bitc.fullstack405.team2.PopCafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CafeController {

    @Autowired
    private CafeService cafeService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView selectLocationDetail(@RequestParam("cafeId") int cafeId) throws Exception {
        ModelAndView mv = new ModelAndView("location/locationdetail");

        CafeDTO cafe = cafeService.selectCafe(cafeId);
        mv.addObject("cafe", cafe);

        return mv;
    }

    @RequestMapping("/locationmain")
    public String themeMain() throws Exception{
//    ModelAndView mv = new ModelAndView("main/main");
        return "location/locationmain";
    }

}
