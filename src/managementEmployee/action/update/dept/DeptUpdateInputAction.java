package managementEmployee.action.update.dept;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Department;
import managementEmployee.entity.DeptEntity;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.DeptUpdateLogic;


public class DeptUpdateInputAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/update/deptUpdateInput.jsp";

		DeptUpdateLogic deptLogic = new DeptUpdateLogic();

		//deptList.jspから遷移した場合
		if (req.getParameter("deptId") != null) {
			//部署IDに合致する社員情報の抽出
			int deptId = Integer.parseInt(req.getParameter("deptId"));
			DeptEntity deptEntity = deptLogic.findById(deptId);
			Department dept = new Department(deptEntity);

			//合致した社員情報をセッションに格納
			HttpSession session = req.getSession();
			session.setAttribute("dept", dept);
		}

		//全部署情報をリクエストに格納
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
