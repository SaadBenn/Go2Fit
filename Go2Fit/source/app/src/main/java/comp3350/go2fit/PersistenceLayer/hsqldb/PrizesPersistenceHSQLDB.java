package comp3350.go2fit.PersistenceLayer.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import comp3350.go2fit.Models.PrizesModel;
import comp3350.go2fit.PersistenceLayer.PrizesPersistence;

public class PrizesPersistenceHSQLDB implements PrizesPersistence {
    private String dbPath;
    //private final Connection c;
    private Integer nextId;


    public PrizesPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    } // close PrizesPersistenceHSQLDB

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private PrizesModel fromResultSet(final ResultSet rs) throws SQLException {
        return new PrizesModel();
    } // close fromResultSet


    @Override
    public boolean addPrize(PrizesModel model) {
        boolean result;

        int image = model.getImage();
        String description = model.getDescription();
        int pointsRequired = model.getPointsRequired();
        model.setId(nextId);
        int id = model.getId();

        try(final Connection c = connection()) {
            String cmdString = "INSERT INTO Prizes VALUES(?, ?, ?, ?)";
            final PreparedStatement st = c.prepareStatement(cmdString);

            st.setInt(1, id);
            st.setInt(2, image);
            st.setString(3, description);
            st.setInt(4, pointsRequired);

            st.executeUpdate();
            result = true;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
        nextId++;
        return result;
    } // close addPrize


    @Override
    public PrizesModel getGoal(int userId) {
        PrizesModel model = null;

        try(final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM Prizes WHERE Id= ?");
            st.setInt(1, userId);

            final ResultSet rs = st.executeQuery();

            while(rs.next()) {
                model = fromResultSet(rs);

                final int image = rs.getInt("image");
                final String description = rs.getString("description");
                final int pointsRequired = rs.getInt("points");
                final int time = rs.getInt("time");
                final int points = rs.getInt("points");
                final int id = rs.getInt("id");

                model.setImage(image);
                model.setDescription(description);
                model.setPointsRequired(pointsRequired);
                model.setId(id);
                //model.setId(userId);
            }
            rs.close();
            st.close();

            return model;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    } // close getGoal


    @Override
    public HashMap<Integer, PrizesModel> getAllPrizes() {
        HashMap<Integer, PrizesModel> map = new HashMap<>();
        PrizesModel model = null;

        try(final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM Prizes");

            while (rs.next()) {
                model = fromResultSet(rs);

                final int image = rs.getInt("image");
                final String description = rs.getString("description");
                final int pointsRequired = rs.getInt("points");
                final int time = rs.getInt("time");
                final int id = rs.getInt("id");

                model.setImage(image);
                model.setDescription(description);
                model.setPointsRequired(pointsRequired);
                model.setId(id);

                map.put(model.getId(), model);

            } // while

            rs.close();
            st.close();

            return map;

        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    } // close getAllPrizes
}