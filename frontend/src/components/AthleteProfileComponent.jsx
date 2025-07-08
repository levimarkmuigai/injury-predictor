import React from 'react';

export default function AthleteProfileComponent({ profile }) {
  return (
    <div className="max-w-md mx-auto p-4">
      <h1 className="text-2xl font-bold mb-4">Athlete Profile</h1>
      <p><strong>Name:</strong> {profile.firstName} {profile.lastName}</p>
      <p><strong>DOB:</strong> {new Date(profile.dob).toLocaleDateString()}</p>
      <p><strong>Gender:</strong> {profile.gender}</p>
      <p><strong>Height:</strong> {profile.height} cm</p>
      <p><strong>Weight:</strong> {profile.weight} kg</p>
      <p><strong>History:</strong> {profile.injuryHistory}</p>
    </div>
  );
}
