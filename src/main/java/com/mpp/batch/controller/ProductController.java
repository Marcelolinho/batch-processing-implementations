package com.mpp.batch.controller;

import com.mpp.batch.model.ProductBo;
import com.mpp.batch.services.impl.ProductWorkerServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/batch")
public class ProductController {

    private final ProductWorkerServiceImpl productWorkerService;
    List<ProductBo> listOfProducts = new ArrayList<>();

    public ProductController(ProductWorkerServiceImpl productWorkerServiceImpl) {
        this.productWorkerService = productWorkerServiceImpl;
    }


    @PostMapping("/hard-breach")
    public void saveProductBatchByHardBreach(ProductBo product) {
        listOfProducts.add(product);
        /*
        * Esse método apenas salva, criando um memory leakage e também um overprocessing muito grande,
        * essa implementação em uma API que deve suportar 1 milhão de requests realmente não é ideal
        */
    }

    @PostMapping("/worker")
    public void saveProductBatchByWorker(ProductBo product) {
        productWorkerService.save(product);
    }
}
