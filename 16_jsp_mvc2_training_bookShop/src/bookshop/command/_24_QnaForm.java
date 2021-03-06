package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.dao.ManagerDao;
import bookshop.controller.CommandAction;



public class _24_QnaForm implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String book_kind = request.getParameter("book_kind");
		int book_id=Integer.parseInt(request.getParameter("book_id"));  
		
		//book_id에 해당하는 book_title을 얻어냄
		ManagerDao bookProcess = ManagerDao.getInstance();
		String book_title = bookProcess.getBookTitle(book_id);
	   
		request.setAttribute("book_kind", book_kind);
	    request.setAttribute("book_id", new Integer(book_id));
	    request.setAttribute("book_title", book_title);
	    request.setAttribute("qora", new Integer(1));
		request.setAttribute("type", new Integer(1));
		
		return "/24_qnaForm.jsp";
		
	}
	
}