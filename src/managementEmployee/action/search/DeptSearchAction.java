package managementEmployee.action.search;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Employee;
import managementEmployee.entity.EmpEntity;
import managementEmployee.exception.EmpBusinessException;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.DeptSearchLogic;


public class DeptSearchAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/list/empList.jsp";

		int deptId = Integer.parseInt(req.getParameter("deptId"));

		try {
			DeptSearchLogic deptLogic = new DeptSearchLogic();
			ArrayList<EmpEntity> empEntityList = deptLogic.findAllEmpById(deptId);

			//Beanへ詰め替え
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
