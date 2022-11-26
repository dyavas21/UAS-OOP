import java.io.*;

class Keranjang implements Serializable{
    private String idBarang, namaBarang;
    private int jumBarang;
    private int hargaPrint, hargaElec, hargaTotalPrint, hargaTotalElec;

    Keranjang (String idBarang, String namaBarang, int hargaPrint, int hargaElec, int hargaTotalPrint, int hargaTotalElec, int jumBarang){
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.hargaPrint = hargaPrint;
        this.hargaElec = hargaElec;
        this.hargaTotalPrint = hargaTotalPrint;
        this.hargaTotalElec = hargaTotalElec;
        this.jumBarang = jumBarang;
    }

    public int getHargaTotalPrint() {
        return hargaTotalPrint;
    }

    public void setHargaTotalPrint(int hargaTotalPrint) {
        this.hargaTotalPrint = hargaTotalPrint;
    }

    public int getHargaTotalElec() {
        return hargaTotalElec;
    }

    public void setHargaTotalElec(int hargaTotalElec) {
        this.hargaTotalElec = hargaTotalElec;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getJumBarang() {
        return jumBarang;
    }

    public void setJumBarang(int jumBarang) {
        this.jumBarang = jumBarang;
    }

    public int getHargaPrint() {
        return hargaPrint;
    }

    public void setHargaPrint(int hargaPrint) {
        this.hargaPrint = hargaPrint;
    }

    public int getHargaElec() {
        return hargaElec;
    }

    public void setHargaElec(int hargaElec) {
        this.hargaElec = hargaElec;
    }

    public void showKeranjang (){
        System.out.print("  " + this.idBarang + "\t\t\t" + this.namaBarang + "\t\t\t\t\t" + this.jumBarang + "\t\t\t\t\t" + this.hargaPrint + "\t\t\t\t" + this.hargaElec + "\n\n");
    }

    public void showPrinted (){
        System.out.println(" " + this.getHargaTotalPrint());
    }
}