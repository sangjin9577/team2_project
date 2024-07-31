package bitc.fullstack405.team2.review;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // review 게시판 목록 출력(페이징)
    @GetMapping("/review")
    public ModelAndView selectReviewList(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("review/reviewList");

        List<ReviewDTO> reviewList = reviewService.selectReviewList(pageNum);

        PageInfo<ReviewDTO> pageInfo = new PageInfo<>(reviewList, 5);

        mv.addObject("reviewList", reviewList);
        mv.addObject("pageInfo", pageInfo);

        return mv;
    }

    // review 게시물 상세
    @GetMapping("/review/{boardIdx}")
    public ModelAndView selectNoticeDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
        reviewService.updateHitCount(boardIdx);

        ModelAndView mv = new ModelAndView("review/reviewDetail");

        ReviewDTO review = reviewService.selectReviewDetail(boardIdx); // 현재 게시물 조회

        mv.addObject("review", review);

        return mv;
    }

    // review 게시글 작성(view)
    @GetMapping("/review/write")
    public String reviewWrite() throws Exception {
        return "review/reviewWrite";
    }

    // review 게시글 작성(내부 처리)
//    @PostMapping("/review/write")
//    public String reviewWrite(ReviewDTO review, @RequestParam("uploadFile") MultipartFile uploadFile) throws Exception {
//
//        int cafeId = 0;
//
//        // 지점명이 전체가 아니면 해당 지점의 id 가져오기
//        if(!notice.getName().equals("전체")) {
//            cafeId = noticeService.getCafeIdByName(notice.getName());
//        }
//
//        // cafeId를 notice 객체에 설정
//        notice.setCafeId(cafeId);
//
//        noticeService.insertNotice(notice, uploadFile);
//        return "redirect:/notice";
//    }
//
//    // notice 게시물 삭제
//    @DeleteMapping("/notice/{noticeId}")
//    public String deleteNotice(int noticeId) throws Exception {
//        noticeService.deleteNotice(noticeId);
//
//        return "redirect:/notice";
//    }
//
//    // notice 게시글 수정(view)
//    @GetMapping("/notice/edit/{noticeId}")
//    public ModelAndView noticeEdit(@PathVariable("noticeId") int noticeId) throws Exception {
//        noticeService.updateHitCount(noticeId);
//
//        ModelAndView mv = new ModelAndView("notice/noticeEdit");
//
//        ReviewDTO notice = noticeService.selectNoticeDetail(noticeId);
//        mv.addObject("notice", notice);
//
//        return mv;
//    }
//
//    // notice 게시물 수정(내부 처리)
//    @PutMapping("/notice/edit/{noticeId}")
//    public String updateNotice(@PathVariable("noticeId") int noticeId, ReviewDTO notice, @RequestParam("uploadFile") MultipartFile uploadFile) throws Exception {
//        int cafeId = 0;
//
//        // 지점명이 전체가 아니면 해당 지점의 id 가져오기
//        if(!notice.getName().equals("전체")) {
//            cafeId = noticeService.getCafeIdByName(notice.getName());
//        }
//
//        // cafeId를 notice 객체에 설정
//        notice.setCafeId(cafeId);
//        // noticeId를 notice 객체에 설정
//        notice.setNoticeId(noticeId);
//
//        noticeService.updateNotice(notice, uploadFile);
//
//        return "redirect:/notice";
//    }
}