package org.example.Lesson5;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GetProductTest {

    int id;
    static ProductService productService;
    Product product;


    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit2().create(ProductService.class);
    }

    @Test
    @SneakyThrows
    void createProductInFoodCategoryTest() {
        Response<Product> response = productService.createProduct(new Product(null, "banana", 3000, "fruits")).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));

    }

    @Test
    @SneakyThrows
    void getProduct() {

        Response response = productService.getProduct().execute();
        Assertions.assertEquals(response.code(), 200);
    }

    @Test
    @SneakyThrows
    void getProductByID(){

        Response response = productService.getProductById(995).execute();
        Assertions.assertEquals(response.isSuccessful(),true);

    }

}
