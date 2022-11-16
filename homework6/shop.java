public class shop {
  public static void main(String[] args) {
    Product currentProdukt = new Product();    

    currentProdukt = new CreateProdukt()  
    
        .setId(1)
        .setName("tv")
        .setCategory("appliances")
        .setManufacturer("LG")
        .setPrice(25000)
        .Create();

    currentProdukt.print();    
  }
}

