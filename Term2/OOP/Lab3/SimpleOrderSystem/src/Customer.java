
import java.util.ArrayList;

public class Customer
{
  private String firstName;
  private String lastName;
  private String address;
  private String phone;
  private String mobilePhone;
  private String email;
  private ArrayList<Order> orders;

  public Customer(String firstName, String lastName, String address, String phone, String mobilePhone, String email)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.phone = phone;
    this.mobilePhone = mobilePhone;
    this.email = email;
    orders = new ArrayList<Order>();
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getAddress()
  {
    return address;
  }

  public String getPhone()
  {
    return phone;
  }
  
  public String getMobilePhone()
  {
    return mobilePhone;
  }

  public String getEmail()
  {
    return email;
  }

  public void addOrder(Order order)
  {
    orders.add(order);
  }

  public ArrayList<Order> getOrders()
  {
    return new ArrayList<Order>(orders);
  }

  public int getTotalForAllOrders()
  {
    int total = 0;
    for (Order order : orders)
    {
      total += order.getTotal();
    }
    return total;
  }
}
