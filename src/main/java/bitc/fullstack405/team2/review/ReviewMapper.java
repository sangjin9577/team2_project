package bitc.fullstack405.team2.review;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
//    int getCafeIdByName(String name) throws Exception;
//
    void insertReview(ReviewDTO review) throws Exception;

    Page<ReviewDTO> selectReviewList() throws Exception;

    ReviewDTO selectReviewDetail(int boardIdx) throws Exception;

    void updateHitCount(int boardIdx) throws Exception;

    void deleteReview(int boardIdx) throws Exception;

    void updateReview(ReviewDTO review) throws Exception;
//
//    List<ReviewDTO> selectFAQ() throws Exception;
//
//    int findPreviousPost(int noticeId) throws Exception;
//
//    int findNextPost(int noticeId) throws Exception;
}