package managementEmployee.action.list;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Department;
import managementEmployee.bean.Employee;
import managementEmployee.entity.DeptEntity;
import managementEmployee.entity.EmpEntity;
import managementEmployee.exception.DeptBusinessException;
import managementEmployee.exception.EmpBusinessException;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.DeptListLogic;
import managementEmployee.logic.EmpListLogic;

public class EmpListAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/list/empList.jsp";

		try {
			EmpListLogic empLogic = new EmpListLogic();
			ArrayList<EmpEntity> empEntityList = empLogic.findAll();

			//Beanへの詰め替え
			ArrayList<Employee> empList = new ArrayList<>();
			for (EmpEntity empEntity : empEntityList) {
				Employee emp = new Employee(empEntity);
				empList.add(emp);
			}

			req.setAttribute("empList", empList);

			//登録or変更or削除情報の入ったemployeeBeanキーをセッションから削除
			HttpSession session = req.getSession();
			session.removeAttribute("emp");

			//部署一覧情報の取得
			DeptListLogic deptLogic = new DeptListLogic();
			ArrayList<DeptEntity> deptEntityList = deptLogic.findAll();

			//Beanへ詰め替え
			ArrayList<Department> deptList = new ArrayList<>();
			for (DeptEntity deptEntity : deptEntityList) {
				Department dept = new Department(deptEntity);
				deptList.add(dept);
			}

			//部署一覧情報をリクエストに格納
			session.setAttribute("deptList", deptList);

		} catch (EmpBusinessException | DeptBusinessException e) {
			req.setAttribute("errorMessage", e.getMessage());
		}

		return path;
	}

}
