package managementEmployee.action;

import javax.servlet.http.HttpServletRequest;

import managementEmployee.exception.SystemException;

/**
 * Actionクラスのインタフェース
 */
public interface ActionIF {

	/**
	 * executeメソッド(doGet、doPostのかわり)
	 *
	 * @param req リクエスト
	 * @return path 遷移先のパス
	 * @throws SystemException システムエラー
	 */
	String execute(HttpServletRequest req) throws SystemException;

}
