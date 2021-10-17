import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Lab7_2 {
    public static void main(String[] args){
        try {
            File folder = new File("C:\\My");
            if(!folder.exists())
                folder.mkdir();

            File f1=new File("C:\\My\\strokiRand.txt");
            f1.createNewFile();

            Scanner sc = new Scanner(System.in, "cp1251");
            System.out.print("Сколько строк надо записать в файл? \n =>");
            int count = sc.nextInt();
            sc.nextLine();

            RandomAccessFile rf = new RandomAccessFile(f1, "rw");
            rf.setLength(0);
            long len = rf.length();
            System.out.println("Открыт файл размером " +len+" байт");
            System.out.println("Введите строки: ");
            int kol=0;

            for (int i=0; i<count; i++){
                String s = sc.nextLine();
                rf.writeUTF(s);
                kol+=s.length();
            }
            len = rf.length();

            rf = new RandomAccessFile(f1, "r");
            System.out.println("Строки из файла: ");
            rf.seek(0);
            for (int i=0; i<count; i++)
                System.out.println("Строка " +i+ " начинается с байта "
                        + rf.getFilePointer() + " - " + rf.readUTF() + " - заканчивается байтом "
                        + (rf.getFilePointer()-1));
            rf.close();
        }
        catch (IOException e){
            System.out.println("End of file " +e);
        }
    }
}
