
public class Product
{
  private int code;
  private int price;
  private String description;

  public Product(int code, String description, int price)
  {
    this.code = code;
    this.price = price;
    this.description = description;
  }

  public int getPrice()
  {
    return price;
  }

  public String getDescription()
  {
    return description;
  }

  public int getCode()
  {
    return code;
  }
}
