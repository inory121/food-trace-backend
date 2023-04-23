pragma solidity ^0.4.25;

contract FoodTrace {
struct Farm {
    string pigId;
    string hash;
}

struct Butchery {
    string pigId;
    string hash;
}

struct Transport {
    string transportId;
    string hash;
}

struct Sale {
    string saleInfoId;
    string hash;
}

mapping(string => Farm) farmMap;
mapping(string => Butchery) butcheryMap;
mapping(string => Transport) transportMap;
mapping(string => Sale) saleMap;

function setFarm(string pigId, string hash) public {
    Farm memory farm = Farm(pigId, hash);
    farmMap[pigId] = farm;
}

function getFarm(string pigId) public returns (string){
    return farmMap[pigId].hash;
}

function setButchery(string pigId, string hash) public {
    Butchery memory butchery = Butchery(pigId, hash);
    butcheryMap[pigId] = butchery;
}

function getButchery(string pigId) public returns (string){
    return butcheryMap[pigId].hash;
}

function setTransport(string transportId, string hash) public {
    Transport memory transport = Transport(transportId, hash);
    transportMap[transportId] = transport;
}

function getTransport(string transportId) public returns (string){
    return transportMap[transportId].hash;
}

function setSale(string saleInfoId, string hash) public {
    Sale memory sale = Sale(saleInfoId, hash);
    saleMap[saleInfoId] = sale;
}

function getSale(string saleInfoId) public returns (string){
    return saleMap[saleInfoId].hash;
}
}