
import java.util.ArrayList;

public class Order
{
  private ArrayList<LineItem> lineItems;

  public Order()
  {
    lineItems = new ArrayList<LineItem>();
  }

  public int getLineItemCount()
  {
    return lineItems.size();
  }

  public void add(LineItem item)
  {
    lineItems.add(item);
  }

  public int getTotal()
  {
    int total = 0;
    for (LineItem item : lineItems)
    {
      total += item.getSubTotal();
    }
    return total;
  }
  
  public boolean containsProduct(Product product)
  {
	  for (LineItem item : lineItems)
	  {
		  if (item.getProduct().getCode() == product.getCode())
		  {
			  return true;
		  }
	  }
	  return false;
  }
  
  public ArrayList<LineItem> getLineItems()
  {
	  return lineItems;
  }
}
