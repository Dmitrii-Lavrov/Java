public class CreateProdukt { 

Product temp;

  public CreateProdukt() {
    temp = new Product();
    temp.id = -1;
    temp.name = "--";
    temp.price = -1;
    temp.category = "--";    
    temp.manufacturer = "--";
   
  }

  public CreateProdukt setId(int id) {
    temp.id = id;
    return this;
  }  

  public CreateProdukt setName(String name) {
    temp.name = name;
    return this;
  }

  public CreateProdukt setPrice(int price) {
    temp.price = price;
    return this;
  }

  public CreateProdukt setCategory(String category) {
    temp.category = category;
    return this;
  }

  public CreateProdukt setManufacturer(String manufacturer) {
    temp.manufacturer = manufacturer;
    return this;
  }  

  public Product Create() {
    return temp;
  }
}