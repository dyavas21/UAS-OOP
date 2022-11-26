import java.io.*;

class Practice implements Serializable {
    private int jumPrac;
    private String pracName, idPrac;
    private int hargaPracPrint, hargaPracElec;

    Practice (String idPrac, String pracName, int hargaPracPrint, int hargaPracElec, int jumPrac){
        this.idPrac = idPrac;
        this.pracName = pracName;
        this.hargaPracPrint = hargaPracPrint;
        this.hargaPracElec = hargaPracElec;
        this.jumPrac = jumPrac;
    }

    public String getIdPrac() {
        return idPrac;
    }

    public void setIdPrac(String idPrac) {
        this.idPrac = idPrac;
    }

    public int getJumPrac() {
        return jumPrac;
    }

    public void setJumPrac(int jumPrac) {
        this.jumPrac = jumPrac;
    }

    public String getPracName() {
        return pracName;
    }

    public void setPracName(String pracName) {
        this.pracName = pracName;
    }

    public int getHargaPracPrint() {
        return hargaPracPrint;
    }

    public void setHargaPracPrint(int hargaPracPrint) {
        this.hargaPracPrint = hargaPracPrint;
    }

    public int getHargaPracElec() {
        return hargaPracElec;
    }

    public void setHargaPracElec(int hargaPracElec) {
        this.hargaPracElec = hargaPracElec;
    }

    public void showPractice (){
        System.out.print("  " + this.idPrac + "\t\t" + this.pracName + "\t\t\t\t\t" + this.jumPrac + "\t\t\t\t\t\t" + this.hargaPracPrint + "\t\t\t\t" + this.hargaPracElec + "\n\n");
    }
}