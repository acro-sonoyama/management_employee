package managementEmployee.action.delete.dept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Department;
import managementEmployee.entity.DeptEntity;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.DeptDeleteLogic;


public class DeptDeleteCheckAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/delete/deptDeleteCheck.jsp";

		int deptId = Integer.parseInt(req.getParameter("deptId"));

		DeptDeleteLogic deptLogic = new DeptDeleteLogic();
		DeptEntity deptEntity = deptLogic.findById(deptId);

		//Beanへの詰め替え
		Department dept = new Department(deptEntity);

		HttpSession session = req.getSession();
		session.setAttribute("dept", dept);

		return path;
	}
}