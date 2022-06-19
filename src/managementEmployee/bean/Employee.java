package managementEmployee.bean;

import java.io.Serializable;

import managementEmployee.entity.EmpEntity;

/**
 * 社員Bean
 */
public class Employee implements Serializable {

	/** 社員ID */
	private int empId;
	/** 社員パスワード */
	private String empPass;
	/** 社員名 */
	private String empName;
	/** 性別 */
	private int gender;
	/** 住所 */
	private String address;
	/** 生年月日 */
	private String birthday;
	/** 権限 */
	private int authority;
	/** 部署ID */
	private int deptId;
	/** 部署 */
	private Department department;


	/**
	 * コンストラクタ（引数なし）
	 */
	public Employee() { }

	/**
	 * コンストラクタ
	 * @param empId 社員ID
	 * @param empPass 社員パスワード
	 * @param empName 社員名
	 * @param gender 性別
	 * @param address 住所
	 * @param birthday 生年月日
	 * @param authority 権限
	 * @param deptId 部署ID
	 */
	public Employee(int empId, String empPass, String empName, int gender, String address, String birthday,
			int authority, int deptId) {
		super();
		this.empId = empId;
		this.empPass = empPass;
		this.empName = empName;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.authority = authority;
		this.deptId = deptId;
	}

	/**
	 * コンストラクタ
	 * @param empId 社員ID
	 * @param empPass 社員パスワード
	 * @param empName 社員名
	 * @param gender 性別
	 * @param address 住所
	 * @param birthday 生年月日
	 * @param authority 権限
	 * @param department 部署
	 */
	public Employee(int empId, String empPass, String empName, int gender, String address, String birthday,
			int authority, Department department) {
		super();
		this.empId = empId;
		this.empPass = empPass;
		this.empName = empName;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.authority = authority;
		this.department = department;
	}

	/**
	 * 社員IDの取得
	 * @return empId 社員ID
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * 社員IDの設定
	 * @param empId 社員ID
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * 社員パスワードの取得
	 * @return empPass 社員パスワード
	 */
	public String getEmpPass() {
		return empPass;
	}

	/**
	 * 社員パスワードの設定
	 * @param empPass 社員パスワード
	 */
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	/**
	 * 社員名の取得
	 * @return empName 社員名
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * 社員名の設定
	 * @param empName 社員名
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * 性別の取得
	 * @return gender 性別
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * 性別の設定
	 * @param gender 性別
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * 住所の取得
	 * @return address 住所
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 住所の設定
	 * @param address 住所
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 生年月日の取得
	 * @return birthday 生年月日
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * 生年月日の設定
	 * @param birthday 生年月日
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 権限の取得
	 * @return authority 権限
	 */
	public int getAuthority() {
		return authority;
	}

	/**
	 * 権限の設定
	 * @param authority 権限
	 */
	public void setAuthority(int authority) {
		this.authority = authority;
	}

	/**
	 * 部署IDの取得
	 * @return deptId 部署ID
	 */
	public int getDeptId() {
		return deptId;
	}

	/**
	 * 部署IDの設定
	 * @param deptId 部署ID
	 */
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	/**
	 * 部署情報の取得
	 * @return department 部署
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * 部署情報の設定
	 * @param department 部署
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * EntityをBeanへ詰め替える
	 * @param empEntity 社員エンティティ
	 */
	public Employee(EmpEntity empEntity) {
		empId = empEntity.getEmpId();
		empPass = empEntity.getEmpPass();
		empName = empEntity.getEmpName();
		gender = empEntity.getGender();
		address = empEntity.getAddress();
		birthday = empEntity.getBirthday();
		authority = empEntity.getAuthority();
		department = new Department(empEntity.getDepartment());
	}


	/**
	 * EntityをBeanへ詰め替える
	 * @param empEntity 社員エンティティ
	 */
	public Employee(EmpEntity empEntity, String login) {
		empId = empEntity.getEmpId();
		empName = empEntity.getEmpName();
		authority = empEntity.getAuthority();
	}
}
