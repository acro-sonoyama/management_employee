package managementEmployee.action.regist.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Employee;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.EmpRegistLogic;


public class EmpRegistCompleteAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/regist/empRegistComplete.jsp";

		HttpSession session = req.getSession();
		Employee emp = (Employee) session.getAttribute("emp");

		EmpRegistLogic empLogic = new EmpRegistLogic();
		empLogic.insert(emp);

		session.removeAttribute("emp");

		return path;
	}
}
