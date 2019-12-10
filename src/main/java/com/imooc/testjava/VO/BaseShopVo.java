package com.imooc.testjava.VO;

import lombok.Data;

import java.util.List;

/**
 * @author : jack sd
 * @date : 2019/12/9
 */
@Data
public class BaseShopVo {
    private String plat;
    private String name;
    private String province;
    private String city;
    private String area;
    private String address;
    private String tel;
    private String soldNum;
    private String lnt;
    private String lat;
    private String logo;
    private String startCost;
    private String carryTime;
    private String carryCost;
    private String carryCostType;
    private String carryType;
    private String score;
    private String class0;
    private String class1;
    private String class2;
    private String class3;
    private String state;
    private String updateTime;
    private String updateDate;
    private String activity1;
    private String isNew;
    private String topFoodName;
    private String topFoodLogo;
    private String topFoodPrice;
    private String topFoodSoldNum;
    private String openTime;
    private String foodScore;
    private String commentNum;
    private String avgPrice;
    private String serverScore;
    private String packagePrices;
    private String avgPackagePrice;
    private String activity;
    private String products;

    public BaseShopVo() {
    }
    public BaseShopVo(List<Object> lo) {
        this.plat = lo.get(0) == null ? "" : lo.get(0).toString();
        this.name = lo.get(1) == null ? "" : lo.get(1).toString();
        this.province = lo.get(2) == null ? "" : lo.get(2).toString();
        this.city = lo.get(3) == null ? "" : lo.get(3).toString();
        this.area = lo.get(4) == null ? "" : lo.get(4).toString();
        this.address = lo.get(5) == null ? "" : lo.get(5).toString();
        this.tel = lo.get(6) == null ? "" : lo.get(6).toString();
        this.soldNum = lo.get(7) == null ? "" : lo.get(7).toString();
        this.lnt = lo.get(8) == null ? "" : lo.get(8).toString();
        this.lat = lo.get(9) == null ? "" : lo.get(9).toString();
        this.logo = lo.get(10) == null ? "" : lo.get(10).toString();
        this.startCost = lo.get(11) == null ? "" : lo.get(11).toString();
        this.carryTime = lo.get(12) == null ? "" : lo.get(12).toString();
        this.carryCost = lo.get(13) == null ? "" : lo.get(13).toString();
        this.carryCostType = lo.get(14) == null ? "" : lo.get(14).toString();
        this.carryType = lo.get(15) == null ? "" : lo.get(15).toString();
        this.score = lo.get(16) == null ? "" : lo.get(16).toString();
        this.class0 = lo.get(17) == null ? "" : lo.get(17).toString();
        this.class1 = lo.get(18) == null ? "" : lo.get(18).toString();
        this.class2 = lo.get(19) == null ? "" : lo.get(19).toString();
        this.class3 = lo.get(20) == null ? "" : lo.get(20).toString();
        this.state = lo.get(21) == null ? "" : lo.get(21).toString();
        this.updateTime = lo.get(22) == null ? "" : lo.get(22).toString();
        this.updateDate = lo.get(23) == null ? "" : lo.get(23).toString();
        this.activity1 = lo.get(24) == null ? "" : lo.get(24).toString();
        this.isNew = lo.get(25) == null ? "" : lo.get(25).toString();
        this.topFoodName = lo.get(26) == null ? "" : lo.get(26).toString();
        this.topFoodLogo = lo.get(27) == null ? "" : lo.get(27).toString();
        this.topFoodPrice = lo.get(28) == null ? "" : lo.get(28).toString();
        this.topFoodSoldNum = lo.get(29) == null ? "" : lo.get(29).toString();
        this.openTime = lo.get(30) == null ? "" : lo.get(30).toString();
        this.foodScore = lo.get(31) == null ? "" : lo.get(31).toString();
        this.commentNum = lo.get(32) == null ? "" : lo.get(32).toString();
        this.avgPrice = lo.get(33) == null ? "" : lo.get(33).toString();
        this.serverScore = lo.get(34) == null ? "" : lo.get(34).toString();
        this.packagePrices = lo.get(35) == null ? "" : lo.get(35).toString();
        this.avgPackagePrice = lo.get(36) == null ? "" : lo.get(36).toString();
        this.activity = lo.get(37) == null ? "" : lo.get(37).toString();
        this.products = lo.get(38) == null ? "" : lo.get(38).toString();
    }
}
