package com.javarest;
import java.util.List;
public interface IProductService 
{
List<Product> findAll();

String AddProduct(Product product);
}
