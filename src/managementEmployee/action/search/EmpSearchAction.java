package managementEmployee.action.search;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Employee;
import managementEmployee.entity.EmpEntity;
import managementEmployee.exception.EmpBusinessException;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.EmpSearchLogic;


public class EmpSearchAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/list/empList.jsp";

		String empName = req.getParameter("empName");

		try {
			EmpSearchLogic empLogic = new EmpSearchLogic();
			ArrayList<EmpEntity> empEntityList = empLogic.findByName(empName);

			//Beanへの詰め替え
			ArrayList<Employee> empList = new ArrayList<>();
			for (EmpEntity empEntity : empEntityList) {
				Employee emp = new Employee(empEntity);
				empList.add(emp);
			}

			req.setAttribute("empList", empList);

		} catch (EmpBusinessException e) {
			req.setAttribute("errorMessage", e.getMessage());
		}

		return path;
	}
}
