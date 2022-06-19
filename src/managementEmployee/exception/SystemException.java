package managementEmployee.exception;

/** システムエラー */
public class SystemException extends Exception {

	/**
	 * コンストラクタ
	 */
	public SystemException() { }


	/**
	 * エラーメッセージの格納
	 *
	 * @param msg エラーメッセージ
	 */
	public SystemException(String msg) {
		super(msg);
	}


}
