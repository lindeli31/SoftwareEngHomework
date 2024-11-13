public class Voto {
    private String Materia;
    private int id;
    private int voto;
    private int crediti;
    public Voto(String Materia, int voto, int crediti) {
        this.Materia = Materia;
        this.voto = voto;
        this.crediti = crediti;
    }
    public String getMateria() {
        return Materia;

    }
    public int getId(){
        return id;

    }
    public void setId(int id){
        this.id =id;
    }
    public void setMateria(String Materia) {
        this.Materia = Materia;
    }
    public int getVoto() {
        return voto;

    }
    public void setVoto(int voto) {
        this.voto = voto;
    }
    public int getCrediti() {
        return crediti;
    }
    public void setCrediti(int crediti) {
        this.crediti = crediti;
    }

}
