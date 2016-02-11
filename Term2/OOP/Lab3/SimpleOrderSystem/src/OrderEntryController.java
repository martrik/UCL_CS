
import java.util.ArrayList;

public class OrderEntryController
{
  private final SimpleOrderSystemModel model;
  private final SimpleOrderSystemView view;

  public OrderEntryController(SimpleOrderSystemModel model,
                              SimpleOrderSystemView view)
  {
    this.model = model;
    this.view = view;
  }

  public ArrayList<LineItem> getLineItemsList()
  {
    ArrayList<LineItem> items = new ArrayList<LineItem>();
    while (view.isNextLineItem())
    {
      LineItem item = getLineItemFromView();
      if (item != null) { items.add(item);}
    }
    return items;
  }

  public LineItem getLineItemFromView()
  {
    Product product = getProductFromView();
    if (product == null)
    {
      return null;
    }
    int quantity = getProductQuantityFromView();
    return new LineItem(quantity,product);
  }

  public int getProductQuantityFromView()
  {
    return view.getProductQuantity();
  }

  public Product getProductFromView()
  {
    int productCode = view.getProductCode();
    Product product = model.getProduct(productCode);
    if (product == null)
    {
      view.reportInvalidProductCode(productCode);
    }
    return product;  
  }

}