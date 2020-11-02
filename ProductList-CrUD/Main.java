import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Прайсы
*/

public class Main {
    public static void main(String[] args) throws Exception{
        if(args.length == 0){
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  //read from keyboard name of the file
        String fileName = reader.readLine();

        List<Product> products = new ArrayList<>(); //create new ArrayList for products;

        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
            while (fileReader.ready()){
                Product product = Product.getProduct(fileReader.readLine());
                products.add(product);
            }
        }

        switch (args[0]){
            case "-c":
                int id=0;
                for(Product product : products){
                    if(product.id > id) id = product.id;
                }
                String name = "";
                for(int i=1;i< args.length-2;i++){
                    name += args[i] + " ";
                }
                if(name.length() > 30){
                    name = name.substring(0, 30);
                }
                String price = args[args.length-2];
                if(price.length() > 8){
                    price = price.substring(0, 8);
                }
                String quantity = args[args.length-1];
                if(quantity.length() > 4){
                    quantity = quantity.substring(0, 4);
                }
                Product product = new Product(++id, name.trim(), price, quantity);
                products.add(product);
        }

        try(FileWriter fileWriter = new FileWriter(fileName)) {  //write from the ArrayList to fileName;
            for (Product product : products) {
                fileWriter.write(product.toString());
                fileWriter.write("\n");
            }
        }

    }
}

//   D:/qq.txt

//    0       1      3       4
// [productID, Name, price, quantity]

//  12      productName1                  2.0     5
//  13      productName2                  7.0     4
//  14      productName3                  7.5     3


//  12 productName1 2.0 5

