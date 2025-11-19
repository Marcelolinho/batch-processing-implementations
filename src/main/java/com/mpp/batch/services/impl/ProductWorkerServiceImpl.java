package com.mpp.batch.services.impl;

import com.mpp.batch.model.ProductBo;
import com.mpp.batch.services.IProductService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class ProductWorkerServiceImpl implements IProductService {

    private Queue<ProductBo> queueOfWorkerProduct = new ConcurrentLinkedQueue<>();

    @Override
    public void save(ProductBo product) {
        queueOfWorkerProduct.add(product);
    }

//    Esse método a cada 100ms vai buscar 1000 produtos da fila de pedidos e processá-los (poderia ser salvando em um banco de dados ou algo assim)
    @Scheduled(fixedRate = 100)
    public void process() {
        List<ProductBo> currentBatchOfProducts = new ArrayList<>();

        while (!queueOfWorkerProduct.isEmpty() && currentBatchOfProducts.size() > 0) {
            queueOfWorkerProduct.poll();
        }

        if (currentBatchOfProducts.isEmpty()) {
            System.out.println("Terminou o batch!");
        }
    }

    @Override
    public void flush(List<ProductBo> listOfProducts) {

    }
}
