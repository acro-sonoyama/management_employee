package managementEmployee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import managementEmployee.bean.Department;
import managementEmployee.entity.DeptEntity;
import managementEmployee.entity.EmpEntity;

/**
 * 部署用DAO
 */
public class DepartmentDao {
	/** 接続情報 */
	private Connection con = null;

	/**
	 * コンストラクタ
	 *
	 * @param con 接続情報
	 */
	public DepartmentDao(Connection con) {
		super();
		this.con = con;
	}


	/**
	 * 部署IDによる1件検索
	 *
	 * @param deptId 部署ID
	 * @return 部署Entity
	 * @throws SQLException
	 */
	public DeptEntity findById(int deptId) throws SQLException {
		String sql = "SELECT dept_id, dept_name FROM department WHERE dept_id = ?";
		ResultSet rs = null;
		DeptEntity deptEntity = null;

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, deptId);
			rs = ps.executeQuery();

			if (rs.next()) {
				deptEntity = new DeptEntity(rs.getInt("dept_id"), rs.getString("dept_name"));
			}
		}

		return deptEntity;
	}


	/**
	 * 部署全件検索
	 *
	 * @return 部署リスト
	 * @throws SQLException
	 */
	public ArrayList<DeptEntity> findAll() throws SQLException {
		String sql = "SELECT dept_id, dept_name FROM department ORDER BY dept_id";
		ResultSet rs = null;
		ArrayList<DeptEntity> deptEntityList = new ArrayList<>();

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			rs = ps.executeQuery();

			while (rs.next()) {
				DeptEntity dept = new DeptEntity(rs.getInt("dept_id"), rs.getString("dept_name"));
				deptEntityList.add(dept);
			}
		}

		return deptEntityList;
	}


	/**
	 * 部署IDによる社員全件検索
	 *
	 * @param deptId 部署ID
	 * @return 社員リスト
	 * @throws SQLException
	 */
	public ArrayList<EmpEntity> findAllEmpById(int deptId) throws SQLException {
		String sql = "SELECT emp_id, emp_name, gender, address, DATE_FORMAT(birthday, '%Y/%m/%d') AS birthday, "
				+ "authority, dept_name "
				+ "FROM employee e INNER JOIN department d ON e.dept_id = d.dept_id "
				+ "WHERE d.dept_id = ? ORDER BY emp_id";
		ResultSet rs = null;
		ArrayList<EmpEntity> empEntityList = new ArrayList<>();

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, deptId);
			rs = ps.executeQuery();

			while (rs.next()) {
				DeptEntity dept = new DeptEntity(rs.getString("dept_name"));
				EmpEntity emp = new EmpEntity(rs.getInt("emp_id"), rs.getString("emp_name"), rs.getInt("gender"),
						rs.getString("address"), rs.getString("birthday"),
						rs.getInt("authority"), dept);
				empEntityList.add(emp);
			}
		}

		return empEntityList;
	}


	/**
	 * 部署登録
	 *
	 * @param dept 部署情報
	 * @return result 登録結果
	 * @throws SQLException
	 */
	public int insert(Department dept) throws SQLException {
		String sql = "INSERT INTO department VALUES (dept_id, ?)";
		int result = 0;

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1,dept.getDeptName());
			result = ps.executeUpdate();
		}

		return result;
	}


	/**
	 * 部署変更
	 *
	 * @param dept 部署情報
	 * @return result 変更結果
	 * @throws SQLException
	 */
	public int update(Department dept) throws SQLException {
		String sql = "UPDATE department SET dept_name = ? WHERE dept_id = ?";
		int result = 0;

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1,dept.getDeptName());
			ps.setInt(2,dept.getDeptId());
			result = ps.executeUpdate();
		}

		return result;
	}


	/**
	 * 部署削除
	 *
	 * @param deptId 部署ID
	 * @return result 削除結果
	 * @throws SQLException
	 */
	public int delete(int deptId) throws SQLException {
		String sql = "DELETE FROM department WHERE dept_id = ?";
		int result = 0;

		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1,deptId);
			result = ps.executeUpdate();
		}

		return result;
	}

}
