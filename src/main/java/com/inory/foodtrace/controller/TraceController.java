package com.inory.foodtrace.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.inory.foodtrace.entity.Butcher;
import com.inory.foodtrace.entity.Farm;
import com.inory.foodtrace.entity.Sale;
import com.inory.foodtrace.entity.Transport;
import com.inory.foodtrace.model.bo.FoodTraceGetButcheryInputBO;
import com.inory.foodtrace.model.bo.FoodTraceGetFarmInputBO;
import com.inory.foodtrace.model.bo.FoodTraceGetSaleInputBO;
import com.inory.foodtrace.model.bo.FoodTraceGetTransportInputBO;
import com.inory.foodtrace.service.*;
import com.inory.foodtrace.utils.CryptoUtil;
import com.inory.foodtrace.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * The type Trace controller.
 *
 * @author inory
 * @create 2021-08-05 16:43
 */
@RestController
@RequestMapping("/api/foodtrace")
@Api(tags = {"Trace"})
public class TraceController {

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

    @PostMapping("getInfo")
    @ApiOperation(value = "Extract info from QRCode")
    public Result getInfo(@RequestParam("file") MultipartFile file) throws IOException {
        String code = QrCodeUtil.decode(file.getInputStream());
        JSONObject jsonObject = JSONUtil.parseObj(Base64.decodeStr(code));
        Farm farm = farmService.selectFarmInfo(jsonObject.getStr("pigId"));
        Butcher butcher = butcherService.selectButcherInfo(jsonObject.getStr("pigId"));
        Transport transport = transportService.selectTransportInfo(jsonObject.getStr("transportId"));
        Sale sale = saleService.selectSaleInfo(jsonObject.getStr("saleInfoId"));
        Map<Object, Object> map = MapUtil.of(new Object[][]{
                {"farm", farm},
                {"butcher", butcher},
                {"transport", transport},
                {"sale", sale}
        });
        return Result.ok().data("info", map);
    }

    @GetMapping("getFarm")
    public String getFarm(@RequestParam String pigId) throws Exception {
        return foodTraceService.getFarm(new FoodTraceGetFarmInputBO(pigId)).getValues();
    }

    @GetMapping("getButchery")
    public String getButchery(@RequestParam String pigId) throws Exception {
        return foodTraceService.getButchery(new FoodTraceGetButcheryInputBO(pigId)).getValues();
    }

    @GetMapping("getTransport")
    public String getTransport(@RequestParam String transportId) throws Exception {
        return foodTraceService.getTransport(new FoodTraceGetTransportInputBO(transportId)).getValues();
    }

    @GetMapping("getSale")
    public String getSale(@RequestParam String salesInfoId) throws Exception {
        return foodTraceService.getSale(new FoodTraceGetSaleInputBO(salesInfoId)).getValues();
    }

    @PostMapping("trace")
    @ApiOperation(value = "Trace food and verify the reality of info")
    public Result trace(@ApiParam(value = "猪肉编号", required = true) @RequestParam String pigId,
                        @ApiParam(value = "物流编号", required = true) @RequestParam String transportId,
                        @ApiParam(value = "销售编号", required = true) @RequestParam String salesInfoId) throws Exception {
        if (StringUtils.isAllEmpty(pigId, transportId, salesInfoId)) {
            return Result.error().data("errMsg", "上传的图片不正确,找不到相关信息");
        }
        String farmHash = foodTraceService.getFarm(new FoodTraceGetFarmInputBO(pigId))
                .getValues().replaceAll("[\\[\\]\"]", "");
        String butcheryHash = foodTraceService.getButchery(new FoodTraceGetButcheryInputBO(pigId))
                .getValues().replaceAll("[\\[\\]\"]", "");
        String transportHash = foodTraceService.getTransport(new FoodTraceGetTransportInputBO(transportId))
                .getValues().replaceAll("[\\[\\]\"]", "");
        String salesHash = foodTraceService.getSale(new FoodTraceGetSaleInputBO(salesInfoId))
                .getValues().replaceAll("[\\[\\]\"]", "");
        ArrayList<String> blockList = ListUtil.toList(farmHash, butcheryHash, transportHash, salesHash);
        String newFarmHash = CryptoUtil.crypto(farmService.selectFarmInfo(pigId).toString());
        String newButcherHash = CryptoUtil.crypto(butcherService.selectButcherInfo(pigId).toString());
        String newTransportHash = CryptoUtil.crypto(transportService.selectTransportInfo(transportId).toString());
        String newSalesHash = CryptoUtil.crypto(saleService.selectSaleInfo(salesInfoId).toString());
        ArrayList<String> sqlList = ListUtil.toList(newFarmHash, newButcherHash, newTransportHash, newSalesHash);
        return Result.ok().data("blockList", blockList).data("sqlList", sqlList);
    }

    @PostMapping("QRCode")
    @ApiOperation(value = "GenerateQRCode with pigId and transportId and salesInfoId")
    public Result generateQRCode(@ApiParam(value = "猪肉编号", required = true) @RequestParam String pigId,
                                 @ApiParam(value = "物流编号", required = true) @RequestParam String transportId,
                                 @ApiParam(value = "销售编号", required = true) @RequestParam String salesInfoId) {
        String info = "{\"pigId\":" + pigId + ",\"transportId\":" + transportId + ",\"saleInfoId\":" + salesInfoId + "}";
        String code = Base64.encode(info);
        QrCodeUtil.generate(code, 300, 300, FileUtil.file("d:/qrcode.jpg"));
        String code2 = QrCodeUtil.decode(FileUtil.file("d:/qrcode.jpg"));
        return Result.ok().data("info", info);
    }
}
