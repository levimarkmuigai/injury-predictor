import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import AthleteProfile from './pages/AthleteProfile/AthleteProfile';

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/profiles/:id" element={<AthleteProfile />} />
        {/* Later we’ll add /add-profile */}
      </Routes>
    </BrowserRouter>
  );
}

