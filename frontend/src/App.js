// src/App.js
import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import LoginPage from './pages/Login';
import RegisterPage from './pages/Register';
import ForgotPasswordPage from './pages/ForgotPassword';
import ResetPasswordPage from './pages/ResetPassword';

// The App component sets up client-side routes using React Router v6.
function App() {
  return (
    <BrowserRouter>
      <div className="container mt-5">
        <Routes>
          <Route path="/login" element={<LoginPage />} />
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/forgot-password" element={<ForgotPasswordPage />} />
          <Route path="/reset-password" element={<ResetPasswordPage />} />
          {/* You could add a protected "home" or "dashboard" route here */}
          {/* <Route path="/dashboard" element={<Dashboard />} /> */}
          {/* Redirect default route to /login */}
          <Route path="*" element={<LoginPage />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
