//package com.ecommerceapi.ecommerce.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/api/v1/orders")
//public class OrderController {
//
//    @CrossOrigin
//    @RequestMapping(value="/initiate", method= RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity orders_initiate(
//            @RequestBody OrderInitiateMap initiateMap,
//            @RequestHeader UserTokenMap tokenMap) throws NullAccessTokenException, NotValidAccessTokenException {
//
//
//        if (!tokenMap.validateAuthorization()) {
//            // 토큰이 null로 옴
//            throw new NullAccessTokenException();
//        }
//
//        if (!tokenMap.validateAccessToken()) {
//            // 토큰이 유효하지 않음
//            throw new NotValidAccessTokenException();
//        }
//
//        String merchantUid = UUID.randomUUID().toString();
//        String accessToken = tokenMap.getAccessToken();
//
//
//        initiateMap.getOrder();
//
//        Object order = JsonObject.get("order");
//
//        Gson gson = new Gson();
//
//        String jsonString_temp = gson.toJson(order);
//
//        JsonParser jparser = new JsonParser();
//
//        JsonElement jsonElement = jparser.parse(jsonString_temp);
//
//        JsonArray jsonArray = jsonElement.getAsJsonObject().get("orderItems").getAsJsonArray();
//
//        List<HashMap<String,String>> itemsList = new ArrayList<>();
//
//        for(int i = 0; i < jsonArray.size(); i++) {
//            JsonObject jsonObject =(JsonObject) jsonArray.get(i);
//            HashMap<String,String> temp = new HashMap<String,String>();
//            String productId = (jsonObject.get("productId")).getAsString();
//            String optionId = jsonObject.get("optionId").getAsString();
//            String referer = jsonObject.get("referer").getAsString();
//            String SId = jsonObject.get("SId").getAsString();
//            // referer 추가 로직
//            temp.put("productId", productId);
//            temp.put("optionId", optionId);
//            temp.put("referer", referer);
//            temp.put("SId", SId);
//            itemsList.add(temp);
//        }
//
//        // json parsing 끝
//
//        String userId = userService.getUserIdFromAccessToken(accessToken);
//        String platformType = userService.getPlatformTypeFromAccessToken(accessToken);
//
//        int orderId = orderService.selectNextOrderId();
//
//        for (HashMap<String, String> oneItem : itemsList) {
//
//            String stringProductId = oneItem.get("productId");
//            String stringProductOptionId = oneItem.get("optionId");
//            String stringReferer = oneItem.get("referer");
//            String stringSId = oneItem.get("SId");
//
//            if(stringProductId==null || "".contentEquals(stringProductId) || stringProductOptionId==null || "".contentEquals(stringProductOptionId)) {
//                throw new NullProductIdOptionIdException();
//            }
//
//            int productId = Integer.parseInt(stringProductId);
//            int productOptionId = Integer.parseInt(stringProductOptionId);
//
//            // 이미 구매한 상품인지 아닌지 체크
//            ProductOptionVO option = optionService.selectOne(productOptionId);
//
//            // order_map
//            HashMap<String, Object> order_map = new HashMap<String, Object>();
//
//            order_map.put("productId", productId);
//            order_map.put("productOptionId", productOptionId);
//            order_map.put("merchantUid", merchantUid);
//
//            int originalPrice = option.getOriginalPrice();
//            int salePrice = option.getSalePrice();// 나중에 쿠폰이나 포인트를 추가한 계산 알고리즘 만들 예정...ㅠㅠ
//            order_map.put("originalPrice", originalPrice);
//            order_map.put("salePrice", salePrice);
//            order_map.put("userId", userService.getUserIdFromAccessToken(accessToken));
//            order_map.put("platformType", userService.getPlatformTypeFromAccessToken(accessToken));
//            order_map.put("personalPdfUrl", option.getPdfUrl()); // 쿼리 덜하기 위해 임시로 저장해둠...
//            // 각각 다른 url을 가져온다.
//
//            // order initiate하면 아직 결제 대기중인 상태니까 status를 자동으로 "결제 대기"로 저장한다.
//            String orderType1 = "결제 대기";
//            order_map.put("status", orderType1);
//            order_map.put("orderId", orderId);
//            // referer 추가
//            order_map.put("referer", stringReferer);
//            order_map.put("SId", stringSId);
//            int orderItemId = orderService.insertRow(order_map);
//            // insert하고,
//
//            ProductVO product = productService.selectOne(productId);
//
//            int productCategoryId = product.getProductCategoryId();
//
//            HashMap<String, Object> tmp_order_map = new HashMap<String, Object>();
//
//            tmp_order_map.put("orderItemId", orderItemId);
//            tmp_order_map.put("productId", productId);
//            tmp_order_map.put("optionId", productOptionId);
//            tmp_order_map.put("categoryId", productCategoryId);
//            orderItems.add(tmp_order_map);
//
//        }
//
//        result_map.put("orderId", orderId);
//        result_map.put("merchantUid", merchantUid);
//        result_map.put("orderItems", orderItems);
//        result_map.put("status", "결제 대기");
//        return result_map;
//    }
//}
