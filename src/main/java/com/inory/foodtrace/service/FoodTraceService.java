package com.inory.foodtrace.service;

import com.inory.foodtrace.constants.ContractConstants;
import com.inory.foodtrace.model.bo.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor;
import org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@NoArgsConstructor
@Data
public class FoodTraceService {
    AssembleTransactionProcessor txProcessor;
    @Value("${contract.foodTraceAddress}")
    private String address;
    @Autowired
    private Client client;

    @PostConstruct
    public void init() throws Exception {
        this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
    }

    public TransactionResponse getFarm(FoodTraceGetFarmInputBO input) throws Exception {
        return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.FoodTraceAbi, "getFarm", input.toArgs());
    }

    public TransactionResponse setButchery(FoodTraceSetButcheryInputBO input) throws Exception {
        return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.FoodTraceAbi, "setButchery", input.toArgs());
    }

    public TransactionResponse setTransport(FoodTraceSetTransportInputBO input) throws Exception {
        return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.FoodTraceAbi, "setTransport", input.toArgs());
    }

    public TransactionResponse setSale(FoodTraceSetSaleInputBO input) throws Exception {
        return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.FoodTraceAbi, "setSale", input.toArgs());
    }

    public TransactionResponse getButchery(FoodTraceGetButcheryInputBO input) throws Exception {
        return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.FoodTraceAbi, "getButchery", input.toArgs());
    }

    public TransactionResponse getTransport(FoodTraceGetTransportInputBO input) throws Exception {
        return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.FoodTraceAbi, "getTransport", input.toArgs());
    }

    public TransactionResponse getSale(FoodTraceGetSaleInputBO input) throws Exception {
        return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.FoodTraceAbi, "getSale", input.toArgs());
    }

    public TransactionResponse setFarm(FoodTraceSetFarmInputBO input) throws Exception {
        return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.FoodTraceAbi, "setFarm", input.toArgs());
    }
}
