import  {   useState,   useEffect   }   from    'react';

import  {   fetchProfileBy  }   from    '../api/athleteApi';

export  function    useAthleteProfile(id){
    const   [   profile,    setProfile  ]   =   useState(null);
    
    const   [   loading,    setLoading  ]   =   useState(true);

    const   [   error,  setError    ]   =   useState(null);

    useEffect(() => {
        setLoading(true);
        fetchProfileById(id)
            .then(data => {
                setProfile(data); 
                setLoading(false);
        }).catch(err => {
            setError(err);
            setLoading(false);
        });
    }, [id]);
}
