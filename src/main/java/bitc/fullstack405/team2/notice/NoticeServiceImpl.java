package bitc.fullstack405.team2.notice;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

//    @Autowired
//    private FileUtils fileUtils;

    // notice 목록
    @Override
    public List<NoticeDTO> selectNoticeList() throws Exception {
        return noticeMapper.selectNoticeList();
    }

    // notice 게시글 세부 내용
    @Override
    public NoticeDTO selectNoticeDetail(int noticeId) throws Exception {
        return noticeMapper.selectNoticeDetail(noticeId);
    }

    // notice 조회수 증가
    @Override
    public void updateHitCount(int noticeId) throws Exception {
        noticeMapper.updateHitCount(noticeId);
    }

    // notice 글 등록 - 관리자
//    @Override
//    public void insertNotice(NoticeDTO notice, MultipartFile multipart) throws Exception {
//        noticeMapper.insertNotice(notice);
//    }
}