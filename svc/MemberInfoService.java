package svc;
import static db.Jdbcutil.close;
import static db.Jdbcutil.commit;
import static db.Jdbcutil.getConnection;
import static db.Jdbcutil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MyPageDAO;
import vo.Member;
import vo.MemberOrder;

public class MemberInfoService {
	
	//AdminMemberListProAction : 회원 전체 목록
	public ArrayList<Member> getListMember(int page, int viewCount) throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		ArrayList<Member> memberList = myPageDAO.getListMember(page,viewCount);
		
		close(con);
		
		return memberList;
	}

	//AdminMemberProAction : 회원 아이디를 통해 검색
	public Member getMember(String id) throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		Member member = myPageDAO.getMember(id);
		
		close(con);
		
		return member;
	}

	//AdminMemberDeleteProAction
	//AdminMemberUpdateProAction
	//관리자 회원(개인) 조회
	public ArrayList<Member> getArrMember(String[] memberCheckId) throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		ArrayList<Member> memberList = myPageDAO.adminGetMember(memberCheckId);
		
		close(con);
		
		return memberList;
	}
	
	//AdminMemberDeleteProAction : 관리자 회원 체크박스 선택시 삭제  		용준
	public boolean getArrMemberDelete(Member members) throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		int arrMemberDeleteCount = myPageDAO.arrMemberDelete(members);
		
		boolean arrMemberDeleteSuccess = false;
		if(arrMemberDeleteCount>0) {
			commit(con);
			arrMemberDeleteSuccess=true;
		} else {
			rollback(con);
		}
		close(con);
		return arrMemberDeleteSuccess;
	}

	//AdminMemberDeletePointProAction : 포인트 있음에도 불구하고 삭제하는 요청
	public boolean getArrMemberPoint(ArrayList<Member> memberList) throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		int arrMemberrPointDeleteCount = myPageDAO.arrMemberPointDelete(memberList);
		
		boolean arrMemberrPointDeleteSuccess = false;
		if(arrMemberrPointDeleteCount>0) {
			commit(con);
			arrMemberrPointDeleteSuccess=true;
		} else {
			rollback(con);
		}
		close(con);
		return arrMemberrPointDeleteSuccess;
	}
	
	//AdminMemberListProAction : 회원 전체 카운터 숫자로 반환
	public int getMemberListCount() throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		int MemberListCount = myPageDAO.selectMemberListCount();
		
		close(con);
		
		return MemberListCount;
	}

	//AdminMemberUpdateProAction : 관리자 조회 - 회원 권한 수정
	public boolean getArrmemberUpdate(Member members, String memberUpdateAthor) throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		int updateMemberAuthorCount = myPageDAO.updateMemberAuthor(members,memberUpdateAthor);
		boolean updateMemberAuthorSuccess = false;
		
		if(updateMemberAuthorCount >0) {
			updateMemberAuthorSuccess=true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return updateMemberAuthorSuccess;
		
	}

	//MemberOrderResultProAction
	public ArrayList<MemberOrder> getListMyOrder(String id) throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		ArrayList<MemberOrder> myOrderList = myPageDAO.getListMyOrder(id);
		
		close(con);
		
		return myOrderList;
	}
	
	//AdminServerMoneyAction
	public int getMemberMoney() {
		Connection con = getConnection();
	
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
	
		myPageDAO.setConnection(con);
		
		int totalMoney = myPageDAO.getMemberMoney();
		
		close(con);
		
		return totalMoney;
	}
	
	
}
