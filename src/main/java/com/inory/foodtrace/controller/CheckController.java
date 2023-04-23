package com.inory.foodtrace.controller;

import cn.hutool.json.JSONUtil;
import com.inory.foodtrace.entity.*;
import com.inory.foodtrace.service.*;
import com.inory.foodtrace.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * The type Check controller.
 *
 * @author inory
 * @create 2021 -07-21 18:01
 */

@RestController
@RequestMapping("/api/check")
@Api(tags = {"Check"})
public class CheckController {

    @Resource
    CheckService checkService;

    @Resource
    FarmService farmService;

    @Resource
    ButcherService butcherService;

    @Resource
    TransportService transportService;

    @Resource
    SaleService saleService;

    @ApiOperation(value = "养殖场信息变更申请存入数据库")
    @PostMapping("farmInfo")
    public Result setFarmCheckInfo(@RequestBody Farm farm) {
        Check check = new Check();
        farm.setHash(null);
        check.setInfo(JSONUtil.toJsonStr(farm));
        check.setId(farm.getPigId());
        check.setState(0);
        try {
            checkService.insertCheck(check);
            int num = farmService.updateFarmStateInfo(farm.getPigId(), 0);
            if (num == 1) {
                return Result.ok().data("info", "审核信息插入成功,更新审核状态成功");
            } else {
                return Result.ok().data("info", "更新审核状态失败");
            }
        } catch (Exception e) {
            return Result.error().data("info", "插入失败");
        }
    }

    @ApiOperation(value = "屠宰场信息变更申请存入数据库")
    @PostMapping("butcherInfo")
    public Result setButcherCheckInfo(@RequestBody Butcher butcher) {
        Check check = new Check();
        butcher.setHash(null);
        check.setInfo(JSONUtil.toJsonStr(butcher));
        check.setId(butcher.getPigId());
        check.setState(0);
        try {
            checkService.insertCheck(check);
            int num = butcherService.updateSButcherStateInfo(butcher.getPigId(), 0);
            if (num == 1) {
                return Result.ok().data("info", "审核信息插入成功,更新审核状态成功");
            } else {
                return Result.ok().data("info", "更新审核状态失败");
            }
        } catch (Exception e) {
            return Result.error().data("info", "插入失败");
        }
    }

    @ApiOperation(value = "物流信息变更申请存入数据库")
    @PostMapping("transportInfo")
    public Result setTransportCheckInfo(@RequestBody Transport transport) {
        Check check = new Check();
        transport.setHash(null);
        check.setInfo(JSONUtil.toJsonStr(transport));
        check.setId(transport.getTransportId());
        check.setState(0);
        try {
            checkService.insertCheck(check);
            int num = transportService.updateTransportStateInfo(transport.getTransportId(), 0);
            if (num == 1) {
                return Result.ok().data("info", "审核信息插入成功,更新审核状态成功");
            } else {
                return Result.ok().data("info", "更新审核状态失败");
            }
        } catch (Exception e) {
            return Result.error().data("info", "插入失败");
        }
    }

    @ApiOperation(value = "销售信息变更申请存入数据库")
    @PostMapping("saleInfo")
    public Result setSaleCheckInfo(@RequestBody Sale sale) {
        Check check = new Check();
        sale.setHash(null);
        check.setInfo(JSONUtil.toJsonStr(sale));
        check.setId(sale.getSalesInfoId());
        check.setState(0);
        try {
            checkService.insertCheck(check);
            int num = saleService.updateSaleStateInfo(sale.getSalesInfoId(), 0);
            if (num == 1) {
                return Result.ok().data("info", "审核信息插入成功,更新审核状态成功");
            } else {
                return Result.ok().data("info", "更新审核状态失败");
            }
        } catch (Exception e) {
            return Result.error().data("info", "插入失败");
        }
    }

    @ApiOperation(value = "查询所有的审核信息")
    @GetMapping("checkInfo")
    public Result getCheckInfo() {
        List<Check> checks = checkService.selectCheck();
        return Result.ok().data("info", "查询成功").data("list", checks);
    }

    @ApiOperation(value = "变更审核状态信息")
    @GetMapping("confirmInfo")
    public Result confirmInfo(@RequestParam String id) {
        checkService.updateCheck(id, 1);
        return Result.ok().data("info", "审核成功");
    }

}
