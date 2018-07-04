package comp3350.go2fit.PersistenceLayer.hsqldb;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.PersistenceLayer.ChallengePersistence;

public class ChallengePersistenceHSQLDB implements ChallengePersistence {

    private final Connection c;
    private Integer nextId = 0;

    public ChallengePersistenceHSQLDB(final String dbPath) {
        try {
            this.c = DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath, "SA", "");
        } catch (final SQLException e) {
            Log.e("Connect SQL", e.getMessage() + e.getSQLState());
            throw new PersistenceException(e);
        }
    } // close ChallengePersistenceHSQLDB


    @Override
    public boolean add(final ChallengesModel progress) {
        boolean result = false;
        String cName = progress.getChallengeName();
        String cType = progress.getChallengeType();
        int steps = progress.getStepsRequired();
        long time = progress.getTime();
        int points = progress.getPoints();
        progress.setId(nextId);
        int id = 0;

        try {
            String cmdString = "INSERT INTO Challenges VALUES(?, ?, ?, ?, ?, ?)";
            final PreparedStatement st = c.prepareStatement(cmdString);

            final PreparedStatement maxId = c.prepareStatement("SELECT TOP 1 Id FROM Challenges ORDER BY Id DESC");

            final ResultSet rs = maxId.executeQuery();
            while (rs.next()) {
                id = rs.getInt("Id");
            }

            st.setInt(1, id+1);
            st.setString(2, cName);
            st.setString(3, cType);
            st.setInt(4, steps);
            st.setLong(5, time);
            st.setInt(6, points);

            st.executeUpdate();
            result = true;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        nextId++;
        return result;
    } // close add


    private ChallengesModel fromResultSet(final ResultSet rs) throws SQLException {
        final int id = rs.getInt("Id");
        final String challengeName = rs.getString("CName");
        final String challengeType = rs.getString("CType");
        final int stepsRequired = rs.getInt("steps");
        final long time = rs.getLong("time");
        final int points = rs.getInt("points");
        ChallengesModel challengesModel = new ChallengesModel(challengeName, challengeType, stepsRequired, time, points);
        challengesModel.setId(id);
        return challengesModel;
    } // close fromResultSet


    @Override
    public ChallengesModel getChallenge(int userId) {
        ChallengesModel challenge = null;

        try {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM Challenges WHERE Id= ?");
            st.setInt(1, userId);

            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                challenge = fromResultSet(rs);
                challenge.setId(userId);
            }
            rs.close();
            st.close();

            return challenge;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    } // close getChallenge


    @Override
    public LinkedHashMap<Integer, ChallengesModel> getAllChallenges() {
        final LinkedHashMap<Integer, ChallengesModel> challenges_List = new LinkedHashMap<>();

        try {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM Challenges");

            while (rs.next()) {
                final ChallengesModel challenge = fromResultSet(rs);
                //++nextId;
                //challenge.setId(nextId);

                challenges_List.put(challenge.getId(), challenge);
            } // while
            rs.close();
            st.close();

            return challenges_List;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    } // close getAllChallenges

} // close class

