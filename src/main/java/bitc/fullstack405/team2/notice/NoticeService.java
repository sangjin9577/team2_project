package bitc.fullstack405.team2.notice;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface NoticeService {
    List<NoticeDTO> selectNoticeList() throws Exception;

    NoticeDTO selectNoticeDetail(int noticeId) throws Exception;

    void updateHitCount(int noticeId) throws Exception;

    int getCafeIdByName(String name) throws Exception;

    void insertNotice(NoticeDTO notice, MultipartHttpServletRequest multipart) throws Exception;
}
