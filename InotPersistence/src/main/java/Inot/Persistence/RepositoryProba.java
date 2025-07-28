package Inot.Persistence;

import Inot.Model.Proba;
import Inot.Persistence.Interfaces.IRepoProba;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Repository
public class RepositoryProba implements IRepoProba {
    private DbUtils dbUtils;
    private static final Logger logger = LogManager.getLogger();

    public RepositoryProba(Properties props) {
        logger.info("Initializing RepositoryProba with properties: {}", props);
        dbUtils = new DbUtils(props);
    }

    @Autowired
    public RepositoryProba(
            @Value("${jdbc.driver}") String driver,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.user}") String user,
            @Value("${jdbc.pass}") String pass) {
        Properties props = new Properties();
        props.setProperty("inot.jdbc.driver", driver);
        props.setProperty("inot.jdbc.url", url);
        props.setProperty("inot.jdbc.user", user);
        props.setProperty("inot.jdbc.pass", pass);
//            logger.info("Initializing repository.database.ChallengeDBRepository with properties: {} ", props);
        dbUtils = new DbUtils(props);
    }

    @Override
    public Iterable<Proba> findByNrParticipanti(int nrParticipantiInscrisi) {
        logger.traceEntry(String.valueOf(nrParticipantiInscrisi));
        List<Proba> probe = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM probe WHERE nr_participanti_inscrisi = ?")) {
            preStmt.setInt(1, nrParticipantiInscrisi);
            ResultSet rs=preStmt.executeQuery();
            while(rs.next()) {
                Proba proba = new Proba(
                        rs.getString("distanta"),
                        rs.getString("stil"),
                        rs.getLong("nr_participanti_inscrisi")
                );
                proba.setId(Long.valueOf(rs.getLong("id")));
                probe.add(proba);
            }
            logger.info("Found {} proba by nr. ParticipantiInscrisi {}", Optional.of(probe.size()), Optional.of(nrParticipantiInscrisi));
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findByNrParticipanti Proba:"+e);
        }
        logger.traceExit();
        return probe;
    }

    @Override
    public Iterable<Proba> findByDistanta(String distanta) {
        logger.traceEntry(distanta);
        List<Proba> probe = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM probe WHERE distanta = ?")) {
            preStmt.setString(1, distanta);
            ResultSet rs=preStmt.executeQuery();
            while(rs.next()) {
                Proba proba = new Proba(
                        rs.getString("distanta"),
                        rs.getString("stil"),
                        rs.getLong("nr_participanti_inscrisi")
                );
                proba.setId(Long.valueOf(rs.getLong("id")));
                probe.add(proba);
            }
            logger.info("Found {} probe by distanta {}", Optional.of(probe.size()), distanta);
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findByDistanta Proba:"+e);
        }
        logger.traceExit();
        return probe;
    }

    @Override
    public Proba findOne(Long aLong) {
        logger.traceEntry(String.valueOf(aLong));
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM probe WHERE id = ?")) {
            preStmt.setLong(1, aLong);
            ResultSet rs=preStmt.executeQuery();
            Proba proba = new Proba(
                    rs.getString("distanta"),
                    rs.getString("stil"),
                    rs.getLong("nr_participanti_inscrisi")
            );
            proba.setId(Long.valueOf(rs.getLong("id")));
            logger.info("Found {} proba by ID", aLong);
            return proba;
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findOne Proba:"+e);
        }
        logger.traceExit();
        return null;
    }

    @Override
    public Iterable<Proba> findAll() {
        logger.traceEntry();
        List<Proba> probe = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM probe")) {
            ResultSet rs=preStmt.executeQuery();
            while(rs.next()) {
                Proba proba = new Proba(
                        rs.getString("distanta"),
                        rs.getString("stil"),
                        rs.getLong("nr_participanti_inscrisi")
                );
                proba.setId(Long.valueOf(rs.getLong("id")));
                probe.add(proba);
            }
            logger.info("Found all {} probe", Optional.of(probe.size()));
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findAll Probe:"+e);
        }
        logger.traceExit();
        return probe;
    }

    @Override
    public void save(Proba entity) {
        logger.traceEntry("saving Proba {}", entity);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("INSERT INTO probe (distanta, stil, nr_participanti_inscrisi) VALUES (?,?,?) RETURNING id")) {
            preStmt.setString(1, entity.getDistanta());
            preStmt.setString(2, entity.getStil());
            preStmt.setLong(3, entity.getNrParticipantiInscrisi());
            ResultSet result = preStmt.executeQuery();
            if(result.next()) {
                entity.setId(result.getLong("id"));
            }
            logger.trace("Saved {} proba", result);
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Eroare la save Proba:"+e);
        }
        logger.traceExit();
    }

    @Override
    public Proba delete(Proba entity) {
        logger.traceEntry("deleting Proba {}", entity);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("DELETE FROM probe WHERE id = ?")) {
            preStmt.setLong(1, entity.getId());
            int result=preStmt.executeUpdate();
            logger.trace("Deleted {} Proba", Optional.of(result));
            return entity;
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Eroare la delete Proba:"+e);
        }
        logger.traceExit();
        return null;
    }

    @Override
    public Proba update(Proba entity) {
        logger.traceEntry("updating Proba {}", entity);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("UPDATE probe SET distanta = ?, stil = ?, nr_participanti_inscrisi = ? WHERE id = ?")) {
            preStmt.setString(1, entity.getDistanta());
            preStmt.setString(2, entity.getStil());
            preStmt.setLong(3, entity.getNrParticipantiInscrisi());
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
