package com.attendance.response;

import com.google.gson.annotations.SerializedName;

public class AttendannceResponse {

    @SerializedName("Success")
    private Integer successCode;

    @SerializedName("error")
    private error error;

    public AttendannceResponse(Integer successCode, com.attendance.response.error error) {
        this.successCode = successCode;
        this.error = error;
    }

    public Integer getSuccessCode() {
        return successCode;
    }

    public com.attendance.response.error getError() {
        return error;
    }

    public String getType(){
        return error.getType();
    }

    public String getMessage(){
        return error.getMessage();
    }

}

class error {

    @SerializedName("Type")
    private String type;

    @SerializedName("Message")
    private String message;

    public error(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
