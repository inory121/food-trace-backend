package com.inory.foodtrace;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodTraceApplicationTests {

//    @Resource
//    UserService userService;
//
//    @Resource
//    UserMapper userMapper;
//
//    @Resource
//    FarmService farmService;

//    @Test
//    void contextLoads() {
////        int num = userService.selectUserByNameAndPwd("zhangsan", "12");
////        System.out.println(num);
//        User user = new User();
//        user.setName("sakura");
//        user.setPassword("123");
//        user.setRole("supervision");
//        user.setPermission("supervision");
//
//        userMapper.insert(user);
//    }
//
//    @Test
//    void testJWT() {
//        Map<String, Claim> stringClaimMap = JWTUtil.verifyToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJBUFAiLCJ1c2VyX2lkIjoiMTQxODA5NDg0ODkyNTIzNzI0OSIsImlzcyI6IlNlcnZpY2UiLCJleHAiOjE2Mjc4MDI0ODIsImlhdCI6MTYyNjkzODQ4Mn0.y7zivVSdYYS32fSMsVWf0sk8hPdkyWwBAFoo8ylYexo");
//        System.out.println(stringClaimMap.get("user_id"));
//
//    }
//
//    @Test
//    void testID() {
//        User user = userMapper.selectOne(new QueryWrapper<User>().eq("name", "inory").eq("password", "222"));
//        System.out.println(user);
//    }
//
//    @Test
//    void testMem() {
//        System.out.println("max" + Runtime.getRuntime().maxMemory() / (double) 1024 / 1024);
//        System.out.println("total" + Runtime.getRuntime().totalMemory() / (double) 1024 / 1024);
//    }
//
//    @Test
//    void testAll() {
//        Farm farm = farmService.selectFarmInfo("2");
//        System.out.println(farm.toString());
//
//    }

    //
//    @Test
//    void testTo() {
//        Farm farm = new Farm();
//        System.out.println(farm.toString());
//    }
//    @Resource
//    CheckService checkService;
//    @Resource
//    UserService userService;

    //    @Resource
//    HelloWorldService helloWorldService;
//
//    @Test
//    public void testCrypto() {
//        CryptoSuite cryptoSuite = new CryptoSuite(CryptoType.ECDSA_TYPE);
//        // 使用cryptoSuite调用hash算法，返回十六进制哈希字符串
//        String hash = cryptoSuite.hash("123");
//        System.out.println(hash.length());
//    }
//
//    @Test
//    public void testT() throws Exception {
//        String values = helloWorldService.get().getValues();
//        System.out.println(values);
//    }
//    @Resource
//    FarmService farmService;
//
//    @Test
//    void testQRcode() {
//        String code = Base64.encode("{\"pigId\":1,\"transportId\":21,\"saleInfoId\":31}");
//        System.out.println(code);
//        // 生成指定url对应的二维码到文件，宽和高都是300像素
//        QrCodeUtil.generate(code, 300, 300, FileUtil.file("d:/qrcode.jpg"));
//        String code2 = QrCodeUtil.decode(FileUtil.file("D:/qrcode.jpg"));
//        System.out.println(code2);
//    }
//
//    @Test
//    void testCheck() {
////        checkService.insertCheck(new Check("1", "111", 0));
////        userService.insertUser(new User(1L, "a", "a", "a", "a"));
////        checkService.updateCheck("1");
//    }

//    @Autowired
//    FoodTraceService foodTraceService;
//
//    @Test
//    void test() {
//        try {
//            Credential cred = new Credential("AKID3wZv0pOeeOq1vYv1pMefPs51g4B1buwi", "WljRr0sSmpb6KHxMVN0MSIsBDzUEhtoS");
//            CvmClient client = new CvmClient(cred, "ap-shanghai");
//            DescribeInstancesRequest req = new DescribeInstancesRequest();
//            DescribeInstancesResponse resp = client.DescribeInstances(req);
//            System.out.println(DescribeInstancesResponse.toJsonString(resp));
//        } catch (TencentCloudSDKException e) {
//            System.out.println(e.toString());
//        }
//    }

//    @Test
//    void test2() throws Exception {
//        String values = foodTraceService.getTransport(new FoodTraceGetTransportInputBO("4271359911")).getValues();
//        System.out.println(values);
//    }

}
