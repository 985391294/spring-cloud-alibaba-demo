package com.tqz.order.client.fallback;

import com.tqz.order.client.ProductClient;
import com.tqz.product.base.ResultData;
import com.tqz.product.dto.ProductDTO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * ProductClientFallback
 * </p
 *
 * @author tianqingzhao
 * @since 2021/2/26 9:58
 */
@Slf4j
public class ProductClientFallback implements ProductClient {
    @Setter
    private Throwable cause;



    @Override
    public ResultData<String> insert(ProductDTO productDTO) {
        return ResultData.fail("接口熔断");
    }

    @Override
    public ResultData<String> delete(String accountCode) {
        return ResultData.fail("接口熔断");
    }

    @Override
    public ResultData<String> update(ProductDTO productDTO) {
        return ResultData.fail("接口熔断");
    }

    @Override
    public ResultData<ProductDTO> getByCode(String productCode) {
        log.error("查询失败,接口异常" ,cause);
        ProductDTO product = new ProductDTO();
        product.setProductCode("000");
        product.setProductName("测试Feign");
        return ResultData.success(product);
    }


    @Override
    public ResultData<String> deduct(String productCode, Integer count) {
        return ResultData.fail("接口熔断");
    }

}
