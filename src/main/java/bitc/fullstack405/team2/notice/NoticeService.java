package bitc.fullstack405.team2.notice;

import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface NoticeService {
    List<NoticeDTO> selectNoticeList() throws Exception;

    NoticeDTO selectNoticeDetail(int noticeId) throws Exception;

    void updateHitCount(int noticeId) throws Exception;

    int getCafeIdByName(String name) throws Exception;

    void insertNotice(NoticeDTO notice, MultipartFile uploadFile) throws Exception;

    void deleteNotice(int noticeId) throws Exception;

    void updateNotice(NoticeDTO notice, MultipartFile uploadFile) throws Exception;
}
