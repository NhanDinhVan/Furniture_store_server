package com.vn.dvn.spring.furniture_store_service.service.authentication_service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.AuthenticationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.IntrospectRequest;
import com.vn.dvn.spring.furniture_store_service.dto.response.AuthenticationResponse;
import com.vn.dvn.spring.furniture_store_service.dto.response.IntrospectResponse;
import com.vn.dvn.spring.furniture_store_service.handle_exception.AppException;
import com.vn.dvn.spring.furniture_store_service.handle_exception.ErrorCode;
import com.vn.dvn.spring.furniture_store_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    UserRepository userRepository;
    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY ;

    public IntrospectResponse introspect(IntrospectRequest request)
            throws JOSEException, ParseException {
        var token = request.getToken();

        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expityTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier);

        return IntrospectResponse.builder()
                .valid(verified && expityTime.after(new Date()))
                .build();
    }



    //Hàm xác thực email, mật khẩu khi đăng nhập
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new AppException(ErrorCode.USER_NOTFOUND));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if(!authenticated) throw new AppException(ErrorCode.UNAUTHENTICATED);

        var token = generateToken(request.getEmail());

        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();

    }

    //Hàm tạo generate token
    String generateToken(String username){
        //Tạo header
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        //Tạo payload
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("dvn.com")
                .issueTime(new Date()) //Thời gian khởi tạo
                .expirationTime(new Date(
                        //Thời gian hết hạn
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("customClaim", "Custom")
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        //Tạo đối tượng jwt ( Truyền vào header và payload)
        JWSObject jwsObject = new JWSObject(header,payload);

        try {
            //Gọi phương thức kí token
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));

            //.serialize là phương thức convert thành kiểu String
            return jwsObject.serialize();
        }catch (JOSEException e){
            System.out.println("Cannot create token" + e);
            throw new RuntimeException(e);
        }
    }
}
