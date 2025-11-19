package com.mpp.batch.services.impl;

import com.mpp.batch.model.ProductBo;
import com.mpp.batch.services.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductKafkaServiceImpl implements IProductService {
    @Override
    public ProductBo save(ProductBo product, List<ProductBo> listOfProducts) {
        return null;
    }

    @Override
    public void flush(List<ProductBo> listOfProducts) {

    }
}
