package com.dlsdlworld.web.Service;

import java.util.ArrayList;

import com.dlsdlworld.web.Dao.MemberDao;
import com.dlsdlworld.web.Entities.Member;

public class MemberService {
	MemberDao md = new MemberDao();
	
	public void memberInsert(Member member){
		md.insert(member);
	}
	
	public void memberDelete(String userId,String userPw){
		if(md.pwCheck(userId, userPw)) {
			md.delete(userId);			
		}
	}
	
	public void memberUpdate(Member member, String userId, String userPw) {
		if(md.pwCheck(userId, userPw)) {
			md.update(member, userId);
		}
	}
	
	
	public ArrayList<String> getIdInfomation(String findUserId, String findUserPassword) {
		ArrayList<String> tmp = new ArrayList<>();
		if(md.pwCheck(findUserId, findUserPassword)) {
			tmp = md.getIdInfo(findUserId);
			return tmp;			
		} 
		return tmp;
	}
	
}
