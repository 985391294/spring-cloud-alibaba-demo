package com.tqz.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author tianqingzhao
 * @since 2021/2/26 9:59
 */
@Slf4j
@RestController
public class FeignController {
  /*  @Autowired
    private AccountClient accountClient;*/

    /*@Autowired
    private ProductClient productClient;*/
/*

    @Reference
    private AccountService accountService;

    @GetMapping("/order/getAccount/{accountCode}")
    public ResultData<AccountDTO> getAccount(@PathVariable String accountCode){
        return accountClient.getByCode(accountCode);
    }
*/

    /*@GetMapping("/order/getAccount/{accountCode}")
    public ResultData<AccountDTO> getAccount(@PathVariable String accountCode){

        AccountDTO accountDTO = accountService.getByCode(accountCode);

        return ResultData.success(accountDTO);
    }*/

    /*@PostMapping("/order/insertAccount")
    public ResultData<String> insertAccount(AccountDTO accountDTO){
        return accountClient.insert(accountDTO);
    }

    @PostMapping("/order/updateAccount")
    public ResultData<String> updateAccount(AccountDTO accountDTO){
        return accountClient.update(accountDTO);
    }

    @PostMapping("/order/deleteAccount/{accountCode}")
    public ResultData<String> deleteAccount(@PathVariable String accountCode){
        return accountClient.delete(accountCode);
    }

    @GetMapping("/order/getProduct/{productCode}")
    public ResultData<ProductDTO> getProduct(@PathVariable String productCode){
        return productClient.getByCode(productCode);
    }


    @PostMapping("/order/insertProduct")
    public ResultData<String> insertProduct(ProductDTO productDTO){
        return productClient.insert(productDTO);
    }

    @PostMapping("/order/updateProduct")
    public ResultData<String> updateProduct(ProductDTO productDTO){
        return productClient.update(productDTO);
    }

    @PostMapping("/order/deleteProduct/{productCode}")
    public ResultData<String> deleteProduct(@PathVariable String productCode){
        return productClient.delete(productCode);
    }*/

}
