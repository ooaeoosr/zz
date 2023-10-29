package BE.UniBuddy_crud.dao;

import BE.UniBuddy_crud.domain.Users;

public interface UsersDAO {
    Users saveUser(Users user);

    Users getUser(Long userId);

    void deleteUser(Users user);

    

    Users findUserByEmail(String email);

    Users findUserById(Long id);
}
