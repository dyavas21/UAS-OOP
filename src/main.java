import java.io.*;
import java.util.*;



public class main {
    public static void main(String[] args) throws Exception {

        //Lecture
        File fileLec = new File("lecture.txt");
        ArrayList<Lecture> LectureList = new ArrayList<Lecture>();
        ObjectOutputStream oosLec =  null;
        ObjectInputStream oisLec = null;
        ListIterator li = null;

        if (fileLec.isFile()){
            oisLec = new ObjectInputStream(new FileInputStream(fileLec));
            LectureList = (ArrayList<Lecture>)oisLec.readObject();
            oisLec.close();
        }

        //ExamPaper
        File fileExam = new File("exampap.txt");
        ArrayList<Exam> ExamList = new ArrayList<Exam>();
        ObjectOutputStream oosEx =  null;
        ObjectInputStream oisEx = null;

        if (fileExam.isFile()){
            oisEx = new ObjectInputStream(new FileInputStream(fileExam));
            ExamList = (ArrayList<Exam>)oisEx.readObject();
            oisEx.close();
        }

        //Practice
        File filePractice = new File("practice.txt");
        ArrayList<Practice> PracticeList = new ArrayList<Practice>();
        ObjectOutputStream oosPra =  null;
        ObjectInputStream oisPra = null;

        if (filePractice.isFile()){
            oisPra = new ObjectInputStream(new FileInputStream(filePractice));
            PracticeList = (ArrayList<Practice>)oisPra.readObject();
            oisPra.close();
        }

        //Keranjang
        File fileKeranjang = new File("keranjang.txt");
        ArrayList<Keranjang> KeranjangList = new ArrayList<Keranjang>();
        ObjectOutputStream oosKer =  null;
        ObjectInputStream oisKer = null;

        if (fileKeranjang.isFile()){
            oisKer = new ObjectInputStream(new FileInputStream(fileKeranjang));
            KeranjangList = (ArrayList<Keranjang>)oisKer.readObject();
            oisKer.close();
        }

        //Receipt
        File fileBayar = new File("receipt.txt");
        ArrayList<Receipt> receiptList = new ArrayList<Receipt>();
        ObjectOutputStream oosBay =  null;
        ObjectInputStream oisBay = null;

        if (fileBayar.isFile()){
            oisBay = new ObjectInputStream(new FileInputStream(fileBayar));
            receiptList = (ArrayList<Receipt>)oisBay.readObject();
            oisBay.close();
        }

        Scanner forInt = new Scanner(System.in);
        Scanner forStr = new Scanner(System.in);
        int chooseRole = -1;
        Random random = new Random();

        do {
            System.out.println("\n\n1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Choose role: ");
            chooseRole = forInt.nextInt();

            switch (chooseRole){
                case 1 :
                    int chooseAdmin = -1;

                    do {
                        System.out.println("\n\nADMIN");
                        System.out.println("1. Lecture Module");
                        System.out.println("2. Previous Exam");
                        System.out.println("3. Practice Paper");
                        System.out.println("4. Logout");
                        System.out.print("Pilihan: ");
                        chooseAdmin = forInt.nextInt();

                        switch (chooseAdmin){
                            case 1:
                                int chooseLec = -1;
                                do {
                                    System.out.println("+=======================================================================================================+");
                                    System.out.println("+ ID. |\t\t\tNama Subject\t\t\t|\tJumlah Modul\t|\tHarga Printed\t|\tHarga Elektronik\t+");
                                    System.out.println("+=======================================================================================================+");
                                    if (LectureList.isEmpty()){
                                        System.out.println("empty");
                                    }else {
                                        int i = 0;
                                        while (i < LectureList.size()){
                                            LectureList.get(i).showLecture();
                                            i++;
                                        }
                                    }
                                    System.out.println("\n\n1. Tambah Lecture Module");
                                    System.out.println("2. Hapus Lecture Module");
                                    System.out.println("3. Exit");
                                    System.out.print("Pilihan: ");
                                    chooseLec = forInt.nextInt();
                                    switch (chooseLec){
                                        case 1:
                                            String idLec, namaSubject;
                                            int jumModul;
                                            int hargaLecPrint, hargaLecElec;

                                            do {
                                                System.out.print("Masukkan ID [diawali 10 didepan]: ");
                                                idLec = forStr.nextLine();
                                            }while (!idLec.contains("10") || idLec.isEmpty());

                                            do {
                                                System.out.print("Masukkan nama subject [tidak boleh kosong]: ");
                                                namaSubject = forStr.nextLine();
                                            }while (namaSubject.isEmpty());

                                            do {
                                                System.out.print("Masukkan jumlah modul [10 - 12]: ");
                                                jumModul = forInt.nextInt();
                                            }while (jumModul < 10 || jumModul > 12);

                                            do {
                                                System.out.print("Masukkan Harga Printed [tidak boleh kosong]: ");
                                                hargaLecPrint = forInt.nextInt();
                                            }while (hargaLecPrint <= 0);

                                            do {
                                                System.out.print("Masukkan Harga Electronic [nilai tidak boleh lebih tinggi daripada printed]: ");
                                                hargaLecElec = forInt.nextInt();
                                            }while (hargaLecElec > hargaLecPrint || hargaLecElec <= 0);

                                                LectureList.add(new Lecture(idLec,namaSubject, hargaLecPrint, hargaLecElec, jumModul));
                                                oosLec = new ObjectOutputStream(new FileOutputStream(fileLec));
                                                oosLec.writeObject(LectureList);
                                                oosLec.close();

                                            break;
                                        case 2:
                                            if(fileLec.isFile()){
                                                oisLec = new ObjectInputStream(new FileInputStream(fileLec));
                                                LectureList = (ArrayList<Lecture>)oisLec.readObject();
                                                oisLec.close();
                                                boolean found = false;
                                                System.out.print("ID mana yang ingin dihapus: ");
                                                String delete = forStr.nextLine();
                                                li = LectureList.listIterator();
                                                while (li.hasNext()){
                                                    Lecture b = (Lecture) li.next();
                                                    if (b.getIdLec().equals(delete)){
                                                        li.remove();
                                                        found = true;
                                                    }
                                                }if (!found)
                                                    System.out.println("ID tidak ditemukan..!");
                                                else{
                                                    oosLec = new ObjectOutputStream(new FileOutputStream(fileLec));
                                                    oosLec.writeObject(LectureList);
                                                    oosLec.close();
                                                    System.out.println("ID berhasil di delete....!");
                                                }
                                            }else {
                                                System.out.println("File tidak ada....!");
                                            }
                                            break;
                                    }
                                }while (chooseLec!=3);
                                break;
                            case 2:
                                int chooseExam = -1;
                                do {
                                    System.out.println("+===============================================================================================+");
                                    System.out.println("+ ID. |\t\t\tNama Exam\t\t\t|\tJumlah Exam\t|\tHarga Printed\t|\tHarga Elektronik\t+");
                                    System.out.println("+===============================================================================================+");
                                    if (ExamList.isEmpty()){
                                        System.out.println("empty");
                                    }else {
                                        int i = 0;
                                        while (i < ExamList.size()){
                                            ExamList.get(i).showExam();
                                            i++;
                                        }
                                    }
                                    System.out.println("\n\n1. Tambah Previous Exam");
                                    System.out.println("2. Hapus Previous Exam");
                                    System.out.println("3. Exit");
                                    System.out.print("Pilihan: ");
                                    chooseExam = forInt.nextInt();

                                    switch (chooseExam){
                                        case 1:
                                            String idExam, namaExam;
                                            int jumExam;
                                            int hargaExamPrint, hargaExamElec;

                                            do {
                                                System.out.print("Masukkan ID [diawali 20 didepan]: ");
                                                idExam = forStr.nextLine();
                                            }while (!idExam.contains("20") || idExam.isEmpty());

                                            do {
                                                System.out.print("Masukkan nama Previous Exam Paper [tidak boleh kosong]: ");
                                                namaExam = forStr.nextLine();
                                            }while (namaExam.isEmpty());

                                            do {
                                                System.out.print("Masukkan jumlah Previous Exam Paper [tidak boleh kosong]: ");
                                                jumExam = forInt.nextInt();
                                            }while (jumExam <= 0);

                                            do {
                                                System.out.print("Masukkan Harga Printed [tidak boleh kosong]: ");
                                                hargaExamPrint = forInt.nextInt();
                                            }while (hargaExamPrint <= 0);

                                            do {
                                                System.out.print("Masukkan Harga Electronic [nilai tidak boleh lebih tinggi daripada printed]: ");
                                                hargaExamElec = forInt.nextInt();
                                            }while (hargaExamElec > hargaExamPrint || hargaExamElec <= 0);

                                            ExamList.add(new Exam(idExam,namaExam, hargaExamPrint, hargaExamElec, jumExam));
                                            oosEx = new ObjectOutputStream(new FileOutputStream(fileExam));
                                            oosEx.writeObject(ExamList);
                                            oosEx.close();
                                            break;
                                        case 2:
                                            if(fileExam.isFile()){
                                                oisEx = new ObjectInputStream(new FileInputStream(fileExam));
                                                ExamList = (ArrayList<Exam>)oisEx.readObject();
                                                oisEx.close();
                                                boolean found = false;
                                                System.out.print("ID mana yang ingin dihapus: ");
                                                String delete = forStr.nextLine();
                                                li = ExamList.listIterator();
                                                while (li.hasNext()){
                                                    Exam b = (Exam) li.next();
                                                    if (b.getIdExam().equals(delete)){
                                                        li.remove();
                                                        found = true;
                                                    }
                                                }if (!found)
                                                    System.out.println("ID tidak ditemukan..!");
                                                else{
                                                    oosEx = new ObjectOutputStream(new FileOutputStream(fileExam));
                                                    oosEx.writeObject(ExamList);
                                                    oosEx.close();
                                                    System.out.println("ID berhasil di delete....!");
                                                }
                                            }else {
                                                System.out.println("File tidak ada....!");
                                            }
                                            break;
                                    }
                                }while (chooseExam!=3);
                                break;
                            case 3:
                                int choosePractice = -1;
                                do {
                                    System.out.println("+===========================================================================================================+");
                                    System.out.println("+ ID. |\t\tNama Practice Paper\t\t|\tJumlah Practice Paper\t|\tHarga Printed\t|\tHarga Elektronik\t+");
                                    System.out.println("+===========================================================================================================+");
                                    if (PracticeList.isEmpty()){
                                        System.out.println("empty");
                                    }else {
                                        int i = 0;
                                        while (i < PracticeList.size()){
                                            PracticeList.get(i).showPractice();
                                            i++;
                                        }
                                    }
                                    System.out.println("\n\n1. Tambah Practice Paper");
                                    System.out.println("2. Hapus Practice Paper");
                                    System.out.println("3. Exit");
                                    System.out.print("Pilihan: ");
                                    choosePractice = forInt.nextInt();
                                    switch (choosePractice){
                                        case 1:
                                            String idPrac,namaPrac;
                                            int jumPrac;
                                            int hargaPracPrint, hargaPracElec;

                                            do {
                                                System.out.print("Masukkan ID [diawali 30 didepan]: ");
                                                idPrac = forStr.nextLine();
                                            }while (!idPrac.contains("30") || idPrac.isEmpty());

                                            do {
                                                System.out.print("Masukkan nama Practice Paper [tidak boleh kosong]: ");
                                                namaPrac = forStr.nextLine();
                                            }while (namaPrac.isEmpty());

                                            do {
                                                System.out.print("Masukkan jumlah Practice Paper [tidak boleh kosong]: ");
                                                jumPrac = forInt.nextInt();
                                            }while (jumPrac <= 0);

                                            do {
                                                System.out.print("Masukkan Harga Printed [tidak boleh kosong]: ");
                                                hargaPracPrint = forInt.nextInt();
                                            }while (hargaPracPrint <= 0);

                                            do {
                                                System.out.print("Masukkan Harga Electronic [nilai tidak boleh lebih tinggi daripada printed]: ");
                                                hargaPracElec = forInt.nextInt();
                                            }while (hargaPracElec > hargaPracPrint || hargaPracElec <= 0);

                                            PracticeList.add(new Practice(idPrac,namaPrac, hargaPracPrint, hargaPracElec, jumPrac));
                                            oosPra = new ObjectOutputStream(new FileOutputStream(filePractice));
                                            oosPra.writeObject(PracticeList);
                                            oosPra.close();
                                            break;
                                        case 2:
                                            if(filePractice.isFile()){
                                                oisPra = new ObjectInputStream(new FileInputStream(filePractice));
                                                PracticeList = (ArrayList<Practice>)oisPra.readObject();
                                                oisPra.close();
                                                boolean found = false;
                                                System.out.print("ID mana yang ingin dihapus: ");
                                                String delete = forStr.nextLine();
                                                li = PracticeList.listIterator();
                                                while (li.hasNext()){
                                                    Practice b = (Practice) li.next();
                                                    if (b.getIdPrac().equals(delete)){
                                                        li.remove();
                                                        found = true;
                                                    }
                                                }if (!found)
                                                    System.out.println("ID tidak ditemukan..!");
                                                else{
                                                    oosEx = new ObjectOutputStream(new FileOutputStream(fileExam));
                                                    oosEx.writeObject(ExamList);
                                                    oosEx.close();
                                                    System.out.println("ID berhasil di delete....!");
                                                }
                                            }else {
                                                System.out.println("File tidak ada....!");
                                            }
                                            break;
                                    }
                                }while (choosePractice!=3);
                                break;
                        }
                    }while (chooseAdmin!=4);
                    break;
                case 2 :
                    int chooseUser = -1;
                    do {
                        System.out.println("\n\nUSER");
                        System.out.println("1. Beli Lecture Module");
                        System.out.println("2. Beli Previous Exam");
                        System.out.println("3. Beli Practice Paper");
                        System.out.println("4. Cek Keranjang Belanja");
                        System.out.println("5. Cek Receipt");
                        System.out.println("6. Logout");
                        System.out.print("Pilihan: ");
                        chooseUser = forInt.nextInt();
                        switch (chooseUser){
                            case 1:
                                System.out.println("+=======================================================================================================+");
                                System.out.println("+ ID. |\t\t\tNama Subject\t\t\t|\tJumlah Modul\t|\tHarga Printed\t|\tHarga Elektronik\t+");
                                System.out.println("+=======================================================================================================+");
                                if (LectureList.isEmpty()){
                                    System.out.println("Empty--");
                                }else {
                                    int i = 0;
                                    while (i < LectureList.size()){
                                        if (LectureList.get(i).getJumModul() == 0){
                                            LectureList.remove(i);
                                        }else {
                                            LectureList.get(i).showLecture();
                                        }
                                        i++;
                                    }
                                }
                                if (PracticeList.isEmpty()){
                                    break;
                                }
                                if(fileLec.isFile()){
                                    oisLec = new ObjectInputStream(new FileInputStream(fileLec));
                                    LectureList = (ArrayList<Lecture>)oisLec.readObject();
                                    oisLec.close();
                                    boolean found = false;
                                    System.out.print("ID mana yang ingin dibeli: ");
                                    String idPilihan = forStr.nextLine();
                                    li = LectureList.listIterator();
                                    while (li.hasNext()){
                                        Lecture b = (Lecture) li.next();
                                        if (b.getIdLec().equals(idPilihan)){
                                            System.out.print("Jumlah yang ingin dibeli: ");
                                            int jumlahLec = forInt.nextInt();
                                            KeranjangList.add(new Keranjang(b.getIdLec(), b.getNamaSubject(), b.getHargaLecPrint(), b.getHargaLecElec(), b.getHargaLecPrint()*jumlahLec, b.getHargaLecElec()*jumlahLec, jumlahLec));
                                            oosKer = new ObjectOutputStream(new FileOutputStream(fileKeranjang));
                                            oosKer.writeObject(KeranjangList);
                                            oosKer.close();
                                            found = true;
                                        }
                                    }if (!found)
                                        System.out.println("ID tidak ditemukan..!");
                                    else{
                                        oosEx = new ObjectOutputStream(new FileOutputStream(fileExam));
                                        oosEx.writeObject(ExamList);
                                        oosEx.close();
                                        System.out.println("ID berhasil dibeli dan masuk ke dalam keranjang");
                                    }
                                }else {
                                    System.out.println("File tidak ada....!");
                                }
                                break;
                            case 2:
                                System.out.println("+===============================================================================================+");
                                System.out.println("+ ID. |\t\t\tNama Exam\t\t\t|\tJumlah Exam\t|\tHarga Printed\t|\tHarga Elektronik\t+");
                                System.out.println("+===============================================================================================+");
                                if (ExamList.isEmpty()){
                                    System.out.println("Empty--");
                                }else {
                                    int i = 0;
                                    while (i < ExamList.size()){
                                        if (ExamList.get(i).getJumExam() == 0){
                                            ExamList.remove(i);
                                            System.out.println("Empty--");
                                        }else {
                                            ExamList.get(i).showExam();
                                        }
                                        i++;
                                    }
                                }
                                if (ExamList.isEmpty()){
                                    break;
                                }
                                if(fileExam.isFile()){
                                    oisEx = new ObjectInputStream(new FileInputStream(fileExam));
                                    ExamList = (ArrayList<Exam>)oisEx.readObject();
                                    oisEx.close();
                                    boolean found = false;
                                    System.out.print("ID mana yang ingin dibeli: ");
                                    String idPilihan = forStr.nextLine();
                                    li = ExamList.listIterator();
                                    while (li.hasNext()){
                                        Exam b = (Exam) li.next();
                                        if (b.getIdExam().equals(idPilihan)){
                                            System.out.print("Jumlah yang ingin dibeli: ");
                                            int jumlahExam = forInt.nextInt();
                                            KeranjangList.add(new Keranjang(b.getIdExam(), b.getExamName(), b.getHargaExamPrint(), b.getHargaExamElec(), b.getHargaExamPrint()*jumlahExam, b.getHargaExamElec()*jumlahExam, jumlahExam));
                                            oosKer = new ObjectOutputStream(new FileOutputStream(fileKeranjang));
                                            oosKer.writeObject(KeranjangList);
                                            oosKer.close();
                                            int jumlahTotal = b.getJumExam() - jumlahExam;
                                            b.setJumExam(jumlahTotal);
                                            oosEx = new ObjectOutputStream(new FileOutputStream(fileExam));
                                            oosEx.writeObject(ExamList);
                                            oosEx.close();
                                            found = true;
                                        }
                                    }if (!found)
                                        System.out.println("ID tidak ditemukan..!");
                                    else{
                                        oosEx = new ObjectOutputStream(new FileOutputStream(fileExam));
                                        oosEx.writeObject(ExamList);
                                        oosEx.close();
                                        System.out.println("ID berhasil dibeli dan masuk ke dalam keranjang");
                                    }
                                }else {
                                    System.out.println("File tidak ada....!");
                                }
                                break;
                            case 3:
                                System.out.println("+===========================================================================================================+");
                                System.out.println("+ ID. |\t\tNama Practice Paper\t\t|\tJumlah Practice Paper\t|\tHarga Printed\t|\tHarga Elektronik\t+");
                                System.out.println("+===========================================================================================================+");
                                if (PracticeList.isEmpty()){
                                    System.out.println("empty");
                                }else {
                                    int i = 0;
                                    while (i < PracticeList.size()){
                                        if (PracticeList.get(i).getJumPrac() == 0){
                                            PracticeList.remove(i);
                                        }else {
                                            PracticeList.get(i).showPractice();
                                        }
                                        i++;
                                    }
                                }
                                if (PracticeList.isEmpty()){
                                    break;
                                }
                                if(filePractice.isFile()){
                                    oisPra = new ObjectInputStream(new FileInputStream(filePractice));
                                    PracticeList = (ArrayList<Practice>)oisPra.readObject();
                                    oisPra.close();
                                    boolean found = false;
                                    System.out.print("ID mana yang ingin dibeli: ");
                                    String idPilihan = forStr.nextLine();
                                    li = PracticeList.listIterator();
                                    while (li.hasNext()){
                                        Practice b = (Practice) li.next();
                                        if (b.getIdPrac().equals(idPilihan)){
                                            System.out.print("Jumlah yang ingin dibeli: ");
                                            int jumlahPrac = forInt.nextInt();
                                            KeranjangList.add(new Keranjang(b.getIdPrac(), b.getPracName(), b.getHargaPracPrint(), b.getHargaPracElec(), b.getHargaPracPrint()*jumlahPrac, b.getHargaPracElec()*jumlahPrac, jumlahPrac));
                                            oosKer = new ObjectOutputStream(new FileOutputStream(fileKeranjang));
                                            oosKer.writeObject(KeranjangList);
                                            oosKer.close();
                                            int jumlahTotal = b.getJumPrac() - jumlahPrac;
                                            b.setJumPrac(jumlahTotal);
                                            oosPra = new ObjectOutputStream(new FileOutputStream(filePractice));
                                            oosPra.writeObject(PracticeList);
                                            oosPra.close();
                                            found = true;
                                        }
                                    }if (!found)
                                        System.out.println("ID tidak ditemukan..!");
                                    else{
                                        oosPra = new ObjectOutputStream(new FileOutputStream(filePractice));
                                        oosPra.writeObject(PracticeList);
                                        oosPra.close();
                                        System.out.println("ID berhasil dibeli dan masuk ke dalam keranjang");
                                    }
                                }else {
                                    System.out.println("File tidak ada....!");
                                }
                                break;
                            case 4:
                                int chooseKeranjang = -1;
                                do {
                                    System.out.println("+=======================================================================================================+");
                                    System.out.println("+ ID. |\t\t\tNama Subject\t\t\t|\tJumlah Modul\t|\tHarga Printed\t|\tHarga Elektronik\t+");
                                    System.out.println("+=======================================================================================================+");
                                    if (KeranjangList.isEmpty()){
                                        System.out.println("empty");
                                    }else {
                                        int i = 0;
                                        while (i < KeranjangList.size()){
                                            KeranjangList.get(i).showKeranjang();
                                            i++;
                                        }
                                    }
                                    System.out.println("1. Lanjut Checkout Barang");
                                    System.out.println("2. Hapus Barang di Keranjang");
                                    System.out.println("3. Exit");
                                    System.out.print("Pilihan: ");
                                    chooseKeranjang = forInt.nextInt();
                                    switch (chooseKeranjang){
                                        case 1:
                                            int chooseCheckout = -1;
                                            do {
                                                System.out.println("1. Printed Version");
                                                System.out.println("2. Electronic Version");
                                                System.out.println("3. Exit");
                                                System.out.print("Pilihan: ");
                                                chooseCheckout = forInt.nextInt();
                                                switch (chooseCheckout){
                                                    case 1:
                                                        String alamat;
                                                        int postalCode = 0;
                                                        do {
                                                            System.out.print("Input Address: ");
                                                            alamat = forStr.nextLine();
                                                        }while (alamat.isEmpty());
                                                        do {
                                                            System.out.print("Input Postal Code [5 digit]: ");
                                                            postalCode = forInt.nextInt();
                                                        }while (postalCode < 9999);
                                                        if(fileKeranjang.isFile()){
                                                            oisKer = new ObjectInputStream(new FileInputStream(fileKeranjang));
                                                            KeranjangList = (ArrayList<Keranjang>)oisKer.readObject();
                                                            oisKer.close();
                                                            boolean found = false;
                                                            int total = 0;
                                                            String namaBarang = null;
                                                            int hargaPrint = 0, jumBarang = 0;
                                                            li = KeranjangList.listIterator();
                                                            while (li.hasNext()){
                                                                Keranjang b = (Keranjang) li.next();
                                                                int hargaPrinted = b.getHargaTotalPrint();
                                                                total = total + hargaPrinted;
                                                                jumBarang = b.getJumBarang();
                                                                li.remove();
                                                            }
                                                            System.out.println("Total Barang yang harus dibayarkan: " + total);
                                                            String pembayaran = null;
                                                            do {
                                                                System.out.println("Tekan Y untuk Bayar: ");
                                                                pembayaran = forStr.nextLine();
                                                            }while (!pembayaran.equals("Y"));
//                                                            simpen data total
                                                            receiptList.add(new Receipt(null, alamat, postalCode, total, jumBarang));
                                                            oosBay = new ObjectOutputStream(new FileOutputStream(fileBayar));
                                                            oosBay.writeObject(receiptList);
                                                            oosBay.close();

                                                            // hapus keranjang
                                                            oosKer = new ObjectOutputStream(new FileOutputStream(fileKeranjang));
                                                            oosKer.writeObject(KeranjangList);
                                                            oosKer.close();
                                                            chooseCheckout = 3;
                                                        }
                                                        break;
                                                    case 2:
                                                        String emailAdress;
                                                        do {
                                                            System.out.print("Input Email Address: ");
                                                            emailAdress = forStr.nextLine();
                                                        }while (emailAdress.isEmpty());
                                                        if(fileKeranjang.isFile()){
                                                            oisKer = new ObjectInputStream(new FileInputStream(fileKeranjang));
                                                            KeranjangList = (ArrayList<Keranjang>)oisKer.readObject();
                                                            oisKer.close();
                                                            boolean found = false;
                                                            int total = 0;
                                                            int jumBarang = 0;
                                                            li = KeranjangList.listIterator();
                                                            while (li.hasNext()){
                                                                Keranjang b = (Keranjang) li.next();
                                                                int hargaElectronic = b.getHargaTotalElec();
                                                                total = total + hargaElectronic;
                                                                jumBarang = b.getJumBarang();
                                                                li.remove();
                                                            }
                                                            System.out.println("Total Barang yang harus dibayarkan: " + total);
                                                            String pembayaran = null;
                                                            do {
                                                                System.out.println("Tekan Y untuk Bayar: ");
                                                                pembayaran = forStr.nextLine();
                                                            }while (!pembayaran.equals("Y"));
//                                                            simpen data total
                                                            receiptList.add(new Receipt(emailAdress, null, 0, total, jumBarang));
                                                            oosBay = new ObjectOutputStream(new FileOutputStream(fileBayar));
                                                            oosBay.writeObject(receiptList);
                                                            oosBay.close();

                                                            // hapus keranjang
                                                            oosKer = new ObjectOutputStream(new FileOutputStream(fileKeranjang));
                                                            oosKer.writeObject(KeranjangList);
                                                            oosKer.close();
                                                            chooseCheckout = 3;
                                                        }
                                                        break;
                                                }
                                            }while (chooseCheckout != 3);
                                            break;
                                        case 2:
                                            if(fileKeranjang.isFile()){
                                                oisKer = new ObjectInputStream(new FileInputStream(fileKeranjang));
                                                KeranjangList = (ArrayList<Keranjang>)oisKer.readObject();
                                                oisKer.close();
                                                boolean found = false;
                                                System.out.print("ID mana yang ingin dihapus: ");
                                                String delete = forStr.nextLine();
                                                li = KeranjangList.listIterator();
                                                while (li.hasNext()){
                                                    Keranjang b = (Keranjang) li.next();
                                                    if (b.getIdBarang().equals(delete)){
                                                        li.remove();
                                                        found = true;
                                                    }
                                                }if (!found)
                                                    System.out.println("ID tidak ditemukan..!");
                                                else{
                                                    oosKer = new ObjectOutputStream(new FileOutputStream(fileKeranjang));
                                                    oosKer.writeObject(KeranjangList);
                                                    oosKer.close();
                                                    System.out.println("ID berhasil di delete....!");
                                                }
                                            }else {
                                                System.out.println("File tidak ada....!");
                                            }
                                           break;
                                    }
                                }while (chooseKeranjang != 3);
                                break;
                            case 5:
                                System.out.println("+=======================================================================================================+");
                                System.out.println("+ No. |\t\tEmail Address\t\t|\t\t\tAlamat\t\t\t|\tKode Pos\t|\tJumlah\t|\tTotal Harga\t+");
                                System.out.println("+=======================================================================================================+");
                                if (receiptList.isEmpty()){
                                    System.out.println("empty");
                                }else {
                                    int i = 0;
                                    while (i < receiptList.size()){
                                        System.out.print("   " + (i+1));
                                        receiptList.get(i).showBayar();
                                        i++;
                                    }
                                }
                                break;
                        }
                    }while (chooseUser!=6);
            }
        }while (chooseRole!=3);
    }
}