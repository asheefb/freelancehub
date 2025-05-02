// src/pages/LoginPage.js
import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import axios from 'axios';

/*
  LoginPage - allows users to enter email and password.
  On submit, sends a POST request to /auth/login, stores the token on success,
  and displays an error message on failure.
*/
const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    // Perform client-side validation (HTML5 handles 'required')
    try {
      // Send login request to backend
      const response = await axios.post('/auth/login', { email, password });
      const { token } = response.data;
      // Store the auth token (e.g. JWT) in localStorage
      localStorage.setItem('token', token);
      // Redirect or update UI as needed (example: navigate to dashboard)
      // navigate('/dashboard');
      console.log('Login successful, token saved.');
    } catch (err) {
      // Display error message returned from server or a generic one
      const message =
        err.response?.data?.message || 'Login failed. Please try again.';
      setError(message);
    }
  };

  return (
    <div className="row justify-content-center">
      <div className="col-md-6">
        <h2>Login</h2>
        {error && <div className="alert alert-danger">{error}</div>}
        <form onSubmit={handleSubmit} noValidate>
          <div className="mb-3">
            <label htmlFor="loginEmail" className="form-label">Email address</label>
            <input
              type="email"
              className="form-control"
              id="loginEmail"
              placeholder="Enter email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
            <div className="invalid-feedback">
              Please enter your email.
            </div>
          </div>
          <div className="mb-3">
            <label htmlFor="loginPassword" className="form-label">Password</label>
            <input
              type="password"
              className="form-control"
              id="loginPassword"
              placeholder="Enter password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
              minLength="6"
            />
            <div className="invalid-feedback">
              Please enter your password (at least 6 characters).
            </div>
          </div>
          <button type="submit" className="btn btn-primary">Login</button>
        </form>
        <div className="mt-3">
          <p>
            Don't have an account? <Link to="/register">Register here</Link>.
          </p>
          <p>
            <Link to="/forgot-password">Forgot Password?</Link>
          </p>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
