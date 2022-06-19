package managementEmployee.action.update.dept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Department;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.DeptUpdateLogic;


public class DeptUpdateCompleteAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/update/deptUpdateComplete.jsp";

		HttpSession session = req.getSession();
		Department dept = (Department) session.getAttribute("dept");

		DeptUpdateLogic deptLogic = new DeptUpdateLogic();
		deptLogic.update(dept);

		session.removeAttribute("dept");

		return path;
	}
}
