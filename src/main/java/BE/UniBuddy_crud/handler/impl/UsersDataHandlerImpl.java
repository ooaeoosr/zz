package BE.UniBuddy_crud.handler.impl;

import BE.UniBuddy_crud.dao.UsersDAO;
import BE.UniBuddy_crud.domain.Users;
import BE.UniBuddy_crud.handler.UsersDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersDataHandlerImpl implements UsersDataHandler {

    private final UsersDAO usersDAO;

    @Autowired
    public UsersDataHandlerImpl(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public Users saveUser(Users user) {
        return usersDAO.saveUser(user);
    }

    @Override
    public void deleteUser(Users user) {
        usersDAO.deleteUser(user);
    }

    @Override
    public Users findUserByEmail(String email) {
        return usersDAO.findUserByEmail(email);
    }

    @Override
    public Users findUserById(Long id) {
        return usersDAO.findUserById(id);
    }
}
