package com.tqz.product.service.impl;

import com.tqz.product.dto.ProductDTO;
import com.tqz.product.mapper.ProductMapper;
import com.tqz.product.po.Product;
import com.tqz.product.service.ProductService;
import io.seata.core.context.RootContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * ProductService实现类
 * </p
 *
 * @author tianqingzhao
 * @since 2021/2/25 10:15
 */
@Service
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;

    @Override
    public ProductDTO selectByCode(String productCode) {
        ProductDTO productVO = new ProductDTO();
        Product product = productMapper.selectByCode(productCode);
        BeanUtils.copyProperties(product, productVO);
        return productVO;
    }


    @Override
    public ProductDTO updateProduct(ProductDTO productVO) {
        Product product = new Product();
        BeanUtils.copyProperties(productVO, product);
        productMapper.updateById(product);
        return productVO;
    }

    @Override
    public ProductDTO insertProduct(ProductDTO productVO) {
        Product product = new Product();
        BeanUtils.copyProperties(productVO, product);
        productMapper.insert(product);
        return productVO;
    }

    @Override
    public int deleteProduct(String productCode) {
        return productMapper.deleteByCode(productCode);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void deduct(String productCode, Integer deductCount) {
        log.info("PRODUCT XID is: {}", RootContext.getXID());
        Product product = productMapper.selectByCode(productCode);
        if (null == product) {
            throw new RuntimeException("can't deduct product,product is null");
        }
        int surplus = product.getCount() - deductCount;
        if (surplus < 0) {
            throw new RuntimeException("can't deduct product,product's count is less than deduct count");
        }
        product.setCount(surplus);
        productMapper.updateById(product);
        int i = 1 / 0;
    }
}
