
public interface SimpleOrderSystemView
{
  String getCustomerFirstName();
  String getCustomerLastName();
  void reportInvalidCustomer(String firstName, String lastName);
  int getProductCode();
  void reportInvalidProductCode(int productCode);
  int getProductQuantity();
  boolean isNextLineItem();
  void run();

  void addOrderEntryController(OrderEntryController orderEntryController);
}
