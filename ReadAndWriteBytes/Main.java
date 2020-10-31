import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String fileFirst = reader.readLine();
                String fileSecond = reader.readLine();
                String fileThird = reader.readLine();

                try(FileInputStream inputStream = new FileInputStream(fileFirst);
                    FileOutputStream outputStream1 = new FileOutputStream(fileSecond);
                    FileOutputStream outputStream2 = new FileOutputStream(fileThird);)
                {
                    int halfOfTheFIle = (inputStream.available() + 1)/2; //if inputStream contains 101(odd number) bytes: 101/2=50;
                    int count = 0;                                       //(inputStream+1): 102/2=51;

                    while (inputStream.available()>0){  //while fileFirst has unread bytes;
                        if(inputStream.available()==0){ //close the streams if fileFirst doesn't have unread bytes;
                            inputStream.close();
                            outputStream1.close();
                            outputStream2.close();
                            break;
                        }
                        if(count < halfOfTheFIle) {   //reckon until count == halfOfTheFile;
                            outputStream1.write(inputStream.read());
                            count++;
                        }
                        else{  // (count >= halfOfTheFile);
                            outputStream2.write(inputStream.read());
                        }
                    }
                }
    }
}

