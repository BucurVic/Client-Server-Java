package Inot.Client.gui;

import Inot.Model.Inscriere;
import Inot.Model.PersoanaOficiu;
import Inot.Model.Proba;
import Inot.Services.IInotObserver;
import Inot.Services.IInotServices;
import Inot.Services.InotException;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javafx.scene.control.TableColumn;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class MainController implements Initializable, IInotObserver {
    @FXML
    private TableView<Proba> ProbeTableView;
    @FXML
    private TableColumn<Proba, String> DistantaTableColumn;
    @FXML
    private TableColumn<Proba, String> StilTableColumn;
    @FXML
    private TableColumn<Proba, Integer> NrParticipantiTableColumn;

    @FXML
    private TableView<Inscriere> ParticipantiTableView;
    @FXML
    private TableColumn<Inscriere, String> NumeTableColumn;
    @FXML
    private TableColumn<Inscriere, String> VarstaTableColumn;
    @FXML
    private TableColumn<Inscriere, Long> NrProbeTableColumn;

    @FXML
    private TextField searchDistantaProba;
    @FXML
    private TextField searchStilProba;
    @FXML
    private TextField InscriereNumeParticipantField;
    @FXML
    private TextField InscriereVarstaParticipantField;



    private ObservableList<Proba> probeList = FXCollections.observableArrayList();
    private ObservableList<Inscriere> inscriereList = FXCollections.observableArrayList();
    private IInotServices server;
//    private MainService mainService;
    private PersoanaOficiu persoanaLogata;
    private Stage stage;

    public void setServer(IInotServices server) {this.server = server;}

    public void setPersoanaLogata(PersoanaOficiu persoanaLogata, Stage stage) {
        this.persoanaLogata = persoanaLogata;
        this.stage = stage;
        initModel();
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        DistantaTableColumn.setCellValueFactory(new PropertyValueFactory<>("distanta"));
        StilTableColumn.setCellValueFactory(new PropertyValueFactory<>("stil"));
        NrParticipantiTableColumn.setCellValueFactory(new PropertyValueFactory<>("nrParticipantiInscrisi"));

        searchDistantaProba.textProperty().addListener(o->handleSearch());
        searchStilProba.textProperty().addListener(o->handleSearch());

        ProbeTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ProbeTableView.setItems(probeList);
        ParticipantiTableView.setItems(inscriereList);

        NumeTableColumn.setCellValueFactory(new PropertyValueFactory<>("numeParticipant"));
        VarstaTableColumn.setCellValueFactory(new PropertyValueFactory<>("varstaParticipant"));
    }

    private void initModel(){
        Proba[] probe;
        try{
            probe = server.findAllProba();
        }catch (InotException e){
            throw new RuntimeException(e);
        }
        Inscriere[] inscrieri;
        try{
            inscrieri = server.findAllInscriere();
        }catch (InotException e){
            throw new RuntimeException(e);
        }
        List<Proba> pList = Arrays.stream(probe).collect(Collectors.toList());
        List<Inscriere> iList = Arrays.stream(inscrieri).toList();

        Map<String, Set<Long>> mapNrProbe = iList.stream()
                .collect(Collectors.groupingBy(
                        i -> i.getNumeParticipant() + "#" + i.getVarstaParticipant(),
                        Collectors.mapping(Inscriere::getIdProba, Collectors.toSet())
                ));

        Map<String, Inscriere> inscriereUnicaMap = new HashMap<>();
        for (Inscriere inscriere : iList) {
            String key = inscriere.getNumeParticipant() + "#" + inscriere.getVarstaParticipant();
            if (!inscriereUnicaMap.containsKey(key)) {
                inscriereUnicaMap.put(key, inscriere);
            }
        }
        List<Inscriere> listaFinala = new ArrayList<>(inscriereUnicaMap.values());

        NrProbeTableColumn.setCellValueFactory(cellData->{
            Inscriere inscriere1 = cellData.getValue();
            String cheie = inscriere1.getNumeParticipant() + "#" + inscriere1.getVarstaParticipant();
            Long nrProbe = (long) mapNrProbe.getOrDefault(cheie, Set.of()).size();
            return new ReadOnlyObjectWrapper<>(nrProbe);
        });

        probeList.setAll(pList);
        inscriereList.setAll(listaFinala);
    }

    public void handleSearch() {
        if (!searchDistantaProba.getText().isEmpty() && !searchStilProba.getText().isEmpty()) {
            Proba[] probaIterable;
            try{
                probaIterable = server.findAllProba();
            }catch (InotException e){
                throw new RuntimeException(e);
            }
            Inscriere[] inscriereIterable;
            try{
                inscriereIterable = server.findAllInscriere();
            }catch (InotException e){
                throw new RuntimeException(e);
            }

            List<Proba> probas = Arrays.stream(probaIterable)
                    .filter(x-> x.getDistanta().equals(searchDistantaProba.getText()))
                    .filter(x-> x.getStil().equals(searchStilProba.getText()))
                    .toList();

            Set<Long> idsFiltrate = probas.stream().map(Proba::getId).collect(Collectors.toSet());

            List<Inscriere> inscrieres = Arrays.stream(inscriereIterable)
                    .filter(x-> idsFiltrate.contains(x.getIdProba()))
                    .collect(Collectors.toList());
            inscriereList.setAll(inscrieres);
        }
//        else if (!searchDistantaProba.getText().isEmpty()) {
//            List<Proba> probas = StreamSupport.stream(probaIterable.spliterator(), false)
//                    .filter(x-> x.getDistanta().equals(searchDistantaProba.getText()))
//                    .collect(Collectors.toList());
//            probeList.setAll(probas);
//        }
//        else if (!searchStilProba.getText().isEmpty()) {
//            List<Proba> probas = StreamSupport.stream(probaIterable.spliterator(), false)
//                    .filter(x-> x.getStil().equals(searchStilProba.getText()))
//                    .collect(Collectors.toList());
//            probeList.setAll(probas);
//        }
        else{
           initModel();
        }
    }

    public void handleInscriere() throws InotException {
        String numeParticipant = InscriereNumeParticipantField.getText();
        int varstaParticipant = Integer.parseInt(InscriereVarstaParticipantField.getText());
        ObservableList<Proba> ProbaObservableList = ProbeTableView.getSelectionModel().getSelectedItems();
        for (Proba proba : ProbaObservableList) {
            Inscriere inscriere = new Inscriere(proba.getId(), numeParticipant, varstaParticipant);
            server.addInscriere(inscriere);
        }
        if (!ProbaObservableList.isEmpty()) {
            MessageAlert.showMessage(null, Alert.AlertType.CONFIRMATION, "Inscriere", "Inscriere cu numele: " + numeParticipant + " si varsta: " + varstaParticipant + " realizata cu succes!");
            initModel();
        }
        else{
            MessageAlert.showErrorMessage(null, "Nicio Proba Selectata!");
        }
    }

    public void handleLogout() throws InotException {
        server.logout(persoanaLogata, this);
        stage.close();
    }

    @Override
    public void inscriereAdded(Inscriere inscriere) {
        Platform.runLater(()->{
            System.out.println("Inscriere added: " + inscriere);
            initModel();
        });
    }
}
