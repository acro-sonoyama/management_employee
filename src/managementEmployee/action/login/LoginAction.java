package managementEmployee.action.login;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Employee;
import managementEmployee.entity.EmpEntity;
import managementEmployee.exception.DeptBusinessException;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.LoginLogic;
import managementEmployee.util.Constants;

public class LoginAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/fc?actionId=EmpList";

		ArrayList<String> errorMessageList = new ArrayList<>();

		String empId = req.getParameter("empId");
		String empPass = req.getParameter("empPass");

		//empId入力チェック
		if (empId == null || empId.equals("")) {
			errorMessageList.add(Constants.EMPID_EMPTY);
		} else {
			try {
				int empIdInt = Integer.parseInt(empId);
				if (empIdInt > 99999) {
					errorMessageList.add(Constants.EMPID_LENGTH_OVER);
				}
			} catch (NumberFormatException e) {
				errorMessageList.add(Constants.EMPID_MISSMATCH);
			}
		}

		//empPass入力チェック
		if (empPass == null || empPass.equals("")) {
			errorMessageList.add(Constants.PASSWORD_EMPTY);
		}

		//入力チェックに該当した場合
		if (!errorMessageList.isEmpty()) {
			req.setAttribute("errorMessageList", errorMessageList);
			path = "/WEB-INF/jsp/top.jsp";
			return path;
		}

		try {
			//ログイン処理用業務ロジック呼び出し
			LoginLogic loginLogic = new LoginLogic();
			EmpEntity loginUserEntity = loginLogic.findByIdPass(empId, empPass);


			//正常時：ユーザが見つかった場合
			//ログインユーザー情報をBeanで初期化し、セッションに格納
			Employee user = new Employee(loginUserEntity, "Login");
			HttpSession session = req.getSession();
			session.setAttribute("user", user);

			//異常時：ユーザが見つからなかった場合
		} catch (DeptBusinessException e) {
			req.setAttribute("errorMessageList", e.getMessage());
			path = "/WEB-INF/jsp/top.jsp";
		}

		return path;
	}

}
