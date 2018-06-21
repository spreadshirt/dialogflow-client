package com.dialogflow.client.model;

public class GoogleRequestUser {

    // TOOD - lastSeen to Date
    private String lastSeen;
    private String locale;
    private String userId;


    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GoogleRequestUser{");
        sb.append("lastSeen='").append(lastSeen).append('\'');
        sb.append(", locale='").append(locale).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
