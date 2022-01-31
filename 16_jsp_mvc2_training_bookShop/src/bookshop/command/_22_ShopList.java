package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.ManagerDto;
import bookshop.controller.CommandAction;
import bookshop.dao.ManagerDao;


public class _22_ShopList implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {
		
		List<ManagerDto> bookList = null;
		int count = 0;
		String book_kind = request.getParameter("book_kind");
		
		ManagerDao bookProcess = ManagerDao.getInstance();
				
		if (book_kind.equals("all"))	count = bookProcess.getBookCount(); 
		else							count = bookProcess.getBookCount(book_kind);
		
        if (count > 0) {
        	bookList = bookProcess.getBooks(book_kind);
        	request.setAttribute("bookList", bookList);
        }
        
        request.setAttribute("count", new Integer(count));
        request.setAttribute("book_kind", book_kind);
        request.setAttribute("type", new Integer(1));
        
		return "/22_shopList.jsp";
		
	}

}
