package BE.UniBuddy_crud.dao.impl;

import BE.UniBuddy_crud.dao.UsersDAO;
import BE.UniBuddy_crud.domain.Users;
import BE.UniBuddy_crud.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersDAOImpl implements UsersDAO {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersDAOImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Users getUser(Long userId) {
        return usersRepository.getById(userId);
    }

    @Override
    public void deleteUser(Users user) {
        usersRepository.delete(user);
    }

    @Override
    public Users findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Users findUserById(Long id) {
        return usersRepository.getById(id);
    }
}
