package cniao5.com.cniao5shop.manager;

import cniao5.com.cniao5shop.bean.User;

public class UserManager {

    private static UserManager sInstance = new UserManager();

    private User user;

    private UserManager() {}

    public static UserManager getInstance() {
        return sInstance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
