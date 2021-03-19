package exam.musicdb.service;

import exam.musicdb.model.entity.User;
import exam.musicdb.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel map);

    UserServiceModel findByUsername(String username);

    UserServiceModel findByEmail(String email);

    User setUserToAlbum(String username);

}
