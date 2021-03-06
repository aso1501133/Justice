package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Votes;

public class VotesDAO {
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
	 * votesテーブルにコメント等を格納
	 */
	public void insertComment(String bento_id,String user_id,String comment){
		try {
			// DB接続
			connection();
			// INSERT文の設定・実行
			// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！

			String sql = "INSERT INTO `votes` VALUES (?,?,?);";

			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持
			stmt.setString(1, bento_id);
			stmt.setString(2, user_id);
			stmt.setString(3, comment);
			int cnt = stmt.executeUpdate();

			// コミット
			con.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * votesテーブルから結果発表用にコメント等を取得
	 */
	public List<Votes> selectRankDetail(String bento_id){
		// スケジュール情報を格納
		// ▼▼List（大きさが決まっていない配列のようなもの）、メッセージ格納用変数 準備
		List<Votes> list = new ArrayList<Votes>();

		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM votes WHERE bento_id = ?;";
			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持

			// ユーザの入力値を代入
			stmt.setString(1, bento_id);

			// sql文を実行
			rs = stmt.executeQuery();

			while (rs.next()) {
				Votes vo = new Votes ();
				// 1件分のデータをBeanに格納し、それをListに入れてjspに渡す
				// DBから取得したデータをObentoオブジェクトに格納
				vo.setBento_id(rs.getString("bento_id"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setComment(rs.getString("comment"));
				list.add(vo);
			}
		} catch (Exception e) {
			Votes vo = new Votes();
			vo = null;
			System.out.println("muri");
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		// 全員分のデータが入ったlistをサーブレットに渡す
		return list;
	}


}
