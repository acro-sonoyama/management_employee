package managementEmployee.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import managementEmployee.dao.ConnectionManager;
import managementEmployee.dao.DepartmentDao;
import managementEmployee.entity.DeptEntity;
import managementEmployee.exception.DeptBusinessException;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;

/**
 * 部署一覧用業務ロジック
 */
public class DeptListLogic {

	/**
	 * 部署一覧ロジック
	 * @return 部署リスト
	 * @throws DeptBusinessException
	 * @throws SystemException
	 */
	public ArrayList<DeptEntity> findAll() throws DeptBusinessException, SystemException {

		ArrayList<DeptEntity> deptEntityList = new ArrayList<>();

		try (Connection con = ConnectionManager.getConnection()) {

			//部署用DAOの全部署検索処理呼び出し
			DepartmentDao deptDao = new DepartmentDao(con);
			deptEntityList = deptDao.findAll();

			//部署が存在しない場合
			if (deptEntityList.isEmpty()) {
				throw new DeptBusinessException(Constants.DEPT_NOT_FOUND);
			}

		} catch (SQLException e) {
			throw new SystemException("");
		}

		return deptEntityList;
	}
}
