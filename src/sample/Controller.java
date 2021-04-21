package sample;

import Model.Auto;
import Model.CrearAuto;
import Model.Estacionamiento;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {
    @FXML
    private ImageView caj0, caj1, caj2, caj3, caj4, caj5, caj6, caj7, caj8, caj9, caj10,
                        caj11, caj12, caj13, caj14, caj15, caj16, caj17, caj18, caj19;
    @FXML
    ImageView imgEntrando, imgSaliendo;

    private ImageView[] cajones = new ImageView[20];
    int[] cajonesEstacionamiento = {0, 0, 0, 0, 0,};

    @Override
    public void update(Observable o, Object arg) {
        if(arg.toString().charAt(0) == 'E'){
            entrando(Integer.valueOf(arg.toString().split("E")[1]));
        }else if(arg.toString().equals("esperandoE") || arg.toString().equals("esperandoS")){
            esperando(arg.toString());
        }else if(arg.toString().equals("pasando") || arg.toString().equals("saliendo")){
            pasandoSaliendo(arg.toString());
        }
        else{
            saliendo(Integer.valueOf(arg.toString().split("S")[1]));
        }

    }

    public void iniciar(){
        config();
        CrearAuto crearAuto = new CrearAuto(this);
        crearAuto.start();
        /*Estacionamiento estacionamiento = new Estacionamiento(cajonesEstacionamiento);
        Semaphore numEspacios = new Semaphore(5);
        Semaphore entrando = new Semaphore(0);
        Semaphore saliendo = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);

        Auto auto;
        int numAutos = 20;
        for(int x=1; x<=numAutos; x++){
            auto = new Auto(estacionamiento, numEspacios, entrando, saliendo, mutex);
            auto.addObserver(this);
            new Thread(auto).start();
            try {
                int num = (int)Math.floor(Math.random()*(5-1+1)+1);
                Thread.sleep(num*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }

    public void config(){
        cajones[0] = caj0;
        cajones[1] = caj1;
        cajones[2] = caj2;
        cajones[3] = caj3;
        cajones[4] = caj4;
        cajones[5] = caj5;
        cajones[6] = caj6;
        cajones[7] = caj7;
        cajones[8] = caj8;
        cajones[9] = caj9;
        cajones[10] = caj10;
        cajones[11] = caj11;
        cajones[12] = caj12;
        cajones[13] = caj13;
        cajones[14] = caj14;
        cajones[15] = caj15;
        cajones[16] = caj16;
        cajones[17] = caj17;
        cajones[18] = caj18;
        cajones[19] = caj19;

    }

    public void entrando(int numCajon){
        System.out.println(numCajon+" Entrando");
        //texto.setText(String.valueOf(numCajon));
        Platform.runLater(() -> cajones[numCajon].setVisible(true));
        //Platform.runLater(() -> texto.setText(String.valueOf(numCajon)));

    }

    public void saliendo(int numCajon){
        System.out.println(numCajon + " Saliendo");
        //cajones[numCajon].setFill(Color.GREEN);
        Platform.runLater(() -> cajones[numCajon].setVisible(false));
    }

    public void esperando(String cadena){
        if (cadena.equals("esperandoE")){
            Platform.runLater(() -> imgEntrando.setVisible(true));
            //Platform.runLater(() -> esperandoEntrar.setFill(Paint.valueOf("#22d343")));
        }else{
            Platform.runLater(() -> imgSaliendo.setVisible(true));
            //Platform.runLater(() -> esperandoSalir.setFill(Paint.valueOf("#22d343")));
        }
    }

    public void pasandoSaliendo(String cadena){
        if(cadena.equals("pasando")){
            Platform.runLater(() -> imgEntrando.setVisible(false));
            //Platform.runLater(() -> esperandoEntrar.setFill(Color.WHITE));
        }else{
            //Platform.runLater(() -> esperandoSalir.setFill(Color.WHITE));
            Platform.runLater(() -> imgSaliendo.setVisible(false));
        }
    }
}
