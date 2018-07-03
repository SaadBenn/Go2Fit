package comp3350.go2fit.PersistenceLayer.hsqldb;

import android.support.annotation.NonNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistence;

public class TrackProgressPersistenceHSQLDB implements TrackProgressPersistence {

    private final Connection c;
    private Integer nextId = 0;

    public TrackProgressPersistenceHSQLDB(final String dbPath) {
        try {
            this.c = DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath, "SA", "");
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    } // close SetGoalPersistenceHSQLDB


    @NonNull
    private TrackProgressModel fromResultSet(final ResultSet rs) {
        return new TrackProgressModel();
    } // close fromResultSet


    @Override
    public boolean add(TrackProgressModel userProgress) {
        boolean result = false;

        userProgress.setId(nextId);
        double distance = userProgress.getDistance();
        double calories = userProgress.getCalories();
        int numSteps = userProgress.getNumSteps();
        int percentageComplete = userProgress.getPercentageComplete();

        try {
            String cmdString = "INSERT INTO TrackProgress VALUES(?, ?, ?, ?, ?)";
            final PreparedStatement st = c.prepareStatement(cmdString);

            st.setInt(1, nextId);
            st.setDouble(2, distance);
            st.setDouble(3, calories);
            st.setInt(4, numSteps);
            st.setInt(5, percentageComplete);

            st.executeUpdate();
            result = true;

        } catch(final SQLException e) {
            throw new PersistenceException(e);
        }
        nextId++;
        return result;

    } // close add


    @Override
    public boolean update(TrackProgressModel userProgress) {
        boolean result = false;
        int id = userProgress.getId();
        double distance = userProgress.getDistance();
        double calories = userProgress.getCalories();
        int numSteps = userProgress.getNumSteps();
        int percentageComplete = userProgress.getPercentageComplete();

        try {
            final PreparedStatement st = c.prepareStatement("UPDATE TrackProgress SET distance= ?, calories= ?, numSteps = ?, percentageComplete = ? WHERE id = ?");
            st.setInt(5, id);
            st.setDouble(1, distance);
            st.setDouble(2, calories);
            st.setInt(3, numSteps);
            st.setInt(4, percentageComplete);

            st.executeUpdate();

            result = true;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }

        return result;
    } // close update


    @Override
    public TrackProgressModel getProgress(int userId) {
        TrackProgressModel trackProgress = null;

        try {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM TrackProgress WHERE Id=?");
            st.setInt(1, userId);

            final ResultSet rs = st.executeQuery();

            while(rs.next()) {
                trackProgress = fromResultSet(rs);

                double distance = rs.getDouble("distance");
                Integer calories = rs.getInt("calories");
                int numSteps = rs.getInt("numSteps");
                int percentageComplete = rs.getInt("percentageComplete");

                trackProgress.setId(userId);
                trackProgress.setDistance(distance);
                trackProgress.setCalories(calories);
                trackProgress.setNumSteps(numSteps);
                trackProgress.setPercentageComplete(percentageComplete);
            }
            rs.close();
            st.close();

            return trackProgress;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    } // close getProgress

} // close class