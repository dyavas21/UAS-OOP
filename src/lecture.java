import java.io.*;

class Lecture implements Serializable{
    private String namaSubject, idLec;
    private int hargaLecPrint, hargaLecElec;
    private int jumModul;

    public String getIdLec() {
        return idLec;
    }

    public void setId(String id) {
        this.idLec = id;
    }

    public int getHargaLecPrint() {
        return hargaLecPrint;
    }

    public void setHargaLecPrint(int hargaLecPrint) {
        this.hargaLecPrint = hargaLecPrint;
    }

    public int getHargaLecElec() {
        return hargaLecElec;
    }

    public void setHargaLecElec(int hargaLecElec) {
        this.hargaLecElec = hargaLecElec;
    }

    public void setIdLec(String idLec) {
        this.idLec = idLec;
    }

    Lecture (String idLec, String namaSubject, int hargaLecPrint, int hargaLecElec, int jumModul){
        this.idLec = idLec;
        this.namaSubject = namaSubject;
        this.hargaLecPrint = hargaLecPrint;
        this.hargaLecElec = hargaLecElec;
        this.jumModul = jumModul;
    }

    public void showLecture (){
        System.out.print("  " + this.idLec + "\t\t\t" + this.namaSubject + "\t\t\t\t\t" + this.jumModul + "\t\t\t\t\t" + this.hargaLecPrint + "\t\t\t\t" + this.hargaLecElec + "\n\n");
    }


    public String getNamaSubject() {
        return namaSubject;
    }

    public void setNamaSubject(String namaSubject) {
        this.namaSubject = namaSubject;
    }

    public int getJumModul() {
        return jumModul;
    }

    public void setJumModul(int jumModul) {
        this.jumModul = jumModul;
    }
}