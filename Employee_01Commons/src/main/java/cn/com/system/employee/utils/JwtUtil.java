package cn.com.system.employee.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

public class JwtUtil {
    public static final String TOKEN_LOGIN_NAME="loginName";
    public static final String TOKEN_LOGIN_ID="userId";
    public static final String TOKEN_SUCCESS="success";
    public static final String TOKEN_FAIL="fail";
    /*过期时间为一天
    TODO
     */
    private static final long EXPIRE_TIME=24*60*60*1000;
    private static final String TOKEN_SECRET="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsb2dpbk5hbWUiOiJ6aGFuZ3NhbjEiLCJleHAiOjE2MjIzNTEyMzcsInVzZXJJZCI6Ii0xIn0.Xi0PDrhjmpKXfe2xi6_0vv443elB9mQkkh0aioeRhIQ";
    /*
    生成签名15分钟后到期
    @param username
    @param userId
    @return
     */
    public static String sign(String username,String userId){
        //过期时间
        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        //秘钥加密
        Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
        HashMap<String,Object> header =new HashMap<>(2);
        header.put("typ","JWT");
        header.put("alg","HS256");

        return JWT.create().withHeader(header).withClaim(TOKEN_LOGIN_NAME,username).withClaim(TOKEN_LOGIN_ID,userId).withExpiresAt(date).sign(algorithm);
    }
    public static String verity(String token){
        String result=TOKEN_SUCCESS;
        try{
            Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier=JWT.require(algorithm).build();
            DecodedJWT jwt=verifier.verify(token);
            result+=jwt.getClaims().get(TOKEN_LOGIN_NAME).asString();
            return result;// success :username
        }catch(IllegalArgumentException e){
            return TOKEN_FAIL+e.getMessage();
        }catch (JWTDecodeException e){
            return TOKEN_FAIL+e.getMessage();
        }catch (Exception e){
            return TOKEN_FAIL+e.getMessage();
        }

    }

}















