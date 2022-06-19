package managementEmployee.util;

/**
 * 定数をまとめたクラス
 */
public class Constants {

	/** インスタンス化を禁止 */
	private Constants() {}

	/** 一般社員の権限を表す */
	public static final int EMPLOYEE = 1;

	/** 管理者の権限を表す */
	public static final int MANAGER = 2;

	/** 男性を表す */
	public static final int MAN = 1;

	/** 女性を表す */
	public static final int WOMAN = 2;

	/** 最小部署ID */
	public static final int MIN_DEPT_ID = 1;

	/** 最大部署ID */
	public static final int MAX_DEPT_ID = 3;

	/** 社員ID、またはパスワードが間違っていた場合のエラーメッセージ */
	public static final String EMPID_OR_PASSWORD_MISMATCH = "社員ID、またはパスワードが間違っています。";

	/** 社員IDの桁数が5桁を超えた場合のチェックエラーメッセージ */
	public static final String EMPID_LENGTH_OVER = "社員IDは99999までの整数値で入力してください。";

	/** 社員IDが整数値以外で入力された場合のエラーメッセージ */
	public static final String EMPID_MISSMATCH = "社員IDは整数値で入力してください。";

	/** 社員IDが未入力のエラーメッセージ */
	public static final String EMPID_EMPTY = "社員IDを入力してください。";

	/** パスワードが未入力のエラーメッセージ */
	public static final String PASSWORD_EMPTY = "パスワードを入力してください。";

	/** パスワードの入力文字が15文字を超えた場合のエラーメッセージ */
	public static final String PASSWORD_LENGTH_OVER = "パスワードは16文字以内で入力してください。";

	/** 名前が未入力のエラーメッセージ */
	public static final String NAME_EMPTY = "社員名を入力してください。";

	/** 名前の入力文字が30文字を超えた場合のエラーメッセージ */
	public static final String NAME_LENGTH_OVER = "社員名は30文字以内で入力してください。";

	/** 住所が未入力のエラーメッセージ */
	public static final String ADDRESS_EMPTY = "住所を入力してください。";

	/** 住所の入力文字が60文字を超えた場合のエラーメッセージ */
	public static final String ADDRESS_LENGTH_OVER = "住所は60文字以内で入力してください。";

	/** 生年月日が未入力のエラーメッセージ */
	public static final String BIRTHDAY_EMPTY = "生年月日を入力してください。";

	/** 生年月日の値が予期しない値時のエラーメッセージ */
	public static final String BIRTHDAY_MISSMATCH = "正しい日付を入力してください。";

	/** 一般権限で管理者しかアクセスできないページに飛ぼうとした時のエラーメッセージ */
	public static final String AUTHORITY_MISSMATCH = "管理者権限ではありませんので、ログインしなおしてください。";

	/** 部署名が未入力のエラーメッセージ */
	public static final String DEPTNAME_EMPTY = "部署名を入力してください。";

	/** 部署名の入力文字が15文字を超えた場合のエラーメッセージ */
	public static final String DEPTNAME_LENGTH_OVER = "部署名は16文字以内で入力してください。";

	/** 検索で社員が見つからなかった場合のエラーメッセージ */
	public static final String EMP_NOT_FOUND = "該当する社員が見つかりませんでした。";

	/** 検索で部署が見つからなかった場合のエラーメッセージ */
	public static final String DEPT_NOT_FOUND = "該当する部署が見つかりませんでした。";

	/** 登録に失敗した場合のエラーメッセージ */
	public static final String REGIST_FAILURE = "登録に失敗しました。";

	/** 変更に失敗した場合のエラーメッセージ */
	public static final String UPDATE_FAILURE = "変更に失敗しました。";

	/** 削除に失敗した場合のエラーメッセージ */
	public static final String DELETE_FAILURE = "削除に失敗しました。";
}