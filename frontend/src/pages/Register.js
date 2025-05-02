// src/pages/RegisterPage.js
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

/*
  RegisterPage - collects user details and sends them to /auth/register.
  All fields are required. Bootstrap validation feedback is shown on invalid input.
*/
const RegisterPage = () => {
  const [formData, setFormData] = useState({
    email: '',
    password: '',
    name: '',
    role: '',
    bio: '',
    profilePictureUrl: '',
    contactInfo: ''
  });
  const [validated, setValidated] = useState(false);
  const [error, setError] = useState(null);

  // Update state on input change
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.id]: e.target.value });
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    // Check form validity (Bootstrap validation)
    const form = e.currentTarget;
    if (!form.checkValidity()) {
      e.stopPropagation();
      setValidated(true);
      return;
    }
    setValidated(true);

    try {
      // Send registration data to backend
      await axios.post('/auth/register', formData);
      console.log('Registration successful. You can now log in.');
      // Optionally redirect to login page:
      // navigate('/login');
    } catch (err) {
      const message =
        err.response?.data?.message || 'Registration failed. Please try again.';
      setError(message);
    }
  };

  return (
    <div className="row justify-content-center">
      <div className="col-md-8">
        <h2>Register</h2>
        {error && <div className="alert alert-danger">{error}</div>}
        {/* The 'was-validated' class is applied after attempting submission to show feedback */}
        <form onSubmit={handleSubmit} noValidate className={validated ? 'was-validated' : ''}>
          <div className="mb-3">
            <label htmlFor="email" className="form-label">Email address</label>
            <input
              type="email"
              className="form-control"
              id="email"
              placeholder="Enter email"
              value={formData.email}
              onChange={handleChange}
              required
            />
            <div className="invalid-feedback">
              A valid email is required.
            </div>
          </div>
          <div className="mb-3">
            <label htmlFor="password" className="form-label">Password</label>
            <input
              type="password"
              className="form-control"
              id="password"
              placeholder="Enter password"
              value={formData.password}
              onChange={handleChange}
              required
              minLength="6"
            />
            <div className="invalid-feedback">
              Please enter a password (at least 6 characters).
            </div>
          </div>
          <div className="mb-3">
            <label htmlFor="name" className="form-label">Full Name</label>
            <input
              type="text"
              className="form-control"
              id="name"
              placeholder="Your name"
              value={formData.name}
              onChange={handleChange}
              required
            />
            <div className="invalid-feedback">
              Name is required.
            </div>
          </div>
          <div className="mb-3">
            <label htmlFor="role" className="form-label">Role</label>
            <input
              type="text"
              className="form-control"
              id="role"
              placeholder="Role (e.g. User, Admin)"
              value={formData.role}
              onChange={handleChange}
              required
            />
            <div className="invalid-feedback">
              Role is required.
            </div>
          </div>
          <div className="mb-3">
            <label htmlFor="bio" className="form-label">Bio</label>
            <textarea
              className="form-control"
              id="bio"
              placeholder="Short bio"
              value={formData.bio}
              onChange={handleChange}
              required
            />
            <div className="invalid-feedback">
              Bio is required.
            </div>
          </div>
          <div className="mb-3">
            <label htmlFor="profilePictureUrl" className="form-label">Profile Picture URL</label>
            <input
              type="url"
              className="form-control"
              id="profilePictureUrl"
              placeholder="http://example.com/photo.jpg"
              value={formData.profilePictureUrl}
              onChange={handleChange}
              required
            />
            <div className="invalid-feedback">
              A profile picture URL is required.
            </div>
          </div>
          <div className="mb-3">
            <label htmlFor="contactInfo" className="form-label">Contact Info</label>
            <input
              type="text"
              className="form-control"
              id="contactInfo"
              placeholder="Contact information"
              value={formData.contactInfo}
              onChange={handleChange}
              required
            />
            <div className="invalid-feedback">
              Contact information is required.
            </div>
          </div>
          <button type="submit" className="btn btn-primary">Register</button>
        </form>
        <div className="mt-3">
          <p>
            Already have an account? <Link to="/login">Login here</Link>.
          </p>
        </div>
      </div>
    </div>
  );
};

export default RegisterPage;
