package ru.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.model.User;
import ru.test.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found by id = " + id));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User find = findById(id);
        find.setFirstName(user.getFirstName());
        find.setLastName(user.getLastName());
        return save(find);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
