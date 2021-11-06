package cn.gson.room_store.model.pojos.secondary;

import lombok.Data;

import java.util.Date;

@Data
public class Secondary {
   private int secondaryId;//序号
   private String secondaryNumber;//房源编号
   private String secondaryCity;//城市/区域
   private String secondaryVillage;//小区名称
   private String secondaryFloor;//总楼层
   private String secondaryLayer;//所在层
   private String secondaryUnit;//单元
   private String secondaryBuilding;//楼栋
   private String secondaryRoom;//房号
   private int secondaryArea;//建筑面积
   private int secondaryWithin;//套内面积
   private String secondaryModel;//户型
   private String secondaryToward;//朝向
   private int secondaryYear;//建筑年代
   private String secondaryUse;//房屋用途
   private String secondaryLadder;//梯户比例
   private String secondaryElevator;//有无电梯
   private String secondaryCover;//封面照片
   private String secondaryBack;//封底照片
   private String secondaryPage;//权属页照片
   private String secondaryFamily;//户型页照片
   private String secondaryTitle;//出售标题
   private double secondaryPrice;//价格
   private String secondaryType;//装修类型
   private String secondaryAccess;//房源获取渠道
   private String secondaryLable;//房屋标签
   private String secondaryPower;//权力性质
   private String secondaryRights;//产权年限
   private String secondaryBuy;//购买年限
   private String secondaryOnly;//是否唯一
   private String secondaryHousing;//房屋介绍
   private String secondaryCommunity;//小区介绍
   private String secondarySchool;//附近学校
   private String secondaryAdvantage;//房源优势
   private String secondaryOwner;//业主心态
   private int secondaryState;//上下架状态
   private int secondaryPoolsAccess;//公房池状态
   private Date secondaryAvailability;//房源发布时间
   private int goodRoom; //好房外键
   private int userId;//用户外键
}
