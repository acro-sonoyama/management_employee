package managementEmployee.action.list;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import managementEmployee.action.ActionIF;
import managementEmployee.bean.Department;
import managementEmployee.entity.DeptEntity;
import managementEmployee.exception.DeptBusinessException;
import managementEmployee.exception.SystemException;
import managementEmployee.logic.DeptListLogic;


public class DeptListAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest req) throws SystemException {

		String path = "/WEB-INF/jsp/list/deptList.jsp";

		try {
			//部署一覧情報の取得
			DeptListLogic deptLogic = new DeptListLogic();
			ArrayList<DeptEntity> deptEntityList = deptLogic.findAll();

			//Beanへ詰め替え
			ArrayList<Department> deptList = new ArrayList<>();
			for (DeptEntity deptEntity : deptEntityList) {
				Department dept = new Department(deptEntity);
				deptList.add(dept);
			}

			req.setAttribute("deptList", deptList);

			//登録or変更or削除情報の入ったdepartmentBeanキーをセッションから削除
			HttpSession session = req.getSession();
			session.removeAttribute("dept");

		} catch (DeptBusinessException e) {
			req.setAttribute("errorMessage", e.getMessage());
		}

		return path;
	}

}
