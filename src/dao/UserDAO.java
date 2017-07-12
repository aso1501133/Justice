
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.User;

public class UserDAO {
	// データソース
	DataSource ds = null;
	// データベース接続情報
	Connection con = null;
	// プリコンパイル用のステートメント
	PreparedStatement stmt = null;
	// SELECTの結果を格納するResultSet
	ResultSet rs = null;

	/**
	 * データベースへの接続処理を行うメソッド
	 *
	 * @return コネクション情報
	 */
	public Connection connection() throws Exception {
		// データソースがなければ、context.xmlから読み込んで設定する
		if (ds == null) {
			ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/MySQL");
		}
		con = ds.getConnection();
		return con;
	}

	/**
	 * データベースからの切断処理を行うメソッド
	 */
	public void close() throws Exception {
		// データベース接続されていれば、切断する
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}

	/**
	 * userテーブルからログインするユーザを探す
	 */
	public User selectLoginUser(String user_id, String password) {
		// ログインユーザ情報を格納
		User us = new User();
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM user WHERE user_id = ? AND password = ?;";

			stmt = con.prepareStatement(sql);// sql文をプリコンパイルした状態で保持
			// ユーザの入力値を代入
			stmt.setString(1, user_id);
			stmt.setString(2, password);

			// sql文を実行
			rs = stmt.executeQuery();

			// 1件目のデータにカーソルをあわせる
			// データない場合はcatchに飛ぶ
			rs.next();

			// DBから取得したデータをuserオブジェクトに格納
			us.setUser_id(rs.getString("user_id"));
			us.setPassword(rs.getString("password"));
			us.setName(rs.getString("name"));
			us.setVote(rs.getString("vote"));
		} catch (Exception e) {
			us = null;
			System.out.println("muri");
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		// 全員分のデータが入ったlistをサーブレットに渡す
		return us;
	}

	/**
	 * userテーブルから件数を表示
	 */
	public String CountUser() {
		// 件数を格納
		String cnt_user = "";
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT COUNT(*) as cnt FROM user;";

			stmt = con.prepareStatement(sql);// sql文をプリコンパイルした状態で保持

			// sql文を実行
			rs = stmt.executeQuery();

			// 1件目のデータにカーソルをあわせる
			// データない場合はcatchに飛ぶ
			rs.next();

			cnt_user = rs.getString("cnt");
		} catch (Exception e) {
			cnt_user = null;
			System.out.println("muri");
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		// 全員分のデータが入ったlistをサーブレットに渡す
		return cnt_user;
	}

	/**
	 * userテーブルから既に投票したユーザーの件数を表示
	 */
	public String CountVotedUser() {
		// 件数を格納
		String voted_user = "";
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT COUNT(*) as voted_user FROM user WHERE vote = 1;";

			stmt = con.prepareStatement(sql);// sql文をプリコンパイルした状態で保持

			// sql文を実行
			rs = stmt.executeQuery();

			// 1件目のデータにカーソルをあわせる
			// データない場合はcatchに飛ぶ
			rs.next();

			voted_user = rs.getString("voted_user");
		} catch (Exception e) {
			voted_user = null;
			System.out.println("muri");
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		// 全員分のデータが入ったlistをサーブレットに渡す
		return voted_user;
	}

<<<<<<< HEAD
=======
	/**
	 * Userテーブルを投票済に更新
	 */
	public void UpdateVote(String user_id) {
		try {
			// DB接続
			connection();
			// INSERT文の設定・実行
			// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！

			String sql = "UPDATE user SET vote=1 WHERE user_id = ?";

			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持
			stmt.setString(1, user_id);

			// sql文を実行
			int cnt = stmt.executeUpdate();

			// コミット
			con.commit();

		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
	}
>>>>>>> branch 'master' of https://github.com/aso1501133/Justice.git
}
