package com.hansospina.jconf.co.demo1.product;

import com.hansospina.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


  List<Product> products = new ArrayList<>();


  @GetMapping("/list")
  public HashMap<String, Object> list(@RequestParam(value = "name", required = false) String name) {
    return Result.withSuccess()
        .set("products", products)
        .json();
  }

}
