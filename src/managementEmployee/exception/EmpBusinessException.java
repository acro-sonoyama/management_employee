package managementEmployee.exception;

/** 社員用業務エラー */
public class EmpBusinessException extends Exception {

	/**
	 * エラーメッセージの格納
	 *
	 * @param msg エラーメッセージ
	 */
	public EmpBusinessException(String msg) {
		super(msg);
	}

}
