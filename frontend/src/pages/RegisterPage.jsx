import React, { useEffect, useState } from 'react';
import { registerUser } from '../api/AuthApi';

const RegisterPage = () => {
    const [formData, setFormData] = useState({
        name: '',
        email: '',
        password: '',
        bio: '',
        profilePictureUrl: '',
        role: '',
        contactInfo:''
      });

  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
   try {
    const result = await registerUser(formData);
    setSuccess("Registration successful! Please log in.");
    console.log(result);
  } catch (err) {
    setError(err.message || "An error occurred during registration.");
  }
}

  return (
    <div className="register-page">
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Username:</label>
          <input type="text" name="name" value={formData.name} onChange={handleChange} required />
        </div>
        <div>
          <label>Bio:</label>
          <input type="text" name="bio" value={formData.bio} onChange={handleChange} required />
        </div>
        <div>
          <label>Profile Picture URL:</label>
          <input type="text" name="profilePictureUrl" value={formData.profilePictureUrl} onChange={handleChange} required />
        </div>
        <div>
          <label>Contact Info:</label>
          <input type="text" name="contactInfo" value={formData.contactInfo} onChange={handleChange} required />
        </div>
        <div>
          <label>Email:</label>
          <input type="email" name="email" value={formData.email} onChange={handleChange} required />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" name="password" value={formData.password} onChange={handleChange} required />
        </div>
        <div></div>
          <label>Role:</label>
          <select name="role" value={formData.role} onChange={handleChange} required>
            <option value="">Select Role</option>
            <option value="ADMIN">ADMIN</option>
            <option value="CLIENT">CLIENT</option>
            <option value="FREELANCER">FREELANCER</option>
          </select>
        <button type="submit">Register</button>
      </form>
      {error && <p className="error">{error}</p>}
      {success && <p className="success">{success}</p>}
    </div>
  );
}

export default RegisterPage;