import  React   from    'react';

import  {   useParams   }   from 'react-router-dom';

import  {   useAthleteProfile   }   from    '../../hooks/useAthleteProfile';

import  LoadingSpinner from '../../components/LoadingSpinner';

export  default function    AthleteProfile()    {
    
    const   {   id  }   =   useParams();
    const   {   profile,    loading,    error   }   =   useAthleteProfile(id    ||  1);

    if  (loading)   return  <LoadingSpinner />;
    if  (error)     return  <p>Error:   {error.message}</p>;

    return (
        <div className="max-w-md mx-auto p-4">
            <h1 className="text-2xl font-bold mb-4">Athlete Profile</h1>
            <p><strong>Name:</strong>   {profile.firstName} {profile.lastName}</p>
            <p><strong>DOB:</strong>    {new    Date(profile.dob).toLocaleDateString()  }</p>
            <p><strong>Gender:</strong> {profile.gender}</p>
            <p><strong>Height:</strong> {profile.height}</p>
            <p><strong>Weight:</strong> {profile.weight}</p>
            <p><strong>History:</strong>    {profile.injuryHistory}</p>
        </div>
    );
}
