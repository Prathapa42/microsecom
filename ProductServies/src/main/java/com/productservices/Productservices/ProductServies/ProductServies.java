package com.productservices.Productservices.ProductServies;

import com.productservices.Productservices.Dto.ProductRequest;
import com.productservices.Productservices.Dto.productResponse;
import com.productservices.Productservices.Model.Product;

import java.util.List;

public interface ProductServies {


      public Product setproduct(ProductRequest product);
      public List<productResponse> getproduct();


}
