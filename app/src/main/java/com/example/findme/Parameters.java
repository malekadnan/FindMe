package com.example.findme;

public class Parameters {

    static Boolean isLogin = false;
    static Boolean isProf = false;

    public static Boolean getIsLogin() {
        return isLogin;
    }

    public static void setIsLogin(Boolean isLogin) {
        Parameters.isLogin = isLogin;
    }

    public static Boolean getIsProf() {
        return isProf;
    }

    public static void setIsProf(Boolean isProf) {
        Parameters.isProf = isProf;
    }
}
