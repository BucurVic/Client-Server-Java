import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import LoginForm from "./LoginForm.jsx";
import Main2 from "./Main2.jsx";

createRoot(document.getElementById('root')).render(
  // <StrictMode>
    <Main2 />
  // </StrictMode>,
)
