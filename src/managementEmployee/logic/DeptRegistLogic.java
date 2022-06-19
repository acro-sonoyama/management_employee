package managementEmployee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import managementEmployee.bean.Department;
import managementEmployee.dao.ConnectionManager;
import managementEmployee.dao.DepartmentDao;
import managementEmployee.entity.DeptEntity;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;

/**
 * 部署登録用業務ロジック
 */
public class DeptRegistLogic {

	/**
	 * 部署IDによる部署検索ロジック
	 * @param deptId
	 * @return
	 * @throws SystemException
	 */
	public DeptEntity findById(int deptId) throws SystemException {

		DeptEntity deptEntity = null;

		try (Connection con = ConnectionManager.getConnection()) {

			//部署用DAOの部署IDによる部署検索処理呼び出し
			DepartmentDao deptDao = new DepartmentDao(con);
			deptEntity = deptDao.findById(deptId);

		} catch (SQLException e) {
			throw new SystemException("");
		}

		return deptEntity;
	}


	/**
	 * 部署登録ロジック
	 * @param dept 登録用部署情報
	 * @throws SystemException
	 */
	public void insert(Department dept) throws SystemException {

		try (Connection con = ConnectionManager.getConnection()) {

			//部署用DAOの登録処理呼び出し
			DepartmentDao deptDao = new DepartmentDao(con);
			int result = deptDao.insert(dept);

			//登録に失敗した場合
			if (result == 0) {
				throw new SystemException(Constants.REGIST_FAILURE);
			}

		} catch (SQLException e) {
			throw new SystemException("");
		}
	}
}
