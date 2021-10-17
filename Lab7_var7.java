import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Lab7_var7 {
    public static void main(String[]args) {
        try {
            File folder = new File("C:\\Java");
            if (!folder.exists())
                folder.mkdir();
            File f1 = new File("C:\\My\\qwe.txt");
            f1.createNewFile();

            File f2 = new File("C:\\My\\asd.txt");
            f2.createNewFile();
            RandomAccessFile rr = new RandomAccessFile(f2, "rw");
            long rsize = rr.length();
            String rfam, rname, rpol;
            int  rrost;

            RandomAccessFile rf = new RandomAccessFile(f1, "rw");
            long size = rf.length();
            Scanner sc = new Scanner(System.in, "cp1251");
            System.out.print("Введите количество людей для записи в файл\n" + "=> ");
            int tov = sc.nextInt();
            sc.nextLine();
            String fam, name, pol;
            int rost;

            for (int i = 0; i < tov; i++) {
                System.out.print("Введите Фамилию =>");
                fam = sc.next();
                rf.seek(rf.length());
                rf.writeUTF(fam);
                for (int j = 0; j < 20 - fam.length(); j++)
                    rf.writeByte(1);

                System.out.print("Введите Имя =>");
                name = sc.next();
                rf.writeUTF(name);
                for (int j = 0; j < 20 - name.length(); j++)
                    rf.writeByte(1);

                System.out.print("Введите пол =>");
                pol = sc.next();
                rf.writeUTF(pol);
                for (int j = 0; j < 20 - pol.length(); j++)
                    rf.writeByte(1);

                System.out.print("Введите рост =>");
                rost = sc.nextInt();
                rf.writeInt(rost);

                if (rost>170){
                    rr.seek(rr.length());
                    rfam = fam;
                    rr.writeUTF(rfam);
                    rname = name;
                    rr.writeUTF(rname);
                    rpol = pol;
                    rr.writeUTF(rpol);
                    rrost = rost;
                    rr.writeInt(rrost);
                }
                sc.nextLine();
            }
            rf.close();
            rr.close();

            rf = new RandomAccessFile(f1, "r");
            rf.seek(0);
            System.out.println("Информация о людях");
            System.out.println("Фамилия \t\t Имя \t\t Пол \t\t Рост");
            for (int i = 0; i < tov; i++) {
                fam = rf.readUTF();
                for (int j = 0; j < 20 - fam.length(); j++)
                    rf.readByte();

                name = rf.readUTF();
                for (int j = 0; j < 20 - name.length(); j++)
                    rf.readByte();

                pol = rf.readUTF();
                for (int j = 0; j < 20 - pol.length(); j++)
                    rf.readByte();

                rost = rf.readInt();

                System.out.println(fam + "\t\t\t\t" + name + "\t\t\t\t" + pol + "\t\t\t\t" + rost);
            }
            rf.close();

        } catch (IOException e) {
            System.out.println("End of file " + e);
        }
    }
}
