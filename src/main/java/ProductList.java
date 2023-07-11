public class ProductList {
    public static String createProductList(String name, double price) {
        String listTemplate = "%s, цена: %.2f\n";
        String productList = "";
        productList = productList + String.format(listTemplate, name, price);
        return productList;
        }
}
