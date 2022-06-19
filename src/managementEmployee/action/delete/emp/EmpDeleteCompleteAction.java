package managementEmployee.action.delete.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Employee;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.EmpDeleteLogic;


public class EmpDeleteCompleteAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/delete/empDeleteComplete.jsp";

		HttpSession session = req.getSession();
		Employee emp = (Employee) session.getAttribute("emp");

		EmpDeleteLogic empLogic = new EmpDeleteLogic();
		empLogic.delete(emp.getEmpId());

		session.removeAttribute("emp");

		return path;
	}

}
