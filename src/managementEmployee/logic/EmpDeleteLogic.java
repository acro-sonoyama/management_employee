package managementEmployee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import managementEmployee.dao.ConnectionManager;
import managementEmployee.dao.EmployeeDao;
import managementEmployee.entity.EmpEntity;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;

/**
 * 社員削除用業務ロジック
 */
public class EmpDeleteLogic {

	/**
	 * 部署IDによる社員検索ロジック
	 * @param deptId 部署ID
	 * @return 社員Entity
	 * @throws SystemException
	 */
	public EmpEntity findById(int deptId) throws SystemException {

		EmpEntity empEntity = null;

		try (Connection con = ConnectionManager.getConnection()) {

			//社員用DAOの部署IDによる社員検索処理呼び出し
			EmployeeDao empDao = new EmployeeDao(con);
			empEntity = empDao.findById(deptId);

		} catch (SQLException e) {
			throw new SystemException();
		}

		return empEntity;
	}


	/**
	 * 社員削除ロジック
	 * @param deptId
	 * @throws SystemException
	 */
	public void delete(int deptId) throws SystemException {

		try (Connection con = ConnectionManager.getConnection()) {

			//社員用DAOの削除処理呼び出し
			EmployeeDao empDao = new EmployeeDao(con);
			int result = empDao.delete(deptId);

			//削除に失敗した場合
			if (result == 0) {
				throw new SystemException(Constants.DELETE_FAILURE);
			}

		} catch (SQLException e) {
			throw new SystemException();
		}
	}
}
