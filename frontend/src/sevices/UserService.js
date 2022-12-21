import axios from 'axios';
import authService from './authService';

const USER_API_BASE_URL = 'http://localhost:8080/api';

class UserService {

    fetchUsers() {
        return axios.get(USER_API_BASE_URL + '/auth', authService.getAuthHeader());
    }

    fetchUserById(userId) {
        return axios.get(USER_API_BASE_URL + '/auth/' + userId, authService.getAuthHeader());
    }

    deleteUser(userId) {
        return axios.delete(USER_API_BASE_URL + '/auth/' + userId, authService.getAuthHeader());
    }


    editUser(user) {
        return axios.put(USER_API_BASE_URL + '/autn/' + user.id, user, authService.getAuthHeader());
    }

}

export default new UserService();