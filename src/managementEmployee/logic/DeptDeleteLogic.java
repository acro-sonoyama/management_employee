package managementEmployee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import managementEmployee.dao.ConnectionManager;
import managementEmployee.dao.DepartmentDao;
import managementEmployee.entity.DeptEntity;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;

/**
 * 部署削除用業務ロジック
 */
public class DeptDeleteLogic {

	/**
	 * 部署IDによる部署検索ロジック
	 * @param deptId 部署ID
	 * @return 部署Entity
	 * @throws SystemException
	 */
	public DeptEntity findById(int deptId) throws SystemException {

		DeptEntity deptEntity = null;

		try (Connection con = ConnectionManager.getConnection()) {

			//部署用DAOの部署IDによる部署検索処理呼び出し
			DepartmentDao deptDao = new DepartmentDao(con);
			deptEntity = deptDao.findById(deptId);

		} catch (SQLException e) {
			throw new SystemException();
		}

		return deptEntity;
	}


	/**
	 * 部署削除ロジック
	 * @param deptId 部署ID
	 * @throws SystemException
	 */
	public void delete(int deptId) throws SystemException {

		try (Connection con = ConnectionManager.getConnection()) {

			//部署用DAOの削除処理呼び出し
			DepartmentDao deptDao = new DepartmentDao(con);
			int result = deptDao.delete(deptId);

			//削除に失敗した場合
			if (result == 0) {
				throw new SystemException(Constants.DELETE_FAILURE);
			}

		} catch (SQLException e) {
			throw new SystemException();
		}
	}

}
