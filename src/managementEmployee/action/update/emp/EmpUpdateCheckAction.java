package managementEmployee.action.update.emp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Department;
import managementEmployee.bean.Employee;
import managementEmployee.entity.DeptEntity;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.DeptUpdateLogic;
import managementEmployee.util.Constants;


public class EmpUpdateCheckAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/update/empUpdateCheck.jsp";

		ArrayList<String> errorMessageList = new ArrayList<>();

		//セッションから社員IDに合致した社員情報が入っているemployeeBeanキー、userキーを取得
		HttpSession session = req.getSession();
		Employee emp = (Employee) session.getAttribute("emp");
		Employee loginUser = (Employee) session.getAttribute("user");

		//パラメータの取得
		String empPass = req.getParameter("empPass");
		String empName = req.getParameter("empName");
		int gender = Integer.parseInt(req.getParameter("gender"));
		String address = req.getParameter("address");
		String birthday = req.getParameter("birthday");
		int deptId = Integer.parseInt(req.getParameter("deptId"));

		//empPass入力チェック
		if (empPass == null || empPass.equals("")) {
			errorMessageList.add(Constants.PASSWORD_EMPTY);
		} else if (empPass.length() > 15) {
			errorMessageList.add(Constants.PASSWORD_LENGTH_OVER);
		}

		//empName入力チェック
		if (empName == null || empName.equals("")) {
			errorMessageList.add(Constants.NAME_EMPTY);
		} else if (empName.length() > 30) {
			errorMessageList.add(Constants.NAME_LENGTH_OVER);
		}

		//address入力チェック
		if (address == null || address.equals("")) {
			errorMessageList.add(Constants.ADDRESS_EMPTY);
		} else if (address.length() > 60) {
			errorMessageList.add(Constants.ADDRESS_LENGTH_OVER);
		}

		//birthday入力チェック
		if (birthday == null || birthday.equals("")) {
			errorMessageList.add(Constants.BIRTHDAY_EMPTY);
		} else {
			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				String birthdayCheck = dtf.format(LocalDate.parse(birthday, dtf)); // ←LocalDate.parseでDateTimeParseExceptionがThrowされる
			} catch (DateTimeParseException dtp) {
				errorMessageList.add(Constants.BIRTHDAY_MISSMATCH);
			}
		}

		//入力チェックに該当した場合
		if (errorMessageList.size() != 0) {
			req.setAttribute("errorMessageList", errorMessageList);
			path = "/WEB-INF/jsp/update/update_input.jsp";

		}

		//取得したempBeanにパラメーターから取得した情報をセットする
		emp.setEmpPass(empPass);
		emp.setEmpName(empName);
		emp.setGender(gender);
		emp.setAddress(address);
		emp.setBirthday(birthday);

		//管理者でアクセスしている場合は権限のパラメーターを取得し、情報をセットする
		if (loginUser.getAuthority() == Constants.MANAGER) {
			int authority = Integer.parseInt(req.getParameter("authority"));
			emp.setAuthority(authority);
		}

		//部署IDによる1件検索の結果をBeanで初期化し、empBeanにセットする
		DeptUpdateLogic deptLogic = new DeptUpdateLogic();
		DeptEntity deptEntity = deptLogic.findById(deptId);
		emp.setDepartment(new Department(deptEntity));

		//変更情報の入ったemployeeBeanキーをセッションに格納
		session.setAttribute("emp", emp);

		return path;
	}
}
