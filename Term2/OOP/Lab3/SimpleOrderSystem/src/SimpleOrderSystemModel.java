
import java.util.ArrayList;
import java.util.Iterator;

public interface SimpleOrderSystemModel
{
  void addCustomer(String firstName, String lastName,
                   String address, String phone, String mobilePhone, String email);

  Customer getCustomer(String firstName, String lastName);

  Iterator<Customer> getCustomerIterator();
    
  Customer getCustomerWithIndex(int index) throws Exception;
  
  ArrayList<String> getOrdersFromCustomer(Customer customer);
  
  ArrayList<String> getOrdersWithProduct(Product product);

  Product getProduct(int code);
  
  void addProduct(int code, String description, int price);

  boolean isAvailableProductCode(int code);
  
  int overallTotal();
}
 