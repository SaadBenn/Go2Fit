package comp3350.go2fit.PersistenceLayer.hsqldb;

import android.support.annotation.NonNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import comp3350.go2fit.Models.SetGoalModel;
import comp3350.go2fit.PersistenceLayer.SetGoalPersistence;

public class SetGoalPersistenceHSQLDB implements SetGoalPersistence {

	private final Connection c;
	private Integer nextId = 1;

	public SetGoalPersistenceHSQLDB(final String dbPath) {
		try {
			this.c = DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath, "SA", "");
		} catch (final SQLException e) {
			throw new PersistenceException(e);
		}
	} // close SetGoalPersistenceHSQLDB


	@NonNull
	private SetGoalModel fromResultSet(final ResultSet rs) throws SQLException {
		final String mode = rs.getString("mode");
		final Integer steps = rs.getInt("steps");
		final String time = rs.getString("time");
		final String period = rs.getString("period");

		return new SetGoalModel(mode, steps, time, period);
	} // close fromResultSet


	@Override
	public boolean addGoal(SetGoalModel model) {
		boolean result = false;

		String mode = model.getMode();
		Integer steps = model.getSteps();
		String time = model.getTime();
		String period = model.getPeriod();
		model.setId(nextId);

		try {
			String cmdString = "INSERT INTO Goals VALUES(?, ?, ?, ?, ?)";
			final PreparedStatement st = c.prepareStatement(cmdString);
			
			st.setInt(1, nextId);
			st.setString(2, mode);
			st.setInt(3, steps);
			st.setString(4, time);
			st.setString(5, period);

			st.executeUpdate();
			result = true;

		} catch (final SQLException e) {
			throw new PersistenceException(e);
		}
		
		nextId++;
		return result;
	} // close addGoal


	@Override
	public SetGoalModel getGoal(int id) {
		SetGoalModel setGoal;

		try {
			final PreparedStatement st = c.prepareStatement("SELECT * FROM Goals WHERE Id=?");
			st.setInt(1, id);

			final ResultSet rs = st.executeQuery();

			setGoal = fromResultSet(rs);
			setGoal.setId(id);

			rs.close();
			st.close();

			return setGoal;

		} catch (final SQLException e) {
			throw new PersistenceException(e);
		}
	} // close getGoal

} // close SetGoalPersistenceHSQLDB