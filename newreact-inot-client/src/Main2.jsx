import React, { useState } from 'react';
import LoginForm from './LoginForm';
import App from './App';

function Main2() {
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    const handleLogin = () => {
        setIsAuthenticated(true);
    };

    return (
        <>
            {isAuthenticated ? <App /> : <LoginForm onLogin={handleLogin} />}
        </>
    );
}

export default Main2;
