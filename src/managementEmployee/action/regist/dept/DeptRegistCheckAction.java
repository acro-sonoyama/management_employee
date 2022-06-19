package managementEmployee.action.regist.dept;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Department;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;


public class DeptRegistCheckAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/regist/deptRegistCheck.jsp";

		ArrayList<String> errorMessageList = new ArrayList<>();

		String deptName = req.getParameter("deptName");

		//empPass入力チェック
		if (deptName == null || deptName.equals("")) {
			errorMessageList.add(Constants.DEPTNAME_EMPTY);
		} else if (deptName.length() > 15) {
			errorMessageList.add(Constants.DEPTNAME_LENGTH_OVER);
		}

		//入力チェックに該当した場合
		if (errorMessageList.size() != 0) {
			req.setAttribute("errorMessageList", errorMessageList);
			path = "/WEB-INF/jsp/regist/regist_input_dept.jsp";

		}

		Department dept = new Department();
		dept.setDeptName(deptName);

		HttpSession session = req.getSession();
		session.setAttribute("dept", dept);

		return path;
	}
}
