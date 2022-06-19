package managementEmployee.action.regist.dept;

import javax.servlet.http.HttpServletRequest;

import managementEmployee.action.ActionIF;


public class DeptRegistInputAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) {

		String path = "/WEB-INF/jsp/regist/deptRegistInput.jsp";

		return path;
	}
}