import React, { useState } from 'react';
import { login } from './utils/authService';
import './LoginForm.css'

function LoginForm({ onLogin }) {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async e => {
        e.preventDefault();
        try {
            await login(username, password);
            onLogin();
            // eslint-disable-next-line no-unused-vars
        } catch (e) {
            alert('Login eșuat');
        }
    };

    return (
        <div className="login-form-container">
            <form className="login-form" onSubmit={handleSubmit}>
                <h2>Autentificare</h2>
                <input
                    value={username}
                    onChange={e => setUsername(e.target.value)}
                    placeholder="Username"
                />
                <input
                    type="password"
                    value={password}
                    onChange={e => setPassword(e.target.value)}
                    placeholder="Parolă"
                />
                <button type="submit">Login</button>
            </form>
        </div>
    );
}

export default LoginForm;
