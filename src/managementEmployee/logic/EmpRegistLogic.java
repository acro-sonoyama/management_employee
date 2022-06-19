package managementEmployee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import managementEmployee.bean.Employee;
import managementEmployee.dao.ConnectionManager;
import managementEmployee.dao.EmployeeDao;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;

/**
 * 社員登録用業務ロジック
 */
public class EmpRegistLogic {

	/**
	 * 社員登録ロジック
	 * @param emp 登録用社員情報
	 * @throws SystemException
	 */
	public void insert(Employee emp) throws SystemException {
		try (Connection con = ConnectionManager.getConnection()) {

			//社員用DAOの登録処理呼び出し
			EmployeeDao empDao = new EmployeeDao(con);
			int result = empDao.insert(emp);

			//登録に失敗した場合
			if (result == 0) {
				throw new SystemException(Constants.REGIST_FAILURE);
			}

		} catch (SQLException e) {
			throw new SystemException();
		}
	}
}
