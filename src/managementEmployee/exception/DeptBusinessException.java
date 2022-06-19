package managementEmployee.exception;

/** 部署用業務エラー */
public class DeptBusinessException extends Exception {

	/**
	 * エラーメッセージの格納
	 *
	 * @param msg エラーメッセージ
	 */
	public DeptBusinessException(String msg) {
		super(msg);
	}

}
