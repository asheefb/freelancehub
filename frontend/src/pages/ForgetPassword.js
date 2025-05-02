// src/pages/ForgotPasswordPage.js
import React, { useState } from 'react';
import { Link } from 'react-router-dom';

/*
  ForgotPasswordPage - simple form with email input.
  Currently, submission just shows a placeholder alert.
*/
const ForgotPasswordPage = () => {
  const [email, setEmail] = useState('');

  // Placeholder submit handler
  const handleSubmit = (e) => {
    e.preventDefault();
    // In a real app, send this email to backend to initiate password reset
    alert('Password reset link functionality is not implemented yet.');
  };

  return (
    <div className="row justify-content-center">
      <div className="col-md-6">
        <h2>Forgot Password</h2>
        <form onSubmit={handleSubmit} noValidate>
          <div className="mb-3">
            <label htmlFor="forgotEmail" className="form-label">Email address</label>
            <input
              type="email"
              className="form-control"
              id="forgotEmail"
              placeholder="Enter your email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
            <div className="invalid-feedback">
              Please enter your email.
            </div>
          </div>
          <button type="submit" className="btn btn-primary">Send Reset Link</button>
        </form>
        <div className="mt-3">
          <p>
            Remembered your password? <Link to="/login">Login</Link>.
          </p>
        </div>
      </div>
    </div>
  );
};

export default ForgotPasswordPage;
