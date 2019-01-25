package com.aiprous.medicoboxpharmacist.utils;


public class APIConstant {

    //API BASE URL
    public static String LOGIN = "http://user8.itsindev.com/medibox/API/login.php";
    public static String OTP_REGISTER = "http://user8.itsindev.com/medibox/API/otp-register.php";
    public static String REGISTER = "http://user8.itsindev.com/medibox/API/register.php";
    public static String VERIFY_OTP = "http://user8.itsindev.com/medibox/API/verify-register-otp.php";
    public static String GETUSERINFO = "http://user8.itsindev.com/medibox/API/customer_self.php";
    public static String ADD_DELIVERY_BOY = "http://user8.itsindev.com/medibox/API/delivery-boy/add-new.php";
    public static String DELIVERY_BOY_LISTING = "http://user8.itsindev.com/medibox/API/delivery-boy/listing.php";
    public static String PRODUCT_LIST = "http://user8.itsindev.com/medibox/API/seller_products.php";
    public static String ORDER = "http://user8.itsindev.com/medibox/API/seller-sales-orders.php";
    public static String ASSIGN_DELIVERY_BOY = "http://user8.itsindev.com/medibox/API/assign_deliverboy.php";
    public static String ORDER_INVOICE = "http://user8.itsindev.com/medibox/API/order-invoice.php";
    public static String SELLER_PRODUCT_UPDATE = "http://user8.itsindev.com/medibox/API/seller_product_qty_update_api.php";
    public static String GET_ORDER_INVOICE = "http://user8.itsindev.com/medibox/API/get-order-invoices.php";

    //Response Status Code
    public static final int SUCCESS_CODE = 200;
    /*For Sweet alert*/
    public static final int ERROR_TYPE = 1;
    public static final int SUCCESS_TYPE = 2;
    public static final int WARNING_TYPE = 3;
    public static final int PROGRESS_TYPE = 4;
    public static final String SOME_THING_WENT_WRONG = "Oops! Something went wrong!";
    public static String Authorization = "Authorization";
    public static String BEARER = "Bearer ";
}

