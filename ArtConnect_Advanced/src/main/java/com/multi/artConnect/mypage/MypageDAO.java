package com.multi.artConnect.mypage;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.artConnect.member.MemberVO;
import com.multi.artConnect.reservation.ReservationVO;
import com.multi.artConnect.review.BoardVO;



@Repository
public class MypageDAO {

	@Autowired
	SqlSessionTemplate my; 
	
	public MemberVO one(String memberID) {
		return my.selectOne("mymember.updateOne", memberID);
	}
	
	public int update(MemberVO vo) {
		int result = my.update("mymember.update", vo);
		return result;
	}
	
	public int updatePw(MemberVO vo) { // 비밀번호 변경
		return my.update("mymember.updatePw", vo);
	}
	
	
	public MemberVO one2(String memberID) {
		return my.selectOne("mymember.deleteOne", memberID);
	}
	
	public int delete(String memberID) {
		int result = my.delete("mymember.delete", memberID);
		return result;
	}
	
	// 내가 쓴 리뷰 목록
	public List<BoardVO> myReviewList(String memberID, int start, int size) {
		Map<String, Object> params = new HashMap<>();
		 params.put("memberID", memberID);
	    params.put("start", start);
		params.put("size", size);
		List<BoardVO> list = my.selectList("review.myReview", memberID);
		return my.selectList("review.myReviewList", params);
	}
	
	public int getTotalCount(String memberID) {
		return my.selectOne("review.getTotalCount", memberID);
	}
	
	// 내 예약 목록
		public List<ReservationVO> myReservationList(String memberID) {
			List<ReservationVO> list = my.selectList("reservation.myReservation", memberID);
			return list;
		}
		
		public List<Map<String, Object>> myLike(String memberID) {
			// DAO에서 데이터베이스에서 좋아요 정보를 가져오는 코드 작성
	        List<Map<String, Object>> likesList = my.selectList("mymember.myLike", memberID);
	        return likesList;
		}
		
		public int deleteReservation(int reservationID) {
		    return my.delete("reservation.deleteReservation", reservationID);
		}
}