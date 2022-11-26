import java.io.*;

class Exam implements Serializable{
    private int jumExam;
    private String examName, idExam;
    private int hargaExamPrint, hargaExamElec;

    public String getIdExam() {
        return idExam;
    }

    public void setIdExam(String idExam) {
        this.idExam = idExam;
    }

    public int getHargaExamPrint() {
        return hargaExamPrint;
    }

    public void setHargaExamPrint(int hargaExamPrint) {
        this.hargaExamPrint = hargaExamPrint;
    }

    public int getHargaExamElec() {
        return hargaExamElec;
    }

    public void setHargaExamElec(int hargaExamElec) {
        this.hargaExamElec = hargaExamElec;
    }

    Exam (String idExam, String examName, int hargaExamPrint, int hargaExamElec, int jumExam){
        this.idExam = idExam;
        this.examName = examName;
        this.hargaExamPrint = hargaExamPrint;
        this.hargaExamElec = hargaExamElec;
        this.jumExam = jumExam;
    }

    public String getId() {
        return idExam;
    }

    public void setId(int id) {
        this.idExam = idExam;
    }

    public int getJumExam() {
        return jumExam;
    }

    public void setJumExam(int jumExam) {
        this.jumExam = jumExam;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void showExam (){
        System.out.print("  " + this.idExam + "\t\t" + this.examName + "\t\t\t\t\t" + this.jumExam + "\t\t\t\t" + this.hargaExamPrint + "\t\t\t\t" + this.hargaExamElec + "\n\n");
    }
}