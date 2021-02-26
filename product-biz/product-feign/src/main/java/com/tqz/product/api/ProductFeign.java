package com.tqz.product.api;

import com.tqz.product.base.ResultData;
import com.tqz.product.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * ProductFeign 对外暴露接口
 * </p
 *
 * @author tianqingzhao
 * @since 2021/2/26 10:02
 */
@FeignClient(value = "product-service")
public interface ProductFeign {
    /** 新增产品 */
    @PostMapping("/product/insert")
    ResultData<String> insert(@RequestBody ProductDTO productDTO);

    /** 删除产品 */
    @PostMapping("/product/delete")
    ResultData<String> delete(@RequestParam("productCode") String productCode);

    /** 编辑产品 */
    @PostMapping("/product/update")
    ResultData<String> update(@RequestBody ProductDTO productDTO);

    /** 查找产品 */
    @GetMapping("/product/getByCode/{productCode}")
    ResultData<ProductDTO> getByCode(@PathVariable(value = "productCode") String productCode);

    /**扣减库存*/
    @PostMapping("/product/deduct")
    ResultData<String> deduct(@RequestParam("productCode")String productCode, @RequestParam("count")Integer count);
}
