package comp3350.go2fit.PersistenceLayer.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

import comp3350.go2fit.Models.AchieveModel;
import comp3350.go2fit.PersistenceLayer.AchievePersistence;

public class AchievePersistenceHSQLDB implements AchievePersistence {

    private String dbPath;
    //private final Connection c;
    private Integer nextId = 0;

    public AchievePersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    } // AchievePersistenceHSQLDB

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private AchieveModel fromResultSet(final ResultSet rs) throws SQLException {
        final String achieveName = rs.getString("achieveName");
        final String achieveType = rs.getString("achieveType");
        final int stepsRequired = rs.getInt("stepsRequired");
        final long time = rs.getLong("time");
        final int calories = rs.getInt("calories");

        return new AchieveModel(achieveName, achieveType, stepsRequired, time);
        } // close fromResultSet


    @Override
    public boolean add(final AchieveModel model) {
        boolean result;

        String achieveName = model.getAchieveName();
        String achieveType = model.getAchieveType();
        long   time = model.getTime();
        int    stepsRequired = model.getStepsRequired();
        int    calories = model.getCalories();
        model.setId(nextId);
        int    id = model.getId();

        try(final Connection c = connection()) {
            String cmdString = "INSERT INTO Achievements VALUES(?, ?, ?, ?, ?, ?)";
            final PreparedStatement st = c.prepareStatement(cmdString);

            st.setInt(1, id);
            st.setString(2, achieveName);
            st.setString(3, achieveType);
            st.setLong(4, time);
            st.setInt(5, stepsRequired);
            st.setInt(6, calories);

            st.executeUpdate();
            result = true;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        nextId++;
        return result;
    } // add

    @Override
    public AchieveModel getAchieve(int userId) {
        AchieveModel model = null;
        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM Achievements WHERE Id= ?");
            st.setInt(1, userId);

            final ResultSet rs = st.executeQuery();

            while(rs.next()) {
                model = fromResultSet(rs);
                model.setId(userId);
            }
            rs.close();
            st.close();

            return model;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }


    @Override
    public LinkedHashMap<Integer, AchieveModel> getAllAchieve() {
        final LinkedHashMap<Integer, AchieveModel> achievementList = new LinkedHashMap<>();

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM Achievements");
            while (rs.next()) {
                final AchieveModel model = fromResultSet(rs);
                //++nextId;
                //model.setId(nextId);

                achievementList.put(model.getId(), model);
            } // while
            rs.close();
            st.close();

            return achievementList;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    } // close getAllAchieve
}