// src/pages/ResetPasswordPage.js
import React, { useState } from 'react';

/*
  ResetPasswordPage - allows entering a new password and confirming it.
  For now, it just checks that both fields match and shows an alert.
*/
const ResetPasswordPage = () => {
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [matchError, setMatchError] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (password !== confirmPassword) {
      setMatchError("Passwords do not match.");
    } else {
      setMatchError(null);
      // In a real app, send { password } along with a reset token to the backend
      alert('Password has been reset (placeholder).');
    }
  };

  return (
    <div className="row justify-content-center">
      <div className="col-md-6">
        <h2>Reset Password</h2>
        {matchError && <div className="alert alert-danger">{matchError}</div>}
        <form onSubmit={handleSubmit} noValidate>
          <div className="mb-3">
            <label htmlFor="newPassword" className="form-label">New Password</label>
            <input
              type="password"
              className="form-control"
              id="newPassword"
              placeholder="Enter new password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
              minLength="6"
            />
            <div className="invalid-feedback">
              Please enter a new password (at least 6 characters).
            </div>
          </div>
          <div className="mb-3">
            <label htmlFor="confirmPassword" className="form-label">Confirm Password</label>
            <input
              type="password"
              className="form-control"
              id="confirmPassword"
              placeholder="Confirm new password"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
              required
              minLength="6"
            />
            <div className="invalid-feedback">
              Please confirm your new password.
            </div>
          </div>
          <button type="submit" className="btn btn-primary">Reset Password</button>
        </form>
      </div>
    </div>
  );
};

export default ResetPasswordPage;
