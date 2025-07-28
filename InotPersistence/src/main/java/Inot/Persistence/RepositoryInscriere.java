package Inot.Persistence;

import Inot.Model.Inscriere;
import Inot.Persistence.Interfaces.IRepoInscriere;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class RepositoryInscriere implements IRepoInscriere {
    private DbUtils dbUtils;
    private static final Logger logger = LogManager.getLogger();

    public RepositoryInscriere(Properties props) {
        logger.info("Initializing RepositoryInscriere with properties: {}", props);
        dbUtils = new DbUtils(props);
    }

    @Override
    public Iterable<Inscriere> findBetweenAge(int ageMin, int ageMax) {
        logger.traceEntry();
        List<Inscriere> inscrieri = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM inscireri WHERE varsta_participant >= ? AND varsta_participant <= ?")) {
            preStmt.setInt(1, ageMin);
            preStmt.setInt(2, ageMax);
            ResultSet rs=preStmt.executeQuery();
            while(rs.next()) {
                Inscriere inscriere = new Inscriere(
                        rs.getLong("id_proba"),
                        rs.getString("nume_participant"),
                        rs.getInt("varsta_participant")
                );
                inscriere.setId(Long.valueOf(rs.getLong("id")));
                inscrieri.add(inscriere);
            }
            logger.info("Found all {} Inscrieri between ages", Optional.of(inscrieri.size()));
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findBetweenAge Inscriere:"+e);
        }
        logger.traceExit();
        return inscrieri;
    }

    @Override
    public Long findByNumeParticipant(String numeParticipant) {
        logger.traceEntry();
        List<Inscriere> inscrieri = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM inscireri WHERE nume_participant = ?")) {
            preStmt.setString(1, numeParticipant);
            ResultSet rs=preStmt.executeQuery();
            while(rs.next()) {
                Inscriere inscriere = new Inscriere(
                        rs.getLong("id_proba"),
                        rs.getString("nume_participant"),
                        rs.getInt("varsta_participant")
                );
                inscriere.setId(Long.valueOf(rs.getLong("id")));
                inscrieri.add(inscriere);
            }
            logger.info("Found all {} Inscrieri by name participant", Optional.of(inscrieri.size()));
            return Long.valueOf(inscrieri.size());
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findByNumeParticipant Inscriere:"+e);
        }
        logger.traceExit();
        return null;
    }

    @Override
    public Iterable<Inscriere> findByAge(int age) {
        logger.traceEntry();
        List<Inscriere> inscrieri = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM inscireri WHERE varsta_participant = ?")) {
            preStmt.setInt(1, age);
            ResultSet rs=preStmt.executeQuery();
            while(rs.next()) {
                Inscriere inscriere = new Inscriere(
                        rs.getLong("id_proba"),
                        rs.getString("nume_participant"),
                        rs.getInt("varsta_participant")
                );
                inscriere.setId(Long.valueOf(rs.getLong("id")));
                inscrieri.add(inscriere);
            }
            logger.info("Found all {} Inscrieri by age", Optional.of(inscrieri.size()));
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findByAge Inscriere:"+e);
        }
        logger.traceExit();
        return inscrieri;
    }

    @Override
    public Inscriere findOne(Long aLong) {
        logger.traceEntry(String.valueOf(aLong));
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM inscrieri WHERE id = ?")) {
            preStmt.setLong(1, aLong);
            ResultSet rs=preStmt.executeQuery();
            Inscriere inscriere = new Inscriere(
                    rs.getLong("id_proba"),
                    rs.getString("nume_participant"),
                    rs.getInt("varsta_participant")
            );
            inscriere.setId(Long.valueOf(rs.getLong("id")));
            logger.info("Found {} Inscriere by ID", aLong);
            return inscriere;
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findOne Inscriere:"+e);
        }
        logger.traceExit();
        return null;
    }

    @Override
    public Iterable<Inscriere> findAll() {
        logger.traceEntry();
        List<Inscriere> inscrieri = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM inscrieri")) {
            ResultSet rs=preStmt.executeQuery();
            while(rs.next()) {
                Inscriere inscriere = new Inscriere(
                        rs.getLong("id_proba"),
                        rs.getString("nume_participant"),
                        rs.getInt("varsta_participant")
                );
                inscriere.setId(Long.valueOf(rs.getLong("id")));
                inscrieri.add(inscriere);
            }
            logger.info("Found all {} Inscrieri", Optional.of(inscrieri.size()));
        }catch(SQLException e) {
            logger.error(e);
            System.out.println("Eroare la findAll Inscriere:"+e);
        }
        logger.traceExit();
        return inscrieri;
    }

    @Override
    public void save(Inscriere entity) {
        logger.traceEntry("saving Inscriere {}", entity);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("INSERT INTO inscrieri (id_proba, nume_participant, varsta_participant) VALUES (?,?,?) RETURNING id")) {
            preStmt.setLong(1, entity.getIdProba());
            preStmt.setString(2, entity.getNumeParticipant());
            preStmt.setInt(3, entity.getVarstaParticipant());
            ResultSet result = preStmt.executeQuery();
            if(result.next()) {
                entity.setId(Long.valueOf(result.getLong("id")));
            }
            logger.trace("Saved {} Inscriere", result);
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Eroare la save Inscriere:"+e);
        }
        logger.traceExit();
    }

    @Override
    public Inscriere delete(Inscriere entity) {
        logger.traceEntry("deleting Inscriere {}", entity);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("DELETE FROM inscrieri WHERE id = ?")) {
            preStmt.setLong(1, entity.getId());
            int result=preStmt.executeUpdate();
            logger.trace("Deleted {} Inscriere", Optional.of(result));
            return entity;
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Eroare la delete Inscriere:"+e);
        }
        logger.traceExit();
        return null;
    }

    @Override
    public Inscriere update(Inscriere entity) {
        logger.traceEntry("updating Inscriere {}", entity);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preStmt = con.prepareStatement("UPDATE inscrieri SET id_proba = ?, nume_participant = ?, varsta_participant = ? WHERE id = ?")) {
            preStmt.setLong(1, entity.getIdProba());
            preStmt.setString(2, entity.getNumeParticipant());
            preStmt.setInt(3, entity.getVarstaParticipant());
            preStmt.setLong(4, entity.getId());
            int result=preStmt.executeUpdate();
            logger.trace("Updated {} Inscriere", Optional.of(result));
            return entity;
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Eroare la update Inscriere:"+e);
        }
        logger.traceExit();
        return null;
    }
}
