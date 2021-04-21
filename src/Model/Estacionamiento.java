package Model;

public class Estacionamiento {
    private int[] cajones;
    //private final int numCajones = 5;

    public Estacionamiento(int[] cajones){
        this.cajones = cajones;
    }

    public int estacionar(){
        int index = 0;
        while (cajones[index] != 0){
            index++;
        }
        cajones[index] = 1;
        return index;
    }

    public void dejarCajon(int numCajon){
        cajones[numCajon] = 0;
    }
}
