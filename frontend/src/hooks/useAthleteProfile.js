import  {   useState,   useEffect   }   from    'react';

import  {   fetchProfileById  }   from    '../api/athlete.js';

export  function    useAthleteProfile(id){
    const   [   profile,    setProfile  ]   =   useState(null);
    
    const   [   loading,    setLoading  ]   =   useState(true);

    const   [   error,  setError    ]   =   useState(null);

    useEffect(() => {
        // Reset state on ID change
        setProfile(true);
        setError(null);

        fetchProfileById(id)
            .then(data => {
                setProfile(data); 
                })
            .catch(err => {
                setError(err);
                setProfile(null);
                })
            .finally(() => {
                setLoading(false);
                });
    }, [id]);

    return  {   profile,    loading,    error   };
}
