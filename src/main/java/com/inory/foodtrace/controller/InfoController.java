package com.inory.foodtrace.controller;

import cn.hutool.core.util.ObjectUtil;
import com.inory.foodtrace.entity.Butcher;
import com.inory.foodtrace.entity.Farm;
import com.inory.foodtrace.entity.Sale;
import com.inory.foodtrace.entity.Transport;
import com.inory.foodtrace.model.bo.FoodTraceSetButcheryInputBO;
import com.inory.foodtrace.model.bo.FoodTraceSetFarmInputBO;
import com.inory.foodtrace.model.bo.FoodTraceSetSaleInputBO;
import com.inory.foodtrace.model.bo.FoodTraceSetTransportInputBO;
import com.inory.foodtrace.service.*;
import com.inory.foodtrace.utils.CryptoUtil;
import com.inory.foodtrace.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * The type Info controller.
 *
 * @author inory
 * @create 2021 -07-21 18:01
 */

@RestController
@RequestMapping("/api/info")
@Api(tags = {"Info"})
public class InfoController {

    @Resource
    FarmService farmService;

    @Resource
    ButcherService butcherService;

    @Resource
    TransportService transportService;

    @Resource
    SaleService saleService;

    @Resource
    FoodTraceService foodTraceService;

    @PostMapping("farm")
    @ApiOperation(value = "Insert Farm Info")
    public Result insertFarm(@RequestBody Farm farm) {
        try {
            String hash = CryptoUtil.crypto(farm.toString());
            farm.setHash(hash);
            farmService.insertFarmInfo(farm);
            // 将信息摘要存入区块链
            foodTraceService.setFarm(new FoodTraceSetFarmInputBO(farm.getPigId(), hash));
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @GetMapping("farm")
    @ApiOperation(value = "Search Farm Info")
    public Result selectFarm() {
        List<Farm> farmList = farmService.selectFarmInfo();
        if (ObjectUtil.isNotNull(farmList)) {
            return Result.ok().data("info", farmList);
        }
        return Result.error();
    }

    @PutMapping("farm")
    @ApiOperation(value = "Update Farm Info")
    public Result updateFarm(@RequestBody Farm farm) {
        try {
            String hash = CryptoUtil.crypto(farm.toString());
            farm.setHash(hash);
            farm.setState(1);
            int num = farmService.updateFarmInfo(farm, farm.getPigId());
            foodTraceService.setFarm(new FoodTraceSetFarmInputBO(farm.getPigId(), hash));
            if (num == 1) {
                return Result.ok().data("msg", "更新成功").data("info", farm);
            } else {
                return Result.error().data("errMsg", "更新失败");
            }
        } catch (Exception e) {
            return Result.error().data("errMsg", "更新失败");
        }
    }

    @PostMapping("butcher")
    @ApiOperation(value = "Insert butcher Info")
    public Result insertButcher(@RequestBody Butcher butcher) {
        try {
            String hash = CryptoUtil.crypto(butcher.toString());
            butcher.setHash(CryptoUtil.crypto(butcher.toString()));
            butcherService.insertButcherInfo(butcher);
            // 将信息摘要存入区块链
            foodTraceService.setButchery(new FoodTraceSetButcheryInputBO(butcher.getPigId(), hash));
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @GetMapping("butcher")
    @ApiOperation(value = "Search butcher Info")
    public Result selectButcher() {
        List<Butcher> butcherList = butcherService.selectButcherInfo();
        if (ObjectUtil.isNotNull(butcherList)) {
            return Result.ok().data("info", butcherList);
        }
        return Result.error();
    }

    @PutMapping("butcher")
    @ApiOperation(value = "Update butcher Info")
    public Result updateButcher(@RequestBody Butcher butcher) {
        try {
            String hash = CryptoUtil.crypto(butcher.toString());
            butcher.setHash(hash);
            butcher.setState(1);
            int num = butcherService.updateButcherInfo(butcher, butcher.getPigId());
            foodTraceService.setButchery(new FoodTraceSetButcheryInputBO(butcher.getPigId(), hash));
            if (num == 1) {
                return Result.ok().data("msg", "更新成功").data("info", butcher);
            } else {
                return Result.error().data("errMsg", "更新失败");
            }
        } catch (Exception e) {
            return Result.error().data("errMsg", "更新失败");
        }
    }

    @PostMapping("transport")
    @ApiOperation(value = "Insert transport Info")
    public Result insertTransport(@RequestBody Transport transport) {
        try {
            String hash = CryptoUtil.crypto(transport.toString());
            transport.setHash(CryptoUtil.crypto(transport.toString()));
            transportService.insertTransportInfo(transport);
            // 将信息摘要存入区块链
            foodTraceService.setTransport(new FoodTraceSetTransportInputBO(transport.getTransportId(), hash));
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @GetMapping("transport")
    @ApiOperation(value = "Search transport Info")
    public Result selectTransport() {
        List<Transport> transportList = transportService.selectTransportInfo();
        if (ObjectUtil.isNotNull(transportList)) {
            return Result.ok().data("info", transportList);
        }
        return Result.error();
    }

    @PutMapping("transport")
    @ApiOperation(value = "Update transport Info")
    public Result updateTransport(@RequestBody Transport transport) {
        try {
            String hash = CryptoUtil.crypto(transport.toString());
            transport.setHash(hash);
            transport.setState(1);
            int num = transportService.updateTransportInfo(transport, transport.getTransportId());
            foodTraceService.setTransport(new FoodTraceSetTransportInputBO(transport.getTransportId(), hash));
            if (num == 1) {
                return Result.ok().data("msg", "更新成功").data("info", transport);
            } else {
                return Result.error().data("errMsg", "更新失败");
            }
        } catch (Exception e) {
            return Result.error().data("errMsg", "更新失败");
        }
    }

    @PostMapping("sale")
    @ApiOperation(value = "Insert sale Info")
    public Result insertSale(@RequestBody Sale sale) {
        try {
            String hash = CryptoUtil.crypto(sale.toString());
            sale.setHash(hash);
            saleService.insertSaleInfo(sale);
            // 将信息摘要存入区块链
            foodTraceService.setSale(new FoodTraceSetSaleInputBO(sale.getSalesInfoId(), hash));
            return Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    @GetMapping("sale")
    @ApiOperation(value = "Search sale Info")
    public Result selectSale() {
        List<Sale> saleList = saleService.selectSaleInfo();
        if (ObjectUtil.isNotNull(saleList)) {
            return Result.ok().data("info", saleList);
        }
        return Result.error();
    }

    @PutMapping("sale")
    @ApiOperation(value = "Update sale Info")
    public Result updateSale(@RequestBody Sale sale) {
        try {
            String hash = CryptoUtil.crypto(sale.toString());
            sale.setHash(hash);
            sale.setState(1);
            int num = saleService.updateSaleInfo(sale, sale.getSalesInfoId());
            foodTraceService.setSale(new FoodTraceSetSaleInputBO(sale.getSalesInfoId(), hash));
            if (num == 1) {
                return Result.ok().data("msg", "更新成功").data("info", sale);
            } else {
                return Result.error().data("errMsg", "更新失败");
            }
        } catch (Exception e) {
            return Result.error().data("errMsg", "更新失败");
        }
    }

}
