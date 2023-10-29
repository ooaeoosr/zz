package BE.UniBuddy_crud.handler;

import BE.UniBuddy_crud.domain.Users;

public interface UsersDataHandler {

    Users saveUser(Users user);

    void deleteUser(Users user);

    Users findUserByEmail(String email);

    Users findUserById(Long id);
}

