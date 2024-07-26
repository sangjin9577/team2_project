package bitc.fullstack405.team2.notice;

import jakarta.servlet.http.HttpServletRequest;
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
    public String  noticeWrite(NoticeDTO notice, @RequestParam("uploadFiles") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return "notice/noticeWrite";
        }

        // 1. cafe_name으로 cafe_id 조회
        int cafeId = noticeService.getCafeIdByName(notice.getName());

        // 2. cafe_id를 notice 객체에 설정
        notice.setCafeId(cafeId);


        // 3. notice_test 테이블에 데이터 삽입
//        try {
//            noticeService.insertNotice(notice);
//            return "Notice created successfully";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error creating notice";
//        }

        noticeService.insertNotice(notice, multipart);
        return "redirect:/notice";
    }
}
