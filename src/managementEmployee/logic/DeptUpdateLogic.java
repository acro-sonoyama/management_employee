package managementEmployee.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import managementEmployee.bean.Department;
import managementEmployee.dao.ConnectionManager;
import managementEmployee.dao.DepartmentDao;
import managementEmployee.entity.DeptEntity;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;

/**
 * 部署更新用業務ロジック
 */
public class DeptUpdateLogic {

	public DeptEntity findById(int deptId) throws SystemException {

		DeptEntity deptEntity = null;

		try (Connection con = ConnectionManager.getConnection()) {

			DepartmentDao deptDao = new DepartmentDao(con);
			deptEntity = deptDao.findById(deptId);

		} catch (SQLException e) {
			throw new SystemException();
		}

		return deptEntity;
	}


	public ArrayList<DeptEntity> findAll() throws SystemException {

		ArrayList<DeptEntity> deptEntityList = new ArrayList<>();

		try (Connection con = ConnectionManager.getConnection()) {

			DepartmentDao deptDao = new DepartmentDao(con);
			deptEntityList = deptDao.findAll();

		} catch (SQLException e) {
			throw new SystemException("");
		}

		return deptEntityList;
	}


	public void update(Department dept) throws SystemException {

		try (Connection con = ConnectionManager.getConnection()) {

			DepartmentDao deptDao = new DepartmentDao(con);
			int result = deptDao.update(dept);

			if (result == 0) {
				throw new SystemException(Constants.UPDATE_FAILURE);
			}

		} catch (SQLException e) {
			throw new SystemException();
		}
	}

}
