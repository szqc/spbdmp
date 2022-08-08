package spb.crm.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import spb.crm.domain.Customer;

import java.util.Date;

public class JwtUtils {
    // 过期时间，30分钟，实际应用中应该使用配置的方式，通过读取配置文件
    private static final long EXPIRE = 1000 * 60 * 30;
    // 加密秘钥，实际应用中应写在配置文件中，实际应用的秘钥要通过网上相关网站生成
    private static final String SECRET = "spbdmp";
    // 主题
    private static final String SUBJECT = "jwtsubject";
    //根据用户信息生成token
    public static String getJsonWebToken(Customer customer){
        String token = Jwts.builder().setSubject(SUBJECT)//header
                .claim("id",customer.getId())//claim中设置用户信息，即payload部分的内容
                .claim("custNo",customer.getCustNo())
                .claim("name",customer.getCustName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))//设置过期时间
                .signWith(SignatureAlgorithm.HS512,SECRET)//设置加密位数和密钥，secret
                .compact();
        return token;
    }
    //校验jwt
    public static Claims checkJWT(String token){
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }
}

