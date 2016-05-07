package com.hytx.util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * SHA加密工具
 * @author YangJiang
 * @time   2015年9月8日 上午11:01:18
 */
public class ToolSecuritySHA {
    public static final String KEY_SHA = "SHA";
    public static final String KEY_MD5 = "MD5";


    /**
     * MD5加密字节
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(data);
        return md5.digest();

    }

    /**
     * SHA加密字节
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] data) throws Exception {
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        sha.update(data);
        return sha.digest();
    }


    /**
     * SHA加密
     *
     * @param inputStr
     * @return
     */
    public static String shaEncrypt(String inputStr) {
        byte[] inputData = inputStr.getBytes();
        String returnString = "";
        try {
            inputData = encryptSHA(inputData);
            for (int i = 0; i < inputData.length; i++) {
                returnString += byteToHexString(inputData[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnString;
    }


    private static String byteToHexString(byte ib) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
                'b', 'c', 'd', 'e', 'f'};
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];

        String s = new String(ob);

        return s;
    }

    /**
     * MD5加密
     *
     * @param inputStr
     * @return
     */
    public static String md5Encrypt(String inputStr) {
        byte[] inputData = inputStr.getBytes();
        String returnString = "";
        try {
            BigInteger md5 = new BigInteger(encryptMD5(inputData));
            returnString = md5.toString(16);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnString;
    }

    public static String dataDecrypt(Map<String, Object> serviceParams) {
        StringBuilder sb = new StringBuilder();
        Object[] keys = serviceParams.keySet().toArray();
        Arrays.sort(keys);
        for (Object key : keys) {
        	sb.append(key).append(serviceParams.get(key));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	String key = "2442#qwq";
    	Map<String,Object> data = new HashMap<String,Object>();
    	data.put("appkey", "313131331");
    	data.put("method", "backward.order");
    	data.put("v", "1");
    	data.put("ruleType", "0");
    	data.put("productId", "111111");
		data.put("phoneNo", "18126424181");
		data.put("region", "1");
    }
}
