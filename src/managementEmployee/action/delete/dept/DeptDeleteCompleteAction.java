package managementEmployee.action.delete.dept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Department;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.DeptDeleteLogic;


public class DeptDeleteCompleteAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/delete/deptDeleteComplete.jsp";

		HttpSession session = req.getSession();
		Department dept = (Department) session.getAttribute("dept");

		DeptDeleteLogic deptLogic = new DeptDeleteLogic();
		deptLogic.delete(dept.getDeptId());

		session.removeAttribute("dept");

		return path;
	}

}