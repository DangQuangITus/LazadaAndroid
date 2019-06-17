
package com.example.mystore.ConnectInternet;

public class ApiUtils {
    //    public static String BASE_URL = "http://192.168.100.7:8000";
    public static String BASE_URL = "http://10.0.2.2:8000";

    public static ServiceGenerator getServiceGenerator() {
        return RetrofitClient.getClient(BASE_URL).create(ServiceGenerator.class);
    }
}
