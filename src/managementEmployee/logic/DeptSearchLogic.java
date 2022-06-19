package managementEmployee.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import managementEmployee.dao.ConnectionManager;
import managementEmployee.dao.DepartmentDao;
import managementEmployee.entity.EmpEntity;
import managementEmployee.exception.EmpBusinessException;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;

/**
 * 部署検索用業務ロジック
 */
public class DeptSearchLogic {

	/**
	 * 部署IDによる全社員検索ロジック
	 * @param deptId 部署ID
	 * @return 社員リスト
	 * @throws EmpBusinessException
	 * @throws SystemException
	 */
	public ArrayList<EmpEntity> findAllEmpById(int deptId) throws EmpBusinessException, SystemException {

		ArrayList<EmpEntity> empEntityList = new ArrayList<>();

		try (Connection con = ConnectionManager.getConnection()) {

			//部署用DAOの部署IDによる全社員検索処理呼び出し
			DepartmentDao deptDao = new DepartmentDao(con);
			empEntityList = deptDao.findAllEmpById(deptId);

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
