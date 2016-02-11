
import java.util.ArrayList;
import java.util.Iterator;

public class DataManager implements SimpleOrderSystemModel
{
  private ArrayList<Customer> customers;
  private ArrayList<Product> products;

  public DataManager()
  {
    customers = new ArrayList<Customer>();
    products = new ArrayList<Product>();
  }

  public void addCustomer(String firstName, String lastName,
                          String address, String phone, String mobilePhone, String email)
  {
    Customer customer = new Customer(firstName, lastName,
                                     address, phone, mobilePhone, email);
    customers.add(customer);
  }

  public Customer getCustomer(String firstName, String lastName)
  {
    for (Customer customer : customers)
    {
      if (customer.getFirstName().equals(firstName)
          && customer.getLastName().equals(lastName))
      {
        return customer;
      }
    }
    return null;
  }

  public Iterator<Customer> getCustomerIterator()
  {
    return customers.iterator();
  }
  
  public Customer getCustomerWithIndex(int index) throws Exception
  {
	  if (index >= 0 && index < customers.size()) {
		  return customers.get(index);
	  } else throw new Exception("Index out of bunds");
  }

  public Product getProduct(int code)
  {
    for (Product product : products)
    {
      if (product.getCode() == code)
      {
        return product;
      }
    }
    return null;
  }

  public void addProduct(int code, String description, int price)
  {
    Product product = new Product(code,description,price);
    products.add(product);
  }

  public boolean isAvailableProductCode(int code)
  {
    if (code < 1)
    {
      return false;
    }
    for (Product product : products)
    {
      if (product.getCode() == code)
      {
        return false;
      }
    }
    return true;
  }

  public int overallTotal()
  {
    int total = 0;
    for (Customer customer : customers)
    {
      total += customer.getTotalForAllOrders();
    }
    return total;
  }
  
  public ArrayList<String> getOrdersFromCustomer(Customer customer)
  {	  
	  ArrayList<String> orders = new ArrayList<>();

	  int counter = 1;
	  for (Order order : customer.getOrders()) {
		  orders.add("Order " + counter + ", " + order.getTotal());
		  counter++;
	  } 
	  return orders;
  }
  
  public ArrayList<String> getOrdersWithProduct(Product product)
  {
	  Iterator<Customer> customers = getCustomerIterator();
	  ArrayList<String> orders = new ArrayList<>();
	  
	  while (customers.hasNext())
	  {
		  Customer customer = customers.next();
	      for (Order order : customer.getOrders())
	      {
	    	  if (order.containsProduct(product))
	    	  orders.add("Order with total amount: " + order.getTotal() + 
	    			  ". From customer: " + customer.getLastName()+", " + customer.getFirstName());
	      }
	  }	  
	  return orders;
  }
}