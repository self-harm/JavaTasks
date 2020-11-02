public class Product {
    int id;
    String name;
    String price;
    String quantity;

    public Product(int id, String name, String price, String quantity){
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    @Override
    public String toString(){
        return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
    }

    public static Product getProduct(String string){
        String id = string.substring(0, 8).trim();
        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id),name, price, quantity);
    }
}
