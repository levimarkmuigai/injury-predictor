import React from 'react';

import {   useEffect   }   from    'react';

import {    useParams,  useNavigate }   from    'react-router-dom';

import { useAthleteProfile } from '../../hooks/useAthleteProfile';

import AthleteProfileComponent from '../../components/AthleteProfileComponent';

export default function AthleteProfile(){
    
    const   {id}  = useParams();
    
    const   navigate = useNavigate();
    
    const numericId = Number(id);
    
    const   {profile,loading,error} = useAthleteProfile(numericId);

    useEffect(() => {
        if(!id || Number.isNaN(numericId)) {
            navigate('/', { replace: true});
        }
    }, [id, numericId, navigate]);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error.message}</p>;

  return <AthleteProfileComponent profile={profile} />;
}

