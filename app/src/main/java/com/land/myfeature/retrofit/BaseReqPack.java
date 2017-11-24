package com.land.myfeature.retrofit;

import java.io.Serializable;


/**
 * Created by nikai on 2017-08-21.
 * Description:
 */

public class BaseReqPack implements Serializable {

    private static final String TAG = "BaseReqPack";

    //Common Params
    private String cmdId;
    private String version;
    private String outSystemId;
    private String requestId;
    private String requestDate;
    private String requestTime;
    private String checkValue;


//    public void genBaseParam(TransType transType, String terminalSn) {
//        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US).format(new Date());
//        String strDate = timeStamp.substring(0, 8);
//        String strTime = timeStamp.substring(8, 14);
//
//        cmdId = transType.getCmdId();
//
//        requestId = "P" + terminalSn + timeStamp;
//        requestDate = strDate;
//        requestTime = strTime;
//
//        if (BuildConfig.DEBUG) {
//            version = PosParam.DEBUG_PACK_VERSION;
//            outSystemId = PosParam.DEBUG_PACK_OUT_SYSTEM_ID;
//        } else {
//            version = PosParam.RELEASE_PACK_VERSION;
//            outSystemId = PosParam.RELEASE_PACK_OUT_SYSTEM_ID;
//        }
//
//    }
//
//
//    public void genCheckValue() {
//        LogUtils.d("land", "start sign");
//
//        String keyStoreFileName;
//        String alias;
//        String password;
//        String md5Salt;
//        String checkValue = null;
//
//        if (BuildConfig.DEBUG) {
//            keyStoreFileName = PosParam.DEBUG_PACK_BKS_FILE_NAME;
//            alias = PosParam.DEBUG_PACK_BKS_FILE_ALIAS;
//            password = PosParam.DEBUG_PACK_BKS_FILE_ALIAS_PWD;
//            md5Salt = PosParam.DEBUG_PACK_SIGN_MD5_SALT;
//        } else {
//            keyStoreFileName = PosParam.RELEASE_PACK_BKS_FILE_NAME;
//            alias = PosParam.RELEASE_PACK_BKS_FILE_ALIAS;
//            password = PosParam.RELEASE_PACK_BKS_FILE_ALIAS_PWD;
//            md5Salt = PosParam.RELEASE_PACK_SIGN_MD5_SALT;
//        }
//
//        LogUtils.d(TAG, "keyStoreFileName:" + keyStoreFileName);
//        LogUtils.d(TAG, "alias:" + alias);
//        LogUtils.d(TAG, "password:" + password);
//        LogUtils.d(TAG, "md5Salt:" + md5Salt);
//
//        String tmpString = buildPlainText();
//        LogUtils.d("land", "buildPlainText:" + tmpString);
//
//        try {
//            checkValue = SignUtils.signWithBksFileName(tmpString, md5Salt,
//                    keyStoreFileName, alias, password);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        this.checkValue = checkValue;
//    }
//
//
//    private String buildPlainText() {
//        String plainStr = "";
//        try {
//            plainStr = JsonUtils.sortBeanValueString(this,
//                    "checkValue");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return plainStr;
//    }

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

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }
}
