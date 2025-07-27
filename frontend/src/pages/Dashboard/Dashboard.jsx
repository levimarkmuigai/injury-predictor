import React, { useEffect, useState} from 'react';

import StatsCard from '../components/StatsCard';

const STAT_KEYS = [
 { key: 'totalAthletes', label: 'Total Athletes'},
 { key: 'totalInjuries', label: 'Total Injuries'},
 { key: 'activeProfiles', label: 'Active Profiles'},
 { key: 'recentSignups', label: 'Recent Signups'},
];

export default function Dashboard(){
    const [stats, setStats] = useState({});

    const [loading, setLoading] = useState(true);

    const [error, setError] = useState(false);

    useEffect (() => {
        async function fetchState() {
            setLoading(true);
            setError(false);

            try{
                const res = await fetch('/api/stats');
                if(!res.ok) throw new Error('Network response was not ok');
                const data = await res.json();
                setStats(data);
            }catch(err){
                console.error(err);
                setError(true);
                setStats({});
            }finally{
                setLoading(false);
            }       
        }

        fetchStats();
    }, []});

    return(
     <section className="dashboard">
        <div className="dashboard_stats-grid">
            {STAT_KEYS.map(({key, lable}) =>    (
                <StatsCard
                    key={key}
                    title={label}
                    value={stats[key]}
                    loading={ loading}
                    error ={error}
                />
            ))}
        </div>
     </section>

    );
}
