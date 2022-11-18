package com.e.mademvvm.mvvmnews.baseurltihuan.bean;

import java.io.Serializable;

public  class BaseHttpEntity {
    public void setLoginForAccessTokenEntity(LoginForAccessTokenEntity loginForAccessTokenEntity) {
        this.loginForAccessTokenEntity = loginForAccessTokenEntity;
    }

    public BaseHttpEntity(LoginForAccessTokenEntity loginForAccessTokenEntity) {
        this.loginForAccessTokenEntity = loginForAccessTokenEntity;
    }

    public  LoginForAccessTokenEntity loginForAccessTokenEntity;
  public  class  LoginForAccessTokenEntity  implements Serializable

    {
        private  String  userid;
        private String  username;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
