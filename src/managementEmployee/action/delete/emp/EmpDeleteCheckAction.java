package managementEmployee.action.delete.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Employee;
import managementEmployee.entity.EmpEntity;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.EmpDeleteLogic;


public class EmpDeleteCheckAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/delete/empDeleteCheck.jsp";

		int empId = Integer.parseInt(req.getParameter("empId"));

		EmpDeleteLogic empLogic = new EmpDeleteLogic();
		EmpEntity empEntity = empLogic.findById(empId);

		//Beanへの詰め替え
		Employee emp = new Employee(empEntity);

		HttpSession session = req.getSession();
		session.setAttribute("emp", emp);

		return path;
	}
}
