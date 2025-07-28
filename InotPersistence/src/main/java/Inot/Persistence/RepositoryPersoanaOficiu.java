package Inot.Persistence;


import Inot.Model.PersoanaOficiu;
import Inot.Persistence.Interfaces.IRepoPersoanaOficiu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Component
public class RepositoryPersoanaOficiu implements IRepoPersoanaOficiu {
    private final DbUtils dbUtils;
    private static final Logger logger = LogManager.getLogger();

    public RepositoryPersoanaOficiu(Properties props) {
        logger.info("Initializing RepositoryPersoanaOficiu with properties: {}", props);
        dbUtils = new DbUtils(props);
    }

    @Override
    public PersoanaOficiu findByUsername(String username) {
        logger.trace("Find persoana by username {}", username);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM persoaneoficiu WHERE username = ?")) {
            preStmt.setString(1, username);
            ResultSet rs=preStmt.executeQuery();
            while(rs.next()) {
                PersoanaOficiu persoanaOficiu = new PersoanaOficiu(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("location")
                );
                persoanaOficiu.setId(Long.valueOf(rs.getLong("id")));
                logger.info("Found {} PersoanaOficiu by Username", persoanaOficiu);
                return persoanaOficiu;
            }
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findByUsername PersoanaOficiu:"+e);
        }
        logger.traceExit();
        return null;
    }

    @Override
    public Iterable<PersoanaOficiu> findByLocation(String location) {
        logger.trace("Find persoana by location {}", location);
        List<PersoanaOficiu> persoaneOficiu = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM persoaneoficiu WHERE location = ?")) {
            preStmt.setString(1, location);
            ResultSet rs=preStmt.executeQuery();
            while(rs.next()) {
                PersoanaOficiu persoanaOficiu = new PersoanaOficiu(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("location")
                );
                persoanaOficiu.setId(Long.valueOf(rs.getLong("id")));
                persoaneOficiu.add(persoanaOficiu);
            }
            logger.info("Found all {} PersoanaOficiu by Location", Optional.of(persoaneOficiu.size()));
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findByLocation PersoanaOficiu:"+e);
        }
        logger.traceExit();
        return persoaneOficiu;
    }

    @Override
    public PersoanaOficiu findOne(Long aLong) {
        logger.traceEntry(String.valueOf(aLong));
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM persoaneoficiu WHERE id = ?")) {
            preStmt.setLong(1, aLong);
            ResultSet rs=preStmt.executeQuery();
            PersoanaOficiu persoanaOficiu = new PersoanaOficiu(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("location")
            );
            persoanaOficiu.setId(Long.valueOf(rs.getLong("id")));
            logger.info("Found {} proba by ID", aLong);
            return persoanaOficiu;
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findOne PersoanaOficiu:"+e);
        }
        logger.traceExit();
        return null;
    }

    @Override
    public Iterable<PersoanaOficiu> findAll() {
        logger.traceEntry();
        List<PersoanaOficiu> persoaneOficiu = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM persoaneoficiu")) {
            ResultSet rs=preStmt.executeQuery();
            while(rs.next()) {
                PersoanaOficiu persoanaOficiu = new PersoanaOficiu(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("location")
                );
                persoanaOficiu.setId(Long.valueOf(rs.getLong("id")));
                persoaneOficiu.add(persoanaOficiu);
            }
            logger.info("Found all {} PersoanaOficiu", Optional.of(persoaneOficiu.size()));
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findAll PersoanaOficiu:"+e);
        }
        logger.traceExit();
        return persoaneOficiu;
    }

    @Override
    public void save(PersoanaOficiu entity) {
        logger.traceEntry("saving PersoanaOficiu {}", entity);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("INSERT INTO persoaneoficiu (username, password, location) VALUES (?,?,?) RETURNING id")) {
            preStmt.setString(1, entity.getUsername());
            preStmt.setString(2, entity.getPassword());
            preStmt.setString(3, entity.getLocation());
            ResultSet result = preStmt.executeQuery();
            if(result.next()) {
                entity.setId(Long.valueOf(result.getLong("id")));
            }
            logger.trace("Saved {} PersoanaOficiu", result);
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Eroare la save PersoanaOficiu:"+e);
        }
        logger.traceExit();
    }

    @Override
    public PersoanaOficiu delete(PersoanaOficiu entity) {
        logger.traceEntry("deleting PersoanaOficiu {}", entity);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("DELETE FROM persoaneoficiu WHERE id = ?")) {
            preStmt.setLong(1, entity.getId());
            int result=preStmt.executeUpdate();
            logger.trace("Deleted {} PersoanaOficiu", Optional.of(result));
            return entity;
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Eroare la delete PersoanaOficiu:"+e);
        }
        logger.traceExit();
        return null;
    }

    @Override
    public PersoanaOficiu update(PersoanaOficiu entity) {
        logger.traceEntry("updating Proba {}", entity);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("UPDATE persoaneoficiu SET username = ?, password = ?, location = ? WHERE id = ?")) {
            preStmt.setString(1, entity.getUsername());
            preStmt.setString(2, entity.getPassword());
            preStmt.setString(3, entity.getLocation());
            preStmt.setLong(4, entity.getId());
            int result=preStmt.executeUpdate();
            logger.trace("Updated {} proba", Optional.of(result));
            return entity;
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Eroare la update Proba:"+e);
        }
        logger.traceExit();
        return null;
    }
}
