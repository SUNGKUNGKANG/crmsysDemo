package com.sungkang.crmsys.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 信息摘要(Message Digest)工具.
 *
 * <p>
 *     使用：
 *     <code>
 *         String md5 = MsgDigestUtil.digest(text.getBytes(), MsgDigestUtil.MsgDigestAlgorithm.MD5, MsgDigestUtil.MsgDigestReturnType.STRING_TYPE);
 *     </code>
 * @author Askia
 * @version 1.1
 * @support www.argentoaskia.tech
 */

public class MsgDigestUtil {

    /**
     * 信息摘密返回值类型
     * @author askia
     * @version 1.1.1
     * @since 1.1
     */
    public enum MsgDigestReturnType{
        BYTES_TYPE(byte[].class),
        STRING_TYPE(String.class),
        INTEGER_TYPE(BigInteger.class);
        private Class<?> type;
        <T> MsgDigestReturnType(Class<T> type){

        }

        public String getTypeName(){
            String typeName = type.getTypeName();
            return typeName;
        }
        public String getSimpleName(){
            String simpleName = type.getSimpleName();
            return simpleName;
        }

        public Class<?> getType(){
            return type;
        }
    }

    /**
     * 信息摘密字节类型返回值
     * @deprecated 请使用更加规范的MsgDigestReturnType类返回
     * @since 1.1
     */
    @Deprecated
    public static final Class<byte[]> bytesType = byte[].class;

    /**
     * 信息摘密字符类型返回值
     * @deprecated 请使用更加规范的MsgDigestReturnType类返回
     * @since 1.1
     */
    @Deprecated
    public static final Class<String> stringType = String.class;

    /**
     * 摘密函数，关键
     * @deprecated 建议使用更加规范的{@link MsgDigestUtil#digest(byte[], MsgDigestAlgorithm, MsgDigestReturnType)}方法，此方法第三个参数非参数安全
     * @param data 待摘要的数据
     * @param algorithm 摘要算法定义集，常量，参考{@link MsgDigestAlgorithm}
     * @param returnType 返回的摘要数据的类型，提供一个{@link Class}对象，请使用{@link MsgDigestUtil#stringType}或者{@link MsgDigestUtil#bytesType}
     * @param <T> 摘要数据对象的泛型类型，根据传入的{@link Class}对象决定
     * @return 摘要数据，常见的有32位，64位，128位等，可能是16进制的Hash值，也可能是字符串值，或者其他自定义值
     */
    @Deprecated
    @SuppressWarnings("All")
    public static <T> T digest(byte[] data, MsgDigestAlgorithm algorithm, Class<T> returnType){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm.value);
            messageDigest.update(data);
            byte[] result = messageDigest.digest();
            if (returnType.equals(bytesType)){
                return (T) result;
            }else if(returnType.equals(stringType)){
                return (T) new BigInteger(result).toString(16);
            }else{
                throw new RuntimeException("no such return type! type：" + returnType.getName());
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("something wrong with function!");
        }
    }


    /**
     * 摘密函数，关键
     * @param data 待摘要的数据
     * @param algorithm 摘要算法定义集，常量，参考{@link MsgDigestAlgorithm}
     * @param returnType 返回的摘要数据的类型，常量，参考{@link MsgDigestReturnType}
     * @param <T> 摘要数据对象的泛型类型，根据传入的{@link Class}对象决定
     * @return 摘要数据，常见的有32位，64位，128位等，可能是16进制的Hash值，也可能是字符串值，或者其他自定义值
     */
    @SuppressWarnings("all")
    public static <T> T digest(byte[] data, MsgDigestAlgorithm algorithm, MsgDigestReturnType returnType){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm.value);
            messageDigest.update(data);
            byte[] digest = messageDigest.digest();
            Object disData = solveWithReturnType(digest, returnType);
            return (T) disData;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static Object solveWithReturnType(byte[] digest, MsgDigestReturnType returnType){
        switch (returnType){
            case BYTES_TYPE:{
                return digest;
            }
            case INTEGER_TYPE:{
                BigInteger bigInteger = new BigInteger(digest);
                return bigInteger;
            }
            case STRING_TYPE: default:{
                return new BigInteger(digest).toString(16);
            }
        }
    }
    // jdk 1.5
    /**
     * 常用信息摘密算法定义
     * @author askia
     * @version 1.0.1
     * @since 1.0
     */
    public enum MsgDigestAlgorithm{
        SHA_224("SHA-256"),
        SHA_256("SHA-256"),
        SHA_384("SHA-384"),
        SHA_512("SHA-512"),
        SHA_512_224("SHA-512/224"),
        SHA_512_256("SHA-512/256"),
        SHA3_224("SHA3-224"),
        SHA3_256("SHA3-256"),
        SHA3_384("SHA3-384"),
        SHA3_512("SHA3-512"),
        MD5("MD5");
        private final String value;
        MsgDigestAlgorithm(String value) {
            this.value = value;
        }
        public String getValue(){
            return value;
        }
    }
}
