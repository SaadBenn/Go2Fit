package comp3350.go2fit.PersistenceLayer.hsqldb;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ArrayList;
import com.google.gson.*;
import java.util.List;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.PersistenceLayer.UserPersistence;

public class UserPersistenceHSQLDB implements UserPersistence {

	private final Connection c;
	private Integer nextId = 0;

	public UserPersistenceHSQLDB(final String dbPath) {
		try {
			System.out.println(dbPath);
			this.c = DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath, "SA", "");
		} catch (final SQLException e) {
			throw new PersistenceException(e);
		}
	} // close UserPersistenceHSQLDB


	private UserModel fromResultSet(final ResultSet rs) throws SQLException {
		return new UserModel();

	} // close fromResultSet


	@Override
	public boolean add(UserModel user) {
		boolean result;
		int id = 0;
		int totalPoints = user.getTotalPoints();
		double totalDistance = user.getTotalDistance();
		int currentChallengeId = user.getCurrentChallenge();
		boolean challengeStarted = user.getChallengeStarted();
		int challengesCompleted = user.getChallengesCompleted();
		String name = user.getName();
		String pass = user.getPassword();
		int nextAchievement = 0;
		String listAchievements = "";

		try {
			final PreparedStatement maxId = c.prepareStatement("SELECT TOP 1 Id FROM USERMODEL ORDER BY Id DESC");

			final ResultSet rs = maxId.executeQuery();
			while (rs.next()) {
				id = rs.getInt("Id");
			}

			String cmdString = "INSERT INTO USERMODEL VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			final PreparedStatement st = c.prepareStatement(cmdString);
			st.setInt(1, id+1);
			st.setInt(2, totalPoints);
			st.setDouble(3, totalDistance);
			st.setInt(4, currentChallengeId);

			if(challengeStarted) {
				st.setInt(5, 1);
			}
			else
			{
				st.setInt(5, 0);

			}
			st.setInt(6, challengesCompleted);
			st.setString(7, name);
			st.setString(8, pass);
			st.setInt(9, nextAchievement);
			st.setString(10, listAchievements);

			st.executeUpdate();
			result = true;

		} catch (final SQLException e) {
			throw new PersistenceException(e);
		}
		nextId++;
		return result;
	} // close add


	@Override
	public UserModel getUser(int userId) {

		UserModel user = null;

		try {
			final PreparedStatement st = c.prepareStatement("SELECT * FROM USERMODEL WHERE id= ?");
			st.setInt(1, userId);

			final ResultSet rs = st.executeQuery();
			while (rs.next()) {
				user = fromResultSet(rs);

				int id = rs.getInt("id");
				int totalPoints = rs.getInt("totalPoints");
				int totalDistance = rs.getInt("totalDistance");
				int currentChallengeId = rs.getInt("currentChallengeId");
				int challengesCompleted = rs.getInt("challengesCompleted");
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				int nextAchieve = rs.getInt("nextAchieve");
				String achieveList = rs.getString("achieveList");

				ArrayList list = new ArrayList();
				if(achieveList != null && achieveList != "") {
					String[] tokens = achieveList.split(",");
					for (String token : tokens) {
						token = token.replace("\"", "");
						token = token.replace("[", "");
						token = token.replace("]", "");
						if(token != "") {
							list.add(token);
						}
						System.out.println("[" + token + "]");
					}
				}
				boolean challengeStarted = false;
				if(rs.getInt("challengeStarted") == 1)
				{
					challengeStarted = true;
				}
				user.setId(id);
				user.setTotalPoints(totalPoints);
				user.setTotalDistance(totalDistance);
				user.setCurrentChallenge(currentChallengeId);
				user.setChallengeStarted(challengeStarted);
				user.setName(name);
				user.setPassword(pass);
				user.setAchievements(list);
			}
			rs.close();
			st.close();

			return user;

		} catch (final SQLException e) {
			throw new PersistenceException(e);
		}

	} // close getUser


	@Override
	public HashMap<Integer, UserModel> getAllUsers() {
		final HashMap<Integer, UserModel> users = new HashMap<>();

		try {
			final Statement st = c.createStatement();
			final ResultSet rs = st.executeQuery("SELECT * FROM USERMODEL");

			while (rs.next()) {
				final UserModel user = fromResultSet(rs);
				int id = rs.getInt("id");
				int totalPoints = rs.getInt("totalPoints");
				int totalDistance = rs.getInt("totalDistance");
				int currentChallengeId = rs.getInt("currentChallengeId");
				int challengesCompleted = rs.getInt("challengesCompleted");
				boolean challengeStarted = false;
				if(rs.getInt("challengeStarted") == 1)
				{
					challengeStarted = true;
				}

				String name = rs.getString("name");
				String pass = rs.getString("pass");

				user.setId(id);
				user.setTotalPoints(totalPoints);
				user.setTotalDistance(totalDistance);
				user.setCurrentChallenge(currentChallengeId);
				user.setChallengeStarted(challengeStarted);
				user.setName(name);
				user.setPassword(pass);

				users.put(user.getId(), user);
			} // while

			rs.close();
			st.close();

			return users;

		} catch (final SQLException e) {
			throw new PersistenceException(e);
		}
	} // close getAllUsers

	@Override
	public boolean update(UserModel user) {
		boolean result;

		int id = user.getId();
		int totalPoints = user.getTotalPoints();
		double totalDistance = user.getTotalDistance();
		int currentChallengeId = user.getCurrentChallenge();
		boolean challengeStarted = user.getChallengeStarted();
		int challengesCompleted = user.getChallengesCompleted();
		String name = user.getName();
		String pass = user.getPassword();
		ArrayList list = user.getAchievements();
		String json = new Gson().toJson(list);

		try {	
			final PreparedStatement st = c.prepareStatement("UPDATE USERMODEL SET totalPoints = ?, totalDistance = ?, currentChallengeId = ?, challengeStarted = ?, challengesCompleted = ?, name = ?, pass = ?, nextAchieve = ?, achieveList = ? WHERE id = ?");
			st.setInt(10, id);
			st.setInt(1, totalPoints);
			st.setDouble(2, totalDistance);
			st.setInt(3, currentChallengeId);
			if(challengeStarted) {
				st.setInt(4, 1);
			}
			else
			{
				st.setInt(4, 0);

			}
			st.setInt(5, challengesCompleted);
			st.setString(6, name);
			st.setString(7, pass);
			st.setInt(8, 1);
			st.setString(9, json);

			st.executeUpdate();

			result = true;

		} catch (final SQLException e) {
			throw new PersistenceException(e);
		}

		return result;
	} // close update

} // close UserPersistenceHSQLDB
