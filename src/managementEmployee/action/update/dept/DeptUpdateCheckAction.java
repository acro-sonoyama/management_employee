package managementEmployee.action.update.dept;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Department;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;


public class DeptUpdateCheckAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/update/deptUpdateCheck.jsp";

		ArrayList<String> errorMessageList = new ArrayList<>();

		////セッションから部署IDに合致した部署情報が入っているdepartmentBeanキーを取得
		HttpSession session = req.getSession();
		Department dept = (Department) session.getAttribute("dept");

		String deptName = req.getParameter("deptName");

		//deptName入力チェック
		if (deptName == null || deptName.equals("")) {
			errorMessageList.add(Constants.DEPTNAME_EMPTY);
		} else if (deptName.length() > 15) {
			errorMessageList.add(Constants.DEPTNAME_LENGTH_OVER);
		}

		//入力チェックに該当した場合
		if (errorMessageList.size() != 0) {
			req.setAttribute("errorMessageList", errorMessageList);
			path = "/WEB-INF/jsp/update/update_input_dept.jsp";
		}

		//取得したdeptにパラメーターから取得した情報をセットする
		dept.setDeptName(deptName);

		//変更情報の入ったdepartmentBeanキーをセッションに格納
		session.setAttribute("dept", dept);

		return path;
	}
}
