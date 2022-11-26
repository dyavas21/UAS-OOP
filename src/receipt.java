import java.io.*;

class Receipt implements Serializable {
    private String email, alamat;
    private int jumBarang;
    private int totalBayar, postalCode;

    Receipt(String email, String alamat, int postalCode, int totalBayar, int jumBarang){
        this.email = email;
        this.alamat = alamat;
        this.postalCode = postalCode;
        this.totalBayar = totalBayar;
        this.jumBarang = jumBarang;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getJumBarang() {
        return jumBarang;
    }

    public void setJumBarang(int jumBarang) {
        this.jumBarang = jumBarang;
    }

    public int getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(int totalBayar) {
        this.totalBayar = totalBayar;
    }

    public void showBayar (){
        System.out.print("\t" + this.email + "\t\t\t\t\t\t\t" + this.alamat + "\t\t\t\t" + this.postalCode + "\t\t\t" + this.jumBarang + "\t\t\t" + this.totalBayar +"\n\n");
    }
}
