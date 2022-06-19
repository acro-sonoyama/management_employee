package managementEmployee.action.top;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;


public class TopAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) {

		String path = "/WEB-INF/jsp/top.jsp";

		//セッションの削除
		HttpSession session = req.getSession();
		session.invalidate();

		return path;
	}

}
