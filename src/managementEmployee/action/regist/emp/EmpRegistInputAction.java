package managementEmployee.action.regist.emp;

import javax.servlet.http.HttpServletRequest;

import managementEmployee.action.ActionIF;


public class EmpRegistInputAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) {

		String path = "/WEB-INF/jsp/regist/empRegistInput.jsp";

		return path;
	}
}
