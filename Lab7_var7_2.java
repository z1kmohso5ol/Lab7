import java.io.*;
import java.util.Scanner;

class Ludi implements Serializable{
    String fam, name, pol;
    int rost;
}

public class Lab7_var7_2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in, "cp1251");
        File f1= new File("C:\\My\\zxc.txt");
        f1.createNewFile();
        File f2= new File("C:\\My\\iop.txt");
        f2.createNewFile();

        FileOutputStream ohh = new FileOutputStream(f2);
        ObjectOutputStream uhh = new ObjectOutputStream(ohh);

        FileOutputStream oh = new FileOutputStream(f1);
        ObjectOutputStream uh = new ObjectOutputStream(oh);

        System.out.print("Введите количество людей для записи в файл: ");
        int count = sc.nextInt();
        sc.nextLine();
        Ludi ludi;
        for (int i=0; i<count; i++) {
            ludi = new Ludi();
            System.out.print("Введите Фамилию =>");
            ludi.fam = sc.nextLine();
            System.out.print("Введите Имя =>");
            ludi.name = sc.nextLine();
            System.out.print("Введите пол =>");
            ludi.pol = sc.nextLine();
            System.out.print("Введите рост =>");
            ludi.rost = sc.nextInt();
            sc.nextLine();
            uh.writeObject(ludi);

            if(ludi.rost>170) uhh.writeObject(ludi);
        }
        uh.flush();
        uh.close();
        uhh.flush();
        uhh.close();

        FileInputStream ooh = new FileInputStream(f1);
        ObjectInputStream uuh = new ObjectInputStream(ooh);

        for (int j=0; j<count; j++) {
            ludi = (Ludi) uuh.readObject();
            System.out.println("Фамилия: " + ludi.fam + "\t\tИмя: " + ludi.name +
                    "\t\tпол: " + ludi.pol + "\t\tрост: " + ludi.rost);
        }
        uuh.close();

        FileInputStream oohh = new FileInputStream(f2);
        ObjectInputStream uuhh = new ObjectInputStream(oohh);
        System.out.println("\nлюди ростом выше 170 см: ");
        for (int k=0; k<count; k++) {
            ludi = (Ludi) uuhh.readObject();
            System.out.println("Фамилия: " + ludi.fam + "\t\tИмя: " + ludi.name +
                    "\t\tпол: " + ludi.pol + "\t\tрост: " + ludi.rost);
        }
        uuhh.close();
    }
}
