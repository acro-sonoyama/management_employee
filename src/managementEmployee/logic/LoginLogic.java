package managementEmployee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import managementEmployee.dao.ConnectionManager;
import managementEmployee.dao.EmployeeDao;
import managementEmployee.entity.EmpEntity;
import managementEmployee.exception.DeptBusinessException;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;

/**
 * ログイン用業務ロジック
 */
public class LoginLogic {

	/**
	 * 社員IDと社員パスワードに一致する社員情報取得ロジック
	 * @param empId 社員ID
	 * @param empPass 社員パスワード
	 * @return 社員Entity
	 * @throws DeptBusinessException
	 * @throws SystemException
	 */
	public EmpEntity findByIdPass(String empId, String empPass) throws DeptBusinessException, SystemException {

		EmpEntity empEntity = null;

		try (Connection con = ConnectionManager.getConnection()) {

			//社員用DAOのログイン処理呼び出し
			EmployeeDao empDao = new EmployeeDao(con);
			empEntity = empDao.findByIdPass(empId, empPass);

			//検索結果がなかった場合
			if (empEntity == null) {
				throw new DeptBusinessException(Constants.EMPID_OR_PASSWORD_MISMATCH);
			}

		} catch (SQLException e) {
			throw new SystemException();
		}

		return empEntity;
	}
}
