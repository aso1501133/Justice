package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

	public ArrayList<Votes> getRanking() {
		ArrayList<Votes> historyList = new ArrayList<Votes>();
		try {
			connection();

			String sql = "SELECT * FROM votes ORDER BY votes";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Votes votes = new Votes();
				votes.setBento_id(rs.getString("bento_id"));
				votes.setComment(rs.getString("comment"));
				votes.setVotes(rs.getString("votes"));

				historyList.add(votes);
			}
		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {
			}
		}


		return historyList;

	}

}
