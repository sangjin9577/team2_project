package bitc.fullstack405.team2.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    // FAQ 목록 출력(view)
    @GetMapping("/notice/FAQ")
    public ModelAndView  selectFAQ() throws Exception {
        ModelAndView mv = new ModelAndView("notice/notice_FAQ");

        List<NoticeDTO> FAQList = noticeService.selectFAQ();
        mv.addObject("FAQList", FAQList);

        return mv;
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

        NoticeDTO notice = noticeService.selectNoticeDetail(noticeId); // 현재 게시물 조회
        notice.setPreviousPost(noticeService.getPreviousPost(noticeId)); // 이전 게시물 ID 조회
        notice.setNextPost(noticeService.getNextPost(noticeId)); // 다음 게시물 ID 조회

        mv.addObject("notice", notice);

        return mv;
    }

    // notice 게시글 작성(view)
    @GetMapping("/notice/write")
    public String noticeWrite() throws Exception {
        return "notice/noticeWrite";
    }

    // notice 게시글 작성(내부 처리)
    @PostMapping("/notice/write")
    public String noticeWrite(NoticeDTO notice, @RequestParam("uploadFile") MultipartFile uploadFile) throws Exception {

        int cafeId = 0;
        
        // 지점명이 전체가 아니면 해당 지점의 id 가져오기
        if(!notice.getName().equals("전체")) {
            cafeId = noticeService.getCafeIdByName(notice.getName());
        }

        // cafeId를 notice 객체에 설정
        notice.setCafeId(cafeId);

        noticeService.insertNotice(notice, uploadFile);
        return "redirect:/notice";
    }

    // 공지사항 게시물 삭제
    @DeleteMapping("/notice/{noticeId}")
    public String deleteNotice(int noticeId) throws Exception {
        noticeService.deleteNotice(noticeId);

        return "redirect:/notice";
    }

    // notice 게시글 수정(view)
    @GetMapping("/notice/edit/{noticeId}")
    public ModelAndView noticeEdit(@PathVariable("noticeId") int noticeId) throws Exception {
        noticeService.updateHitCount(noticeId);

        ModelAndView mv = new ModelAndView("notice/noticeEdit");

        NoticeDTO notice = noticeService.selectNoticeDetail(noticeId);
        mv.addObject("notice", notice);

        return mv;
    }

    // 공지사항 게시물 수정(내부 처리)
    @PutMapping("/notice/edit/{noticeId}")
    public String updateNotice(@PathVariable("noticeId") int noticeId, NoticeDTO notice, @RequestParam("uploadFile") MultipartFile uploadFile) throws Exception {
        int cafeId = 0;

        // 지점명이 전체가 아니면 해당 지점의 id 가져오기
        if(!notice.getName().equals("전체")) {
            cafeId = noticeService.getCafeIdByName(notice.getName());
        }

        // cafeId를 notice 객체에 설정
        notice.setCafeId(cafeId);
        // noticeId를 notice 객체에 설정
        notice.setNoticeId(noticeId);

        noticeService.updateNotice(notice, uploadFile);

        return "redirect:/notice";
    }
}