import React from 'react';
import RegisterPage from './pages/RegisterPage';
import Dashboard from './components/Dashboard';
import Navbar from './components/Navbar';
import { Routes,Route } from 'react-router-dom';

function App() {
  return (
    <>
    <Navbar/>
    
    <Routes>
      <Route path="/" element={<Dashboard />} />
      <Route path="/signup" element={<RegisterPage />} />
      {/* <Route path="/register" element={<RegisterPage />} /> */}

    </Routes>
    </>
  );
}

export default App;