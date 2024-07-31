package bitc.fullstack405.team2.review;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private ReviewFileUtils fileUtils;

    @Override
    public Page<ReviewDTO> selectReviewList(int pageNum) throws Exception {
        PageHelper.startPage(pageNum, 5);
        return reviewMapper.selectReviewList();
    }

    // review 게시글 세부 내용
    @Override
    public ReviewDTO selectReviewDetail(int boardIdx) throws Exception {
        return reviewMapper.selectReviewDetail(boardIdx);
    }

    // review 조회수 증가
    @Override
    public void updateHitCount(int boardIdx) throws Exception {
        reviewMapper.updateHitCount(boardIdx);
    }
//
//    @Override
//    public int getCafeIdByName(String name) throws Exception {
//        return noticeMapper.getCafeIdByName(name);
//    }
//
//    @Override
//    public void insertNotice(ReviewDTO notice, MultipartFile uploadFile) throws Exception {
//        // FileUtils에서 DB에 저장할 파일 이름 가져오기
//        String noticeImage = fileUtils.parseFileInfo(uploadFile);
//        notice.setNoticeImage(noticeImage);
//        noticeMapper.insertNotice(notice);
//    }
//
//    @Override
//    public void deleteNotice(int noticeId) throws Exception {
//        noticeMapper.deleteNotice(noticeId);
//    }
//
//    @Override
//    public void updateNotice(ReviewDTO notice, MultipartFile uploadFile) throws Exception {
//        // FileUtils에서 DB에 저장할 파일 이름 가져오기
//        String noticeImage = fileUtils.parseFileInfo(uploadFile);
//        notice.setNoticeImage(noticeImage);
//        noticeMapper.updateNotice(notice);
//    }
}