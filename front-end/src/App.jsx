import React from 'react';
import HomePage from './pages/HomePage';
import Dashboard from './components/Dashboard';
import RegisterPage from './pages/RegisterPage';
import './index.css';

function App() {
  return (
    <div className="App">
      <h1>Welcome to the Registration Page</h1>
      <RegisterPage/>
    </div>
  );
}

export default App;
