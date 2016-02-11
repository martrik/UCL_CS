
public class SimpleOrderSystem
{
  public static void main(String[] args)
  {
    Input in = new Input();
    
    // The model is responsible for managing the data structure and the operations on it.
    SimpleOrderSystemModel model = new DataManager();
    initialiseExampleData(model);
    
    // Create objects to manage the user interface
    SimpleOrderSystemView ui = new SimpleOrderSystemTerminalUI(in,model);
    OrderEntryController orderEntryController = new OrderEntryController(model,ui);
    ui.addOrderEntryController(orderEntryController);
    
    // Start off the main program loop
    ui.run();
  }
  
  // Provide some default data to illustrate how the Customer, Order and LineItem
  // classes are used, and to provide a quick way to add sample data while developing
  // the code.
  public static void initialiseExampleData(SimpleOrderSystemModel model)
  {
    model.addCustomer("First1", "Second1", "Address1", "Phone1", "Mobile1", "Email1");
    model.addCustomer("First2", "Second2", "Address2", "Phone2", "Mobile2", "Email2");

    model.addProduct(1,"Description1",100);
    model.addProduct(2,"Description2",200);
    
    LineItem item1 = new LineItem(1,model.getProduct(1));
    Order order1 = new Order();
    order1.add(item1);
    model.getCustomer("First1", "Second1").addOrder(order1);
    
    LineItem item2 = new LineItem(2,model.getProduct(1));
    LineItem item3 = new LineItem(1,model.getProduct(2));
    Order order2 = new Order();
    order2.add(item2);
    order2.add(item3);
    LineItem item4 = new LineItem(4,model.getProduct(1));
    Order order3 = new Order();
    order3.add(item4);
    model.getCustomer("First2", "Second2").addOrder(order2); 
    model.getCustomer("First2", "Second2").addOrder(order3);        
  }
}
