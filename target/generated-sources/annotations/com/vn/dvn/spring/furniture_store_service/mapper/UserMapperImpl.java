package com.vn.dvn.spring.furniture_store_service.mapper;

import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserCreationRequest;
import com.vn.dvn.spring.furniture_store_service.dto.request.user_request.UserUpdateRequest;
import com.vn.dvn.spring.furniture_store_service.dto.response.UserResponse;
import com.vn.dvn.spring.furniture_store_service.entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-30T13:02:09+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public Users toUser(UserCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        Users users = new Users();

        users.setName( request.getName() );
        users.setAddress( request.getAddress() );
        users.setGender( request.getGender() );
        users.setPurchased( request.getPurchased() );
        users.setEmail( request.getEmail() );
        users.setPhoneNumber( request.getPhoneNumber() );
        users.setPassword( request.getPassword() );
        users.setRole( request.getRole() );
        users.setState( request.getState() );

        return users;
    }

    @Override
    public void toUpdateUser(Users user, UserUpdateRequest userUpdateRequest) {
        if ( userUpdateRequest == null ) {
            return;
        }

        user.setName( userUpdateRequest.getName() );
        user.setAddress( userUpdateRequest.getAddress() );
        user.setGender( userUpdateRequest.getGender() );
        user.setPurchased( userUpdateRequest.getPurchased() );
        user.setPhoneNumber( userUpdateRequest.getPhoneNumber() );
        user.setPassword( userUpdateRequest.getPassword() );
        user.setState( userUpdateRequest.getState() );
    }

    @Override
    public UserResponse toUserResponse(Users user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( user.getId() );
        userResponse.name( user.getName() );
        userResponse.address( user.getAddress() );
        userResponse.gender( user.getGender() );
        userResponse.purchased( user.getPurchased() );
        userResponse.email( user.getEmail() );
        userResponse.phoneNumber( user.getPhoneNumber() );
        userResponse.role( user.getRole() );
        userResponse.state( user.getState() );

        return userResponse.build();
    }

    @Override
    public List<UserResponse> toUserResponseList(List<Users> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( userList.size() );
        for ( Users users : userList ) {
            list.add( toUserResponse( users ) );
        }

        return list;
    }
}
