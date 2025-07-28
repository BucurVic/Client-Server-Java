import axios from 'axios';

export const login = async (username, password) => {
    const response = await axios.post('http://localhost:8080/auth/login', {
        username,
        password
    });
    localStorage.setItem('token', response.data.token);
};