import  {   useState,   useEffect   }   from    'react';

import  {   fetchProfileById  }   from    '../api/athleteApi';

export  function    useAthleteProfile(id){
    const   [   profile,    setProfile  ]   =   useState(null);
    
    const   [   loading,    setLoading  ]   =   useState(true);

    const   [   error,  setError    ]   =   useState(null);

    useEffect(() => {
        // Reset state on ID change
        setProfile(null);
        setError(null);
        setLoading(true);

        fetchProfileById(id)
            .then(data => {
                setProfile(data); 
                })
            .catch(err => {
                setError(err);
                })
            .finally(() => {
                setLoading(false);
                });
    }, [id]);

    return  (   profile,    loading,    error   );
}
