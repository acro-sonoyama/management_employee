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
 * 社員一覧用業務ロジック
 */
public class EmpListLogic {

	/**
	 * 社員一覧ロジック
	 * @return 社員リスト
	 * @throws EmpBusinessException
	 * @throws SystemException
	 */
	public ArrayList<EmpEntity> findAll() throws EmpBusinessException, SystemException {

		ArrayList<EmpEntity> empEntityList = new ArrayList<>();

		try (Connection con = ConnectionManager.getConnection()) {

			//社員用DAOの全社員検索処理呼び出し
			EmployeeDao empDao = new EmployeeDao(con);
			empEntityList = empDao.findAll();

			//社員が存在しない場合
			if (empEntityList.isEmpty()) {
				throw new EmpBusinessException(Constants.EMP_NOT_FOUND);
			}

		} catch (SQLException e) {
			throw new SystemException();
		}

		return empEntityList;
	}
}
