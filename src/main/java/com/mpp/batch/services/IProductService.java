package com.mpp.batch.services;

import com.mpp.batch.model.ProductBo;

import java.util.List;

public interface IProductService {
    void save(ProductBo product);
    void flush(List<ProductBo> listOfProducts);
}
