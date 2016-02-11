
import java.util.ArrayList;
import java.util.Iterator;

public class SimpleOrderSystemTerminalUI implements SimpleOrderSystemView
{
  public static final int ADD_CUSTOMER = 1;
  public static final int EDIT_CUSTOMER = 2;
  public static final int ADD_ORDER = 3;
  public static final int ADD_PRODUCT = 4;
  public static final int LIST_CUSTOMERS = 5;
  public static final int ORDERS_CUSTOMER = 6;
  public static final int ORDERS_PRODUCT = 7;
  public static final int VALUE_ALLORDERS = 8;
  public static final int QUIT = 10;
  private static final int NAME = 1;
  private static final int ADRESS = 2;
  private static final int PHONE = 3;
  private static final int MOBILE_PHONE = 4;
  private static final int EMAIL = 5;
  private Input in;
  private SimpleOrderSystemModel model;
  private OrderEntryController orderEntryController;


  public SimpleOrderSystemTerminalUI(Input in, SimpleOrderSystemModel model)
  {
    this.in = in;
    this.model = model;
  }

  public void addOrderEntryController(OrderEntryController orderEntryController)
  {
    this.orderEntryController = orderEntryController;
  }

  public void run()
  {
    while(true)
    {
      displayMenu();
      int option = getMenuInput();
      if (option == QUIT)
      {
        break;
      }
      doOption(option);
    }
  }

  private void displayMenu()
  {
	System.out.println("");
    System.out.println("Simple Order System Menu");
    System.out.println(ADD_CUSTOMER + ". Add Customer");
    System.out.println(EDIT_CUSTOMER + ". Edit Customer");
    System.out.println(ADD_ORDER + ". Add Order");
    System.out.println(ADD_PRODUCT + ". Add Product");
    System.out.println(LIST_CUSTOMERS + ". List Customers");
    System.out.println(ORDERS_CUSTOMER + ". List of Orders from a Customer");
    System.out.println(ORDERS_PRODUCT + ". List of Orders with a Product");
    System.out.println(VALUE_ALLORDERS + ". Overall Amount");
    System.out.println();
    System.out.println(QUIT + ". Quit");
  }
  
  private void doOption(int option)
  {
    switch (option)
    {
      case ADD_CUSTOMER:
        addCustomer();
        break;
      case EDIT_CUSTOMER:
    	editCustomer();
    	break;
      case ADD_ORDER:
         addOrder();
        break;
      case ADD_PRODUCT:
         addProduct();
         break;
      case LIST_CUSTOMERS:
        listCustomers();
        break;
      case ORDERS_PRODUCT:
        ordersWithProduct();
        break;
      case VALUE_ALLORDERS:
    	valueAllOrders();
    	break;
      default:
        System.out.println("Invalid option - try again");
    }
  }

  private int getMenuInput()
  {
    System.out.print("Enter menu selection: ");
    int option = in.nextInt();
    in.nextLine();
    return option;
  }

  private void addCustomer()
  {
    System.out.println("Add new customer");
    System.out.println("Enter first name:");
    String firstName = in.nextLine();
    System.out.println("Enter last name:");
    String lastName = in.nextLine();
    System.out.println("Enter address:");
    String address = in.nextLine();
    System.out.println("Enter phone number:");
    String phone = in.nextLine();
    System.out.println("Enter mobile phone number:");
    String mobilePhone = in.nextLine();
    System.out.println("Enter email address:");
    String email = in.nextLine();
    model.addCustomer(firstName,lastName,address,phone,mobilePhone,email);
  }
  
  private void editCustomer() 
  {
	  System.out.println("Edit customer information. First enter the customer name");
	  
	  Customer toEdit = findCustomer();
	  
	  if (toEdit != null) 
	  {
		  Customer newCustomer;
		  
		  switch(whatToEdit()) 
		  {
		    case NAME:
		    	String newFirst = getCustomerFirstName();
		    	String newSecond = getCustomerLastName();
		    	model.addCustomer(newFirst, newSecond, toEdit.getAddress(), toEdit.getPhone(), toEdit.getMobilePhone(), toEdit.getEmail());
		    	newCustomer = model.getCustomer(newFirst, newSecond);
		    	break;
		    case ADRESS:
		    	model.addCustomer(toEdit.getFirstName(), toEdit.getLastName(), getWithPrompt("Enter new adress: "), toEdit.getPhone(), toEdit.getMobilePhone(), toEdit.getEmail());
		    	newCustomer = model.getCustomer(toEdit.getFirstName(), toEdit.getLastName());
		    	break;
		    case PHONE:
		    	model.addCustomer(toEdit.getFirstName(), toEdit.getLastName(), toEdit.getAddress(), getWithPrompt("Enter new phone: "), toEdit.getMobilePhone(), toEdit.getEmail());
		    	newCustomer = model.getCustomer(toEdit.getFirstName(), toEdit.getLastName());
		    	break;
		    case MOBILE_PHONE:
		    	model.addCustomer(toEdit.getFirstName(), toEdit.getLastName(), toEdit.getAddress(), toEdit.getPhone(), getWithPrompt("Enter new mobile phone: "), toEdit.getEmail());
		    	newCustomer = model.getCustomer(toEdit.getFirstName(), toEdit.getLastName());
		    	break;
		    case EMAIL:
		    	model.addCustomer(toEdit.getFirstName(), toEdit.getLastName(), toEdit.getAddress(), toEdit.getPhone(), toEdit.getMobilePhone(), getWithPrompt("Enter new email: "));
		    	newCustomer = model.getCustomer(toEdit.getFirstName(), toEdit.getLastName());
		    	break;
		    default:
		    	return;
		  }
		  
		  for (Order order : toEdit.getOrders()) {
			  newCustomer.addOrder(order);
		  }
		  
		  
	  } else System.out.println("Cusomer not fund");
	  
  }
  
  private int whatToEdit() 
  {
	  System.out.println("What do you want to edit?");
	  System.out.println(NAME + ". Name");
	  System.out.println(ADRESS + ". Adress");
	  System.out.println(PHONE + ". Phone");
	  System.out.println(MOBILE_PHONE + ". Mobile Phone");
	  System.out.println(EMAIL + ". Email");
	  System.out.println();
	  return getMenuInput();
  }

  private void addOrder()
  {
    Customer customer = findCustomer();
    if (customer == null)
    {
      System.out.println("Unable to add order");
      return;
    }
    Order order = new Order();
    addLineItems(order);
    if (order.getLineItemCount() == 0)
    {
      System.out.println("Cannot have an empty order");
      return;
    }
    customer.addOrder(order);
  }

  private String getWithPrompt(String prompt)
  {
    System.out.print(prompt);
    return in.nextLine();
  }

  public String getCustomerFirstName()
  {
    return getWithPrompt("Enter customer first name: ");
  }

  public String getCustomerLastName()
  {
    return getWithPrompt("Enter custoitem2mer last name: ");
  }

  public void reportInvalidCustomer(String firstName, String lastName)
  {
    System.out.println("Cannot find a customer called: "
                       + firstName + " " + lastName);
  }

  private Customer findCustomer()
  {
    System.out.print("Enter customer last name: ");
    String lastName = in.nextLine();
    System.out.print("Enter customer first name: ");
    String firstName = in.nextLine();
    return model.getCustomer(firstName, lastName);
  }

  private void addLineItems(Order order)
  {
    while (true)
    {
      System.out.print("Enter line item (y/n): ");
      String reply = in.nextLine();
      if (reply.startsWith("y"))
      {
        LineItem item = getLineItem();
        if (item != null)
        {
          order.add(item);
        }
      }
      else
      {
        break;
      }
    }
  }

  private LineItem getLineItem()
  {
    return orderEntryController.getLineItemFromView();
  }

  public boolean isNextLineItem()
  {
      System.out.print("Enter line item (y/n): ");
      String reply = in.nextLine();
      if (reply.startsWith("y"))
      {
        return true;
      }
      return false;
  }

  public int getProductCode()
  {
    System.out.print("Enter product code: ");
    int code = in.nextInt();
    in.nextLine();
    return code;
  }

  public void reportInvalidProductCode(int productCode)
  {
    System.out.println("Product code: " + productCode + " is invalid");
  }

  public int getProductQuantity()
  {
    System.out.print("Enter quantity: ");
    int quantity = in.nextInt();
    in.nextLine();
    return quantity;
  }

  private void addProduct()
  {
    System.out.print("Enter product code: ");
    int code = in.nextInt();
    in.nextLine();
    if (!model.isAvailableProductCode(code))
    {
      return;
    }
    System.out.print("Enter product description: ");
    String description = in.nextLine();
    System.out.print("Enter product price: ");
    int price = in.nextInt();
    in.nextLine();
    model.addProduct(code, description, price);
  }

  private void listCustomers()
  {
    System.out.println("List of customers");
    Iterator<Customer> customers = model.getCustomerIterator();
    while (customers.hasNext())
    {
      Customer customer = customers.next();
      System.out.println("Name: " + customer.getLastName()
                                  + ", "
                                  + customer.getFirstName());
      System.out.println("Address: " + customer.getAddress());
      System.out.println("Phone: " + customer.getPhone());
      System.out.println("Mobile Phone: " + customer.getMobilePhone());
      System.out.println("Email: " + customer.getEmail());
      System.out.println("Orders made: " + customer.getOrders().size());
      System.out.println("Total for all orders: " + customer.getTotalForAllOrders());
      System.out.println("");
    }
  }
  
  private void ordersFromCustomer()
  {
	  Customer customer = customerSelector();
	  System.out.println("These are all the orders from the selected customer: ");

	  ArrayList<String> orders = model.getOrdersFromCustomer(customer);
	  if (orders.size() > 0)
	  {
		  for (String str : orders)
		  {
			  System.out.println(str);
		  }
	  } 
	  else
	  {
		  System.out.println("This customer has no orders.");
	  }
  }
  
 
  private Customer customerSelector() {
	  System.out.println("These are all the customers: ");
	  Iterator<Customer> customers = model.getCustomerIterator();
	  
	  int counter = 1;
	  while (customers.hasNext())
	  {
		  Customer customer = customers.next();
	      System.out.println(counter + ". " + customer.getLastName() + ", " + customer.getFirstName());
	      counter++;
	  }
	  
	  try {
		  int index = Integer.parseInt(getWithPrompt("Enter the desired customer's index: "))-1;
		  System.out.println(index);
		  return model.getCustomerWithIndex(index);
	  }
	  catch(Exception exception) {
		  System.out.println("Invalid index");
		  return null;
	  }
  }
  
  private void ordersWithProduct()
  {
	  Product product = orderEntryController.getProductFromView();
	  ArrayList<String> orders = model.getOrdersWithProduct(product);
	  
	  for (String str : orders)
	  {
		  System.out.println(str);
	  }
  }
  
  private void valueAllOrders()
  {
      System.out.println("Overall amount of all orders: " + model.overallTotal());
  }
}
