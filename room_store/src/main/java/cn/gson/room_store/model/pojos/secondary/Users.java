package cn.gson.room_store.model.pojos.secondary;

public class Users {
    //用户id
    private int userID;
    //用户名
    private String userName;
    //用户电话号码
    private String userPhone;
    //账号密码
    private String userPass;
    //修改密码用
    private String userPass2;
    //店铺名
    private String userShopName;
    //用户头像
    private String userPortait;
    //用户卡片
    private String userCard;
    //用户所在省
    private String userProvince;
    //用户所在市
    private String userCity;


    public String getUserPass2() {
        return userPass2;
    }

    public void setUserPass2(String userPass2) {
        this.userPass2 = userPass2;
    }
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserShopName() {
        return userShopName;
    }

    public void setUserShopName(String userShopName) {
        this.userShopName = userShopName;
    }

    public String getUserPortait() {
        return userPortait;
    }

    public void setUserPortait(String userPortait) {
        this.userPortait = userPortait;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }
}
