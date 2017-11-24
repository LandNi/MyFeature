package com.land.myfeature.retrofit;

import java.io.Serializable;

/**
 * Created by nikai on 2017-08-22.
 * Description:
 */

public class BaseRespPack implements Serializable {

    private static final String TAG = "BaseRespPack";

    //Base Elements
    private String cmdId;
    private String version;
    private String outSystemId;
    private String requestId;
    private String requestDate;
    private String requestTime;
    private String rcfpTxnSeq;
    private String rcfpDate;
    private String rcfpTime;
    private String responseCode;
    private String responseMessage;
    private String checkValue;


    public String getCmdId() {
        return cmdId;
    }

    public void setCmdId(String cmdId) {
        this.cmdId = cmdId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOutSystemId() {
        return outSystemId;
    }

    public void setOutSystemId(String outSystemId) {
        this.outSystemId = outSystemId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getRcfpTxnSeq() {
        return rcfpTxnSeq;
    }

    public void setRcfpTxnSeq(String rcfpTxnSeq) {
        this.rcfpTxnSeq = rcfpTxnSeq;
    }

    public String getRcfpDate() {
        return rcfpDate;
    }

    public void setRcfpDate(String rcfpDate) {
        this.rcfpDate = rcfpDate;
    }

    public String getRcfpTime() {
        return rcfpTime;
    }

    public void setRcfpTime(String rcfpTime) {
        this.rcfpTime = rcfpTime;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }
}
