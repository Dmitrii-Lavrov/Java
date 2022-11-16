public class Product {

  int id;
  String name;
  String category;
  String manufacturer;
  int price;

  public void print() {
    System.out.println(
        String.format(
            "id - %d; name - %s; category - %s; manufacturer - %s; price - %d;",
            this.id,            
            this.name,
            this.category,
            this.manufacturer,
            this.price));
  }
}


