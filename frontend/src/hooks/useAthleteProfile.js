import  {   useState,   useEffect   }   from    'react';

import  {   fetchProfileById  }   from    '../api/athlete.js';

export  function    useAthleteProfile(id){
    const   [   profile,    setProfile  ]   =   useState(null);
    
    const   [   loading,    setLoading  ]   =   useState(true);

    const   [   error,  setError    ]   =   useState(null);

    useEffect(() => {

        if  (!id    ||  Number.isNaN(Number(id))){
            return;
        }

        // Reset state on ID change
        setProfile(true);
        setError(null);

        setLoading(true);
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
