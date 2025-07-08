import React from 'react';
import { useParams } from 'react-router-dom';
import { useAthleteProfile } from '../../hooks/useAthleteProfile';
import AthleteProfileComponent from '../../components/AthleteProfileComponent';

export default function AthleteProfile() {
  const { id } = useParams();
  const { profile, loading, error } = useAthleteProfile(id || 1);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error.message}</p>;

  return <AthleteProfileComponent profile={profile} />;
}

