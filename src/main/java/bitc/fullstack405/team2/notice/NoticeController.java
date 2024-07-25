package bitc.fullstack405.team2.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // 기본 주소 설정
    @RequestMapping({"", "/"})
    public String index() {
        return "index";
    }

    // FAQ 목록 출력
    @GetMapping("/notice/FAQ")
    public String  selectFAQ() throws Exception {
        return "notice/notice_FAQ";
    }

    // notice 게시판 목록 출력
    @GetMapping("/notice")
    public ModelAndView selectNoticeList() throws Exception {
        ModelAndView mv = new ModelAndView("notice/noticeList");

        List<NoticeDTO> noticeList = noticeService.selectNoticeList();
        mv.addObject("noticeList", noticeList);

        return mv;
    }

    // notice 게시물 상세
    @GetMapping("/notice/{noticeId}")
    public ModelAndView selectNoticeDetail(@PathVariable("noticeId") int noticeId) throws Exception {
        noticeService.updateHitCount(noticeId);

        ModelAndView mv = new ModelAndView("notice/noticeDetail");

        NoticeDTO notice = noticeService.selectNoticeDetail(noticeId);
        mv.addObject("notice", notice);

        return mv;
    }

    // notice 게시글 작성(view)
    @GetMapping("/notice/write")
    public String  selectNoticeWrite() throws Exception {
        return "notice/noticeWrite";
    }

    // notice 게시글 작성(내부 처리)
    @PostMapping("/notice/write")
    public String  noticeWrite(NoticeDTO notice, MultipartHttpServletRequest multipart) throws Exception {

        MultipartFile file = multipart.getFile("file"); // 멀티파트 파일 추출

        noticeService.insertNotice(notice, file);

        return "redirect:/notice";
    }
}
