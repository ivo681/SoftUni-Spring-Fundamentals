package exam.musicdb.service.impl;

import exam.musicdb.model.entity.User;
import exam.musicdb.model.service.UserServiceModel;
import exam.musicdb.repository.UserRepository;
import exam.musicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class);

        return this.modelMapper.map(this.userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return this.userRepository.findByUsername(username).map(user ->
                this.modelMapper.map(user, UserServiceModel.class)).orElse(null);
    }

    @Override
    public UserServiceModel findByEmail(String email) {
        return this.userRepository.findByEmail(email).map(user ->
                this.modelMapper.map(user, UserServiceModel.class)).orElse(null);
    }

    @Override
    public User setUserToAlbum(String username) {
        return this.userRepository.findByUsername(username).get();
    }
}
