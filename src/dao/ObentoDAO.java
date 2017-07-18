package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Obento;

public class ObentoDAO {
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
	 * obentoテーブルからすべてのお弁当データを検索
	 */
	public List<Obento> selectAllObento(){
		// ▼▼List（大きさが決まっていない配列のようなもの）、メッセージ格納用変数 準備
		List<Obento> list = new ArrayList<Obento>();

		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM obento;";
			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持

			// sql文を実行
			rs = stmt.executeQuery();

			while (rs.next()) {
				Obento ob = new Obento();
				// 1件分のデータをBeanに格納し、それをListに入れてjspに渡す
				// (Listには1週間分のデータが入っている)
				// DBから取得したデータをObentoオブジェクトに格納
				ob.setBento_id(rs.getString("bento_id"));
				ob.setBento_name(rs.getString("bento_name"));
				ob.setImage(rs.getString("image"));
				list.add(ob);
			}
		} catch (Exception e) {
			Obento ob = new Obento();
			ob = null;
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

	/**
	 * obentoテーブルからbento_idでお弁当の詳細情報を取得
	 */
	public List<Obento> selectObentoDetail(String bento_id){
		// スケジュール情報を格納
		// ▼▼List（大きさが決まっていない配列のようなもの）、メッセージ格納用変数 準備
		List<Obento> list = new ArrayList<Obento>();

		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM obento WHERE bento_id = ?;";
			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持

			// ユーザの入力値を代入
			stmt.setString(1, bento_id);

			// sql文を実行
			rs = stmt.executeQuery();

			while (rs.next()) {
				Obento ob = new Obento();
				// 1件分のデータをBeanに格納し、それをListに入れてjspに渡す
				// DBから取得したデータをObentoオブジェクトに格納
				ob.setBento_id(rs.getString("bento_id"));
				ob.setBento_name(rs.getString("bento_name"));
				ob.setImage(rs.getString("image"));
				list.add(ob);
			}
		} catch (Exception e) {
			Obento ob = new Obento();
			ob = null;
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
	/**
	 * obentoテーブルから現在の票数を検索
	 */

	public String getObentoVotes(String bento_id){
		String votes = "";

		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT votes FROM obento WHERE bento_id = ?;";
			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持

			// ユーザの入力値を代入
			stmt.setString(1, bento_id);

			// sql文を実行
			rs = stmt.executeQuery();

			while (rs.next()) {
				votes = rs.getString("votes");
			}
		} catch (Exception e) {
			votes = null;
			System.out.println("getObentoVotes:null");
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		// 全員分のデータが入ったlistをサーブレットに渡す
		return votes;
	}


	/**
	 * obentoテーブルから票数1票追加
	 */
	public void updateObentoVotes(String bento_id, int new_vote) {
		try {
			// DB接続
			connection();
			// INSERT文の設定・実行
			// INパラメータ(プレースホルダー)の使用例。サニタイジングのために使おう！

			String sql = "UPDATE obento SET votes = ? WHERE bento_id = ? ";

			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持
			stmt.setInt(1, new_vote);
			stmt.setString(2, bento_id);

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

	/**
	 * obentoテーブルからすべてのお弁当データを検索
	 */
	public List<Obento> getObentoRanking(){
		// スケジュール情報を格納
		// ▼▼List（大きさが決まっていない配列のようなもの）、メッセージ格納用変数 準備
		List<Obento> list = new ArrayList<Obento>();

		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM obento ORDER BY votes DESC;";
			stmt = con.prepareStatement(sql); // sql文をプリコンパイルした状態で保持

			// sql文を実行
			rs = stmt.executeQuery();

			while (rs.next()) {
				Obento ob = new Obento();
				// 1件分のデータをBeanに格納し、それをListに入れてjspに渡す
				// DBから取得したデータをObentoオブジェクトに格納
				ob.setBento_id(rs.getString("bento_id"));
				ob.setBento_name(rs.getString("bento_name"));
				ob.setImage(rs.getString("image"));
				list.add(ob);
			}
		} catch (Exception e) {
			Obento ob = new Obento();
			ob = null;
			System.out.println("muri");
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}
		return list;
	}
}
