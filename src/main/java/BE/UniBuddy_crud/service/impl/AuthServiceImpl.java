//package BE.UniBuddy_crud.service.impl;
//
//import BE.UniBuddy_crud.domain.Users;
//import BE.UniBuddy_crud.handler.GoalDataHandler;
//import BE.UniBuddy_crud.handler.UsersDataHandler;
//import BE.UniBuddy_crud.repository.UsersRepository;
//import BE.UniBuddy_crud.service.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthServiceImpl extends AuthService {
//
//
//    UsersDataHandler usersDataHandler;
//
//
//    @Autowired
//    public AuthServiceImpl(UsersDataHandler usersDataHandler) {
//        this.usersDataHandler = usersDataHandler;
//    }
//
//    @Override
//    public Users register(Users users) {
//        Users userEntity = usersRepository.save(users);
//        return userEntity;
//    }
//
//    @Override
//    public Users login(String email, String password) {
//        Users user = usersRepository.findByEmail(email);
//
//        if (user != null && user.getPassword().equals(password)) {
//            return user;
//        }
//
//        return null;
//    }
//
//    @Override
//    public Users findById(Long id) {
//        return null;
//    }
//}
package BE.UniBuddy_crud.service.impl;

import BE.UniBuddy_crud.domain.Users;
import BE.UniBuddy_crud.handler.UsersDataHandler;
import BE.UniBuddy_crud.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl extends AuthService {

    private final UsersDataHandler usersDataHandler;

    @Autowired
    public AuthServiceImpl(UsersDataHandler usersDataHandler) {
        this.usersDataHandler = usersDataHandler;
    }

    @Override
    public Users register(Users users) {
        Users userEntity = usersDataHandler.saveUser(users);
        return userEntity;
    }

    @Override
    public Users login(String email, String password) {
        Users user = usersDataHandler.findUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    @Override
    public Users findById(Long id) {
        return usersDataHandler.findUserById(id);
    }
}

