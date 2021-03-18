package com.min.service;



import java.sql.ResultSet;
import java.util.ArrayList;

import com.min.dao.ViewDao;
import com.min.vo.CommentVo;
import com.min.vo.ViewVo;
import com.min.vo.memberVo;

public class ViewService {
	private static ViewService service = new ViewService();
	private ViewService() {}
	public static ViewService getInstance() {
		return service;
	}
	
	public ViewDao dao = ViewDao.GetInstance();
	
	public void ViewInsert(ViewVo view) {
		dao.InsertView(view);
	}
	
	public void ViewUpdate(int id, ViewVo view) {
		dao.UpdateView(id, view);
	}
	
	public void ViewDelete(int id) {
		dao.DeleteView(id);
	}
	
	public ArrayList<ViewVo> ViewGetAll() {
		return dao.GetAllView();
	}
	
	public ArrayList<ViewVo> ViewShowDetail(int id) {
		return dao.ShowDetailView(id);
	}
	
	
	
	public ArrayList<ViewVo> SearchView(String type, String item) {
		return dao.ViewSearch(type, item);
	}
	
	public void CommentInsert(String id, String content, String userid) {
		dao.commentInsert(id, content, userid);
	}
	
	public ArrayList<CommentVo> CommentGetAll(String id){
		return dao.commentGetAll(id);
	}
	
	public void commentDelete(String id) {
		dao.commentDelete(id);
	}
	
	public int memberInsert(memberVo member) {
		return dao.memberInsert(member);
	}
	
	public ArrayList<memberVo> login(memberVo member){
		return dao.login(member);
	}
	
	
}
