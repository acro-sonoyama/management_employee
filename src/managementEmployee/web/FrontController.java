package managementEmployee.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.action.delete.dept.DeptDeleteCheckAction;
import managementEmployee.action.delete.dept.DeptDeleteCompleteAction;
import managementEmployee.action.delete.emp.EmpDeleteCheckAction;
import managementEmployee.action.delete.emp.EmpDeleteCompleteAction;
import managementEmployee.action.list.DeptListAction;
import managementEmployee.action.list.EmpListAction;
import managementEmployee.action.login.LoginAction;
import managementEmployee.action.regist.dept.DeptRegistCheckAction;
import managementEmployee.action.regist.dept.DeptRegistCompleteAction;
import managementEmployee.action.regist.dept.DeptRegistInputAction;
import managementEmployee.action.regist.emp.EmpRegistCheckAction;
import managementEmployee.action.regist.emp.EmpRegistCompleteAction;
import managementEmployee.action.regist.emp.EmpRegistInputAction;
import managementEmployee.action.search.DeptSearchAction;
import managementEmployee.action.search.EmpSearchAction;
import managementEmployee.action.top.TopAction;
import managementEmployee.action.update.dept.DeptUpdateCheckAction;
import managementEmployee.action.update.dept.DeptUpdateCompleteAction;
import managementEmployee.action.update.dept.DeptUpdateInputAction;
import managementEmployee.action.update.emp.EmpUpdateCheckAction;
import managementEmployee.action.update.emp.EmpUpdateCompleteAction;
import managementEmployee.action.update.emp.EmpUpdateInputAction;
import managementEmployee.bean.Employee;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;

@WebServlet("/fc")
public class FrontController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String path = "";
		ArrayList<String> errorMessageList = new ArrayList<>();

		try {
			String actionId = req.getParameter("actionId");
			if (actionId == null) {//actionId未送信は"Index"と見なす
				actionId = "Top";
			} else if (actionId.equals("")) { //actionId未設定はシステムエラー
				throw new SystemException("actionIdが未設定です");
			}

			//セッションからログインユーザー情報の抽出
			HttpSession session = req.getSession();
			Employee loginUser = (Employee) session.getAttribute("user");

			//ログイン未実施の場合、そのままログイン画面へ
//			if (loginUser == null) {
//				actionId = "Login";

				//一般でログインした場合
			if (loginUser != null && loginUser.getAuthority() == Constants.EMPLOYEE) {
				ArrayList<String> unaccessList = new ArrayList<>();
				unaccessList.add("RegistInput");
				unaccessList.add("RegistConfirm");
				unaccessList.add("RegistComplete");
				unaccessList.add("DeleteConfirm");
				unaccessList.add("DeleteComplete");
				unaccessList.add("RegistInputDept");
				unaccessList.add("RegistConfirmDept");
				unaccessList.add("RegistCompleteDept");
				unaccessList.add("UpdateInputDept");
				unaccessList.add("UpdateConfirmDept");
				unaccessList.add("UpdateCompleteDept");
				unaccessList.add("DeleteConfirmDept");
				unaccessList.add("DeleteCompleteDept");
				for (String unaccess : unaccessList) {

					//一般でアクセス不可なページにアクセスした場合、エラーメッセージを格納し、ログイン画面へ
					if (unaccess.equals(actionId)) {
						errorMessageList.add(Constants.AUTHORITY_MISSMATCH);
						req.setAttribute("errorMessageList", errorMessageList);
						actionId = "Top";
					}
				}

			}

			ActionIF action = null;
			switch (actionId) {
			case "Login":
				action = new LoginAction();
				break;
			case "EmpList":
				action = new EmpListAction();
				break;
			case "DeptList":
				action = new DeptListAction();
				break;
			case "EmpSearch":
				action = new EmpSearchAction();
				break;
			case "DeptSearch":
				action = new DeptSearchAction();
				break;
			case "EmpRegistInput":
				action = new EmpRegistInputAction();
				break;
			case "EmpRegistCheck":
				action = new EmpRegistCheckAction();
				break;
			case "EmpRegistComplete":
				action = new EmpRegistCompleteAction();
				break;
			case "DeptRegistInput":
				action = new DeptRegistInputAction();
				break;
			case "DeptRegistCheck":
				action = new DeptRegistCheckAction();
				break;
			case "DeptRegistComplete":
				action = new DeptRegistCompleteAction();
				break;
			case "EmpUpdateInput":
				action = new EmpUpdateInputAction();
				break;
			case "EmpUpdateCheck":
				action = new EmpUpdateCheckAction();
				break;
			case "EmpUpdateComplete":
				action = new EmpUpdateCompleteAction();
				break;
			case "DeptUpdateInput":
				action = new DeptUpdateInputAction();
				break;
			case "DeptUpdateCheck":
				action = new DeptUpdateCheckAction();
				break;
			case "DeptUpdateComplete":
				action = new DeptUpdateCompleteAction();
				break;
			case "EmpDeleteCheck":
				action = new EmpDeleteCheckAction();
				break;
			case "EmpDeleteComplete":
				action = new EmpDeleteCompleteAction();
				break;
			case "DeptDeleteCheck":
				action = new DeptDeleteCheckAction();
				break;
			case "DeptDeleteComplete":
				action = new DeptDeleteCompleteAction();
				break;
			case "Top":
				action = new TopAction();
				break;
			}

			path = action.execute(req);


		} catch (SystemException e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", e.getMessage());
			path = "/WEB-INF/jsp/error/SystemError.jsp";
		}

		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
