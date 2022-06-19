package managementEmployee.action.regist.dept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Department;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.DeptRegistLogic;


public class DeptRegistCompleteAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/regist/deptRegistComplete.jsp";

		HttpSession session = req.getSession();
		Department dept = (Department) session.getAttribute("dept");

		DeptRegistLogic deptLogic = new DeptRegistLogic();
		deptLogic.insert(dept);

		session.removeAttribute("dept");

		return path;
	}
}
