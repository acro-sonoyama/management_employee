package managementEmployee.entity;

/**
 * 部署Entity
 */
public class DeptEntity {

	/** 部署ID */
	private int deptId;
	/** 部署名 */
	private String deptName;


	/**
	 * コンストラクタ（引数なし）
	 */
	public DeptEntity() {}

	/**
	 * コンストラクタ
	 * @param deptName 部署名
	 */
	public DeptEntity(String deptName) {
		super();
		this.deptName = deptName;
	}

	/**
	 * コンストラクタ
	 * @param deptId 部署ID
	 * @param deptName 部署名
	 */
	public DeptEntity(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
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
	 * 部署名の取得
	 * @return deptName 部署名
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * 部署名の設定
	 * @param deptName 部署名
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
