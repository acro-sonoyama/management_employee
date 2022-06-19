package managementEmployee.action.update.emp;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Department;
import managementEmployee.bean.Employee;
import managementEmployee.entity.DeptEntity;
import managementEmployee.entity.EmpEntity;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.DeptUpdateLogic;
import managementEmployee.logic.EmpUpdateLogic;

public class EmpUpdateInputAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/update/empUpdateInput.jsp";

		HttpSession session = req.getSession();
		Employee emp = (Employee) session.getAttribute("emp");

		//empList.jspから遷移した場合
		if (req.getParameter("empId") != null) {
			//社員IDに合致する社員情報の抽出
			int empId = Integer.parseInt(req.getParameter("empId"));

			EmpUpdateLogic empLogic = new EmpUpdateLogic();
			EmpEntity empEntity = empLogic.findById(empId);

			emp = new Employee(empEntity);

			//合致した社員情報をセッションに格納
			session.setAttribute("emp", emp);

			//empUpdateCheck.jspから遷移した場合
		} else if (emp != null) {

			//header.jspから遷移した場合
		} else {
			//セッションからログインユーザー情報の抽出
			Employee loginUser = (Employee) session.getAttribute("user");

			EmpUpdateLogic empLogic = new EmpUpdateLogic();
			EmpEntity empEntity = empLogic.findById(loginUser.getEmpId());

			//社員IDに合致する社員情報の抽出
			emp = new Employee(empEntity);

			//ログインユーザー情報をセッションに格納
			session.setAttribute("emp", emp);
		}

		//empUpdateCheck.jspまたはempList.jspから遷移した場合の共通処理
		DeptUpdateLogic deptLogic = new DeptUpdateLogic();
		ArrayList<DeptEntity> deptEntityList = deptLogic.findAll();

		//Beanへの詰め替え
		ArrayList<Department> deptList = new ArrayList<>();
		for (DeptEntity deptEntity : deptEntityList) {
			Department dept = new Department(deptEntity);
			deptList.add(dept);
		}

		req.setAttribute("deptList", deptList);

		return path;
	}
}
