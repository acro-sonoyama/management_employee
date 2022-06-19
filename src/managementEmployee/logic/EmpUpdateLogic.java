package managementEmployee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import managementEmployee.bean.Employee;
import managementEmployee.dao.ConnectionManager;
import managementEmployee.dao.EmployeeDao;
import managementEmployee.entity.EmpEntity;
import managementEmployee.exception.SystemException;
import managementEmployee.util.Constants;

/**
 * 社員変更用業務ロジック
 */
public class EmpUpdateLogic {

	public EmpEntity findById(int deptId) throws SystemException {

		EmpEntity empEntity = null;

		try (Connection con = ConnectionManager.getConnection()) {

			EmployeeDao empDao = new EmployeeDao(con);
			empEntity = empDao.findById(deptId);


		} catch (SQLException e) {
			throw new SystemException();
		}

		return empEntity;
	}


	public void update(Employee emp) throws SystemException {
		try (Connection con = ConnectionManager.getConnection()) {

			EmployeeDao empDao = new EmployeeDao(con);
			int result = empDao.update(emp);

			if (result == 0) {
				throw new SystemException(Constants.UPDATE_FAILURE);
			}

		} catch (SQLException e) {
			throw new SystemException();
		}
	}
}
