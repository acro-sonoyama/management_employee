package managementEmployee.action.update.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Employee;
import managementEmployee.entity.EmpEntity;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.EmpUpdateLogic;


public class EmpUpdateCompleteAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/update/empUpdateComplete.jsp";

		//セッションからemployeeBeanキーを取得
		HttpSession session = req.getSession();
		Employee emp = (Employee) session.getAttribute("emp");

		EmpUpdateLogic empLogic = new EmpUpdateLogic();
		empLogic.update(emp);

		//現在のログインユーザー情報の取得
		Employee oldLoginUser = (Employee)session.getAttribute("user");

		//更新した社員とログインしているユーザーが同じ場合、ログインユーザーの情報を最新化
		if (emp.getEmpId() == oldLoginUser.getEmpId()) {

			EmpEntity loginUserEntity = empLogic.findById(oldLoginUser.getEmpId());
			Employee user = new Employee(loginUserEntity);

			session.setAttribute("user", user);
		}

		session.removeAttribute("emp");

		return path;
	}
}
