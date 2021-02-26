package com.tqz.product.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.tqz.common.base.ResultData;
import com.tqz.product.dto.ProductDTO;
import com.tqz.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品控制器
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/25 10:13
 */
@RestController
@Log4j2
@Api(tags = "product模块")
@RequestMapping("product")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {
    private final ProductService productService;


    @ApiOperation("添加产品")
    @PostMapping("/insert")
    @ApiImplicitParam(name = "productDTO", value = "产品详细说明", required = true, paramType = "body")
    public ResultData<String> insert(@RequestBody ProductDTO productDTO) {
        log.info("insert product:{}", productDTO);
        productService.insertProduct(productDTO);
        return ResultData.success("insert product succeed");
    }

    @ApiOperation(value = "根据产品编码删除对应产品")
    @PostMapping("/delete")
    @ApiImplicitParam(name = "productCode", value = "产品编码", required = true, paramType = "query")
    public ResultData<String> delete(@RequestParam String productCode) {
        log.info("delete product,productCode is {}", productCode);
        productService.deleteProduct(productCode);
        return ResultData.success("delete product succeed");
    }

    @PostMapping("/update")
    @ApiOperation("更新产品信息")
    public ResultData<String> update(@RequestBody ProductDTO productDTO) {
        log.info("update product:{}", productDTO);
        productService.updateProduct(productDTO);
        return ResultData.success("update product succeed");
    }

    @GetMapping("/getByCode/{productCode}")
    @SentinelResource(value = "/product/getByCode", fallback = "fallbackHandler")
    @ApiOperation(value = "根据产品编码查找对应的产品")
    @ApiImplicitParam(name = "productCode", value = "产品编码", required = true, paramType = "path")
    public ResultData<ProductDTO> getByCode(@PathVariable String productCode) {
        log.info("get product detail,productCode is :{}", productCode);
        ProductDTO productDTO = productService.selectByCode(productCode);
        return ResultData.success(productDTO);
    }

    @PostMapping("/deduct")
    @ApiOperation(value = "扣减库存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productCode", value = "产品编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "count", value = "产品数量", required = true, paramType = "query")
    })
    public ResultData<String> deduct(@RequestParam("productCode") String productCode, @RequestParam("count") Integer count) {
        log.info("deduct product, productCode is :{},count is {} ", productCode, count);
        return productService.deduct(productCode, count);
    }

    /**
     * 自定义熔断异常，返回值和参数要跟目标函数一样
     *
     * @param productCode 商品code
     * @return
     */
    public ResultData<ProductDTO> fallbackHandler(String productCode) {
        return ResultData.fail(800, "服务被熔断了，不要调用!");
    }

}
