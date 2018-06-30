package comp3350.go2fit.PersistenceLayer.hsqldb;

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
        int Id = progress.getId();

        try {
            String cmdString = "INSERT INTO Challenges_TBL VALUES(?, ?, ?, ?, ?, ?)";
            final PreparedStatement st = c.prepareStatement(cmdString);

            st.setInt(1, Id);
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
        final String challengeName = rs.getString("CName");
        final String challengeType = rs.getString("CType");
        final int stepsRequired = rs.getInt("steps");
        final long time = rs.getLong("time");
        final int points = rs.getInt("points");
        return new ChallengesModel(challengeName, challengeType, stepsRequired, time, points);
    } // close fromResultSet


    @Override
    public ChallengesModel getChallenge(int userId) {
        final ChallengesModel challenge;

        try {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM Challenges_TBL WHERE Id= ?");
            st.setInt(1, userId);

            final ResultSet rs = st.executeQuery();
            challenge = fromResultSet(rs);
            challenge.setId(userId);

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
            final ResultSet rs = st.executeQuery("SELECT * FROM Challenges_TBL");
            while (rs.next()) {
                final ChallengesModel challenge = fromResultSet(rs);
                //++nextId;
                challenge.setId(nextId);

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

