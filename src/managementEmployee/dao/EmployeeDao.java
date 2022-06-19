package managementEmployee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import managementEmployee.bean.Employee;
import managementEmployee.entity.DeptEntity;
import managementEmployee.entity.EmpEntity;

/**
 * 社員用DAO
 */
public class EmployeeDao {
	/** 接続情報 */
	private Connection con = null;

	/**
	 * コンストラクタ
	 *
	 * @param con 接続情報
	 */
	public EmployeeDao(Connection con) {
		super();
		this.con = con;
	}

	/**
	 * 社員IDとパスワードによる1件検索（ログイン処理）
	 *
	 * @param empId 社員ID
	 * @param empPass パスワード
	 * @return 社員Entity
	 * @throws SQLException
	 */
	public EmpEntity findByIdPass(String empId, String empPass) throws SQLException {
		String sql = "SELECT emp_id, emp_name, authority FROM employee WHERE emp_id = ? AND emp_pass = ?";
		ResultSet rs = null;
		EmpEntity emp = null;

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, empId);
			ps.setString(2, empPass);
			rs = ps.executeQuery();

			if (rs.next()) {
				emp = new EmpEntity(rs.getInt("emp_id"), rs.getString("emp_name"), rs.getInt("authority"));
			}
		}

		return emp;
	}

	/**
	 * 社員ID検索（社員変更、削除時に使用）
	 *
	 * @param empId 社員ID
	 * @return 社員Entity
	 * @throws SQLException
	 */
	public EmpEntity findById(int empId) throws SQLException {
		String sql = "SELECT emp_id, emp_pass, emp_name, gender, address, DATE_FORMAT(birthday, '%Y/%m/%d') AS birthday, "
				+ "authority, d.dept_id, dept_name "
				+ "FROM employee e RIGHT OUTER JOIN department d ON e.dept_id = d.dept_id "
				+ "WHERE emp_id = ?";
		ResultSet rs = null;
		EmpEntity emp = null;

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, empId);
			rs = ps.executeQuery();

			if (rs.next()) {
				DeptEntity dept = new DeptEntity(rs.getInt("dept_id"), rs.getString("dept_name"));
				emp = new EmpEntity(rs.getInt("emp_id"), rs.getString("emp_pass"), rs.getString("emp_name"),
						rs.getInt("gender"), rs.getString("address"), rs.getString("birthday"),
						rs.getInt("authority"), dept);
			}
		}

		return emp;
	}

	/**
	 * 社員一覧検索
	 *
	 * @return 社員リスト
	 * @throws SQLException
	 */
	public ArrayList<EmpEntity> findAll() throws SQLException {
		String sql = "SELECT emp_id, emp_name, gender, address, DATE_FORMAT(birthday, '%Y/%m/%d') AS birthday, "
				+ "authority, dept_name "
				+ "FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id";
		ResultSet rs = null;
		ArrayList<EmpEntity> empList = new ArrayList<>();

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			rs = ps.executeQuery();

			while (rs.next()) {
				DeptEntity dept = new DeptEntity(rs.getString("dept_name"));
				EmpEntity emp = new EmpEntity(rs.getInt("emp_id"), rs.getString("emp_name"), rs.getInt("gender"),
						rs.getString("address"), rs.getString("birthday"),
						rs.getInt("authority"), dept);
				empList.add(emp);
			}
		}

		return empList;
	}

	/**
	 * 社員名検索
	 *
	 * @param empName 社員名
	 * @return 社員リスト
	 * @throws SQLException
	 */
	public ArrayList<EmpEntity> findByName(String empName) throws SQLException {
		String sql = "SELECT emp_id, emp_name, gender, address, DATE_FORMAT(birthday, '%Y/%m/%d') AS birthday, "
				+ "authority, dept_name "
				+ "FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id "
				+ "WHERE emp_name LIKE ? ORDER BY emp_id";
		ResultSet rs = null;
		ArrayList<EmpEntity> empList = new ArrayList<>();

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, "%" + empName + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				DeptEntity dept = new DeptEntity(rs.getString("dept_name"));
				EmpEntity emp = new EmpEntity(rs.getInt("emp_id"), rs.getString("emp_name"), rs.getInt("gender"),
						rs.getString("address"), rs.getString("birthday"),
						rs.getInt("authority"), dept);
				empList.add(emp);
			}
		}

		return empList;
	}

	/**
	 * 社員登録
	 *
	 * @param emp 社員情報
	 * @throws SQLException
	 */
	public int insert(Employee emp) throws SQLException {
		String sql = "INSERT INTO employee VALUES (emp_id, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, emp.getEmpPass());
			ps.setString(2, emp.getEmpName());
			ps.setInt(3, emp.getGender());
			ps.setString(4, emp.getAddress());
			ps.setString(5, emp.getBirthday());
			ps.setInt(6, emp.getAuthority());
			ps.setInt(7, emp.getDepartment().getDeptId());

			result = ps.executeUpdate();
		}

		return result;
	}

	/**
	 * 社員変更
	 *
	 * @param emp 社員情報
	 * @throws SQLException
	 */
	public int update(Employee emp) throws SQLException {
		String sql = "UPDATE employee SET emp_pass = ?, emp_name = ?, gender = ?, address = ?, birthday = ?, "
				+ "authority = ?, dept_id = ? "
				+ "WHERE emp_id = ?";
		int result = 0;

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, emp.getEmpPass());
			ps.setString(2, emp.getEmpName());
			ps.setInt(3, emp.getGender());
			ps.setString(4, emp.getAddress());
			ps.setString(5, emp.getBirthday());
			ps.setInt(6, emp.getAuthority());
			ps.setInt(7, emp.getDepartment().getDeptId());
			ps.setInt(8, emp.getEmpId());

			result = ps.executeUpdate();
		}

		return result;
	}

	/**
	 * 社員削除
	 *
	 * @param empId 社員ID
	 * @throws SQLException
	 */
	public int delete(int empId) throws SQLException {
		String sql = "DELETE FROM employee WHERE emp_id = ?";
		int result = 0;

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, empId);
			result = ps.executeUpdate();
		}

		return result;
	}

}
