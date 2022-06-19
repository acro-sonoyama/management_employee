package managementEmployee.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import managementEmployee.dao.ConnectionManager;
import managementEmployee.dao.EmployeeDao;
import managementEmployee.entity.EmpEntity;
import managementEmployee.exception.EmpBusinessException;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;

/**
 * 社員検索用業務ロジック
 */
public class EmpSearchLogic {

	/**
	 * 社員名による全社員検索ロジック
	 * @param empName 社員名
	 * @return 社員リスト
	 * @throws EmpBusinessException
	 * @throws SystemException
	 */
	public ArrayList<EmpEntity> findByName(String empName) throws EmpBusinessException, SystemException {

		ArrayList<EmpEntity> empEntityList = new ArrayList<>();

		try (Connection con = ConnectionManager.getConnection()) {

			//社員用DAOの社員名による全社員検索処理呼び出し
			EmployeeDao empDao = new EmployeeDao(con);
			empEntityList = empDao.findByName(empName);

			//検索結果がなかった場合
			if (empEntityList.isEmpty()) {
				throw new EmpBusinessException(Constants.EMP_NOT_FOUND);
			}

		} catch (SQLException e) {
			throw new SystemException();
		}

		return empEntityList;
	}
}
